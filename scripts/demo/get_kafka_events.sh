#!/bin/bash
HOST="${1:-192.168.248.105}"
PORT="${2:-8082}"

echo "Fetching Kafka events (sent notifications)..."
curl -s "http://${HOST}:${PORT}/notifications/kafka" | python3 -m json.tool 2>/dev/null || curl -s "http://${HOST}:${PORT}/notifications/kafka"
echo ""
