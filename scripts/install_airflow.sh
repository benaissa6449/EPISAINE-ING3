#!/usr/bin/env bash
set -e

# Variables
AIRFLOW_VERSION="3.1.3"
PYTHON_VERSION="3.10"
AIRFLOW_HOME="$HOME/airflow"
ENV_DIR="$HOME/airflow-env"

echo "[1/5] Mise à jour des paquets..."
sudo apt update -y && sudo apt install -y python3-pip python3-venv libpq-dev build-essential

echo "[2/5] Création du venv..."
python3 -m venv "$ENV_DIR"
source "$ENV_DIR/bin/activate"

echo "[3/5] Installation d'Apache Airflow..."
CONSTRAINT_URL="https://raw.githubusercontent.com/apache/airflow/constraints-${AIRFLOW_VERSION}/constraints-${PYTHON_VERSION}.txt"
pip install --upgrade pip
pip install "apache-airflow[postgres,celery,redis]==${AIRFLOW_VERSION}" --constraint "${CONSTRAINT_URL}"

echo "[4/5] Initialisation de la base Airflow..."
export AIRFLOW_HOME="$AIRFLOW_HOME"
mkdir -p "$AIRFLOW_HOME"
airflow db migrate

echo "[5/5] Création d'un user admin..."
airflow users create \
  --username admin \
  --firstname Admin \
  --lastname User \
  --role Admin \
  --email admin@example.com \
  --password admin

echo "Installation terminée."
echo "Pour démarrer le webserver :"
echo "  source $ENV_DIR/bin/activate"
echo "  export AIRFLOW_HOME=$AIRFLOW_HOME"
echo "  airflow webserver -p 8080 &"
echo "  airflow scheduler &"