import os


APP_NAME = os.getenv("SPARK_APP_NAME", "episaine-bronze-to-silver")
MONGO_URI = os.getenv(
    "MONGO_URI",
    "mongodb://root:root@192.168.248.165:27017/episaine?authSource=admin",
)

BRONZE_COLLECTION = os.getenv("BRONZE_COLLECTION", "episaine_bronze_client")
SILVER_COLLECTION = os.getenv("SILVER_COLLECTION", "episaine_silver_client")
GOLD_COLLECTION = os.getenv("GOLD_COLLECTION", "episaine_gold_client")

CSV_INPUT_PATH = os.getenv("CSV_INPUT_PATH", "/home/episaine/data/uci/cdc_diabetes_253k.csv")
