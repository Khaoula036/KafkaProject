start "KILL BROKER" c:\kafka\bin\windows\kafka-server-stop.bat
ping 127.0.0.1 -n 10 > nul
start "KILL ZOOKEEPER" c:\kafka\bin\windows\zookeeper-server-stop.bat