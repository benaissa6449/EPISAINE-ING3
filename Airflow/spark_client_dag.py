"""
EPISAINE - DAG Spark Jobs Orchestration
Pipeline : CSV -> Bronze -> Silver -> Gold
"""

from datetime import datetime, timedelta

from airflow import DAG
from airflow.providers.ssh.hooks.ssh import SSHHook
from airflow.providers.ssh.operators.ssh import SSHOperator


SSH_CONN_ID = "ssh_spark_vm"
SPARK_HOME = "/opt/spark/bin/spark-submit"
SPARK_PACKAGES = "org.mongodb.spark:mongo-spark-connector_2.12:10.6.0"
MONGO_URI = "mongodb://root:root@192.168.248.165:27017/episaine?authSource=admin"
SPARK_PROJECT_DIR = "~/Spark"
CSV_TARGET = "/home/episaine/data/uci/cdc_diabetes_253k.csv"
CSV_FALLBACK = "~/Spark/data/cdc_diabetes_253k.csv"

# Ajout de la variable PostgreSQL
POSTGRES_URI = "postgresql://episaine:episaine@192.168.248.170:5432/episaine"


def spark_submit_command(job_script: str) -> str:
    # Toutes les tâches reçoivent MONGO_URI/POSTGRES_URI + conf Spark réseau
    return (
        "bash -lc '"
        "set -uo pipefail && "
        f"cd {SPARK_PROJECT_DIR} && "
        f"test -f jobs/{job_script} && "
        "SPARK_MASTER=\"local[*]\" "
        "SPARK_NETWORK_TIMEOUT=\"600s\" "
        "SPARK_HEARTBEAT_INTERVAL=\"60s\" "
        "SPARK_LOG_LEVEL=\"ERROR\" "
        f"MONGO_URI=\"{MONGO_URI}\" POSTGRES_URI=\"{POSTGRES_URI}\" "
        f"{SPARK_HOME} --packages {SPARK_PACKAGES} jobs/{job_script} "
        f"> /tmp/{job_script}.log 2>&1; "
        "rc=$?; "
        f"tail -n 200 /tmp/{job_script}.log; "
        "exit $rc"
        "'"
    )


default_args = {
    "owner": "spark",
    "retries": 2,
    "retry_delay": timedelta(minutes=5),
}

ssh_hook = SSHHook(
    ssh_conn_id=SSH_CONN_ID,
    conn_timeout=30,
    keepalive_interval=30,
)


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
        ssh_hook=ssh_hook,
        command=(
            "bash -lc '"
            f"mkdir -p $(dirname {CSV_TARGET}) && "
            f"if [ -f {CSV_TARGET} ]; then "
            "echo \"CSV already present\"; "
            f"elif [ -f {CSV_FALLBACK} ]; then "
            f"cp -f {CSV_FALLBACK} {CSV_TARGET} && echo \"CSV copied from fallback\"; "
            "else "
            "echo \"CSV missing in target and fallback\" && exit 1; "
            "fi"
            "'"
        ),
        cmd_timeout=600,
        get_pty=True,
    )

    csv_to_bronze = SSHOperator(
        task_id="csv_to_bronze",
        ssh_hook=ssh_hook,
        command=spark_submit_command("csv_to_bronze.py"),
        cmd_timeout=3600,
        get_pty=True,
    )

    bronze_to_silver = SSHOperator(
        task_id="bronze_to_silver",
        ssh_hook=ssh_hook,
        command=spark_submit_command("bronze_to_silver.py"),
        cmd_timeout=3600,
        get_pty=True,
    )

    silver_to_gold = SSHOperator(
        task_id="silver_to_gold",
        ssh_hook=ssh_hook,
        command=spark_submit_command("silver_to_gold.py"),
        cmd_timeout=3600,
        get_pty=True,
    )

    extract_and_copy_csv >> csv_to_bronze >> bronze_to_silver >> silver_to_gold
