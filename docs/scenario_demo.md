# Scénario de démo

> 1. Envoyer des notifications push ciblées aux utilisateurs. Segmenter les utilisateurs selon profil (régime, préférences).

> 2. Envoie des recommandations quotidiennements

## 1. Notifications ciblées

1. **Utilisateurs stockées en base de données**

| customer_id | activity_level | age | allergies  | city       | conditions       | country | created_at                  | diet_type     | disliked_ingredients | email                     | favorite_cuisines        | first_name | gender | height | last_name | last_notification          | meals_per_day | newsletter_opt_in | phone_number | prefered_contact | prefered_meal_times                 | updated_at                  | weight | weight_goal       |
|-------------|---------------|-----|------------|------------|------------------|---------|----------------------------|---------------|----------------------|---------------------------|--------------------------|------------|--------|--------|-----------|----------------------------|---------------|-------------------|--------------|------------------|--------------------------------------|----------------------------|--------|------------------|
| 1           | 3             | 28  | {Peanuts}  | Paris      | {Hypertension}   | France  | 2026-02-27 01:38:49.648718 | Omnivore      | {Broccoli}           | lucas.martin@email.com    | {Italian,Japanese}       | Lucas      | MALE   | 1.78   | Martin    | 2026-02-27 01:38:49.648718 | 3             | t                 | 0612345678   | EMAIL            | {08:00,12:30,19:30}                 | 2026-02-27 01:38:49.648718 | 82.5   | LOSE_WEIGHT      |
| 2           | 2             | 35  | {Gluten}   | Lyon       | {Diabetes}       | France  | 2026-02-27 01:38:49.648718 | Vegetarian    | {Mushrooms}          | emma.dubois@email.com     | {Indian,Mexican}         | Emma       | FEMALE | 1.65   | Dubois    | 2026-02-27 01:38:49.648718 | 4             | f                 | 0676543210   | SMS              | {07:30,12:00,16:00,20:00}           | 2026-02-27 01:38:49.648718 | 60     | MAINTAIN_WEIGHT  |
| 3           | 4             | 22  | {None}     | Marseille  | {}               | France  | 2026-02-27 01:38:49.648718 | High Protein  | {Onion}              | thomas.nguyen@email.com   | {Vietnamese,Thai}        | Thomas     | MALE   | 1.82   | Nguyen    | 2026-02-27 01:38:49.648718 | 5             | t                 | 0699887766   | IN_APP           | {07:00,10:00,13:00,17:00,21:00}     | 2026-02-27 01:38:49.648718 | 68     | GAIN_WEIGHT      |
| 4           | 2             | 40  | {Lactose}  | Madrid     | {Cholesterol}    | Spain   | 2026-02-27 01:38:49.648718 | Keto          | {Sugar}              | sofia.garcia@email.com    | {Spanish,Mediterranean}  | Sofia      | FEMALE | 1.70   | Garcia    | 2026-02-27 01:38:49.648718 | 3             | t                 | 0655443322   | EMAIL            | {09:00,13:00,19:00}                 | 2026-02-27 01:38:49.648718 | 75     | LOSE_WEIGHT      |
| 5           | 5             | 30  | {Soy}      | New York   | {}               | USA     | 2026-02-27 01:38:49.648718 | Vegan         | {Garlic}             | alex.smith@email.com      | {American,Korean}        | Alex       | OTHER  | 1.75   | Smith     | 2026-02-27 01:38:49.648718 | 3             | f                 | 0700112233   | IN_APP           | {08:00,12:00,18:30}                 | 2026-02-27 01:38:49.648718 | 70     | MAINTAIN_WEIGHT  |

2. **Génération de l'état de la notification stockée en cache**

- Pour forcer le chargement du cache, ``1_load_cache.sh``
- Pour afficher le contenu du cache, ``1_5_get_cache.sh``

Exemple :
```
{"customer_id":1,"lastNotification":"2026-02-27T02:25:27.000Z"}
{"customer_id":4,"lastNotification":"2026-02-27T02:25:27.000Z"}
{"customer_id":3,"lastNotification":"2026-02-27T02:25:28.000Z"}
```

3. **Générer les notifications pour les clients**

Pour forcer la génération des notifications :
- Pour tous les clients éligibles : ``2_generate_all_notifications.sh``
- Pour un client _i_ : ``2_5_force_notification.sh i``

4. **Récupérer les notifications générées pour un client**
- Pour récupérer la notification : ``3_get_customer_notifications.sh``
- Pour récupérer les recettes générées pour un client _i_ : ``3_5_get_customers_recipes.sh i``


## 2. Recommandations quotidiennes

Les services tournent avec un scheduler :
- ``episaine-cache-loader`` tous les 6 heures
- ``episaine-generate-notification`` toutes les 12 heures
- ``episaine-send-notification`` tous les jours à minuit