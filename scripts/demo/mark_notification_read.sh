#!/bin/bash
NOTIFICATION_ID="${1:?Usage: $0 <notification_id> [host] [port]}"
HOST="${2:-192.168.248.106}"
PORT="${3:-8083}"

echo "Marking notification ${NOTIFICATION_ID} as read..."
curl -s -X PUT "http://${HOST}:${PORT}/api/notifications/${NOTIFICATION_ID}/read"
echo ""
