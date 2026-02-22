#!/usr/bin/env bash
set -euo pipefail

# Usage:
#   KAFKA_HOME=/opt/kafka \
#   KAFKA_BOOTSTRAP_SERVERS=172.31.249.144:9092 \
#   KAFKA_TOPIC=customer-profile \
#   ./reset_topic_and_run_mock.sh

KAFKA_HOME="${KAFKA_HOME:-/opt/kafka}"
BOOTSTRAP="${KAFKA_BOOTSTRAP_SERVERS:-172.31.249.144:9092}"
TOPIC="${KAFKA_TOPIC:-customer-profile}"
PYTHON_BIN="${PYTHON_BIN:-python3}"
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

if [[ ! -x "${KAFKA_HOME}/bin/kafka-get-offsets.sh" ]]; then
  echo "ERROR: kafka-get-offsets.sh not found in ${KAFKA_HOME}/bin"
  exit 1
fi

if [[ ! -x "${KAFKA_HOME}/bin/kafka-delete-records.sh" ]]; then
  echo "ERROR: kafka-delete-records.sh not found in ${KAFKA_HOME}/bin"
  exit 1
fi

echo "[1/3] Reading end offsets for topic '${TOPIC}' on ${BOOTSTRAP}..."
OFFSETS="$("${KAFKA_HOME}/bin/kafka-get-offsets.sh" \
  --bootstrap-server "${BOOTSTRAP}" \
  --topic "${TOPIC}" || true)"

if [[ -z "${OFFSETS}" ]]; then
  echo "ERROR: no offsets found for topic '${TOPIC}' (topic missing or no partitions)."
  exit 1
fi

PARTITIONS_JSON=""
while IFS= read -r line; do
  [[ -z "${line}" ]] && continue
  # Expected format: topic:partition:offset
  IFS=':' read -r topic partition offset <<< "${line}"
  [[ -z "${topic:-}" || -z "${partition:-}" || -z "${offset:-}" ]] && continue
  PARTITIONS_JSON+="{\"topic\":\"${topic}\",\"partition\":${partition},\"offset\":${offset}},"
done <<< "${OFFSETS}"

PARTITIONS_JSON="${PARTITIONS_JSON%,}"
if [[ -z "${PARTITIONS_JSON}" ]]; then
  echo "ERROR: could not parse offsets output."
  exit 1
fi

TMP_JSON="$(mktemp)"
cat > "${TMP_JSON}" <<EOF
{
  "version": 1,
  "partitions": [${PARTITIONS_JSON}]
}
EOF

echo "[2/3] Truncating topic '${TOPIC}'..."
"${KAFKA_HOME}/bin/kafka-delete-records.sh" \
  --bootstrap-server "${BOOTSTRAP}" \
  --offset-json-file "${TMP_JSON}"

rm -f "${TMP_JSON}"

echo "[3/3] Starting mock producer app.py..."
export KAFKA_BOOTSTRAP_SERVERS="${BOOTSTRAP}"
export KAFKA_TOPIC="${TOPIC}"
exec "${PYTHON_BIN}" "${SCRIPT_DIR}/app.py"

