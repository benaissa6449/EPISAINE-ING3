import psycopg2
import random
import os
from datetime import datetime, timedelta
from psycopg2.extras import execute_values

random.seed()

DB_CONFIG = {
    "host": os.getenv("DB_HOST"),
    "port": os.getenv("DB_PORT"),
    "dbname": os.getenv("DB_NAME"),
    "user": os.getenv("DB_USER"),
    "password": os.getenv("DB_PASSWORD")
}

FIRST_NAMES = [
    "Emma","Liam","Olivia","Noah","Ava","Lucas","Mia","Ethan","Sophia","Leo",
    "Chloe","Nathan","Ines","Gabriel","Jade","Adam","Manon","Louis","Sarah","Hugo",
    "Alice","Tom","Lina","Arthur","Camille","Paul","Eva","Theo","Zoe","Maxime",
    "Clara","Rayan","Louna","Enzo","Yasmine","Sacha","Nina","Milo","Lea","Axel",
    "Lola","Raphael","Elena","Ilyes","Maya","Yanis","Julia","Mathis","Amel","Oscar",
    "Ismael","Fatima","Karim","Salome","Bastien","Anissa","Victor","Helena","Mehdi","Lucie"
]

LAST_NAMES = [
    "Martin","Bernard","Dubois","Thomas","Robert","Richard","Petit","Durand","Leroy","Moreau",
    "Simon","Laurent","Lefebvre","Michel","Garcia","David","Bertrand","Roux","Vincent","Fournier",
    "Morel","Girard","Andre","Lefevre","Mercier","Dupont","Lambert","Bonnet","Francois","Martinez",
    "Legrand","Garnier","Faure","Rousseau","Blanc","Guerin","Muller","Henry","Roussel","Nicolas",
    "Perrin","Morin","Mathieu","Clement","Gauthier","Dumont","Lopez","Fontaine","Chevalier","Robin",
    "Boulanger","Payet","Schmitt","Colin","Renard","Barbier","Maillard","Benoit","Rey","Perrot"
]

EMAIL_DOMAINS = [
    "gmail.com","yahoo.fr","outlook.com","hotmail.fr",
    "icloud.com","protonmail.com","orange.fr","free.fr"
]

ALLERGIES_POOL = [
    "GLUTEN","LACTOSE","PEANUTS","SHELLFISH","SOY","EGGS","FISH",
    "SESAME","CELERY","MUSTARD","TREE_NUTS","SULFITES","WHEAT",
    "DAIRY","STRAWBERRY","KIWI","BANANA","TOMATO","GARLIC","ONION"
]

CUISINES_POOL = [
    "ITALIAN","JAPANESE","MEXICAN","FRENCH","INDIAN","THAI","CHINESE",
    "SPANISH","GREEK","MOROCCAN","LEBANESE","TURKISH","KOREAN",
    "VIETNAMESE","AMERICAN","BRAZILIAN","ETHIOPIAN","GERMAN","PERUVIAN"
]

DISLIKED_POOL = [
    "BROCCOLI","SPINACH","ONION","GARLIC","MUSHROOM","CARROT",
    "EGGPLANT","ZUCCHINI","PEPPER","CABBAGE","BEETROOT","LENTILS",
    "CHICKPEAS","SALMON","TUNA","BEEF","PORK","TOFU","CHEESE","OLIVES"
]

DIET_TYPES = [
    "STANDARD","VEGETARIAN","VEGAN","PESCATARIAN","LOW_CARB",
    "KETO","MEDITERRANEAN","HIGH_PROTEIN","LOW_FAT","PALEO",
    "GLUTEN_FREE","DASH","FLEXITARIAN"
]

COUNTRY_CITY = {
    "France": ["Paris","Lyon","Marseille","Toulouse","Nice","Nantes"],
    "Canada": ["Montreal","Toronto","Vancouver","Quebec"],
    "Japan": ["Tokyo","Osaka","Kyoto"],
    "Germany": ["Berlin","Munich","Hamburg"],
    "Spain": ["Madrid","Barcelona","Valencia"]
}

CONTACT_TYPES = ["EMAIL","SMS","IN_APP"]
MEAL_TIMES_OPTIONS = [
    ["07:30","12:00","19:00"],
    ["08:00","13:00","20:00"],
    ["06:30","11:30","18:30"],
    ["09:00","14:00","21:00"],
    ["08:30","12:30","18:00"]
]

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

def random_subset(pool, max_items=4):
    return random.sample(pool, random.randint(0, min(max_items, len(pool))))

def realistic_activity(age, bmi):
    if bmi > 30:
        return random.randint(1,2)
    if age < 30:
        return random.randint(3,5)
    if age < 50:
        return random.randint(2,4)
    return random.randint(1,3)

def weight_goal_from_bmi(bmi):
    if bmi < 18.5:
        return "GAIN_WEIGHT"
    if bmi > 25:
        return "LOSE_WEIGHT"
    return "MAINTAIN_WEIGHT"

def generate_timestamp():
    now = datetime.now()
    return now - timedelta(days=random.randint(0, 365))

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

    for snapshot_id, bmi, sex, age_range, smoker, diabetes in rows:

        try:
            low, high = age_range.split("-")
            age = random.randint(int(low), int(high))
        except:
            age = random.randint(18, 75)

        gender = "MALE" if sex.lower() == "homme" else "FEMALE"

        height = random.randint(155, 200)
        weight = round(bmi * ((height/100)**2), 1)

        conditions = []
        if "diabetes" in diabetes.lower():
            conditions.append("DIABETES")
        if smoker.lower() == "yes":
            conditions.append("SMOKER")
        if bmi > 30:
            conditions.append("OBESITY")
        if age > 60:
            conditions.append("HYPERTENSION")

        country = random.choice(list(COUNTRY_CITY.keys()))
        city = random.choice(COUNTRY_CITY[country])

        first_name = random.choice(FIRST_NAMES)
        last_name = random.choice(LAST_NAMES)

        created_at = generate_timestamp()
        updated_at = created_at + timedelta(days=random.randint(0, 100))
        last_notification = updated_at - timedelta(days=random.randint(0, 30))

        customers.append((
            last_name,
            first_name,
            random.choice(CONTACT_TYPES),
            f"0{random.randint(6,7)}{random.randint(10000000,99999999)}",
            f"{first_name.lower()}.{last_name.lower()}{snapshot_id}@{random.choice(EMAIL_DOMAINS)}",
            weight_goal_from_bmi(bmi),
            age,
            gender,
            height,
            weight,
            random.randint(2,6),
            realistic_activity(age, bmi),
            random.choice(DIET_TYPES),
            random_subset(ALLERGIES_POOL, 3),
            conditions,
            random_subset(CUISINES_POOL, 4),
            random_subset(DISLIKED_POOL, 4),
            random.choice(MEAL_TIMES_OPTIONS),
            country,
            city,
            random.random() < 0.7,
            last_notification,
            created_at,
            updated_at
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

    print(f"{len(customers)} customers inserted!")

if __name__ == "__main__":
    main()