#!/usr/bin/env bash
set -euo pipefail

AIRFLOW_HOME="${AIRFLOW_HOME:-$HOME/airflow}"
VENV_PATH="${VENV_PATH:-$HOME/airflow-env}"
DAG_ID="${DAG_ID:-spark_client}"
TEST_DATE="${TEST_DATE:-2026-02-18}"
USE_DAGS_TEST_FALLBACK="${USE_DAGS_TEST_FALLBACK:-1}"
SSH_CONN_ID="${SSH_CONN_ID:-ssh_spark_vm}"
SSH_HOST="${SSH_HOST:-127.0.0.1}"
SSH_LOGIN="${SSH_LOGIN:-episaine}"
SSH_PORT="${SSH_PORT:-22}"
SSH_PASSWORD="${SSH_PASSWORD:-}"

source "$VENV_PATH/bin/activate"

echo "AIRFLOW_HOME=$AIRFLOW_HOME"
echo "Checking DAG import..."

python - <<'PY'
import os
from airflow.models.dagbag import DagBag
b = DagBag(dag_folder=os.path.expanduser(os.environ.get("AIRFLOW_HOME", "~/airflow") + "/dags"), include_examples=False)
print("IMPORT_ERRORS:", b.import_errors)
print("DAGS:", sorted(b.dags.keys()))
PY

echo "Checking SSH connection: $SSH_CONN_ID"
if ! airflow connections get "$SSH_CONN_ID" >/dev/null 2>&1; then
  echo "Creating missing connection: $SSH_CONN_ID"
  if [ -n "$SSH_PASSWORD" ]; then
    airflow connections add "$SSH_CONN_ID" \
      --conn-type ssh \
      --conn-host "$SSH_HOST" \
      --conn-login "$SSH_LOGIN" \
      --conn-port "$SSH_PORT" \
      --conn-password "$SSH_PASSWORD" \
      --conn-extra '{"no_host_key_check": true}'
  else
    airflow connections add "$SSH_CONN_ID" \
      --conn-type ssh \
      --conn-host "$SSH_HOST" \
      --conn-login "$SSH_LOGIN" \
      --conn-port "$SSH_PORT" \
      --conn-extra '{"no_host_key_check": true}'
  fi
fi

if ! airflow dags list 2>/dev/null | grep -q "$DAG_ID"; then
  echo "DAG '$DAG_ID' not found in DagModel. Restarting dag-processor/scheduler..."
  airflow db migrate >/dev/null 2>&1 || true
  pkill -f "airflow dag-processor" || true
  pkill -f "airflow scheduler" || true
  airflow dag-processor -D || true
  airflow scheduler -D
  sleep 12
fi

echo "Available DAG entry:"
if airflow dags list 2>/dev/null | grep -q "$DAG_ID"; then
  airflow dags list | grep "$DAG_ID"
  echo "Triggering DAG: $DAG_ID"
  airflow dags trigger "$DAG_ID"
  echo "Done."
  exit 0
fi

echo "DAG '$DAG_ID' still not found in DagModel."
if [ "$USE_DAGS_TEST_FALLBACK" = "1" ]; then
  echo "Fallback: running 'airflow dags test $DAG_ID $TEST_DATE'"
  airflow dags test "$DAG_ID" "$TEST_DATE"
  echo "Done (fallback with dags test)."
else
  exit 1
fi
