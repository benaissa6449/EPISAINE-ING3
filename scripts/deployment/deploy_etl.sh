#!/bin/bash
set -e

DEPLOY_USER="$1"
DEPLOY_HOST="$2"
DEPLOY_PATH="/home/episaine/episaine-talend-component"

echo "Deploying to ${DEPLOY_USER}@${DEPLOY_HOST}"

rsync -av episaine-talend-component/Jobs ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
rsync -av episaine-talend-component/docker-compose.yml ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/docker-compose.yml

ssh ${DEPLOY_USER}@${DEPLOY_HOST} <<EOF
  cd ${DEPLOY_PATH}
  echo "Setting execute permissions on job scripts..."
  chmod +x Jobs/LoadBronze/LoadBronze_run.sh
  chmod +x Jobs/LoadBronzeK/LoadBronzeK_run.sh
  chmod +x Jobs/LoadBronzeNutritional/LoadBronzeNutritional_run.sh
  chmod +x Jobs/LoadBronzeTMDB/LoadBronzeTMDB_run.sh
  chmod +x Jobs/LoadSilver/LoadSilver_run.sh
  chmod +x Jobs/LoadGold/LoadGold_run.sh
  docker compose down
  docker compose up -d
EOF
