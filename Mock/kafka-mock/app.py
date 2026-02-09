# Kafka activity mock producer (EPISAINE)
# Emits customer profile events for EPISAINE

import json
import logging
import os
import random
import string
import sys
import time
from datetime import datetime, timezone

from kafka import KafkaProducer


def env_int(name, default):
    try:
        return int(os.getenv(name, str(default)))
    except ValueError:
        return default


def env_float(name, default):
    try:
        return float(os.getenv(name, str(default)))
    except ValueError:
        return default


class JsonFormatter(logging.Formatter):
    def format(self, record):
        payload = {
            "ts": datetime.now(timezone.utc).isoformat(),
            "level": record.levelname,
            "msg": record.getMessage(),
            "logger": record.name,
        }
        if record.exc_info:
            payload["exc_info"] = self.formatException(record.exc_info)
        return json.dumps(payload, ensure_ascii=False)


def setup_logging():
    level = os.getenv("LOG_LEVEL", "INFO").upper()
    logger = logging.getLogger()
    logger.setLevel(level)
    handler = logging.StreamHandler(sys.stdout)
    handler.setFormatter(JsonFormatter())
    logger.handlers = [handler]
    return logging.getLogger("kafka-mock")


def rand_id(prefix, length=8):
    return prefix + "".join(random.choices(string.ascii_lowercase + string.digits, k=length))


def now_iso():
    return datetime.now(timezone.utc).isoformat()


def pick_ip():
    return f"192.168.1.{random.randint(2, 254)}"


def generate_event():
    customer_id = random.randint(1000, 9999)
    gender = random.choice(["female", "male", "other"])
    diet_type = random.choice(["omnivore", "vegetarian", "vegan", "pescatarian", "keto"])
    activity_level = random.choice(["low", "moderate", "high"])
    goal = random.choice(["lose_weight", "maintain", "gain_muscle"])

    base = {
        "customer_id": customer_id,
        "created_at": now_iso(),
        "updated_at": now_iso(),
        "email": f"client{customer_id}@episaine.com",
        "gender": gender,
        "age": random.randint(18, 65),
        "height_cm": random.randint(150, 200),
        "weight_kg": round(random.uniform(45.0, 110.0), 1),
        "activity_level": activity_level,
        "goal": goal,
        "diet_type": diet_type,
        "allergies": random.sample(
            ["peanuts", "gluten", "lactose", "shellfish", "eggs", "soy"], k=random.randint(0, 2)
        ),
        "conditions": random.sample(
            ["diabetes", "hypertension", "insulin_resistance", "asthma"], k=random.randint(0, 1)
        ),
        "favorite_cuisines": random.sample(
            ["mediterranean", "japanese", "indian", "french", "mexican"], k=random.randint(1, 2)
        ),
        "disliked_ingredients": random.sample(
            ["celery", "anchovy", "coriander", "beetroot"], k=random.randint(0, 2)
        ),
        "preferred_meal_times": random.sample(
            ["breakfast", "lunch", "dinner", "snack"], k=random.randint(1, 3)
        ),
        "country": random.choice(["FR", "BE", "CH", "MA", "TN"]),
        "city": random.choice(["Paris", "Lyon", "Marseille", "Bruxelles", "Tunis", "Casablanca"]),
        "newsletter_opt_in": random.choice([True, False]),
    }

    return base


def main():
    logger = setup_logging()

    bootstrap = os.getenv("KAFKA_BOOTSTRAP_SERVERS", "192.168.248.110:9092")
    topic = os.getenv("KAFKA_TOPIC", "customer-profile")
    rate_per_sec = env_float("RATE_PER_SEC", 5)
    run_seconds = env_int("RUN_SECONDS", 0)  # 0 = infinite
    linger_ms = env_int("KAFKA_LINGER_MS", 50)
    batch_size = env_int("KAFKA_BATCH_SIZE", 16384)

    if rate_per_sec <= 0:
        rate_per_sec = 1

    interval = 1.0 / rate_per_sec

    logger.info(f"starting producer bootstrap={bootstrap} topic={topic} rate_per_sec={rate_per_sec} run_seconds={run_seconds}")

    producer = KafkaProducer(
        bootstrap_servers=bootstrap.split(","),
        value_serializer=lambda v: json.dumps(v, ensure_ascii=False).encode("utf-8"),
        linger_ms=linger_ms,
        batch_size=batch_size,
        acks="all",
        retries=3,
    )

    start = time.time()
    count = 0

    try:
        while True:
            if run_seconds and (time.time() - start) >= run_seconds:
                break

            event = generate_event()
            producer.send(topic, event)
            count += 1

            if count % max(1, int(rate_per_sec)) == 0:
                logger.info(f"sent events count={count}")

            time.sleep(interval)

    except KeyboardInterrupt:
        logger.info("stopped by user")
    except Exception:
        logger.exception("producer error")
    finally:
        producer.flush(10)
        producer.close(10)
        logger.info(f"producer closed total_sent={count}")


if __name__ == "__main__":
    main()
