@echo off
echo Configurando Java PATH para usar JDK 15...
echo.

REM Obtener el PATH actual
for /f "tokens=2*" %%A in ('reg query "HKLM\SYSTEM\CurrentControlSet\Control\Session Manager\Environment" /v PATH 2^>nul') do set "CURRENT_PATH=%%B"

REM Remover las rutas de Java existentes del PATH
set "NEW_PATH=%CURRENT_PATH%"
set "NEW_PATH=%NEW_PATH:C:\Program Files\Common Files\Oracle\Java\javapath;=%"
set "NEW_PATH=%NEW_PATH:C:\Program Files\Java\jdk-15.0.2\bin;=%"

REM Agregar JDK 15 al inicio del PATH
set "NEW_PATH=C:\Program Files\Java\jdk-15.0.2\bin;%NEW_PATH%"

REM Actualizar el PATH del sistema
setx PATH "%NEW_PATH%" /M

echo.
echo PATH actualizado. JDK 15 ahora tiene prioridad.
echo.
echo IMPORTANTE: 
echo 1. Cierra TODAS las ventanas de PowerShell/CMD abiertas
echo 2. Abre una nueva ventana de PowerShell
echo 3. Ejecuta: java -version
echo.
pause
