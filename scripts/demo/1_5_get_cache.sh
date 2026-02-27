#!/bin/bash
HOST="${1:-192.168.248.105}"
PORT="${2:-8082}"

echo "Fetching cached customers from Redis..."
curl -s "http://${HOST}:${PORT}/notifications/cache"
echo ""
