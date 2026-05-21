# EPISAINE - Scenario Haut Niveau Data / Spark / Airflow

## Objectif
Montrer le traitement data de bout en bout:
- ingestion d'un CSV source,
- transformation Bronze -> Silver -> Gold avec Spark,
- orchestration des etapes via Apache Airflow.

## Composants
- Airflow (VM Orchestration): declenche et supervise le DAG `spark_client`.
- Spark (VM Spark): execute les jobs `csv_to_bronze`, `bronze_to_silver`, `silver_to_gold`.
- MongoDB (Data Lake): stocke Bronze et Silver.
- PostgreSQL (Gold): stocke la table analytique `gold.silver_snapshot`.

## Scenario Haut Niveau
1. Airflow lance le DAG `spark_client` (declenchement manuel).
2. Tache `extract_and_copy_csv`: verifie la presence du CSV source et le copie si necessaire.
3. Tache `csv_to_bronze` (Spark): lit le CSV et ecrit en MongoDB collection Bronze.
4. Tache `bronze_to_silver` (Spark): cast, validation, nettoyage, mapping metier, puis ecriture en Silver.
5. Tache `silver_to_gold` (Spark): lit Silver et charge PostgreSQL dans `gold.silver_snapshot`.
6. Les consumers BI lisent la couche Gold.

## Flux de Donnees
- Source CSV: `/home/episaine/data/uci/cdc_diabetes_253k.csv`
- Bronze Mongo: `episaine_bronze_client`
- Silver Mongo: `episaine_silver_client`
- Gold PostgreSQL: `gold.silver_snapshot`

## Orchestration Airflow
- DAG: `spark_client` (`Airflow/spark_client_dag.py`)
- Sequence:
  - `extract_and_copy_csv`
  - `csv_to_bronze`
  - `bronze_to_silver`
  - `silver_to_gold`
- Execution distante via `SSHOperator` sur la VM Spark (`ssh_spark_vm`).
- Robustesse: retries Airflow, timeouts de job, heartbeat de log.

## Mode De Traitement
- Le DAG active `DELTA_MODE=true`.
- Chaque execution porte un `BATCH_ID={{ dag_run.run_id }}` pour tracer les batches.
- Bronze et Silver sont alimentes depuis Mongo; Gold est alimente dans PostgreSQL.

## Comprendre Le Mode Delta
Le mode delta ne veut pas dire "100% incremental partout".  
Dans votre pipeline actuel, il sert surtout a:
- tracer chaque execution via `BATCH_ID`,
- identifier les lignes metier via `source_key` / `row_hash`,
- eviter les mises a jour inutiles en Gold.

### Difference simple: Full-refresh vs Delta
- Full-refresh:
  - Bronze ecrase la collection (`overwrite`),
  - Silver ecrase la collection (`overwrite`),
  - Gold est tronquee puis rechargee.
- Delta:
  - Bronze ajoute les nouvelles lignes (`append`) avec metadonnees,
  - Silver reconstruit la vue cible en `overwrite` (dedup incluse),
  - Gold fait un upsert (insert/update) au lieu d'un reload total.

### Ce que fait chaque etape en Delta
1. Bronze (`csv_to_bronze`)
- calcule `source_key` et `row_hash` a partir du payload,
- ajoute `batch_id` et `ingestion_ts`,
- genere un `ID` deterministe base sur le hash,
- ecrit en `append` pour conserver l'historique d'ingestion.

2. Silver (`bronze_to_silver`)
- relit Bronze, nettoie/caste/mappe les donnees,
- deduplique par `source_key`,
- peut filtrer un seul batch via `DELTA_BATCH_ONLY=true`,
- ecrit la collection Silver en `overwrite` (vue courante propre).

3. Gold (`silver_to_gold`)
- lit Silver et charge PostgreSQL,
- fait `INSERT ... ON CONFLICT (id) DO UPDATE`,
- met a jour seulement si `row_hash` a change.

### Exemple concret (2 runs)
- Run A (`BATCH_ID=A`):
  - 100 lignes lues depuis CSV,
  - Bronze ajoute 100 lignes,
  - Gold contient 100 lignes.
- Run B (`BATCH_ID=B`):
  - 100 lignes relues, dont 5 lignes modifiees,
  - Bronze ajoute de nouvelles lignes avec `batch_id=B`,
  - Silver garde une seule version par `source_key`,
  - Gold met a jour seulement les 5 lignes dont `row_hash` change.

### Point important
Ce mode est "delta hybride":
- incrementale en Bronze (on ajoute les nouveaux enregistrements a chaque run, sans vider la collection),
- logique incrementale en Gold (upsert conditionnel: insertion si absent, mise a jour seulement si `row_hash` change),
- mais Silver est recalcul cote cible (overwrite: la collection Silver est reecrite a chaque run, sans historique de versions).

## Verification Rapide
1. Airflow:
```bash
airflow dags list | grep spark_client
airflow tasks states-for-dag-run spark_client <run_id>
```

2. Lancer depuis le script projet:
```bash
bash scripts/run_spark_client_dag.sh
```

3. Controle des sorties:
- MongoDB: verifier la presence de donnees dans Bronze/Silver.
- PostgreSQL: verifier la table `gold.silver_snapshot` et son volume.

## Fichiers Cles
- DAG Airflow: `Airflow/spark_client_dag.py`
- Jobs Spark:
  - `Spark/jobs/csv_to_bronze.py`
  - `Spark/jobs/bronze_to_silver.py`
  - `Spark/jobs/silver_to_gold.py`
- Configuration: `Spark/common/config.py`
