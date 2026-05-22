# EPISAINE — Spike Technique
## Proposition de plats sains & Gestion client

---

### 1.1 Architecture existante validée

```mermaid
Voir le fichier EPISAINE-ING3\docs\diagramme_de_haut_niveau.drawio
```

### 1.2 Stack technique utilisée

| Couche | Technologie | VM | Rôle |
|--------|------------|-----|------|
| **Ingestion** | Apache Spark (PySpark) | VM Spark | ETL CSV → Bronze → Silver → Gold |
| **Orchestration** | Apache Airflow | `192.168.248.155` | DAG `spark_client` (séquence de 4 tâches) |
| **Data Lake** | MongoDB | `192.168.248.165` | Stockage Bronze (`episaine_bronze_client`) et Silver (`episaine_silver_client`) |
| **Data Warehouse** | PostgreSQL | `192.168.248.170` | Couche Gold (`gold.silver_snapshot`) |
| **BI** | Power BI | Local | `BI_EPISAINE - ISMAIL BENAISSA & JOHN WANG.pbix` |
| **CI/CD** | GitLab CI | `192.168.248.151` | Pipeline [.gitlab-ci.yml](file:///c:/Users/Ismail%20Benaissa/Desktop/EPISAINE-ING3/.gitlab-ci.yml) |

### 1.3 Pipeline de données — Mode Delta

Le mode **delta hybride** est activé (`DELTA_MODE=true`) :

| Étape | Job Spark | Comportement Delta | Stockage |
|-------|-----------|-------------------|----------|
| CSV → Bronze | [csv_to_bronze.py](file:///c:/Users/Ismail%20Benaissa/Desktop/EPISAINE-ING3/Spark/jobs/csv_to_bronze.py) | `append` + `source_key`, `row_hash`, `batch_id`, `ingestion_ts` | MongoDB `episaine_bronze_client` |
| Bronze → Silver | [bronze_to_silver.py](file:///c:/Users/Ismail%20Benaissa/Desktop/EPISAINE-ING3/Spark/jobs/bronze_to_silver.py) | `overwrite` avec déduplication par `source_key` + validation + mapping labels | MongoDB `episaine_silver_client` |
| Silver → Gold | [silver_to_gold.py](file:///c:/Users/Ismail%20Benaissa/Desktop/EPISAINE-ING3/Spark/jobs/silver_to_gold.py) | `INSERT ... ON CONFLICT DO UPDATE` conditionnel sur `row_hash` | PostgreSQL `gold.silver_snapshot` |

### 1.4 Données source — CDC Diabetes (22 colonnes)

| Catégorie | Colonnes | Type |
|-----------|----------|------|
| **Cible** | `Diabetes_binary` | Binaire |
| **Santé cardio** | `HighBP`, `HighChol`, `CholCheck`, `HeartDiseaseorAttack`, `Stroke` | Binaire |
| **Morphologie** | `BMI` | Entier (12-98) |
| **Habitudes** | `Smoker`, `PhysActivity`, `Fruits`, `Veggies`, `HvyAlcoholConsump` | Binaire |
| **Accès soins** | `AnyHealthcare`, `NoDocbcCost` | Binaire |
| **État santé** | `GenHlth` (1-5), `MentHlth` (0-30j), `PhysHlth` (0-30j), `DiffWalk` | Mixte |
| **Démographie** | `Sex`, `Age` (13 tranches), `Education` (1-6), `Income` (1-8) | Mixte |
