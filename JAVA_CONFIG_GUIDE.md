# Guía de Configuración de Java para Windows

## Problema Actual
El proyecto Gradle no puede encontrar o usar correctamente Java 15 ubicado en `C:\Program Files\Java\jdk-15.0.2`.

## Solución Manual - Configurar Variables de Entorno

### Paso 1: Configurar JAVA_HOME
1. Presiona `Win + R` y escribe `sysdm.cpl`
2. Ve a la pestaña "Avanzado"
3. Haz clic en "Variables de entorno"
4. En "Variables del sistema", haz clic en "Nueva"
5. Nombre de variable: `JAVA_HOME`
6. Valor de variable: `C:\Program Files\Java\jdk-15.0.2`
7. Haz clic en "Aceptar"

### Paso 2: Actualizar PATH
1. En "Variables del sistema", busca y selecciona "Path"
2. Haz clic en "Editar"
3. Haz clic en "Nuevo"
4. Agrega: `%JAVA_HOME%\bin`
5. Haz clic en "Aceptar" en todas las ventanas

### Paso 3: Verificar la Configuración
Abre una nueva ventana de PowerShell y ejecuta:
```powershell
java -version
javac -version
echo $env:JAVA_HOME
```

## Solución Alternativa - Usar Gradle Wrapper con Java específico

Si las variables de entorno no funcionan, puedes usar el wrapper de Gradle directamente:

```powershell
# Limpiar el proyecto
./gradlew clean --no-daemon

# Compilar el proyecto
./gradlew build --no-daemon

# Ejecutar tests
./gradlew test --no-daemon
```

## Configuración Actual del Proyecto

### build.gradle
- Configurado para Java 15
- sourceCompatibility y targetCompatibility establecidos

### gradle.properties
- org.gradle.java.home apunta a tu JDK
- Daemon deshabilitado para evitar conflictos

## Próximos Pasos
1. Configura las variables de entorno manualmente
2. Reinicia tu terminal/IDE
3. Ejecuta `./gradlew clean` para verificar
4. Si persisten los errores, considera usar una versión más reciente de Gradle

## Notas Importantes
- El error actual parece estar relacionado con conflictos de JVM
- La caché de Gradle puede estar corrupta
- Es recomendable reiniciar el sistema después de configurar las variables de entorno
