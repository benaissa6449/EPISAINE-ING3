#!/bin/bash
set -e

DEPLOY_USER="$1"
DEPLOY_HOST="$2"
DEPLOY_PATH="/home/episaine/Spark"

echo "Deploying Spark to ${DEPLOY_USER}@${DEPLOY_HOST}"

rsync -av Spark/jobs ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av Spark/common ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av Spark/data ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av Spark/requirements.txt ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/requirements.txt
rsync -av Spark/run_etl.sh ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/run_etl.sh

ssh ${DEPLOY_USER}@${DEPLOY_HOST} <<EOF
  cd ${DEPLOY_PATH}
  echo "Setting execute permissions..."
  chmod +x run_etl.sh
  echo "Installing Python dependencies..."
  pip install -r requirements.txt
EOF
