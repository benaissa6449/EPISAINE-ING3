#!/usr/bin/env bash
set -euo pipefail

TOPIC_NAME="${KAFKA_TOPIC:-customer-profile}"

echo "Creating topic: ${TOPIC_NAME}"
kafka-topics --bootstrap-server kafka:29092 \
  --create \
  --if-not-exists \
  --topic "${TOPIC_NAME}" \
  --partitions 1 \
  --replication-factor 1

echo "Topic ready."
