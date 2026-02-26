import os
from pyspark.sql import SparkSession


def build_spark(app_name: str, mongo_uri: str) -> SparkSession:
    """
    Build a Spark session with defaults suited for single-VM execution.
    Environment variables can override defaults:
    - SPARK_MASTER (default: local[*])
    - SPARK_DRIVER_HOST (optional)
    """
    builder = (
        SparkSession.builder
        .master(os.getenv("SPARK_MASTER", "local[*]"))
        .appName(app_name)
        .config("spark.mongodb.read.connection.uri", mongo_uri)
        .config("spark.mongodb.write.connection.uri", mongo_uri)
        .config(
            "spark.mongodb.read.partitioner",
            os.getenv(
                "SPARK_MONGO_READ_PARTITIONER",
                "com.mongodb.spark.sql.connector.read.partitioner.SinglePartitionPartitioner",
            ),
        )
        .config("spark.sql.shuffle.partitions", os.getenv("SPARK_SQL_SHUFFLE_PARTITIONS", "8"))
        .config("spark.network.timeout", os.getenv("SPARK_NETWORK_TIMEOUT", "600s"))
        .config("spark.executor.heartbeatInterval", os.getenv("SPARK_HEARTBEAT_INTERVAL", "60s"))
    )

    driver_host = os.getenv("SPARK_DRIVER_HOST")
    if driver_host:
        builder = (
            builder
            .config("spark.driver.host", driver_host)
            .config("spark.driver.bindAddress", "0.0.0.0")
        )

    return builder.getOrCreate()
