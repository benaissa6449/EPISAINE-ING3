#!/bin/bash
set -e

DEPLOY_USER="$1"
DEPLOY_HOST="$2"
DEPLOY_PATH="/home/episaine/episaine-cache-loader"

echo "Deploying episaine-cache-loader to ${DEPLOY_USER}@${DEPLOY_HOST}"

rsync -av episaine-cache-loader/Dockerfile ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av episaine-cache-loader/docker-compose.yml ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av episaine-cache-loader/src ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av episaine-cache-loader/pom.xml ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av episaine-cache-loader/.mvn ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av episaine-cache-loader/mvnw ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/

ssh ${DEPLOY_USER}@${DEPLOY_HOST} <<EOF
  cd ${DEPLOY_PATH}
  docker compose down
  docker compose up -d --build
EOF
