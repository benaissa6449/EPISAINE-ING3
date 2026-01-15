#!/bin/bash

# Script pour créer les topics Kafka pour EPISAINE
# Assurez-vous que Kafka et Zookeeper sont démarrés avant d'exécuter ce script

KAFKA_HOME="/opt/kafka"
BOOTSTRAP_SERVER="localhost:9092"

echo "===== Création des topics Kafka ====="
echo ""
echo "Assurez-vous que Kafka et Zookeeper sont déjà démarrés!"
echo ""

echo "Création du topic 'customer-profile'..."
$KAFKA_HOME/bin/kafka-topics.sh --create \
  --topic customer-profile \
  --bootstrap-server $BOOTSTRAP_SERVER \
  --replication-factor 1 \
  --partitions 1

echo ""

echo "Création du topic 'recipe-programs'..."
$KAFKA_HOME/bin/kafka-topics.sh --create \
  --topic recipe-programs \
  --bootstrap-server $BOOTSTRAP_SERVER \
  --replication-factor 1 \
  --partitions 1

echo ""
echo "===== Vérification des topics créés ====="
$KAFKA_HOME/bin/kafka-topics.sh --list --bootstrap-server $BOOTSTRAP_SERVER

echo ""
echo "===== Détails des topics ====="
$KAFKA_HOME/bin/kafka-topics.sh --describe --bootstrap-server $BOOTSTRAP_SERVER
