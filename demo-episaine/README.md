# EPISAINE - Demo scenario Kafka/SSE + Mock

Document de demonstration destine au professeur (version execution rapide).

## Objet du scenario
Valider, de bout en bout, le flux suivant:

1. Le mock publie des evenements dans Kafka.
2. Le backend Spring Boot consomme ces evenements.
3. Les evenements sont visibles en temps reel via SSE et consultables via API REST.

## Fichier fourni
- `scenario_kafka_sse_mock.sh`: script unique de pilotage de la demo.

## Prerequis
- Docker et Docker Compose installes.
- Python 3.10+ (si execution du mock en local).
- Broker Kafka joignable.
- Topic Kafka `customer-profile` disponible.

## Preparation
Depuis la racine du projet:

```bash
chmod +x demo-episaine/scenario_kafka_sse_mock.sh
```

## Procedure de demonstration
1. Demarrer le backend Kafka/SSE:

```bash
./demo-episaine/scenario_kafka_sse_mock.sh start-backend
```

2. Ouvrir le flux SSE en live (terminal 2):

```bash
./demo-episaine/scenario_kafka_sse_mock.sh stream
```

3. Generer des evenements Kafka (terminal 3):

Option A - mock local:

```bash
./demo-episaine/scenario_kafka_sse_mock.sh run-mock-local
```

Option B - mock docker:

```bash
./demo-episaine/scenario_kafka_sse_mock.sh run-mock-docker
```

4. Verifier les endpoints backend:

```bash
./demo-episaine/scenario_kafka_sse_mock.sh check-api
```

5. (Optionnel) Suivre les logs backend:

```bash
./demo-episaine/scenario_kafka_sse_mock.sh logs
```

6. Arreter le backend a la fin:

```bash
./demo-episaine/scenario_kafka_sse_mock.sh stop-backend
```

## Resultat attendu
- Le terminal SSE affiche des evenements `kafka-event` en continu.
- `GET /api/events/latest` retourne les derniers messages.
- `GET /api/events/page` retourne une pagination valide.

## Variables de configuration (optionnelles)
- `KAFKA_BOOTSTRAP_SERVERS` (defaut: `172.31.249.144:9092`)
- `KAFKA_TOPIC` (defaut: `customer-profile`)
- `DB_HOST` (defaut: `172.31.249.144`)
- `DB_PORT` (defaut: `5432`)
- `DB_NAME` (defaut: `episaine`)
- `DB_USER` (defaut: `episaine`)
- `DB_PASSWORD` (defaut: `episaine`)
- `DB_SSLMODE` (defaut: `disable`)

## Exemple d'execution avec variables surchargees
```bash
KAFKA_BOOTSTRAP_SERVERS=192.168.248.110:9092 \
DB_HOST=192.168.248.110 \
./demo-episaine/scenario_kafka_sse_mock.sh run-mock-local
```
