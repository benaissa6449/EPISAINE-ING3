@echo off

set USER=episaine
set HOST=172.31.249.144
set PORT=160

echo Connecting to %USER%@%HOST% on port %PORT%...
ssh %USER%@%HOST% -p %PORT%