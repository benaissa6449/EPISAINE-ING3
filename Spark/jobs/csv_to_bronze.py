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

from common.config import APP_NAME, BATCH_ID, BRONZE_COLLECTION, CSV_INPUT_PATH, DELTA_MODE, MONGO_URI
from common.schemas import DIABETES_COLUMNS
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
        )

        # Normalize column names (trim + drop BOM on first header).
        normalized_names = []
        for c in df.columns:
            normalized = c.strip().replace("\ufeff", "")
            normalized_names.append((c, normalized))
        for old_name, new_name in normalized_names:
            if old_name != new_name:
                df = df.withColumnRenamed(old_name, new_name)

        required_input_columns = [c for c in DIABETES_COLUMNS if c != "ID"]
        missing_columns = [c for c in required_input_columns if c not in df.columns]
        if missing_columns:
            raise ValueError(
                f"CSV schema invalid. Missing required columns: {missing_columns}. "
                f"Detected columns: {df.columns}"
            )

        if DELTA_MODE:
            # Keep only the business payload to build deterministic technical metadata.
            df = df.select(*required_input_columns)
            hash_input = [F.coalesce(F.col(c).cast("string"), F.lit("")) for c in required_input_columns]
            payload_hash = F.sha2(F.concat_ws("||", *hash_input), 256)

            df = df.withColumn("source_key", payload_hash)
            df = df.withColumn("row_hash", payload_hash)
            df = df.withColumn("batch_id", F.lit(BATCH_ID if BATCH_ID else None).cast("string"))
            df = df.withColumn("ingestion_ts", F.current_timestamp())
            df = df.withColumn("ID", F.abs(F.xxhash64(F.col("source_key"))) + F.lit(1))
            write_mode = "append"
        else:
            # Backward-compatible behavior.
            df = df.withColumn("ID", F.monotonically_increasing_id() + F.lit(1))
            write_mode = "overwrite"

        # Write DataFrame to MongoDB Bronze collection
        (
            df.write.format("mongodb")
            .mode(write_mode)
            .option("collection", BRONZE_COLLECTION)
            .save()
        )
        print(
            f"CSV -> Bronze finished. Target collection: {BRONZE_COLLECTION}. "
            f"Mode: {'delta' if DELTA_MODE else 'full-refresh'}"
        )
    finally:
        # Stop Spark session
        spark.stop()


if __name__ == "__main__":
    main()
