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

from common.config import APP_NAME, MONGO_URI, SILVER_COLLECTION
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
            cur.execute("TRUNCATE TABLE gold.silver_snapshot;")

            rows = (
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
                )
                for r in silver.toLocalIterator()
            )

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
                rows,
                page_size=5000,
            )
            conn.commit()
        finally:
            cur.close()
            conn.close()

        print("Silver -> Gold termine. Table cible: gold.silver_snapshot (PostgreSQL)")
    finally:
        spark.stop()


if __name__ == "__main__":
    main()
