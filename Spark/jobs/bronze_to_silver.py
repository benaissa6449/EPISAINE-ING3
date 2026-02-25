from functools import reduce
import os
import sys

from pyspark.sql import functions as F
from pyspark.sql.window import Window

sys.path.append(os.path.dirname(os.path.dirname(__file__)))

from common.config import APP_NAME, BATCH_ID, BRONZE_COLLECTION, DELTA_MODE, MONGO_URI, SILVER_COLLECTION
from common.schemas import BINARY_COLUMNS, DIABETES_COLUMN_TYPES, DIABETES_COLUMNS
from common.utils import build_spark


LABEL_MAPPINGS = {
    "Diabetes_binary": {0: "no diabetes", 1: "prediabetes or diabetes"},
    "HighBP": {0: "no high BP", 1: "high BP"},
    "HighChol": {0: "no high cholesterol", 1: "high cholesterol"},
    "CholCheck": {0: "no cholesterol check in 5 years", 1: "cholesterol check in 5 years"},
    "Smoker": {0: "no", 1: "yes"},
    "Stroke": {0: "no", 1: "yes"},
    "HeartDiseaseorAttack": {0: "no", 1: "yes"},
    "PhysActivity": {0: "no", 1: "yes"},
    "Fruits": {0: "no", 1: "yes"},
    "Veggies": {0: "no", 1: "yes"},
    "HvyAlcoholConsump": {0: "no", 1: "yes"},
    "AnyHealthcare": {0: "no", 1: "yes"},
    "NoDocbcCost": {0: "no", 1: "yes"},
    "DiffWalk": {0: "no", 1: "yes"},
    "Sex": {0: "femme", 1: "homme"},
    "GenHlth": {
        1: "excellent",
        2: "very good",
        3: "good",
        4: "fair",
        5: "poor",
    },
    "Age": {
        1: "18-24",
        2: "25-29",
        3: "30-34",
        4: "35-39",
        5: "40-44",
        6: "45-49",
        7: "50-54",
        8: "55-59",
        9: "60-64",
        10: "65-69",
        11: "70-74",
        12: "75-79",
        13: "80+",
    },
    "Education": {
        1: "never attended school or kindergarten only",
        2: "grades 1-8 (elementary)",
        3: "grades 9-11 (some high school)",
        4: "grade 12 or GED (high school graduate)",
        5: "college 1-3 years (some college/technical school)",
        6: "college 4+ years (college graduate)",
    },
    "Income": {
        1: "<$10,000",
        2: "$10,000-$15,000",
        3: "$15,000-$20,000",
        4: "$20,000-$25,000",
        5: "$25,000-$35,000",
        6: "$35,000-$50,000",
        7: "$50,000-$75,000",
        8: "$75,000+",
    },
}


def _add_id_if_missing(df):
    if "ID" in df.columns:
        return df
    if "_id" in df.columns:
        window = Window.orderBy(F.col("_id").cast("string"))
    else:
        window = Window.orderBy(F.monotonically_increasing_id())
    return df.withColumn("ID", F.row_number().over(window))


def _cast_columns(df):
    for column_name, dtype in DIABETES_COLUMN_TYPES.items():
        if column_name in df.columns:
            df = df.withColumn(column_name, F.col(column_name).cast(dtype))
    return df


def _validate(df):
    checks = [F.col(c).isin(0, 1) for c in BINARY_COLUMNS]
    checks.extend(
        [
            F.col("BMI").between(12, 98),
            F.col("GenHlth").between(1, 5),
            F.col("MentHlth").between(0, 30),
            F.col("PhysHlth").between(0, 30),
            F.col("Age").between(1, 13),
            F.col("Education").between(1, 6),
            F.col("Income").between(1, 8),
        ]
    )
    combined_check = reduce(lambda a, b: a & b, checks)
    return df.filter(combined_check)


def _map_coded_columns_to_labels(df):
    for column_name, mapping in LABEL_MAPPINGS.items():
        if column_name not in df.columns:
            continue

        expr = None
        for source_value, target_label in mapping.items():
            branch = F.when(F.col(column_name) == source_value, F.lit(target_label))
            expr = branch if expr is None else expr.when(F.col(column_name) == source_value, F.lit(target_label))

        df = df.withColumn(column_name, expr.otherwise(F.lit(None)))
    return df


def _ensure_delta_metadata(df):
    payload_columns = [c for c in DIABETES_COLUMNS if c != "ID" and c in df.columns]
    payload_expr = F.concat_ws(
        "||",
        *[F.coalesce(F.col(c).cast("string"), F.lit("")) for c in payload_columns],
    )

    if "source_key" in df.columns:
        df = df.withColumn("source_key", F.coalesce(F.col("source_key").cast("string"), F.sha2(payload_expr, 256)))
    else:
        df = df.withColumn("source_key", F.sha2(payload_expr, 256))

    if "row_hash" in df.columns:
        df = df.withColumn("row_hash", F.coalesce(F.col("row_hash").cast("string"), F.sha2(payload_expr, 256)))
    else:
        df = df.withColumn("row_hash", F.sha2(payload_expr, 256))

    if "batch_id" in df.columns:
        df = df.withColumn("batch_id", F.coalesce(F.col("batch_id").cast("string"), F.lit(BATCH_ID if BATCH_ID else None)))
    else:
        df = df.withColumn("batch_id", F.lit(BATCH_ID if BATCH_ID else None).cast("string"))

    if "ingestion_ts" in df.columns:
        df = df.withColumn("ingestion_ts", F.coalesce(F.col("ingestion_ts"), F.current_timestamp()))
    else:
        df = df.withColumn("ingestion_ts", F.current_timestamp())

    return df


def main():
    spark = build_spark(APP_NAME, MONGO_URI)
    try:
        bronze = spark.read.format("mongodb").option("collection", BRONZE_COLLECTION).load()

        silver = _add_id_if_missing(bronze)
        silver = _cast_columns(silver)

        missing_columns = [c for c in DIABETES_COLUMNS if c not in silver.columns]
        if missing_columns:
            raise ValueError(f"Missing required columns in bronze data: {missing_columns}")

        if DELTA_MODE:
            technical_columns = [c for c in ["source_key", "row_hash", "batch_id", "ingestion_ts"] if c in silver.columns]
            silver = silver.select(*(DIABETES_COLUMNS + technical_columns))
            silver = silver.dropna(subset=DIABETES_COLUMNS)
            silver = _validate(silver)
            silver = _map_coded_columns_to_labels(silver)
            incoming = _ensure_delta_metadata(silver).dropDuplicates(["source_key"])

            target_columns = DIABETES_COLUMNS + ["source_key", "row_hash", "batch_id", "ingestion_ts"]
            incoming = incoming.select(*target_columns)

            try:
                existing = spark.read.format("mongodb").option("collection", SILVER_COLLECTION).load()
                existing = _ensure_delta_metadata(existing)
                for col_name in target_columns:
                    if col_name not in existing.columns:
                        existing = existing.withColumn(col_name, F.lit(None))
                existing = existing.select(*target_columns).dropDuplicates(["source_key"])

                unchanged_keys = (
                    existing.alias("e")
                    .join(
                        incoming.alias("i"),
                        (F.col("e.source_key") == F.col("i.source_key"))
                        & (F.col("e.row_hash") == F.col("i.row_hash")),
                        "inner",
                    )
                    .select(F.col("e.source_key").alias("source_key"))
                    .distinct()
                )

                existing_untouched = existing.join(incoming.select("source_key").distinct(), "source_key", "left_anti")
                existing_unchanged = existing.join(unchanged_keys, "source_key", "inner")
                incoming_changed_or_new = incoming.join(unchanged_keys, "source_key", "left_anti")

                silver_out = (
                    existing_untouched
                    .unionByName(existing_unchanged)
                    .unionByName(incoming_changed_or_new)
                    .dropDuplicates(["source_key"])
                )
            except Exception:
                # First run or legacy collection state: bootstrap from incoming dataset.
                silver_out = incoming
        else:
            silver = silver.select(*DIABETES_COLUMNS)
            silver = silver.dropna(subset=DIABETES_COLUMNS)
            silver = _validate(silver)
            silver = _map_coded_columns_to_labels(silver)
            silver_out = silver.dropDuplicates(["ID"])

        (
            silver_out.write.format("mongodb")
            .mode("overwrite")
            .option("collection", SILVER_COLLECTION)
            .save()
        )

        print(
            f"Bronze -> Silver termine. Collection cible: {SILVER_COLLECTION}. "
            f"Mode: {'delta' if DELTA_MODE else 'full-refresh'}"
        )
    finally:
        spark.stop()


if __name__ == "__main__":
    main()
