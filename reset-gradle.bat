@echo off
echo Reseteando Gradle y limpiando cache...
echo.

REM Detener todos los procesos de Gradle
taskkill /f /im java.exe 2>nul
timeout /t 2 >nul

REM Eliminar cache de Gradle
if exist "%USERPROFILE%\.gradle\caches" (
    echo Eliminando cache de Gradle...
    rmdir /s /q "%USERPROFILE%\.gradle\caches" 2>nul
)

if exist "%USERPROFILE%\.gradle\daemon" (
    echo Eliminando daemons de Gradle...
    rmdir /s /q "%USERPROFILE%\.gradle\daemon" 2>nul
)

REM Eliminar directorio build del proyecto
if exist "build" (
    echo Eliminando directorio build del proyecto...
    rmdir /s /q "build" 2>nul
)

REM Eliminar archivos .gradle del proyecto
if exist ".gradle" (
    echo Eliminando .gradle del proyecto...
    rmdir /s /q ".gradle" 2>nul
)

echo.
echo Cache de Gradle limpiada.
echo Ahora puedes ejecutar: ./gradlew clean
echo.
pause
