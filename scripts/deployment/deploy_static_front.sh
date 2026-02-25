#!/bin/bash
set -e

DEPLOY_USER="$1"
DEPLOY_HOST="$2"
DEPLOY_PATH="/home/episaine/episaine-static-front"

echo "Deploying episaine-static-front to ${DEPLOY_USER}@${DEPLOY_HOST}"

rsync -av episaine-static-front/Dockerfile ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av episaine-static-front/nginx.conf ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av episaine-static-front/package*.json ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av episaine-static-front/tsconfig.json ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av episaine-static-front/public ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av episaine-static-front/src ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/

ssh ${DEPLOY_USER}@${DEPLOY_HOST} <<EOF
  cd ${DEPLOY_PATH}
  docker stop episaine-static-front || true
  docker rm episaine-static-front || true
  docker rmi episaine-static-front:latest || true
  docker build -t episaine-static-front:latest .
  docker image prune -f
EOF
