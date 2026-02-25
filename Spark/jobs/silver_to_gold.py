"""
silver_to_gold.py

ETL job for copying Silver data into PostgreSQL Gold table.
This script reads the Silver collection from MongoDB and writes the same
records into gold.silver_snapshot in PostgreSQL for BI consumption.
"""

import os
import sys
from urllib.parse import urlparse

sys.path.append(os.path.dirname(os.path.dirname(__file__)))

from common.config import APP_NAME, BATCH_ID, DELTA_MODE, MONGO_URI, SILVER_COLLECTION
from common.schemas import DIABETES_COLUMNS
from common.utils import build_spark


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


def main():
    import psycopg2
    from psycopg2.extras import execute_values

    spark = build_spark(f"{APP_NAME}-silver-to-gold", MONGO_URI)
    try:
        silver = spark.read.format("mongodb").option("collection", SILVER_COLLECTION).load()
        silver = silver.select(*[c for c in DIABETES_COLUMNS if c in silver.columns])

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

            if DELTA_MODE:
                cur.execute("ALTER TABLE gold.silver_snapshot ADD COLUMN IF NOT EXISTS source_key TEXT;")
                cur.execute("ALTER TABLE gold.silver_snapshot ADD COLUMN IF NOT EXISTS row_hash TEXT;")
                cur.execute("ALTER TABLE gold.silver_snapshot ADD COLUMN IF NOT EXISTS batch_id TEXT;")
                cur.execute("ALTER TABLE gold.silver_snapshot ADD COLUMN IF NOT EXISTS ingestion_ts TIMESTAMP;")
            else:
                cur.execute("TRUNCATE TABLE gold.silver_snapshot;")

            rows = []
            for r in silver.toLocalIterator():
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

            if DELTA_MODE:
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
            conn.commit()
        finally:
            cur.close()
            conn.close()

        print(
            "Silver -> Gold termine. Table cible: gold.silver_snapshot (PostgreSQL). "
            f"Mode: {'delta' if DELTA_MODE else 'full-refresh'}"
        )
    finally:
        spark.stop()


if __name__ == "__main__":
    main()
