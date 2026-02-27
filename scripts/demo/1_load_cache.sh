#!/bin/bash
HOST="${1:-192.168.248.170}"
PORT="${2:-8081}"

echo "Loading customers to Redis cache..."
curl -s -X POST "http://${HOST}:${PORT}/customers/load-cache"
echo ""
