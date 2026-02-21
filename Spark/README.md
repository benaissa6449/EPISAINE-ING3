# Spark pipeline (Bronze -> Silver -> Gold)

## Pré-requis
- Spark installé sur la VM Spark (`/opt/spark`)
- MongoDB accessible (Docker) sur `192.168.248.165:27017`
- Mongo Spark Connector utilisé via `--packages`

## Config
Les paramètres sont dans `spark/common/config.py`.

## Lancer Bronze -> Silver
Depuis la racine **spark/** (important pour les imports) :

```bash
cd spark
/opt/spark/bin/spark-submit \
  --packages org.mongodb.spark:mongo-spark-connector_2.12:10.6.0 \
  jobs/bronze_to_silver.py
