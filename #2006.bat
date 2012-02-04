@echo off
@setlocal
@set PATH=%DIR%\\jar;%PATH%
cd bin
java -Xmx500M server.server
pause