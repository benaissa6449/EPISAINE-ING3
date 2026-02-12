# Kafka Mock (EPISAINE)

Mock Python pour simuler des événements `customer-profile` (profil client).
Logs JSON propres sur `stdout`.

## Variables d'environnement
- `KAFKA_BOOTSTRAP_SERVERS` (défaut `192.168.248.110:9092`)
- `KAFKA_TOPIC` (défaut `customer-profile`)
- `RATE_PER_SEC` (défaut `5`)
- `RUN_SECONDS` (défaut `0` = infini)
- `LOG_LEVEL` (défaut `INFO`)
- `KAFKA_LINGER_MS` (défaut `50`)
- `KAFKA_BATCH_SIZE` (défaut `16384`)

## Schéma envoyé (exemple)
```json
{
  "customer_id": 1023,
  "created_at": "2026-02-10T00:40:21.120Z",
  "updated_at": "2026-02-10T00:40:21.120Z",
  "email": "client1023@episaine.com",
  "gender": "female",
  "age": 29,
  "height_cm": 168,
  "weight_kg": 62.4,
  "activity_level": "moderate",
  "goal": "lose_weight",
  "diet_type": "vegetarian",
  "allergies": ["peanuts"],
  "conditions": ["insulin_resistance"],
  "favorite_cuisines": ["mediterranean", "japanese"],
  "disliked_ingredients": ["celery"],
  "preferred_meal_times": ["breakfast", "dinner"],
  "country": "FR",
  "city": "Lyon",
  "newsletter_opt_in": true
}
```

## Run local
```bash
python -m venv .venv
. .venv/bin/activate
pip install -r requirements.txt
KAFKA_BOOTSTRAP_SERVERS=192.168.248.110:9092 KAFKA_TOPIC=customer-profile python app.py
```

## Docker
```bash
docker build -t episaine-kafka-mock .
docker run --rm \
  -e KAFKA_BOOTSTRAP_SERVERS=192.168.248.110:9092 \
  -e KAFKA_TOPIC=customer-profile \
  -e RATE_PER_SEC=5 \
  episaine-kafka-mock
```
