#!/bin/bash
set -e

DEPLOY_USER="$1"
DEPLOY_HOST="$2"
DEPLOY_PATH="/home/episaine/kafka-mock"

echo "Deploying kafka-mock to ${DEPLOY_USER}@${DEPLOY_HOST}"

rsync -av Mock/kafka-mock/app.py ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av Mock/kafka-mock/requirements.txt ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av Mock/kafka-mock/reset_topic_and_run_mock.sh ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av Mock/kafka-mock/Dockerfile ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/

ssh ${DEPLOY_USER}@${DEPLOY_HOST} <<EOF
  cd ${DEPLOY_PATH}
  chmod +x reset_topic_and_run_mock.sh
  python3 -m venv .venv
  . .venv/bin/activate
  pip install -r requirements.txt
  echo "Starting kafka mock..."
  KAFKA_BOOTSTRAP_SERVERS=localhost:9092 KAFKA_TOPIC=customer-profile RATE_PER_SEC=0.0167 nohup python app.py > kafka-mock.log 2>&1 &
  echo "Kafka mock started (PID: \$!)"
EOF
