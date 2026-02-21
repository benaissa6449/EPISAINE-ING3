#!/bin/bash

cd ~/Spark

/opt/spark/bin/spark-submit --packages org.mongodb.spark:mongo-spark-connector_2.12:10.6.0 jobs/csv_to_bronze.py
/opt/spark/bin/spark-submit --packages org.mongodb.spark:mongo-spark-connector_2.12:10.6.0 jobs/bronze_to_silver.py
/opt/spark/bin/spark-submit jobs/silver_to_gold.py