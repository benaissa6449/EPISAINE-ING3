import json
import logging
import os
import random
import sys
import time
from datetime import datetime, timezone

from kafka import KafkaProducer
import psycopg2


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


ROUTES = ["/logging", "/logging?page=1", "/logging?page=2", "/recipes"]


def load_customers_from_db(logger):
    db_host = os.getenv("DB_HOST", "192.168.248.110")
    db_port = env_int("DB_PORT", 5432)
    db_name = os.getenv("DB_NAME", "episaine")
    db_user = os.getenv("DB_USER", "episaine")
    db_password = os.getenv("DB_PASSWORD", "episaine")
    db_sslmode = os.getenv("DB_SSLMODE", "disable")
    connect_timeout = env_int("DB_CONNECT_TIMEOUT_SECONDS", 8)

    logger.info(
        "loading customers from postgres "
        f"host={db_host} port={db_port} db={db_name} user={db_user} sslmode={db_sslmode}"
    )

    query = """
        SELECT customer_id, first_name, last_name
        FROM gold.customers
        WHERE customer_id IS NOT NULL
        ORDER BY customer_id
    """

    with psycopg2.connect(
        host=db_host,
        port=db_port,
        dbname=db_name,
        user=db_user,
        password=db_password,
        sslmode=db_sslmode,
        connect_timeout=connect_timeout,
    ) as conn:
        with conn.cursor() as cur:
            cur.execute(query)
            rows = cur.fetchall()

    customers = []
    for customer_id, first_name, last_name in rows:
        first = (first_name or "").strip()
        last = (last_name or "").strip()
        full_name = f"{first} {last}".strip()
        if not full_name:
            full_name = f"customer_{customer_id}"
        customers.append(
            {
                "customer_id": int(customer_id),
                "first_name": first,
                "last_name": last,
                "user_id": full_name,
            }
        )

    if not customers:
        raise RuntimeError("No customers found in gold.customers; cannot simulate connexions.")

    logger.info(f"loaded customers count={len(customers)} from gold.customers")
    return customers


def pick_disconnected_user(active_sessions, customers):
    inactive = [customer for customer in customers if customer["customer_id"] not in active_sessions]
    if not inactive:
        return None
    return random.choice(inactive)


def build_connexion_event(active_sessions, customers):
    now = datetime.now(timezone.utc)
    event_at = now.isoformat()
    customer = pick_disconnected_user(active_sessions, customers)
    if customer is None:
        return build_deconnexion_event(active_sessions)

    customer_id = customer["customer_id"]
    user_id = customer["user_id"]
    route = random.choice(ROUTES)

    active_sessions[customer_id] = {
        "customer_id": customer_id,
        "first_name": customer["first_name"],
        "last_name": customer["last_name"],
        "user_id": user_id,
        "route": route,
        "session_started_at": event_at,
        "session_started_ts": now.timestamp(),
    }

    return {
        "customer_id": customer_id,
        "first_name": customer["first_name"],
        "last_name": customer["last_name"],
        "event_type": "connexion",
        "user_id": user_id,
        "route": route,
        "event_at": event_at,
        "session_started_at": event_at,
        "session_duration_seconds": None,
    }


def build_deconnexion_event(active_sessions):
    now = datetime.now(timezone.utc)
    event_at = now.isoformat()
    customer_id = random.choice(list(active_sessions.keys()))
    session = active_sessions.pop(customer_id)
    session_duration_seconds = int(max(0, now.timestamp() - session["session_started_ts"]))

    return {
        "customer_id": session["customer_id"],
        "first_name": session["first_name"],
        "last_name": session["last_name"],
        "event_type": "deconnexion",
        "user_id": session["user_id"],
        "route": session["route"],
        "event_at": event_at,
        "session_started_at": session["session_started_at"],
        "session_duration_seconds": session_duration_seconds,
    }


def build_navigation_event(active_sessions):
    now = datetime.now(timezone.utc)
    event_at = now.isoformat()
    customer_id = random.choice(list(active_sessions.keys()))
    session = active_sessions[customer_id]
    route = random.choice(ROUTES)
    session["route"] = route

    return {
        "customer_id": session["customer_id"],
        "first_name": session["first_name"],
        "last_name": session["last_name"],
        "event_type": "navigation",
        "user_id": session["user_id"],
        "route": route,
        "event_at": event_at,
        "session_started_at": session["session_started_at"],
        "session_duration_seconds": None,
    }


def build_event(active_sessions, customers, target_active_users, max_active_users):
    active_count = len(active_sessions)
    total_possible_users = len(customers)

    if active_count < target_active_users and active_count < total_possible_users:
        return build_connexion_event(active_sessions, customers)

    if active_count >= max_active_users or active_count >= total_possible_users:
        return build_deconnexion_event(active_sessions)

    action = random.choices(
        population=["connexion", "deconnexion", "navigation"],
        weights=[35, 35, 30],
        k=1,
    )[0]

    if action == "connexion" and active_count < total_possible_users:
        return build_connexion_event(active_sessions, customers)

    if action == "deconnexion" and active_count > 0:
        return build_deconnexion_event(active_sessions)

    if active_count > 0:
        return build_navigation_event(active_sessions)

    return build_connexion_event(active_sessions, customers)


def main():
    logger = setup_logging()

    bootstrap = os.getenv("KAFKA_BOOTSTRAP_SERVERS", "172.31.249.144:9092")
    topic = os.getenv("KAFKA_TOPIC", "customer-profile")

    # For visible multi-user simulation, default is 1 event/second.
    rate_per_sec = env_float("RATE_PER_SEC", 1.0)
    run_seconds = env_int("RUN_SECONDS", 0)  # 0 = infinite
    target_active_users = env_int("TARGET_ACTIVE_USERS", 5)
    max_active_users = env_int("MAX_ACTIVE_USERS", 8)

    linger_ms = env_int("KAFKA_LINGER_MS", 50)
    batch_size = env_int("KAFKA_BATCH_SIZE", 16384)

    if rate_per_sec <= 0:
        rate_per_sec = 1.0

    customers = load_customers_from_db(logger)
    total_possible_users = len(customers)

    interval = 1.0 / rate_per_sec
    target_active_users = max(1, min(target_active_users, total_possible_users))
    max_active_users = max(target_active_users, min(max_active_users, total_possible_users))

    logger.info(
        "starting producer "
        f"bootstrap={bootstrap} topic={topic} "
        f"rate_per_sec={rate_per_sec} run_seconds={run_seconds} "
        f"target_active_users={target_active_users} max_active_users={max_active_users} "
        f"customer_pool_size={total_possible_users}"
    )

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
    active_sessions = {}
    total_connexions = 0
    total_deconnexions = 0
    total_navigations = 0

    try:
        while True:
            if run_seconds and (time.time() - start) >= run_seconds:
                break

            event = build_event(active_sessions, customers, target_active_users, max_active_users)
            producer.send(topic, event)

            count += 1
            if event["event_type"] == "connexion":
                total_connexions += 1
            elif event["event_type"] == "deconnexion":
                total_deconnexions += 1
            elif event["event_type"] == "navigation":
                total_navigations += 1

            if count % max(1, int(rate_per_sec)) == 0:
                logger.info(
                    f"sent={count} connexions={total_connexions} deconnexions={total_deconnexions} "
                    f"navigations={total_navigations} active_sessions={len(active_sessions)}"
                )

            time.sleep(interval)

    except KeyboardInterrupt:
        logger.info("stopped by user")
    except Exception:
        logger.exception("producer error")
    finally:
        producer.flush(10)
        producer.close(10)
        logger.info(
            f"producer closed total_sent={count} connexions={total_connexions} "
            f"deconnexions={total_deconnexions} navigations={total_navigations} "
            f"active_sessions={len(active_sessions)}"
        )


if __name__ == "__main__":
    main()
