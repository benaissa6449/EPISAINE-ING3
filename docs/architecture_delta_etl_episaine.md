# Architecture Delta ETL pour EPISAINE (guide sans casse)

Ce document explique comment appliquer une architecture **delta** sur le pipeline actuel:

- `CSV -> Bronze -> Silver -> Gold`
- DAG Airflow: `extract_and_copy_csv -> csv_to_bronze -> bronze_to_silver -> silver_to_gold`

## 1. Situation actuelle

Actuellement, le pipeline est surtout en mode *full refresh*:

- `csv_to_bronze.py`: écrit Bronze avec `mode("overwrite")`
- `bronze_to_silver.py`: écrit Silver avec `mode("overwrite")`
- `silver_to_gold.py`: fait `TRUNCATE` puis `INSERT` dans PostgreSQL

Conséquence: pas de vraie logique delta (on recharge presque tout à chaque run).

## 2. Ce que veut dire "delta" ici

Traiter seulement les **changements** entre deux runs:

- nouvelles lignes -> `INSERT`
- lignes modifiées -> `UPDATE`
- lignes inchangées -> `SKIP`
- suppressions (optionnel) -> `soft delete` ou `DELETE`

Le check delta se base sur:

- `source_key` (clé métier stable)
- `row_hash` (empreinte des colonnes métier)

## 3. Colonnes techniques recommandées

Ajouter ces colonnes dans Bronze/Silver:

- `source_key`: clé stable de la ligne
- `row_hash`: hash des colonnes métier
- `batch_id`: identifiant de run (ex: `dag_run.run_id`)
- `ingestion_ts`: timestamp ingestion
- `is_deleted` (optionnel)

## 4. Règles Delta par couche

### Bronze

- mode cible: `append` (journal brut)
- pas de suppression
- stocke les colonnes techniques

### Silver

- mode cible: `merge/upsert`
- règles:
  - clé absente en Silver -> `INSERT`
  - clé présente + hash différent -> `UPDATE`
  - clé présente + hash identique -> `SKIP`

### Gold (PostgreSQL)

- éviter `TRUNCATE` en cible delta
- passer en `UPSERT` (par clé primaire)
- option suppression: soft delete ou delete physique selon besoin métier

## 5. Migration sans casser le pipeline

Approche progressive recommandée:

1. **Ne pas toucher l'ordre du DAG**.
2. Ajouter les colonnes techniques (sans changer la logique overwrite).
3. Passer uniquement `bronze_to_silver` en merge delta.
4. Stabiliser et monitorer (counts insert/update/unchanged).
5. Passer ensuite `silver_to_gold` en upsert.

## 6. Impact DAG Airflow

Le DAG peut garder les mêmes 4 tâches.
Modifs minimales:

- injecter `batch_id` via env (ex: `{{ dag_run.run_id }}`)
- adapter les commandes Spark si besoin (paramètres delta)
- conserver retries/timeouts

## 7. Filet de sécurité (important)

Prévoir un flag d'activation:

- `DELTA_MODE=true|false`

En cas de problème:

- remettre `DELTA_MODE=false`
- revenir temporairement au comportement full refresh sans changer le DAG

## 8. Checklist de validation

Avant de dire "OK delta":

- clé métier stable validée (`source_key`)
- idempotence validée (rejouer le même batch ne duplique pas)
- métriques de run disponibles:
  - inserts
  - updates
  - unchanged
  - deletes
- tests sur 2-3 runs successifs avec données modifiées

## 9. Implémentation réalisée dans ce repo

Les changements suivants sont deja en place, avec un mode securise:

- `Spark/common/config.py`
  - `DELTA_MODE` ajoute (defaut: `false`)
  - `BATCH_ID` ajoute
- `Airflow/spark_client_dag.py`
  - injection de `DELTA_MODE` et `BATCH_ID="{{ dag_run.run_id }}"`
  - valeur actuelle: `DELTA_MODE="false"` (pas de changement fonctionnel)
- `Spark/jobs/csv_to_bronze.py`
  - mode full refresh conserve quand `DELTA_MODE=false`
  - mode delta ajoute quand `DELTA_MODE=true`:
    - colonnes techniques `source_key`, `row_hash`, `batch_id`, `ingestion_ts`
    - ecriture Bronze en `append`
- `Spark/jobs/bronze_to_silver.py`
  - full refresh conserve quand `DELTA_MODE=false`
  - merge logique ajoute quand `DELTA_MODE=true`:
    - `new` / `changed` / `unchanged` via `source_key` + `row_hash`
- `Spark/jobs/silver_to_gold.py`
  - `TRUNCATE + INSERT` conserve quand `DELTA_MODE=false`
  - upsert PostgreSQL ajoute quand `DELTA_MODE=true` (`ON CONFLICT`)
  - colonnes techniques Gold ajoutees si absentes (`ALTER TABLE IF NOT EXISTS`)

## 10. Comment activer le mode delta

Par defaut, le pipeline reste compatible avec l'ancien comportement.

Pour activer delta:

1. Ouvrir `Airflow/spark_client_dag.py`
2. Passer `DELTA_MODE = "true"`
3. Relancer scheduler/dag-processor si necessaire
4. Lancer un nouveau run du DAG `spark_client`

Pour rollback rapide:

1. remettre `DELTA_MODE = "false"`
2. relancer un run

## 11. Risque et compatibilite

- Tant que `DELTA_MODE=false`, aucun impact negatif attendu sur le fonctionnement existant.
- Le mode delta est opt-in et reversible.
- Le DAG (ordre des 4 taches) n'a pas ete modifie.

---

Ce plan permet d'introduire le delta progressivement, avec rollback simple, sans réécrire toute l'orchestration.
