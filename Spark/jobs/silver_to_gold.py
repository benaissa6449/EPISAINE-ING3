"""
silver_to_gold.py

ETL job for aggregating Silver data and storing results in PostgreSQL.
This script reads the Silver collection from MongoDB, performs group-by aggregations,
and writes the results to the gold.clients table in PostgreSQL.

Author: Ismail Benaissa
Date: 2026-02-21
"""

import os
import sys
from pyspark.sql import functions as F

# Add project root to sys.path for imports
sys.path.append(os.path.dirname(os.path.dirname(__file__)))

# Import project configuration and utilities
from common.config import APP_NAME, GOLD_COLLECTION, MONGO_URI, SILVER_COLLECTION
from common.utils import build_spark

def main():
    """
    Main ETL function:
    - Reads Silver data from MongoDB
    - Aggregates by Sex and Diabetes_binary
    - Stores results in PostgreSQL gold.clients table
    """
    import psycopg2
    from pyspark.sql import DataFrame

    # Initialize Spark session
    spark = build_spark(f"{APP_NAME}-silver-to-gold", MONGO_URI)
    try:
        # Read Silver collection from MongoDB
        silver = spark.read.format("mongodb").option("collection", SILVER_COLLECTION).load()

        # Group and aggregate data by Sex and Diabetes_binary
        # Calculate population count and averages for BMI, MentHlth, PhysHlth
        gold = (
            silver.groupBy("Sex", "Diabetes_binary")
            .agg(
                F.count("*").alias("population"),
                F.avg("BMI").alias("avg_bmi"),
                F.avg("MentHlth").alias("avg_mental_days"),
                F.avg("PhysHlth").alias("avg_physical_days"),
            )
            .withColumn("avg_bmi", F.round("avg_bmi", 2))
            .withColumn("avg_mental_days", F.round("avg_mental_days", 2))
            .withColumn("avg_physical_days", F.round("avg_physical_days", 2))
        )

        # Connect to PostgreSQL database
        conn = psycopg2.connect(
            host="192.168.248.170",
            port=5432,
            dbname="episaine",
            user="episaine",
            password="episaine"
        )
        cur = conn.cursor()

        # Create gold.clients table with aggregation columns if it does not exist
        cur.execute("""
            CREATE TABLE IF NOT EXISTS gold.clients (
                id SERIAL PRIMARY KEY,
                nom TEXT,
                email TEXT,
                date_inscription DATE,
                population INTEGER,
                avg_bmi FLOAT,
                avg_mental_days FLOAT,
                avg_physical_days FLOAT
            );
        """)
        conn.commit()

        def insert_clients(df: DataFrame):
            """
            Insert aggregated data into gold.clients table.
            Args:
                df (DataFrame): Aggregated Spark DataFrame
            """
            # Iterate over each row in the DataFrame and insert into PostgreSQL
            for row in df.collect():
                cur.execute(
                    "INSERT INTO gold.clients (nom, email, date_inscription, population, avg_bmi, avg_mental_days, avg_physical_days) VALUES (%s, %s, %s, %s, %s, %s, %s)",
                    (
                        str(row.Sex),
                        str(row.Diabetes_binary),
                        None,
                        int(row.population),
                        float(row.avg_bmi),
                        float(row.avg_mental_days),
                        float(row.avg_physical_days)
                    )
                )
            conn.commit()

        # Insert data into PostgreSQL
        insert_clients(gold)
        cur.close()
        conn.close()
        print("Silver -> Gold finished. Target table: gold.clients (PostgreSQL)")
    finally:
        # Stop Spark session
        spark.stop()

if __name__ == "__main__":
    main()