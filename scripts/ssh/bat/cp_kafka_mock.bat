@echo off
setlocal

set "SRC=C:\Users\Ismail Benaissa\Desktop\EPISAINE-ING3\Mock\kafka-mock"
set "DEST=episaine@172.31.249.144:/home/episaine/"
set "KEY=C:\Users\Ismail Benaissa\.ssh\episaine_vm"
set "PORT=110"

scp -i "%KEY%" -P %PORT% -r "%SRC%" %DEST%

endlocal
