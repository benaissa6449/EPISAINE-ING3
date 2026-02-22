#!/usr/bin/env bash
set -euo pipefail

# Build and deploy episaine-static-front behind Apache.
# Usage:
#   sudo ./deploy_front_apache.sh /path/to/EPISAINE-ING3
# Example:
#   sudo ./deploy_front_apache.sh /home/episaine/EPISAINE-ING3

if [[ "${EUID}" -ne 0 ]]; then
  echo "Run this script with sudo/root."
  exit 1
fi

if [[ $# -ne 1 ]]; then
  echo "Usage: $0 <repo_root_path>"
  exit 1
fi

REPO_ROOT="$1"
FRONT_DIR="${REPO_ROOT}/episaine-static-front"
APACHE_DOCROOT="/var/www/episaine-front"
CONF_SOURCE="${REPO_ROOT}/scripts/configuration/front/apache/episaine-front.conf"
CONF_TARGET="/etc/apache2/sites-available/episaine-front.conf"

if [[ ! -d "${FRONT_DIR}" ]]; then
  echo "Front directory not found: ${FRONT_DIR}"
  exit 1
fi

if [[ ! -f "${CONF_SOURCE}" ]]; then
  echo "Apache config template not found: ${CONF_SOURCE}"
  exit 1
fi

cd "${FRONT_DIR}"
npm ci
npm run build

install -d -m 0755 "${APACHE_DOCROOT}"
rsync -a --delete "${FRONT_DIR}/build/" "${APACHE_DOCROOT}/"

cp "${CONF_SOURCE}" "${CONF_TARGET}"

a2enmod rewrite
a2dissite 000-default.conf || true
a2ensite episaine-front.conf
apache2ctl configtest
systemctl restart apache2

echo "Deployment done: http://<vm-ip>/"
