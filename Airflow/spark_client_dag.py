"""
EPISAINE - DAG Spark Jobs Orchestration
Pipeline : CSV -> Bronze -> Silver -> Gold
"""

from datetime import datetime, timedelta

from airflow import DAG
from airflow.providers.ssh.operators.ssh import SSHOperator


SSH_CONN_ID = "ssh_spark_vm"
SPARK_HOME = "/opt/spark/bin/spark-submit"
SPARK_PACKAGES = "org.mongodb.spark:mongo-spark-connector_2.12:10.6.0"
MONGO_URI = "mongodb://root:root@192.168.248.165:27017/episaine?authSource=admin"
SPARK_PROJECT_DIR = "~/Spark"

# Ajout de la variable PostgreSQL
POSTGRES_URI = "postgresql://user:password@192.168.248.170:5432/gold"


def spark_submit_command(job_script: str) -> str:
    # Toutes les tâches reçoivent MONGO_URI et POSTGRES_URI
    return (
        "bash -lc '"
        f"cd {SPARK_PROJECT_DIR} && "
        f"MONGO_URI=\"{MONGO_URI}\" POSTGRES_URI=\"{POSTGRES_URI}\" "
        f"{SPARK_HOME} --packages {SPARK_PACKAGES} jobs/{job_script}"
        "'"
    )


default_args = {
    "owner": "spark",
    "retries": 1,
    "retry_delay": timedelta(minutes=2),
}


with DAG(
    dag_id="spark_client",
    default_args=default_args,
    start_date=datetime(2025, 12, 1),
    schedule=None,
    catchup=False,
    tags=["spark", "etl", "episaine"],
    description="Pipeline Spark EPISAINE : CSV -> Bronze -> Silver -> Gold",
) as dag:
    extract_and_copy_csv = SSHOperator(
        task_id="extract_and_copy_csv",
        ssh_conn_id=SSH_CONN_ID,
        command="scp /local/path/to/cdc_diabetes_253k.csv episaine@192.168.248.170:/home/episaine/data/uci/cdc_diabetes_253k.csv",
        cmd_timeout=600,
        get_pty=True,
    )

    csv_to_bronze = SSHOperator(
        task_id="csv_to_bronze",
        ssh_conn_id=SSH_CONN_ID,
        command=spark_submit_command("csv_to_bronze.py"),
        cmd_timeout=1200,
        get_pty=True,
    )

    bronze_to_silver = SSHOperator(
        task_id="bronze_to_silver",
        ssh_conn_id=SSH_CONN_ID,
        command=spark_submit_command("bronze_to_silver.py"),
        cmd_timeout=1200,
        get_pty=True,
    )

    silver_to_gold = SSHOperator(
        task_id="silver_to_gold",
        ssh_conn_id=SSH_CONN_ID,
        command=spark_submit_command("silver_to_gold.py"),
        cmd_timeout=1200,
        get_pty=True,
    )

    extract_and_copy_csv >> csv_to_bronze >> bronze_to_silver >> silver_to_gold
