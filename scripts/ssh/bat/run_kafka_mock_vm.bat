@echo off
setlocal

set "SRC=C:\Users\Ismail Benaissa\Desktop\EPISAINE-ING3\Mock\kafka-mock"
set "DEST=episaine@172.31.249.144:/home/episaine/"
set "KEY=C:\Users\Ismail Benaissa\.ssh\episaine_vm"
set "PORT=110"

set "BOOTSTRAP=192.168.248.110:9092"
set "TOPIC=customer-profile"
set "RATE=5"

scp -i "%KEY%" -P %PORT% -r "%SRC%" %DEST%
ssh -i "%KEY%" -p %PORT% episaine@172.31.249.144 "bash -lc 'set -e; cd ~/kafka-mock; python3 -m venv .venv; . .venv/bin/activate; pip install -r requirements.txt; KAFKA_BOOTSTRAP_SERVERS=%BOOTSTRAP% KAFKA_TOPIC=%TOPIC% RATE_PER_SEC=%RATE% python app.py'"

endlocal
