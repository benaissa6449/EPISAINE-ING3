# episaine-kafka-backend

Service backend Spring Boot (Maven) qui consomme Kafka et pousse les events vers le front en SSE (Server-Sent Events).

Configuration par defaut:
- Broker Kafka: `172.31.249.144:9092`
- Topic: `customer-profile`
- Port backend: `8080`

## API

- `GET /api/events/stream`  
  Flux SSE temps reel.
- `GET /api/events/latest?limit=20`  
  Derniers events en memoire.
- `GET /api/events/page?page=0&size=12`  
  Pagination des events (taille maximale 12).
- `POST /api/events/publish`  
  Endpoint de test pour publier un message dans Kafka.

Payload attendu:

```json
{
  "customer_id": 42,
  "recipes_id": [3, 4, 5]
}
```

## Lancer en local (sans Docker)

Depuis `episaine-kafka-backend`:

```bash
KAFKA_BOOTSTRAP_SERVERS=192.168.248.110:9092 \
KAFKA_TOPIC=customer-profile \
mvn spring-boot:run
```

Healthcheck:
```bash
curl http://localhost:8080/actuator/health
```

## Lancer en Docker

Depuis `episaine-kafka-backend`:

```bash
docker compose up -d --build
```

Services:
- Backend: `http://localhost:8080`

Logs propres (live):

```bash
docker compose logs -f --tail=200 kafka-backend
```

Arreter:

```bash
docker compose down
```

Note: `docker compose logs` fonctionne uniquement dans un dossier qui contient un `docker-compose.yml` (ici `episaine-kafka-backend/`).

## Test rapide

1. Ouvrir le stream SSE:

```bash
curl -N http://localhost:8080/api/events/stream
curl "http://localhost:8080/api/events/page?page=0&size=12"
```

2. Publier un event:

```bash
curl -X POST http://localhost:8080/api/events/publish \
  -H "Content-Type: application/json" \
  -d "{\"customer_id\":1,\"recipes_id\":[10,20]}"
```

## Integration front (React ou JS)

```js
const eventSource = new EventSource("http://localhost:8080/api/events/stream");
eventSource.addEventListener("kafka-event", (event) => {
  const data = JSON.parse(event.data);
  console.log("Kafka event:", data);
});
```
