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

---

## Ajout Architecture Front VM (Apache + Node)

Pour le deploiement du front sur VM, la couche Web peut etre geree ainsi:

```text
Utilisateur navigateur
        |
        v
   Apache2 (VM Front)
        |
        +--> sert le build React statique depuis /var/www/episaine-front
        |
        +--> (option) Node.js disponible sur la VM pour build/maintenance
```

### Dossier scripts ajoute

```text
scripts/
  configuration/
    front/
      install_apache_node_front.sh
      deploy_front_apache.sh
      apache/
        episaine-front.conf
      node/
        run_front_node.sh
```

### Usage rapide sur VM Front

1. Installer Apache + Node:
   `sudo ./scripts/configuration/front/install_apache_node_front.sh`
2. Deployer le front via Apache:
   `sudo ./scripts/configuration/front/deploy_front_apache.sh /chemin/vers/EPISAINE-ING3`
