# Architecture Incremementale CSV -> Mongo (Bronze/Silver/Gold)

## Objectif
Ne plus ecraser toutes les collections a chaque execution.
Ajouter uniquement les nouvelles lignes detectees dans le CSV, tout en conservant l'historique.

## Schema d'architecture
```text
                           +----------------------+
                           |   Airflow (DAG)      |
                           |   spark_client       |
                           +----------+-----------+
                                      |
                 +--------------------+--------------------+
                 |                    |                    |
                 v                    v                    v
        +----------------+   +-------------------+   +------------------+
        | csv_to_bronze  |-->| bronze_to_silver  |-->| silver_to_gold   |
        | (Spark job)    |   | (Spark job)       |   | (Spark job)      |
        +--------+-------+   +---------+---------+   +--------+---------+
                 |                     |                      |
                 v                     v                      v
      +--------------------+  +--------------------+  +--------------------+
      | Mongo Bronze       |  | Mongo Silver       |  | Mongo Gold         |
      | append + dedup     |  | upsert             |  | snapshot/upsert    |
      | (row_hash/ID)      |  | (ID/row_hash key)  |  | (aggregats)        |
      +--------------------+  +--------------------+  +--------------------+

Source:
+-----------------------------+
| CSV (fichier mis a jour)    |
| +2/+3 lignes ajoutees       |
+-------------+---------------+
              |
              v
      csv_to_bronze lit le CSV,
      compare avec Bronze,
      n'ecrit que les nouvelles lignes.
```

## Regles par couche
1. Bronze: `append` + deduplication (ex: `row_hash`).
2. Silver: `upsert` (update si existe, insert sinon).
3. Gold:
   - option simple: `overwrite` (snapshot global),
   - option incrementale: `upsert` sur cle d'agregat.

## Cle technique recommandee
- Utiliser une cle stable pour differencier les nouvelles lignes:
  - priorite: cle metier (ex: `customer_id`),
  - sinon: `row_hash` calcule sur les colonnes de la ligne.

## Benefice
- Pas de perte d'historique.
- Pas de reecriture complete des collections.
- Pipeline robuste pour ajouts incrementaux.
