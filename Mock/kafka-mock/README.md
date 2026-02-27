# Kafka Mock (EPISAINE)

Mock Python qui publie des evenements `customer-profile` dans Kafka.
Les utilisateurs sont charges depuis PostgreSQL (`gold.customers`) avec uniquement:
- `customer_id`
- `first_name`
- `last_name`

## Requete SQL utilisee
```sql
SELECT customer_id, first_name, last_name
FROM gold.customers
WHERE customer_id IS NOT NULL
ORDER BY customer_id;
```

## Variables d'environnement
### Kafka
- `KAFKA_BOOTSTRAP_SERVERS` (defaut: `172.31.249.144:9092`)
- `KAFKA_TOPIC` (defaut: `customer-profile`)
- `RATE_PER_SEC` (defaut: `1`)
- `RUN_SECONDS` (defaut: `0`, infini)
- `TARGET_ACTIVE_USERS` (defaut: `5`)
- `MAX_ACTIVE_USERS` (defaut: `8`)
- `LOG_LEVEL` (defaut: `INFO`)
- `KAFKA_LINGER_MS` (defaut: `50`)
- `KAFKA_BATCH_SIZE` (defaut: `16384`)

### PostgreSQL (source utilisateurs)
- `DB_HOST` (defaut: `192.168.248.110`)
- `DB_PORT` (defaut: `5432`)
- `DB_NAME` (defaut: `episaine`)
- `DB_USER` (defaut: `episaine`)
- `DB_PASSWORD` (defaut: `episaine`)
- `DB_SSLMODE` (defaut: `disable`)
- `DB_CONNECT_TIMEOUT_SECONDS` (defaut: `8`)

## Lancement local (venv)
```bash
python3 -m venv .venv
. .venv/bin/activate
pip install -r requirements.txt

KAFKA_BOOTSTRAP_SERVERS=192.168.248.110:9092 \
KAFKA_TOPIC=customer-profile \
DB_HOST=192.168.248.170 \
DB_PORT=5432 \
DB_NAME=episaine \
DB_USER=episaine \
DB_PASSWORD=episaine \
python app.py
```

## Lancement Docker (VM Kafka)
```bash
docker build -t episaine-kafka-mock .
docker rm -f kafka-mock 2>/dev/null || true
docker run -d --name kafka-mock \
  -e KAFKA_BOOTSTRAP_SERVERS=192.168.248.110:9092 \
  -e KAFKA_TOPIC=customer-profile \
  -e DB_HOST=192.168.248.170 \
  -e DB_PORT=5432 \
  -e DB_NAME=episaine \
  -e DB_USER=episaine \
  -e DB_PASSWORD=episaine \
  -e DB_SSLMODE=disable \
  episaine-kafka-mock
```

## Logs
```bash
docker logs -f --tail 50 kafka-mock
```

`~/kafka-mock` ne contient pas de `docker-compose.yml`, donc utiliser `docker logs` et pas `docker compose logs`.

## Logs lisibles (pretty)
Commande directe:
```bash
docker logs -f --tail 50 kafka-mock 2>&1 | python3 -u -c '
import json,re,sys
stats_re=re.compile(r"sent=(\d+)\s+connexions=(\d+)\s+deconnexions=(\d+)\s+navigations=(\d+)\s+active_sessions=(\d+)")
for raw in sys.stdin:
    line=raw.strip()
    if not line:
        continue
    try:
        obj=json.loads(line)
    except Exception:
        print(line)
        continue
    ts=obj.get("ts","-"); level=obj.get("level","-"); logger=obj.get("logger","-"); msg=obj.get("msg","")
    m=stats_re.search(msg)
    if m:
        sent,c,d,n,a=m.groups()
        print(f"{ts} | {level:5} | sent={sent:>6} conn={c:>6} deconn={d:>6} nav={n:>6} active={a}")
    else:
        print(f"{ts} | {level:5} | {logger} | {msg}")
'
```

## Troubleshooting rapide
Si erreur `relation "gold.customers" does not exist`, verifier que vous ciblez la bonne base:
```bash
PGPASSWORD=episaine psql -h 192.168.248.170 -p 5432 -U episaine -d episaine \
  -c "select to_regclass('gold.customers');"
```
Resultat attendu: `gold.customers` (pas `NULL`).
