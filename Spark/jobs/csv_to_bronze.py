"""
csv_to_bronze.py

ETL job to load CSV data into the Bronze collection in MongoDB.
This script reads a CSV file, prepares the input, and writes the result to MongoDB.

Author: Ismail Benaissa
Date: 2026-02-21
"""
import os
import sys
from pathlib import Path
import shutil

from pyspark.sql import functions as F

sys.path.append(os.path.dirname(os.path.dirname(__file__)))

from common.config import APP_NAME, BRONZE_COLLECTION, CSV_INPUT_PATH, MONGO_URI
from common.utils import build_spark


def _prepare_input_csv() -> str:
    """
    Prepare the input CSV file for processing.
    Ensures the CSV exists at the target location, copies from fallback if needed.
    Returns:
        str: Path to the CSV file.
    Raises:
        FileNotFoundError: If CSV is not found in either location.
    """
    target = Path(CSV_INPUT_PATH).expanduser()
    target.parent.mkdir(parents=True, exist_ok=True)

    # If CSV already exists, return its path
    if target.exists():
        return str(target)

    # Try fallback location
    spark_root = Path(__file__).resolve().parents[1]
    fallback = spark_root / "data" / "cdc_diabetes_253k.csv"
    if fallback.exists():
        shutil.copy2(fallback, target)
        print(f"CSV copied from {fallback} to {target}")
        return str(target)

    # Raise error if CSV not found
    raise FileNotFoundError(
        f"CSV not found. Expected: {target}. "
        f"Fallback checked: {fallback}."
    )


def main():
    """
    Main ETL function:
    - Reads CSV file
    - Loads data into Spark DataFrame
    - Writes DataFrame to MongoDB Bronze collection
    """
    spark = build_spark(f"{APP_NAME}-csv-to-bronze", MONGO_URI)
    try:
        # Prepare CSV input
        csv_path = _prepare_input_csv()
        # Read CSV into DataFrame
        df = (
            spark.read.option("header", True)
            .option("inferSchema", True)
            .csv(csv_path)
            .withColumn("ID", F.monotonically_increasing_id() + F.lit(1))
        )

        # Write DataFrame to MongoDB Bronze collection
        (
            df.write.format("mongodb")
            .mode("overwrite")
            .option("collection", BRONZE_COLLECTION)
            .save()
        )
        print(f"CSV -> Bronze finished. Target collection: {BRONZE_COLLECTION}")
    finally:
        # Stop Spark session
        spark.stop()


if __name__ == "__main__":
    main()
