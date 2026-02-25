import psycopg2
import random
import os
from datetime import datetime
from psycopg2.extras import execute_values

DB_CONFIG = {
    "host": os.getenv("DB_HOST"),
    "port": os.getenv("DB_PORT"),
    "dbname": os.getenv("DB_NAME"),
    "user": os.getenv("DB_USER"),
    "password": os.getenv("DB_PASSWORD")
}

def wait_for_db():
    import time
    while True:
        try:
            conn = psycopg2.connect(**DB_CONFIG)
            conn.close()
            break
        except:
            print("Waiting for PostgreSQL...")
            time.sleep(2)

def main():
    wait_for_db()

    conn = psycopg2.connect(**DB_CONFIG)
    cur = conn.cursor()

    print("Truncating gold.customers...")
    cur.execute("TRUNCATE TABLE gold.customers RESTART IDENTITY CASCADE")
    conn.commit()

    cur.execute("""
        SELECT id, bmi, sex, age, smoker, diabetes_binary
        FROM gold.silver_snapshot
    """)

    rows = cur.fetchall()
    customers = []

    for row in rows:
        snapshot_id, bmi, sex, age_range, smoker, diabetes = row

        age = random.randint(30, 70)
        gender = "MALE" if sex.lower() == "homme" else "FEMALE"

        height = random.randint(160, 185)
        weight = round(bmi * ((height/100)**2), 1)

        conditions = []
        if "diabetes" in diabetes.lower():
            conditions.append("DIABETES")
        if smoker.lower() == "yes":
            conditions.append("SMOKER")

        now = datetime.now()

        customers.append((
            "Mock",
            f"User{snapshot_id}",
            "EMAIL",
            f"06{random.randint(10000000,99999999)}",
            f"user{snapshot_id}@mail.com",
            "MAINTAIN_WEIGHT",
            age,
            gender,
            height,
            weight,
            3,
            3,
            "STANDARD",
            ["GLUTEN"],
            conditions,
            ["ITALIAN"],
            ["BROCCOLI"],
            ["08:00","12:30","19:30"],
            "France",
            "Paris",
            True,
            now,
            now,
            now
        ))

    execute_values(cur, """
        INSERT INTO gold.customers (
            last_name, first_name, prefered_contact, phone_number, email,
            weight_goal, age, gender, height, weight,
            meals_per_day, activity_level, diet_type,
            allergies, conditions, favorite_cuisines,
            disliked_ingredients, prefered_meal_times,
            country, city, newsletter_opt_in,
            last_notification, created_at, updated_at
        ) VALUES %s
    """, customers)

    conn.commit()
    cur.close()
    conn.close()

    print(f"{len(customers)} customers insérés !")

if __name__ == "__main__":
    main()