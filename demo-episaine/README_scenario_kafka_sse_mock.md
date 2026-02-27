# Scenario demo: Backend Kafka/SSE + Kafka Mock

## Objectif
Montrer en demo que:
- un producteur mock envoie des events dans Kafka,
- le backend Spring Boot consomme ces events,
- le front (ou curl) peut les lire en SSE et via API REST.

## Composants
- Backend Kafka/SSE: `episaine-kafka-backend`
- Mock producteur Kafka: `Mock/kafka-mock`
- Topic Kafka: `customer-profile`

## Prerequis
- Docker installe (pour le backend).
- Python 3.10+ (pour le mock local).
- Kafka accessible sur un broker (exemple infra: `172.31.249.144:9092`).
- Topic `customer-profile` existant.

Important:
- Le backend et le mock doivent pointer vers le meme broker et le meme topic.

## Etape 1 - Lancer le backend Kafka/SSE
Dans un terminal:

```bash
cd episaine-kafka-backend
docker compose up -d --build
```

Verifier que le backend tourne:

```bash
curl "http://localhost:8080/api/events/latest?limit=1"
```

## Etape 2 - Ouvrir le stream SSE (live)
Dans un second terminal:

```bash
curl -N http://localhost:8080/api/events/stream
```

Tu dois garder ce terminal ouvert pendant la demo.

## Etape 3A - Lancer le mock en local (recommande en demo)
Dans un troisieme terminal:

```bash
cd Mock/kafka-mock
python -m venv .venv
. .venv/bin/activate
pip install -r requirements.txt

export KAFKA_BOOTSTRAP_SERVERS=172.31.249.144:9092
export KAFKA_TOPIC=customer-profile

# Variables Postgres (source des users) - adapter selon ta VM
export DB_HOST=172.31.249.144
export DB_PORT=5432
export DB_NAME=episaine
export DB_USER=episaine
export DB_PASSWORD=episaine
export DB_SSLMODE=disable

python app.py
```

## Etape 3B - Alternative mock en Docker
Si tu preferes Docker pour le mock:

```bash
cd Mock/kafka-mock
docker build -t episaine-kafka-mock .
docker run --rm \
  -e KAFKA_BOOTSTRAP_SERVERS=172.31.249.144:9092 \
  -e KAFKA_TOPIC=customer-profile \
  -e DB_HOST=172.31.249.144 \
  -e DB_PORT=5432 \
  -e DB_NAME=episaine \
  -e DB_USER=episaine \
  -e DB_PASSWORD=episaine \
  -e DB_SSLMODE=disable \
  episaine-kafka-mock
```

## Etape 4 - Verifications API backend
Dans un autre terminal:

```bash
curl "http://localhost:8080/api/events/latest?limit=20"
curl "http://localhost:8080/api/events/page?page=0&size=12"
```

Si `jq` est installe:

```bash
curl -s "http://localhost:8080/api/events/latest?limit=20" | jq .
curl -s "http://localhost:8080/api/events/page?page=0&size=12" | jq .
```

## Resultat attendu
- Le terminal SSE affiche des events `kafka-event` en continu.
- `latest` retourne les derniers events en memoire.
- `page` retourne les events pagines (max 12 par page).

## Arret propre
Mock local:
- `Ctrl+C`
- `deactivate`

Backend:

```bash
cd episaine-kafka-backend
docker compose down
```

## Depannage rapide
- Aucun event en SSE:
  - verifier `KAFKA_BOOTSTRAP_SERVERS` identique backend/mock,
  - verifier `KAFKA_TOPIC=customer-profile` des deux cotes.
- Backend OK mais pas de conso:
  - voir logs backend:

```bash
cd episaine-kafka-backend
docker compose logs -f --tail=200 kafka-backend
```

- Topic douteux ou offset sale:
  - utiliser le script existant:
  - `Mock/kafka-mock/reset_topic_and_run_mock.sh`
