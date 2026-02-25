#!/bin/bash
HOST="${1:-192.168.248.106}"
PORT="${2:-8082}"
CUSTOMER_ID="${3:-1}"

echo "Forcing notification for customer ${CUSTOMER_ID}..."
curl -s -X POST "http://${HOST}:${PORT}/notifications/generate/${CUSTOMER_ID}"
echo ""
