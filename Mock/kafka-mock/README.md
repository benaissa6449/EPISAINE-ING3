# Kafka Mock (EPISAINE)

Mock Python pour simuler des evenements `customer-profile`.
Les connexions utilisent des utilisateurs reels charges depuis Postgres `gold.customers`.

## Variables d'environnement
- `KAFKA_BOOTSTRAP_SERVERS` (defaut `192.168.248.110:9092`)
- `KAFKA_TOPIC` (defaut `customer-profile`)
- `RATE_PER_SEC` (defaut `1`)
- `RUN_SECONDS` (defaut `0` = infini)
- `TARGET_ACTIVE_USERS` (defaut `5`)
- `MAX_ACTIVE_USERS` (defaut `8`)
- `LOG_LEVEL` (defaut `INFO`)
- `KAFKA_LINGER_MS` (defaut `50`)
- `KAFKA_BATCH_SIZE` (defaut `16384`)

## Variables Postgres (source utilisateurs)
- `DB_HOST` (defaut `192.168.248.110`)
- `DB_PORT` (defaut `5432`)
- `DB_NAME` (defaut `episaine`)
- `DB_USER` (defaut `episaine`)
- `DB_PASSWORD` (defaut `episaine`)
- `DB_SSLMODE` (defaut `disable`)
- `DB_CONNECT_TIMEOUT_SECONDS` (defaut `8`)

La requete utilisee:
```sql
SELECT customer_id, first_name, last_name
FROM gold.customers
ORDER BY customer_id;
```

## Schema evenement (exemple)
```json
{
  "customer_id": 42,
  "first_name": "Emma",
  "last_name": "Martin",
  "event_type": "connexion",
  "user_id": "Emma Martin",
  "route": "/logging",
  "event_at": "2026-02-26T14:31:00.000000+00:00",
  "session_started_at": "2026-02-26T14:31:00.000000+00:00",
  "session_duration_seconds": null
}
```

## Run local
```bash
python -m venv .venv
. .venv/bin/activate
pip install -r requirements.txt

KAFKA_BOOTSTRAP_SERVERS=192.168.248.110:9092 \
DB_HOST=192.168.248.110 \
DB_NAME=episaine \
DB_USER=episaine \
DB_PASSWORD=episaine \
python app.py
```

## Docker
```bash
docker build -t episaine-kafka-mock .
docker run --rm \
  -e KAFKA_BOOTSTRAP_SERVERS=192.168.248.110:9092 \
  -e DB_HOST=192.168.248.110 \
  -e DB_NAME=episaine \
  -e DB_USER=episaine \
  -e DB_PASSWORD=episaine \
  episaine-kafka-mock
```
