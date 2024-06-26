@echo off

cd trabFrameworksP2
call mvn clean package

:: Set JAR path
set "jarFile=trabFrameworksP2\target\taskapp.jar"

:: Return to original directory
cd ..

setlocal enabledelayedexpansion

:: Path to the .env file
set "envFile=%~dp0.env"

:: Read and set environment variables from .env
for /F "tokens=*" %%a in (%envFile%) do (
    for /F "tokens=1* delims==" %%b in ("%%a") do (
        set %%b=%%c
    )
)

:: Execute the JAR file
start java -jar %jarFile%

endlocal