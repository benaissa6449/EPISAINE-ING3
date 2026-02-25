#!/bin/bash
set -e

DEPLOY_USER="$1"
DEPLOY_HOST="$2"
DEPLOY_PATH="/home/episaine/customers-mock"

echo "Deploying customers-mock to ${DEPLOY_USER}@${DEPLOY_HOST}"

rsync -av Mock/customers-mock/docker-compose.yml ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av Mock/customers-mock/app/ ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/app/

ssh ${DEPLOY_USER}@${DEPLOY_HOST} <<EOF
  cd ${DEPLOY_PATH}
  docker compose down --rmi local
  docker compose up -d --build
  docker image prune -f
  echo "customers-mock deployed successfully"
EOF
