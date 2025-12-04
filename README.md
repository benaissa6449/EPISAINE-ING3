# SIRIUS Project - EPISAINE

### 👥 Auteurs
- **Ismail Benaissa**
- **John Wang**

---



## Architecture

### Couches de données (Medallion Architecture)

```
┌─────────────────────────────────────────┐
│          Source de données              │
│      (Fichiers CSV, APIs, etc.)         │
└──────────────┬──────────────────────────┘
               │
        ┌──────▼──────┐
        │   BRONZE    │ ← Données brutes, non traitées
        │  (Raw Data) │
        └──────┬──────┘
               │
        ┌──────▼───────┐
        │   SILVER     │ ← Données nettoyées et transformées
        │(Clean Data)  │
        └──────┬───────┘
               │
        ┌──────▼─────┐
        │    GOLD    │ ← Données agrégées, prêtes pour l'analyse
        │(Analytics) │
        └────────────┘
```

### Composants principaux

| Composant | Description | Localisation |
|-----------|-------------|--------------|
| **Talend** | Outil ETL pour les transformations de données |`episaine-talend-component` |
| **Airflow** | Orchestration des workflows de données | `Airflow/` |
| **PostgreSQL** | Base de données relationnelle (couche Gold) | `PSQL-gold/` |
| **MongoDB** | Base NoSQL pour données flexibles | `MongoDB/` |
| **Docker** | Containerisation des services | `Docker/` |

---

## 📂 Structure du projet

```
EPISAINE-ING3/
├── Airflow/
│   └── talend_jobs_dag.py          # DAG principal d'orchestration
├── Docker/
│   └── [Configuration Docker]
├── episaine-talend-component/
│   ├── docker-compose.yml
│   ├── students.csv                # Données de test
│   └── episaine-data-proto/
│       ├── code/                   # Code métier (routines, transformations)
│       ├── context/                # Contextes Talend
│       ├── process/                # Processus ETL (LoadBronze, LoadSilver, LoadGold)
│       └── sqlPatterns/            # Patterns SQL pour différentes BD
│           ├── DeltaLake/
│           ├── Generic/
│           ├── Hive/
│           ├── MySQL/
│           ├── Oracle/
│           ├── Snowflake/
│           └── Teradata/
├── MongoDB/
│   └── [Configuration MongoDB]
├── PSQL-gold/
│   └── [Configuration PostgreSQL]
├── scripts/
│   ├── install_airflow.sh          # Installation Airflow
│   ├── ssh_cicd.bat                # Connexion CICD
│   ├── ssh_datalake.bat            # Connexion Data Lake
│   ├── ssh_orch.bat                # Connexion Orchestration
│   ├── ssh_psql.bat                # Connexion PostgreSQL
│   └── ssh_talend.bat              # Connexion Talend
├── docs/
│   └── Infra.drawio                # Diagramme infrastructure
└── README.md                        # Ce fichier

```

---

### Prérequis
- Docker & Docker Compose
- Python 3.8+
- Apache Airflow 2.x
- Talend ETL

### Installation

1. **Cloner le repository**
```bash
git clone <repository-url>
cd EPISAINE-ING3
```

2. **Installer Airflow**
```bash
bash scripts/install_airflow.sh
```

3. **Démarrer les services Docker**
```bash
cd episaine-talend-component
docker-compose up -d
```

4. **Initialiser Airflow**
```bash
airflow db init
airflow users create --username admin --password admin --firstname Admin --lastname User --role Admin --email admin@example.com
airflow webserver --port 8080
airflow scheduler
```

---


### Workflow Talend → Airflow

```
LoadBronze (Import données brutes)
    ↓
LoadSilver (Nettoyage et transformation)
    ↓
LoadGold (Agrégation et préparation analytics)
```

Le DAG Airflow (`talend_jobs_dag.py`) exécute ces trois étapes en séquence via SSH sur la VM Talend.

---



## 📈 Monitoring et Logs

- **Airflow UI** : `http://localhost:8080`
- **Logs Talend** : `docker logs talend`
- **Logs Airflow** : `$AIRFLOW_HOME/logs/`

---


**Dernière mise à jour** : Décembre 2025