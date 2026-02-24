from functools import reduce
import os
import sys

from pyspark.sql import functions as F
from pyspark.sql.window import Window

sys.path.append(os.path.dirname(os.path.dirname(__file__)))

from common.config import APP_NAME, BRONZE_COLLECTION, MONGO_URI, SILVER_COLLECTION
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


def main():
    spark = build_spark(APP_NAME, MONGO_URI)
    try:
        bronze = spark.read.format("mongodb").option("collection", BRONZE_COLLECTION).load()

        silver = _add_id_if_missing(bronze)
        silver = _cast_columns(silver)

        missing_columns = [c for c in DIABETES_COLUMNS if c not in silver.columns]
        if missing_columns:
            raise ValueError(f"Missing required columns in bronze data: {missing_columns}")

        silver = silver.select(*DIABETES_COLUMNS)
        silver = silver.dropna(subset=DIABETES_COLUMNS)
        silver = _validate(silver)
        silver = _map_coded_columns_to_labels(silver)
        silver = silver.dropDuplicates(["ID"])

        (
            silver.write.format("mongodb")
            .mode("overwrite")
            .option("collection", SILVER_COLLECTION)
            .save()
        )

        print(f"Bronze -> Silver termine. Collection cible: {SILVER_COLLECTION}")
    finally:
        spark.stop()


if __name__ == "__main__":
    main()
