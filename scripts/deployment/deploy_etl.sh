#!/bin/bash
set -e

# Variables passées en argument
DEPLOY_USER="$1"
DEPLOY_HOST="$2"
DEPLOY_PATH="/home/episaine/episaine-talend-component"

echo "Deploying to ${DEPLOY_USER}@${DEPLOY_HOST}"

# Synchronisation des fichiers
rsync -av episaine-talend-component/Jobs ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av episaine-talend-component/docker-compose.yml ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/docker-compose.yml

# Déploiement Docker
ssh ${DEPLOY_USER}@${DEPLOY_HOST} <<EOF
  cd ${DEPLOY_PATH}
  docker compose down
  docker compose up -d
EOF
