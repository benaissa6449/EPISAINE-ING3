"""
================================================================================
EPISAINE - DAG Talend Jobs Orchestration
================================================================================
Auteurs : Ismail Benaissa, John Wang
Description : Orchestration du pipeline ETL EPISAINE avec Talend
Pipeline : Bronze → Silver → Gold (Medallion Architecture)
================================================================================
"""

from datetime import datetime
from airflow import DAG
from airflow.providers.ssh.operators.ssh import SSHOperator

# Configuration par défaut pour les tâches
default_args = {
    "owner": "talend",
    "retries": 1,
}

# Définition du DAG principal
with DAG(
    dag_id="talend_jobs_dag",
    default_args=default_args,
    start_date=datetime(2025, 12, 1),
    schedule_interval=None,  # Déclenché manuellement ou par un trigger externe
    catchup=False,  # Ne pas exécuter les runs passés manqués
    tags=["talend", "etl", "episaine"],
    description="Pipeline ETL EPISAINE : Import et transformation de données via Talend",
) as dag:

    # Tâche 1 : BRONZE - Chargement des données brutes
    # Cette étape importe les données sources sans transformation
    # Contexte : Données non traitées, structure originale conservée
    bronze = SSHOperator(
        task_id="load_bronze",
        ssh_conn_id="ssh_talend_vm",  # Connexion SSH vers la VM Talend
        command="bash -lc 'docker exec talend /opt/talend/LoadBronze/LoadBronze_run.sh'",
        cmd_timeout=600,  # Timeout : 10 minutes
    )

    # Tâche 2 : SILVER - Nettoyage et transformation des données
    # Cette étape applique les règles métier et nettoie les données
    # Contexte : Données validées, structurées, enrichies
    silver = SSHOperator(
        task_id="load_silver",
        ssh_conn_id="ssh_talend_vm",
        command="bash -lc 'docker exec talend /opt/talend/LoadSilver/LoadSilver_run.sh'",
        cmd_timeout=600,
    )

    # Tâche 3 : GOLD - Agrégation et préparation pour l'analytique
    # Cette étape crée des vues agrégées prêtes pour l'analyse et reporting
    # Contexte : Données de haute qualité, optimisées pour les requêtes analytiques
    gold = SSHOperator(
        task_id="load_gold",
        ssh_conn_id="ssh_talend_vm",
        command="bash -lc 'docker exec talend /opt/talend/LoadGold/LoadGold_run.sh'",
        cmd_timeout=600,
    )

    # Dépendances : Ordre d'exécution du pipeline
    # Bronze doit se terminer avant Silver
    # Silver doit se terminer avant Gold
    bronze >> silver >> gold