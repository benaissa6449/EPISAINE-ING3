#!/bin/bash
set -e

DEPLOY_USER="$1"
DEPLOY_HOST="$2"
DEPLOY_PATH="/home/episaine/episaine-send-notification"

echo "Deploying episaine-send-notification to ${DEPLOY_USER}@${DEPLOY_HOST}"

rsync -av episaine-send-notification/Dockerfile ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av episaine-send-notification/docker-compose.yml ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av episaine-send-notification/src ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av episaine-send-notification/pom.xml ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/

ssh ${DEPLOY_USER}@${DEPLOY_HOST} <<EOF
  cd ${DEPLOY_PATH}
  docker compose down --rmi local
  docker compose up -d --build
  docker image prune -f
EOF
