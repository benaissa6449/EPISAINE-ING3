#!/bin/bash
CUSTOMER_ID="${1:?Usage: $0 <customer_id> [host] [port]}"
HOST="${2:-192.168.248.105}"
PORT="${3:-8083}"
URL="http://${HOST}:${PORT}/api/notifications/customer/${CUSTOMER_ID}"

echo "Fetching notifications for customer ${CUSTOMER_ID}..."
HTTP_CODE=$(curl -s -o /tmp/episaine_notifications_response.json -w "%{http_code}" "${URL}")
echo "HTTP ${HTTP_CODE}"
cat /tmp/episaine_notifications_response.json | python3 -m json.tool 2>/dev/null || cat /tmp/episaine_notifications_response.json
echo ""
