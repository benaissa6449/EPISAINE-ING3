#!/usr/bin/env bash
set -euo pipefail

# Install Apache + Node.js LTS on Ubuntu VM.
# Usage: sudo ./install_apache_node_front.sh

if [[ "${EUID}" -ne 0 ]]; then
  echo "Run this script with sudo/root."
  exit 1
fi

export DEBIAN_FRONTEND=noninteractive

apt-get update
apt-get install -y ca-certificates curl gnupg lsb-release

# Apache
apt-get install -y apache2

# Node.js 20 LTS (NodeSource)
install -d -m 0755 /etc/apt/keyrings
curl -fsSL https://deb.nodesource.com/gpgkey/nodesource-repo.gpg.key \
  | gpg --dearmor -o /etc/apt/keyrings/nodesource.gpg

echo "deb [signed-by=/etc/apt/keyrings/nodesource.gpg] https://deb.nodesource.com/node_20.x nodistro main" \
  > /etc/apt/sources.list.d/nodesource.list

apt-get update
apt-get install -y nodejs

# Keep npm current
npm install -g npm@latest

systemctl enable apache2
systemctl restart apache2

echo "Done. Versions:"
node -v
npm -v
apache2 -v | head -n 1
