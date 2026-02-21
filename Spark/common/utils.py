from pyspark.sql import SparkSession

def build_spark(app_name: str, mongo_uri: str) -> SparkSession:
    return (
        SparkSession.builder
        .appName(app_name)
        .config("spark.mongodb.read.connection.uri", mongo_uri)
        .config("spark.mongodb.write.connection.uri", mongo_uri)
        .getOrCreate()
    )
