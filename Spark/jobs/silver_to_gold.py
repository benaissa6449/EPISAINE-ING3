"""
silver_to_gold.py

ETL job for copying Silver data into PostgreSQL Gold tables.
This script keeps the raw BI snapshot in `gold.silver_snapshot` and also
builds a small star schema for analytics consumption.
"""

import os
import sys
from datetime import datetime
from urllib.parse import parse_qsl, urlencode, urlparse, urlsplit, urlunsplit

sys.path.append(os.path.dirname(os.path.dirname(__file__)))

from common.config import APP_NAME, BATCH_ID, DELTA_MODE, MONGO_URI, SILVER_COLLECTION
from common.schemas import DIABETES_COLUMNS
from common.utils import build_spark
from pyspark.sql.types import IntegerType, StringType, StructField, StructType, TimestampType


def _pg_conn_params():
    postgres_uri = os.getenv("POSTGRES_URI")
    if postgres_uri:
        parsed = urlparse(postgres_uri)
        return {
            "host": parsed.hostname,
            "port": parsed.port or 5432,
            "dbname": parsed.path.lstrip("/") or "episaine",
            "user": parsed.username,
            "password": parsed.password,
        }

    # Fallback compatible with previous project setup.
    return {
        "host": "192.168.248.170",
        "port": 5432,
        "dbname": "episaine",
        "user": "episaine",
        "password": "episaine",
    }


def _log(message: str) -> None:
    ts = datetime.utcnow().strftime("%Y-%m-%dT%H:%M:%SZ")
    print(f"[silver_to_gold] {ts} {message}", flush=True)


def _mongo_timeout_uri(uri: str) -> str:
    parts = urlsplit(uri)
    query = dict(parse_qsl(parts.query, keep_blank_values=True))
    defaults = {
        "serverSelectionTimeoutMS": "15000",
        "connectTimeoutMS": "10000",
        "socketTimeoutMS": "120000",
    }
    for key, value in defaults.items():
        query.setdefault(key, value)
    return urlunsplit((parts.scheme, parts.netloc, parts.path, urlencode(query), parts.fragment))


def _mongo_schema(include_technical: bool) -> StructType:
    fields = [
        StructField("ID", IntegerType(), True),
        StructField("Diabetes_binary", StringType(), True),
        StructField("HighBP", StringType(), True),
        StructField("HighChol", StringType(), True),
        StructField("CholCheck", StringType(), True),
        StructField("BMI", IntegerType(), True),
        StructField("Smoker", StringType(), True),
        StructField("Stroke", StringType(), True),
        StructField("HeartDiseaseorAttack", StringType(), True),
        StructField("PhysActivity", StringType(), True),
        StructField("Fruits", StringType(), True),
        StructField("Veggies", StringType(), True),
        StructField("HvyAlcoholConsump", StringType(), True),
        StructField("AnyHealthcare", StringType(), True),
        StructField("NoDocbcCost", StringType(), True),
        StructField("GenHlth", StringType(), True),
        StructField("MentHlth", IntegerType(), True),
        StructField("PhysHlth", IntegerType(), True),
        StructField("DiffWalk", StringType(), True),
        StructField("Sex", StringType(), True),
        StructField("Age", StringType(), True),
        StructField("Education", StringType(), True),
        StructField("Income", StringType(), True),
    ]
    if include_technical:
        fields.extend(
            [
                StructField("source_key", StringType(), True),
                StructField("row_hash", StringType(), True),
                StructField("batch_id", StringType(), True),
                StructField("ingestion_ts", TimestampType(), True),
            ]
        )
    return StructType(fields)


def _risk_factor_count(row):
    risk_columns = [
        "HighBP",
        "HighChol",
        "Smoker",
        "Stroke",
        "HeartDiseaseorAttack",
        "DiffWalk",
    ]
    return sum(1 for col in risk_columns if row.get(col) == "yes")


def _build_dimension_data(rows, column_names):
    unique_values = sorted(
        {
            tuple(row.get(column_name) for column_name in column_names)
            for row in rows
        },
        key=lambda values: tuple("" if value is None else str(value) for value in values),
    )
    return [
        {"id": index, "values": values}
        for index, values in enumerate(unique_values, start=1)
    ]


def _insert_dimension(cur, table_name, pk_name, column_names, dimension_data):
    from psycopg2.extras import execute_values

    cur.execute(f"TRUNCATE TABLE gold.{table_name} RESTART IDENTITY CASCADE;")
    if not dimension_data:
        return {}

    execute_values(
        cur,
        f"""
        INSERT INTO gold.{table_name} ({pk_name}, {", ".join(column_names)})
        VALUES %s
        """,
        [
            (dimension["id"], *dimension["values"])
            for dimension in dimension_data
        ],
        page_size=5000,
    )

    return {
        dimension["values"]: dimension["id"]
        for dimension in dimension_data
    }


def _deduplicate_snapshot_rows(rows):
    deduped = {}
    for row in rows:
        deduped[row[0]] = row
    return list(deduped.values())


def main():
    import psycopg2
    from psycopg2.extras import execute_values

    _log(f"Starting job. DELTA_MODE={DELTA_MODE} BATCH_ID={BATCH_ID if BATCH_ID else '<empty>'}")
    mongo_uri = _mongo_timeout_uri(MONGO_URI)
    spark = build_spark(f"{APP_NAME}-silver-to-gold", mongo_uri)
    spark.sparkContext.setLogLevel(os.getenv("SPARK_LOG_LEVEL", "WARN"))
    try:
        log_manager = spark._jvm.org.apache.log4j.LogManager
        level = spark._jvm.org.apache.log4j.Level.WARN
        log_manager.getLogger("org.mongodb.spark").setLevel(level)
        log_manager.getLogger("org.mongodb.driver").setLevel(level)
        log_manager.getLogger("org.mongodb.spark.sql.connector.schema.BsonDocumentToRowConverter").setLevel(level)
    except Exception:
        pass
    try:
        _log(f"Reading silver collection '{SILVER_COLLECTION}'")
        silver = (
            spark.read.format("mongodb")
            .option("collection", SILVER_COLLECTION)
            .option(
                "partitioner",
                "com.mongodb.spark.sql.connector.read.partitioner.SinglePartitionPartitioner",
            )
            .schema(_mongo_schema(include_technical=True))
            .load()
        )
        _log("Validating source readability with silver.limit(1).count()")
        silver.limit(1).count()
        _log("Source readability check passed")
        selected_columns = [
            c for c in (DIABETES_COLUMNS + ["source_key", "row_hash", "batch_id", "ingestion_ts"])
            if c in silver.columns
        ]
        silver = silver.select(*selected_columns)
        silver_count = silver.count()
        _log(f"Rows to process from silver: {silver_count}")

        conn = psycopg2.connect(**_pg_conn_params())
        cur = conn.cursor()
        try:
            cur.execute("CREATE SCHEMA IF NOT EXISTS gold;")
            cur.execute(
                """
                CREATE TABLE IF NOT EXISTS gold.silver_snapshot (
                    id INTEGER PRIMARY KEY,
                    diabetes_binary TEXT,
                    highbp TEXT,
                    highchol TEXT,
                    cholcheck TEXT,
                    bmi INTEGER,
                    smoker TEXT,
                    stroke TEXT,
                    heartdiseaseorattack TEXT,
                    physactivity TEXT,
                    fruits TEXT,
                    veggies TEXT,
                    hvyalcoholconsump TEXT,
                    anyhealthcare TEXT,
                    nodocbccost TEXT,
                    genhlth TEXT,
                    menthlth INTEGER,
                    physhlth INTEGER,
                    diffwalk TEXT,
                    sex TEXT,
                    age TEXT,
                    education TEXT,
                    income TEXT
                );
                """
            )
            cur.execute(
                """
                CREATE TABLE IF NOT EXISTS gold.dim_cardio (
                    cardio_id INTEGER PRIMARY KEY,
                    highbp TEXT,
                    highchol TEXT,
                    cholcheck TEXT,
                    heartdiseaseorattack TEXT,
                    stroke TEXT
                );
                """
            )
            cur.execute(
                """
                CREATE TABLE IF NOT EXISTS gold.dim_morphologie (
                    morpho_id INTEGER PRIMARY KEY,
                    bmi INTEGER
                );
                """
            )
            cur.execute(
                """
                CREATE TABLE IF NOT EXISTS gold.dim_habitudes (
                    habitude_id INTEGER PRIMARY KEY,
                    smoker TEXT,
                    physactivity TEXT,
                    fruits TEXT,
                    veggies TEXT,
                    hvyalcoholconsump TEXT
                );
                """
            )
            cur.execute(
                """
                CREATE TABLE IF NOT EXISTS gold.dim_acces_soins (
                    acces_id INTEGER PRIMARY KEY,
                    anyhealthcare TEXT,
                    nodocbccost TEXT
                );
                """
            )
            cur.execute(
                """
                CREATE TABLE IF NOT EXISTS gold.dim_etat_sante (
                    etat_id INTEGER PRIMARY KEY,
                    genhlth TEXT,
                    menthlth INTEGER,
                    physhlth INTEGER,
                    diffwalk TEXT
                );
                """
            )
            cur.execute(
                """
                CREATE TABLE IF NOT EXISTS gold.dim_demographie (
                    demo_id INTEGER PRIMARY KEY,
                    sex TEXT,
                    age TEXT,
                    education TEXT,
                    income TEXT
                );
                """
            )
            cur.execute(
                """
                CREATE TABLE IF NOT EXISTS gold.fact_diabetes (
                    diabetes_id INTEGER PRIMARY KEY,
                    diabetes_binary TEXT,
                    risk_factor_count INTEGER,
                    cardio_id INTEGER REFERENCES gold.dim_cardio(cardio_id),
                    morpho_id INTEGER REFERENCES gold.dim_morphologie(morpho_id),
                    habitude_id INTEGER REFERENCES gold.dim_habitudes(habitude_id),
                    acces_id INTEGER REFERENCES gold.dim_acces_soins(acces_id),
                    etat_id INTEGER REFERENCES gold.dim_etat_sante(etat_id),
                    demo_id INTEGER REFERENCES gold.dim_demographie(demo_id),
                    source_key TEXT,
                    row_hash TEXT,
                    batch_id TEXT,
                    ingestion_ts TIMESTAMP
                );
                """
            )

            if DELTA_MODE:
                cur.execute("ALTER TABLE gold.silver_snapshot ADD COLUMN IF NOT EXISTS source_key TEXT;")
                cur.execute("ALTER TABLE gold.silver_snapshot ADD COLUMN IF NOT EXISTS row_hash TEXT;")
                cur.execute("ALTER TABLE gold.silver_snapshot ADD COLUMN IF NOT EXISTS batch_id TEXT;")
                cur.execute("ALTER TABLE gold.silver_snapshot ADD COLUMN IF NOT EXISTS ingestion_ts TIMESTAMP;")
            else:
                cur.execute("TRUNCATE TABLE gold.silver_snapshot;")

            rows = []
            star_rows = []
            for index, r in enumerate(silver.toLocalIterator(), start=1):
                row = {column: r[column] for column in silver.columns}
                rows.append(
                    (
                        int(r["ID"]) if r["ID"] is not None else None,
                        r["Diabetes_binary"],
                        r["HighBP"],
                        r["HighChol"],
                        r["CholCheck"],
                        int(r["BMI"]) if r["BMI"] is not None else None,
                        r["Smoker"],
                        r["Stroke"],
                        r["HeartDiseaseorAttack"],
                        r["PhysActivity"],
                        r["Fruits"],
                        r["Veggies"],
                        r["HvyAlcoholConsump"],
                        r["AnyHealthcare"],
                        r["NoDocbcCost"],
                        r["GenHlth"],
                        int(r["MentHlth"]) if r["MentHlth"] is not None else None,
                        int(r["PhysHlth"]) if r["PhysHlth"] is not None else None,
                        r["DiffWalk"],
                        r["Sex"],
                        r["Age"],
                        r["Education"],
                        r["Income"],
                        r["source_key"] if "source_key" in silver.columns else str(r["ID"]),
                        r["row_hash"] if "row_hash" in silver.columns else None,
                        r["batch_id"] if "batch_id" in silver.columns else (BATCH_ID if BATCH_ID else None),
                        r["ingestion_ts"] if "ingestion_ts" in silver.columns else None,
                    )
                )
                row["risk_factor_count"] = _risk_factor_count(row)
                row["source_key_out"] = row["source_key"] if "source_key" in row else str(row["ID"])
                row["row_hash_out"] = row.get("row_hash")
                row["batch_id_out"] = row["batch_id"] if "batch_id" in row else (BATCH_ID if BATCH_ID else None)
                row["ingestion_ts_out"] = row.get("ingestion_ts")
                row["id_out"] = int(row["ID"]) if row["ID"] is not None else None
                star_rows.append(row)
                if index % 10000 == 0:
                    _log(f"Collected {index} rows from silver")

            rows = _deduplicate_snapshot_rows(rows)
            star_rows = list({row["id_out"]: row for row in star_rows}.values())
            _log(f"Rows retained after ID deduplication: {len(rows)}")

            if DELTA_MODE:
                _log("Upserting gold.silver_snapshot")
                execute_values(
                    cur,
                    """
                    INSERT INTO gold.silver_snapshot (
                        id, diabetes_binary, highbp, highchol, cholcheck, bmi, smoker, stroke,
                        heartdiseaseorattack, physactivity, fruits, veggies, hvyalcoholconsump,
                        anyhealthcare, nodocbccost, genhlth, menthlth, physhlth, diffwalk,
                        sex, age, education, income, source_key, row_hash, batch_id, ingestion_ts
                    ) VALUES %s
                    ON CONFLICT (id) DO UPDATE SET
                        diabetes_binary = EXCLUDED.diabetes_binary,
                        highbp = EXCLUDED.highbp,
                        highchol = EXCLUDED.highchol,
                        cholcheck = EXCLUDED.cholcheck,
                        bmi = EXCLUDED.bmi,
                        smoker = EXCLUDED.smoker,
                        stroke = EXCLUDED.stroke,
                        heartdiseaseorattack = EXCLUDED.heartdiseaseorattack,
                        physactivity = EXCLUDED.physactivity,
                        fruits = EXCLUDED.fruits,
                        veggies = EXCLUDED.veggies,
                        hvyalcoholconsump = EXCLUDED.hvyalcoholconsump,
                        anyhealthcare = EXCLUDED.anyhealthcare,
                        nodocbccost = EXCLUDED.nodocbccost,
                        genhlth = EXCLUDED.genhlth,
                        menthlth = EXCLUDED.menthlth,
                        physhlth = EXCLUDED.physhlth,
                        diffwalk = EXCLUDED.diffwalk,
                        sex = EXCLUDED.sex,
                        age = EXCLUDED.age,
                        education = EXCLUDED.education,
                        income = EXCLUDED.income,
                        source_key = EXCLUDED.source_key,
                        row_hash = EXCLUDED.row_hash,
                        batch_id = EXCLUDED.batch_id,
                        ingestion_ts = COALESCE(EXCLUDED.ingestion_ts, NOW())
                    WHERE gold.silver_snapshot.row_hash IS DISTINCT FROM EXCLUDED.row_hash
                    """,
                    rows,
                    page_size=5000,
                )
            else:
                _log("Reloading gold.silver_snapshot")
                execute_values(
                    cur,
                    """
                    INSERT INTO gold.silver_snapshot (
                        id, diabetes_binary, highbp, highchol, cholcheck, bmi, smoker, stroke,
                        heartdiseaseorattack, physactivity, fruits, veggies, hvyalcoholconsump,
                        anyhealthcare, nodocbccost, genhlth, menthlth, physhlth, diffwalk,
                        sex, age, education, income
                    ) VALUES %s
                    """,
                    [row[:23] for row in rows],
                    page_size=5000,
                )

            cardio_columns = ["HighBP", "HighChol", "CholCheck", "HeartDiseaseorAttack", "Stroke"]
            morpho_columns = ["BMI"]
            habitudes_columns = ["Smoker", "PhysActivity", "Fruits", "Veggies", "HvyAlcoholConsump"]
            acces_columns = ["AnyHealthcare", "NoDocbcCost"]
            etat_columns = ["GenHlth", "MentHlth", "PhysHlth", "DiffWalk"]
            demo_columns = ["Sex", "Age", "Education", "Income"]

            cardio_map = _insert_dimension(
                cur,
                "dim_cardio",
                "cardio_id",
                ["highbp", "highchol", "cholcheck", "heartdiseaseorattack", "stroke"],
                _build_dimension_data(star_rows, cardio_columns),
            )
            morpho_map = _insert_dimension(
                cur,
                "dim_morphologie",
                "morpho_id",
                ["bmi"],
                _build_dimension_data(star_rows, morpho_columns),
            )
            habitudes_map = _insert_dimension(
                cur,
                "dim_habitudes",
                "habitude_id",
                ["smoker", "physactivity", "fruits", "veggies", "hvyalcoholconsump"],
                _build_dimension_data(star_rows, habitudes_columns),
            )
            acces_map = _insert_dimension(
                cur,
                "dim_acces_soins",
                "acces_id",
                ["anyhealthcare", "nodocbccost"],
                _build_dimension_data(star_rows, acces_columns),
            )
            etat_map = _insert_dimension(
                cur,
                "dim_etat_sante",
                "etat_id",
                ["genhlth", "menthlth", "physhlth", "diffwalk"],
                _build_dimension_data(star_rows, etat_columns),
            )
            demo_map = _insert_dimension(
                cur,
                "dim_demographie",
                "demo_id",
                ["sex", "age", "education", "income"],
                _build_dimension_data(star_rows, demo_columns),
            )

            _log("Reloading gold.fact_diabetes")
            cur.execute("TRUNCATE TABLE gold.fact_diabetes;")
            fact_rows = [
                (
                    row["id_out"],
                    row["Diabetes_binary"],
                    row["risk_factor_count"],
                    cardio_map[tuple(row.get(column) for column in cardio_columns)],
                    morpho_map[tuple(row.get(column) for column in morpho_columns)],
                    habitudes_map[tuple(row.get(column) for column in habitudes_columns)],
                    acces_map[tuple(row.get(column) for column in acces_columns)],
                    etat_map[tuple(row.get(column) for column in etat_columns)],
                    demo_map[tuple(row.get(column) for column in demo_columns)],
                    row["source_key_out"],
                    row["row_hash_out"],
                    row["batch_id_out"],
                    row["ingestion_ts_out"],
                )
                for row in star_rows
            ]
            if fact_rows:
                execute_values(
                    cur,
                    """
                    INSERT INTO gold.fact_diabetes (
                        diabetes_id,
                        diabetes_binary,
                        risk_factor_count,
                        cardio_id,
                        morpho_id,
                        habitude_id,
                        acces_id,
                        etat_id,
                        demo_id,
                        source_key,
                        row_hash,
                        batch_id,
                        ingestion_ts
                    ) VALUES %s
                    """,
                    fact_rows,
                    page_size=5000,
                )
            conn.commit()
            _log("PostgreSQL commit completed")
        finally:
            cur.close()
            conn.close()

        print(
            "Silver -> Gold termine. Tables cibles: gold.silver_snapshot + schema en etoile PostgreSQL. "
            f"Mode: {'delta' if DELTA_MODE else 'full-refresh'}"
        )
    finally:
        spark.stop()


if __name__ == "__main__":
    main()
