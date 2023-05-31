@echo off
REM Supprimer les fichiers kafka pour démarrer from scratch
rmdir c:\tmp\zookeeper /S /Q
rmdir c:\tmp\kafka-logs /S /Q

REM lancement de ZOOKEEPER
start "ZOOKEEPER" %~dp0\bin\windows\zookeeper-server-start.bat %~dp0\config\zookeeper.properties
REM attente 15 secondes
ping 127.0.0.1 -n 15 > nul

REM lancement du BROKER
start "BROKER" %~dp0\bin\windows\kafka-server-start.bat %~dp0\config\server.properties
REM attente 15 secondes
ping 127.0.0.1 -n 15 > nul

REM lancement du producer genkp
cd %~dp0\genkp
start "GEN-KP" run.cmd
REM attente 15 secondes
ping 127.0.0.1 -n 15 > nul

REM lancement du consumer kc-etudiants
cd %~dp0\kc-etudiants
start "KC-ETUDIANTS" run.cmd

REM vous pouvez accéder au service swagger via http://localhost:7000/swagger-ui.html	