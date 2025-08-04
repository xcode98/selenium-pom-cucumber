@echo off
echo Configurando variables de entorno de Java...
echo.

REM Configurar JAVA_HOME
setx JAVA_HOME "C:\Program Files\Java\jdk-15.0.2" /M

REM Agregar Java al PATH
for /f "tokens=2*" %%A in ('reg query "HKLM\SYSTEM\CurrentControlSet\Control\Session Manager\Environment" /v PATH 2^>nul') do set "CURRENT_PATH=%%B"
echo %CURRENT_PATH% | find /i "C:\Program Files\Java\jdk-15.0.2\bin" >nul
if errorlevel 1 (
    setx PATH "%CURRENT_PATH%;C:\Program Files\Java\jdk-15.0.2\bin" /M
    echo Java agregado al PATH del sistema
) else (
    echo Java ya esta en el PATH del sistema
)

echo.
echo Variables de entorno configuradas:
echo JAVA_HOME = C:\Program Files\Java\jdk-15.0.2
echo PATH actualizado con Java bin
echo.
echo IMPORTANTE: Reinicia tu terminal o IDE para que los cambios tomen efecto.
echo.
pause
