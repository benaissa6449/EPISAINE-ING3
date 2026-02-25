#!/bin/bash
set -e

DEPLOY_USER="$1"
DEPLOY_HOST="$2"
DEPLOY_PATH="/home/episaine/episaine-kafka-backend"

echo "Deploying episaine-kafka-backend to ${DEPLOY_USER}@${DEPLOY_HOST}"

rsync -av episaine-kafka-backend/Dockerfile ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av episaine-kafka-backend/docker-compose.yml ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av episaine-kafka-backend/src ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av episaine-kafka-backend/pom.xml ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av episaine-kafka-backend/scripts ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av episaine-static-front/ ${DEPLOY_USER}@${DEPLOY_HOST}:/home/episaine/episaine-static-front/

ssh ${DEPLOY_USER}@${DEPLOY_HOST} <<EOF
  cd ${DEPLOY_PATH}
  docker compose down --rmi local
  docker compose up -d --build
  docker image prune -f
EOF
