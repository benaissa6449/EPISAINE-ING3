#!/bin/bash

# Script pour démarrer Kafka sur Ubuntu Linux

echo "===== Démarrage de Kafka ====="
echo ""
echo "Assurez-vous que Zookeeper est déjà démarré dans une autre fenêtre!"
echo "Gardez ce terminal ouvert pendant que vous utilisez Kafka"
echo ""

sudo -u kafka /opt/kafka/bin/kafka-server-start.sh /opt/kafka/config/server.properties
