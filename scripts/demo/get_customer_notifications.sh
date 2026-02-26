#!/bin/bash
CUSTOMER_ID="${1:?Usage: $0 <customer_id> [host] [port]}"
HOST="${2:-192.168.248.106}"
PORT="${3:-8083}"

echo "Fetching notifications for customer ${CUSTOMER_ID}..."
curl -s "http://${HOST}:${PORT}/api/notifications/customer/${CUSTOMER_ID}"
echo ""
