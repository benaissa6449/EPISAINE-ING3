# EPISAINE - Platform de Traitement de Données Temps Réel

**Projet Data Engineering & Streaming**: Une plateforme complète pour l'ingestion, la transformation et l'analyse de données en temps réel.

### 👥 Auteurs
- **Ismail Benaissa**
- **John Wang**

---

## 📋 Table des matières
1. [Architecture](#architecture)
2. [Structure du projet](#-structure-du-projet)
3. [Prérequis](#prérequis)
4. [Installation](#installation)
5. [Services](#-services-principaux)
6. [Workflow de traitement](#-workflow-de-traitement)
7. [Monitoring](#-monitoring-et-logs)
8. [Dépannage](#-dépannage)
9. [Ressources](#-ressources--documentation)

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

| Composant | Description | Port | Localisation |
|-----------|-------------|------|--------------|
| **Talend** | Outil ETL pour les transformations de données | - | `episaine-talend-component/` |
| **Airflow** | Orchestration des workflows de données | 8080 | `Airflow/` |
| **PostgreSQL** | Base de données relationnelle (couche Gold) | 5432 | `PSQL-gold/` |
| **MongoDB** | Base NoSQL pour données flexibles | 27017 | `MongoDB/` |
| **Kafka** | Streaming temps réel & message broker | 9092 | `Kafka/` |
| **Backend Spring Boot** | API temps réel pour Kafka | 8080 | `episaine-kafka-backend/` |
| **Frontend React** | Interface utilisateur React | 3000 | `episaine-static-front/` |
| **Reverse Proxy** | Proxy inverse pour les services | 80/443 | `episaine-reverse-proxy/` |

---

## 📂 Structure du projet

```
EPISAINE-ING3/
├── Airflow/                          # Orchestration des workflows
│   └── talend_jobs_dag.py            # DAG principal d'orchestration
│
├── episaine-talend-component/        # Composant ETL Talend
│   ├── docker-compose.yml
│   ├── USDA.csv                      # Données de test
│   ├── jobInfo.properties            # Configuration des jobs Talend
│   ├── Jobs/                         # Processus ETL Talend
│   │   ├── LoadBronze/               # Import données brutes
│   │   ├── LoadBronzeK/              # Variante LoadBronze (K)
│   │   ├── LoadBronzeNutritional/    # LoadBronze données nutritionnelles
│   │   ├── LoadBronzeTMDB/           # LoadBronze données TMDB
│   │   ├── LoadSilver/               # Nettoyage et transformation
│   │   ├── LoadGold/                 # Agrégation et préparation analytics
│   │   └── lib/                      # Bibliothèques Talend
│   └── Jobs-source-code/             # Code source des jobs Talend
│
├── Kafka/                            # Configuration Kafka
│   └── [Configuration streaming]
│
├── episaine-kafka-backend/           # Backend Spring Boot (temps réel)
│   ├── pom.xml
│   └── src/                          # Code source Spring Boot
│
├── episaine-static-front/            # Frontend React (temps réel)
│   ├── package.json
│   └── src/                          # Code React
│
├── episaine-reverse-proxy/           # Nginx reverse proxy
│   └── [Configuration proxy]
│
├── episaine-cache-loader/            # Loader de cache
├── episaine-generate-notification/   # Service notifications
├── episaine-send-notification/       # Service d'envoi notifications
│
├── MongoDB/                          # Configuration MongoDB
│   └── [Configuration NoSQL]
│
├── PSQL-gold/                        # Configuration PostgreSQL
│   └── [Configuration relationnelle]
│
├── Mock/                             # Services de mock
│   └── kafka-mock/                   # Mock Kafka pour tests
│
├── BI - EPISAINE/                    # Outils BI (Dashboards)
├── Data/                             # Données de test/démo
├── demo-episaine/                    # Démonstrations
├── docs/                             # Documentation
│   └── Infra.drawio                  # Diagramme architecture
├── scripts/                          # Scripts utilitaires
│   ├── install_airflow.sh
│   ├── ssh_*.bat                     # Scripts connexion SSH
│   └── [Autres scripts]
│
└── README.md                         # Ce fichier
```

---

### Prérequis

| Outil | Version | Installation |
|-------|---------|--------------|
| **Docker** | 20.10+ | [docker.com](https://www.docker.com) |
| **Docker Compose** | 2.0+ | Inclus avec Docker Desktop |
| **Python** | 3.8+ | [python.org](https://www.python.org) |
| **Apache Airflow** | 2.x | Via `pip` ou script |
| **Java** | 11+ | Pour Spring Boot (optionnel) |
| **Node.js** | 16+ | Pour React frontend (optionnel) |
| **Git** | Latest | Pour cloner le repo |

---

### Installation

#### 1. Cloner le repository
```bash
git clone https://github.com/benaissa6449/EPISAINE-ING3.git
cd EPISAINE-ING3
```

#### 2. Configuration de base
```bash
# Initialiser les variables d'environnement
export EPISAINE_HOME=$(pwd)
export KAFKA_BOOTSTRAP_SERVERS=192.168.248.110:9092
export KAFKA_TOPIC=customer-profile
```

#### 3. Démarrer Talend & PostgreSQL (ETL Batch)
```bash
cd episaine-talend-component
docker-compose up -d
# Vérifie que les services sont lancés
docker ps
```

#### 4. Installer Airflow (Orchestration)
```bash
bash ../scripts/install_airflow.sh
# Initialiser la BD Airflow
airflow db init
```

#### 5. Lancer Airflow (deux terminaux)
```bash
# Terminal 1 - Webserver
airflow webserver --port 8080

# Terminal 2 - Scheduler
airflow scheduler
```

Accès Airflow : [http://localhost:8080](http://localhost:8080)

---

## 📡 Services principaux

### 🔄 ETL Batch (Talend + Airflow)
**Description**: Pipeline de transformation de données par batch
- **Talend**: Transformations métier complexes
- **Airflow**: Orchestration et scheduling
- **Bases cibles**: PostgreSQL (Gold), MongoDB, Autres

**Ports & URLs**:
- Airflow UI: [http://localhost:8080](http://localhost:8080)
- PostgreSQL: `localhost:5432`
- MongoDB: `localhost:27017`

---

### ⚡ Services Temps Réel (Kafka)

#### Option 1️⃣ : Backend Spring Boot local
```bash
cd episaine-kafka-backend
KAFKA_BOOTSTRAP_SERVERS=192.168.248.110:9092 \
KAFKA_TOPIC=customer-profile \
mvn spring-boot:run
```
**Port**: 8080  
**Endpoints API** : `/api/customer-profile/*`, `/api/health`  
**Base de données**: PostgreSQL (clients)

#### Option 2️⃣ : Frontend React local
```bash
cd episaine-static-front
npm install
REACT_APP_BACKEND_URL=http://localhost:8080 npm start
```
**Port**: 3000  
**URL**: [http://localhost:3000](http://localhost:3000)  
**Features**: Dashboard temps réel, streaming données Kafka

#### Option 3️⃣ : Services via Reverse Proxy
```bash
cd episaine-reverse-proxy
docker-compose up -d
```
**Port**: 80/443  
**Routes** :
- `/api/*` → Backend Spring Boot
- `/*` → Frontend React

---

### 🧪 Kafka Mock (Tests)
Pour tester sans infrastructure complète :
```bash
cd Mock/kafka-mock
# Voir README.md pour détails
docker logs kafka-mock
```

**Points importants**:
- ✓ Mock produit des messages test
- ✓ Utile pour développement local
- ✓ Voir `Mock/kafka-mock/README.md` pour configuration

---

## 🔄 Workflow de traitement

### Pipeline Talend → Airflow

```
LoadBronze (Import données brutes)
    ↓
    ├─→ Sources: CSV, APIs, Fichiers
    ├─→ Stockage: Raw data (HDFS/S3)
    │
LoadSilver (Nettoyage et transformation)
    ↓
    ├─→ Validation & Transformation
    ├─→ Déduplication & Enrichissement
    │
LoadGold (Agrégation & Préparation Analytics)
    ↓
    └─→ PostgreSQL, MongoDB, Data Warehouse
```

**Orchestration Airflow**:
- DAG: `Airflow/talend_jobs_dag.py`
- Exécution: Sequential (Bronze → Silver → Gold)
- Transport: SSH vers VM Talend
- Frequency: Configurable (daily, hourly, etc.)

---

## 📊 Monitoring et Logs

| Service | URL/Commande | Description |
|---------|--------------|-------------|
| **Airflow UI** | [http://localhost:8080](http://localhost:8080) | Orchestration & monitoring DAGs |
| **Spring Boot** | [http://localhost:8080/actuator](http://localhost:8080/actuator) | Health checks & métriques |
| **React App** | [http://localhost:3000](http://localhost:3000) | Dashboard temps réel |
| **Talend Logs** | `docker logs talend` | Logs du conteneur Talend |
| **Airflow Logs** | `$AIRFLOW_HOME/logs/` | Logs de tous les DAGs |
| **PostgreSQL** | `docker logs psql` | Logs PostgreSQL |
| **Kafka** | `docker logs kafka` | Logs broker Kafka |

### Commandes utiles
```bash
# Vérifier les services Docker
docker ps

# Logs temps réel
docker logs -f <container_name>

# Airflow: exécuter un DAG
airflow dags test talend_jobs_dag 2024-01-01

# PostgreSQL: connexion
psql -h localhost -U postgres -d gold_db
```

---

## 🐛 Dépannage

### Problème: Services Docker ne démarre pas
```bash
# Solution 1: Vérifier l'espace disque
docker system prune -a

# Solution 2: Reconstruire les images
cd episaine-talend-component
docker-compose down
docker-compose up -d --build
```

### Problème: Airflow ne trouve pas le DAG
```bash
# Vérifier le répertoire des DAGs
echo $AIRFLOW_HOME
# DAGs doivent être dans $AIRFLOW_HOME/dags/
# Copier le DAG:
cp Airflow/talend_jobs_dag.py $AIRFLOW_HOME/dags/
```

### Problème: Kafka connection refused
```bash
# Vérifier Kafka est démarré
docker ps | grep kafka

# Tester la connexion
nc -zv 192.168.248.110 9092
# Si OK: SUCCEED [IP port]

# Vérifier bootstrap servers
echo $KAFKA_BOOTSTRAP_SERVERS
```

### Problème: Backend Spring Boot ne peut pas se connecter à PostgreSQL
```bash
# Vérifier que PostgreSQL écoute
docker exec -it psql psql -U postgres -c "SELECT 1;"

# Vérifier les variables d'environnement
echo $POSTGRES_HOST
echo $POSTGRES_PORT
echo $POSTGRES_USER
```

### Problème: React Frontend ne voit pas l'API
```bash
# Vérifier URL backend
echo $REACT_APP_BACKEND_URL

# Tester la connexion
curl -v http://localhost:8080/api/health

# Check CORS (si erreur CORS)
# Modifier le backend pour accepter http://localhost:3000
```

---

## 📚 Ressources & Documentation

- [Apache Airflow Documentation](https://airflow.apache.org/docs/)
- [Talend ETL Guide](https://www.talend.com/resources/documentation/)
- [Apache Kafka Documentation](https://kafka.apache.org/documentation/)
- [Spring Boot Reference](https://spring.io/projects/spring-boot)
- [React Documentation](https://react.dev/)
- [PostgreSQL Documentation](https://www.postgresql.org/docs/)
- [MongoDB Documentation](https://docs.mongodb.com/)

---

## 📧 Support & Contribution

Pour toute question ou contribution, veuillez ouvrir une **issue** ou une **pull request** sur le repository GitHub.

**Contacts**:
- Ismail Benaissa: [ismail.benaissa@etu.u-pec.fr](mailto:ismail.benaissa@etu.u-pec.fr)
- John Wang: [john.wang@etu.u-pec.fr](mailto:john.wang@etu.u-pec.fr)

---

**Dernière mise à jour** : Juin 2026
**Statut**: Production Ready ✅
