#!/bin/bash
set -euo pipefail

cd ~/Spark

export SPARK_MASTER="${SPARK_MASTER:-local[*]}"
export SPARK_NETWORK_TIMEOUT="${SPARK_NETWORK_TIMEOUT:-600s}"
export SPARK_HEARTBEAT_INTERVAL="${SPARK_HEARTBEAT_INTERVAL:-60s}"

MONGO_PKG="org.mongodb.spark:mongo-spark-connector_2.12:10.6.0"

/opt/spark/bin/spark-submit --packages "$MONGO_PKG" jobs/csv_to_bronze.py
/opt/spark/bin/spark-submit --packages "$MONGO_PKG" jobs/bronze_to_silver.py
/opt/spark/bin/spark-submit --packages "$MONGO_PKG" jobs/silver_to_gold.py
