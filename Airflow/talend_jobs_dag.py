from datetime import datetime
from airflow import DAG
from airflow.providers.ssh.operators.ssh import SSHOperator

with DAG(
    dag_id="talend_jobs_dag",
    start_date=datetime(2025, 12, 1),
    schedule=None,
    catchup=False,
) as dag:

    bronze = SSHOperator(
        task_id="load_bronze",
        ssh_conn_id="ssh_talend_vm",
        command="bash -lc 'docker exec talend /opt/talend/LoadBronze/LoadBronze_run.sh'",
        cmd_timeout=7200,
    )

    silver = SSHOperator(
        task_id="load_silver",
        ssh_conn_id="ssh_talend_vm",
        command="bash -lc 'docker exec talend /opt/talend/LoadSilver/LoadSilver_run.sh'",
        cmd_timeout=7200,
    )

    gold = SSHOperator(
        task_id="load_gold",
        ssh_conn_id="ssh_talend_vm",
        command="bash -lc 'docker exec talend /opt/talend/LoadGold/LoadGold_run.sh'",
        cmd_timeout=7200,
    )

    bronze >> silver >> gold