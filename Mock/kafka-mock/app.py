import json
import logging
import os
import random
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


FIRST_NAMES = [
    "Yassine", "Nadia", "Karim", "Samira", "Omar", "Camille", "Lucas", "Emma",
    "Nicolas", "Julie",
    "Amine", "Ines", "Sofiane", "Leila", "Rachid", "Sarah", "Hakim", "Myriam",
    "Anis", "Meriem", "Farid", "Amina", "Rania", "Idir",
    "Jean", "Pierre", "Louis", "Hugo", "Paul", "Antoine", "Arthur", "Mathis",
    "Claire", "Sophie", "Marie", "Manon", "Chloe", "Lucie", "Elise", "Jeanne",
    "Ismail", "John"
]

LAST_NAMES = [
    "El Idrissi", "Benali", "Bensalah", "Haddad", "Ait Lahcen", "Martin",
    "Bernard", "Dubois", "Petit", "Moreau", "Ait Ali", "Idir", "Ait Amar",
    "Oumghar", "At Mhand", "Bouzid", "Meziane", "Cherif", "Saidi", "Belkacem",
    "Lamrani", "Ouahbi", "Ait Ahmed", "Benyahia", "Kettani", "Alaoui",
    "Mokhtari", "Toumi", "Azoulay", "Tazrout",
    "Durand", "Lefevre", "Laurent", "Garcia", "Roux", "Fontaine", "Mercier",
    "Dupont", "Girard", "Andre", "Faure", "Masson",
    "Benaissa", "Wang"
]

ROUTES = ["/logging", "/logging?page=1", "/logging?page=2", "/recipes"]
TOTAL_POSSIBLE_USERS = len(FIRST_NAMES) * len(LAST_NAMES)


def random_user_name(used_names):
    for _ in range(30):
        candidate = f"{random.choice(FIRST_NAMES)} {random.choice(LAST_NAMES)}"
        if candidate not in used_names:
            return candidate
    return f"{random.choice(FIRST_NAMES)} {random.choice(LAST_NAMES)} {random.randint(10, 999)}"


def pick_disconnected_user(active_sessions, known_users):
    inactive_known = [name for name in known_users if name not in active_sessions]
    # Reuse some users, but keep creating new random names over time.
    if inactive_known and random.random() < 0.35:
        return random.choice(inactive_known)
    new_name = random_user_name(known_users)
    known_users.add(new_name)
    return new_name


def build_connexion_event(active_sessions, known_users):
    now = datetime.now(timezone.utc)
    event_at = now.isoformat()
    user_id = pick_disconnected_user(active_sessions, known_users)
    customer_id = random.randint(1000, 9999)
    route = random.choice(ROUTES)

    active_sessions[user_id] = {
        "customer_id": customer_id,
        "route": route,
        "session_started_at": event_at,
        "session_started_ts": now.timestamp(),
    }

    return {
        "customer_id": customer_id,
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
    user_id = random.choice(list(active_sessions.keys()))
    session = active_sessions.pop(user_id)
    session_duration_seconds = int(max(0, now.timestamp() - session["session_started_ts"]))

    return {
        "customer_id": session["customer_id"],
        "event_type": "deconnexion",
        "user_id": user_id,
        "route": session["route"],
        "event_at": event_at,
        "session_started_at": session["session_started_at"],
        "session_duration_seconds": session_duration_seconds,
    }


def build_navigation_event(active_sessions):
    now = datetime.now(timezone.utc)
    event_at = now.isoformat()
    user_id = random.choice(list(active_sessions.keys()))
    session = active_sessions[user_id]
    route = random.choice(ROUTES)
    session["route"] = route

    return {
        "customer_id": session["customer_id"],
        "event_type": "navigation",
        "user_id": user_id,
        "route": route,
        "event_at": event_at,
        "session_started_at": session["session_started_at"],
        "session_duration_seconds": None,
    }


def build_event(active_sessions, known_users, target_active_users, max_active_users):
    active_count = len(active_sessions)

    if active_count < target_active_users:
        return build_connexion_event(active_sessions, known_users)

    if active_count >= max_active_users:
        return build_deconnexion_event(active_sessions)

    action = random.choices(
        population=["connexion", "deconnexion", "navigation"],
        weights=[35, 35, 30],
        k=1,
    )[0]

    if action == "connexion" and active_count < TOTAL_POSSIBLE_USERS:
        return build_connexion_event(active_sessions, known_users)

    if action == "deconnexion" and active_count > 0:
        return build_deconnexion_event(active_sessions)

    if active_count > 0:
        return build_navigation_event(active_sessions)

    return build_connexion_event(active_sessions, known_users)


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

    interval = 1.0 / rate_per_sec
    target_active_users = max(1, min(target_active_users, TOTAL_POSSIBLE_USERS))
    max_active_users = max(target_active_users, min(max_active_users, TOTAL_POSSIBLE_USERS))

    logger.info(
        "starting producer "
        f"bootstrap={bootstrap} topic={topic} "
        f"rate_per_sec={rate_per_sec} run_seconds={run_seconds} "
        f"target_active_users={target_active_users} max_active_users={max_active_users}"
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
    known_users = set()
    total_connexions = 0
    total_deconnexions = 0
    total_navigations = 0

    try:
        while True:
            if run_seconds and (time.time() - start) >= run_seconds:
                break

            event = build_event(active_sessions, known_users, target_active_users, max_active_users)
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
