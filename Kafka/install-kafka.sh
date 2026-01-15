#!/bin/bash

# Script d'installation complet de Kafka sur Ubuntu Linux

echo "===== Installation de Kafka sur Ubuntu ====="
echo ""

# Mettre à jour le système
echo "Mise à jour du système..."
sudo apt update
sudo apt upgrade -y

# Installer Java
echo "Installation de Java..."
sudo apt install default-jdk -y
java --version

# Créer l'utilisateur kafka
echo "Création de l'utilisateur Kafka..."
sudo useradd -r -m -U -d /opt/kafka -s /bin/bash kafka

# Télécharger et installer Kafka
echo "Téléchargement et installation de Kafka..."
cd /tmp
wget https://dlcdn.apache.org/kafka/3.6.1/kafka_2.13-3.6.1.tgz
tar -xzf kafka_2.13-3.6.1.tgz
sudo mkdir -p /opt/kafka
sudo mv kafka_2.13-3.6.1/* /opt/kafka/
sudo chown -R kafka:kafka /opt/kafka

echo ""
echo "===== Installation terminée ====="
echo ""
echo "Prochaines étapes :"
echo "1. Exécutez : ./start-zookeeper.sh (dans un premier terminal)"
echo "2. Exécutez : ./start-kafka.sh (dans un deuxième terminal)"
echo "3. Exécutez : ./create-topics.sh (dans un troisième terminal)"
echo ""
