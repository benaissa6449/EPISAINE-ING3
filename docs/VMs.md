# VMs description

How to connect to a VM: ``ssh episaine@172.31.249.144 -p {IP port}``

| VM | IP port | VM user | ssh script | usage | Intern Host |
| - | - | - | - | - | - |
| EPISAINE - CICD | 151 | episaine | ssh_cicd | Handle gitlab CI-CD | 192.168.248.151 |
| Orchestration - VM (Apache Airflow) | 155 | episaine | ssh_orch | Host airflow | 192.168.248.155 |
| ETL - Talend - EPISAINE | 160 | episaine | ssh_talend | Host Talend Jobs | 192.168.248.160
| Data lake - MongoDB - EPISAINE | 165 | episaine | ssh_datalake | Host mongoDB database | 192.168.248.165 |
| PSQL - EPISAINE | 170 | episaine | ssh_psql | Host PostgreSQL database | 192.168.248.170 |