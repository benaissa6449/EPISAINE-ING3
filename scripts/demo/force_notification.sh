#!/bin/bash
CUSTOMER_ID="${1:?Usage: $0 <customer_id>}"
HOST="${2:-192.168.248.106}"
PORT="${3:-8082}"

echo "Forcing notification for customer ${CUSTOMER_ID}..."
curl -s -X POST "http://${HOST}:${PORT}/notifications/generate/${CUSTOMER_ID}"
echo ""
