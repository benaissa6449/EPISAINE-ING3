#!/usr/bin/env bash
set -euo pipefail

# Run the front with Node (development mode) on VM.
# Usage:
#   ./run_front_node.sh /path/to/EPISAINE-ING3

if [[ $# -ne 1 ]]; then
  echo "Usage: $0 <repo_root_path>"
  exit 1
fi

REPO_ROOT="$1"
FRONT_DIR="${REPO_ROOT}/episaine-static-front"

cd "${FRONT_DIR}"
npm ci
npm start
