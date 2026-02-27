#!/bin/bash
HOST="${1:-192.168.248.105}"
PORT="${2:-8082}"

echo "Generating notifications for all eligible customers..."
curl -s -X POST "http://${HOST}:${PORT}/notifications/generate"
echo ""
