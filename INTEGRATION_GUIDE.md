# 🚀 Guía de Integración - SonarQube/SonarCloud y CI/CD

## 📋 Resumen
Esta guía te ayudará a integrar herramientas de análisis de código estático y pipelines de CI/CD en tu proyecto de automatización QA con Selenium y Cucumber.

## 🛠️ Herramientas Integradas

### ✅ Análisis de Código Estático
- **SonarQube/SonarCloud**: Análisis de calidad de código
- **JaCoCo**: Cobertura de código

### ✅ Pipelines CI/CD
- **GitHub Actions**: `.github/workflows/ci.yml`
- **Jenkins**: `Jenkinsfile`
- **Azure DevOps**: `azure-pipelines.yml`

## 🎯 Pasos para Implementar

### 1. SonarCloud (Recomendado para empezar)

#### Paso 1.1: Crear cuenta en SonarCloud
1. Ve a [sonarcloud.io](https://sonarcloud.io)
2. Inicia sesión con tu cuenta de GitHub/GitLab/Azure
3. Crea una nueva organización o usa una existente

#### Paso 1.2: Configurar proyecto
1. Importa tu repositorio desde SonarCloud
2. Obtén tu **Organization Key** y **Project Key**
3. Genera un **SONAR_TOKEN** en tu perfil de SonarCloud

#### Paso 1.3: Actualizar configuración
1. Edita `build.gradle` y cambia:
   ```gradle
   property "sonar.organization", "TU-ORGANIZACION-AQUI"
   ```
2. Si usas SonarQube local, edita `sonar-project.properties`

### 2. Configurar CI/CD

#### Opción A: GitHub Actions
1. **Configurar Secrets en GitHub:**
   - Ve a Settings → Secrets and variables → Actions
   - Agrega: `SONAR_TOKEN` con el token de SonarCloud

2. **El archivo ya está creado:** `.github/workflows/ci.yml`

#### Opción B: Jenkins
1. **Instalar plugins necesarios:**
   - SonarQube Scanner
   - JaCoCo
   - HTML Publisher
   - Email Extension

2. **Configurar herramientas globales:**
   - JDK 15
   - Gradle 7+
   - SonarQube Scanner

3. **Configurar credenciales:**
   - Agregar `SONAR_TOKEN` en Jenkins Credentials

4. **El archivo ya está creado:** `Jenkinsfile`

#### Opción C: Azure DevOps
1. **Configurar Service Connection:**
   - Ve a Project Settings → Service connections
   - Crea conexión a SonarCloud

2. **Configurar variables:**
   - Agregar `SONAR_TOKEN` en Pipeline variables

3. **El archivo ya está creado:** `azure-pipelines.yml`

## 🔧 Comandos para Ejecutar Localmente

### Ejecutar análisis de SonarQube
```bash
# Con SonarCloud
./gradlew sonarqube -Dsonar.login=TU_SONAR_TOKEN

# Con SonarQube local
./gradlew sonarqube
```

### Ejecutar tests con cobertura
```bash
./gradlew test jacocoTestReport
```

### Ejecutar tests de Selenium específicos
```bash
./gradlew test -Dcucumber.options="--tags @Test"
```

## 📊 Reportes Generados

### JaCoCo Coverage
- **HTML**: `build/jacocoHtml/index.html`
- **XML**: `build/reports/jacoco/test/jacocoTestReport.xml`

### Cucumber Reports
- **HTML**: `target/cucumber-reports/index.html`

### Test Results
- **JUnit XML**: `build/test-results/test/*.xml`

## 🎯 Puntos Extras que Obtienes

### ✅ Análisis de Código Estático
- **Code Coverage**: Porcentaje de código cubierto por tests
- **Code Smells**: Problemas de mantenibilidad
- **Bugs**: Errores potenciales
- **Security Hotspots**: Vulnerabilidades de seguridad
- **Duplicated Code**: Código duplicado

### ✅ Pipeline CI/CD
- **Automated Testing**: Tests ejecutados automáticamente
- **Quality Gates**: Bloqueo si la calidad no cumple estándares
- **Artifacts**: Reportes y screenshots guardados
- **Notifications**: Emails de éxito/fallo
- **Multi-environment**: Soporte para diferentes ramas

## 🚀 Siguiente Pasos

1. **Configurar SonarCloud:**
   - Crear cuenta y proyecto
   - Obtener tokens
   - Actualizar `build.gradle`

2. **Elegir plataforma CI/CD:**
   - GitHub Actions (más fácil)
   - Jenkins (más control)
   - Azure DevOps (integración Microsoft)

3. **Configurar secrets/credentials:**
   - SONAR_TOKEN
   - Email notifications

4. **Hacer push y verificar:**
   - Commit y push de los cambios
   - Verificar que el pipeline se ejecute
   - Revisar reportes en SonarCloud

## 🔍 Troubleshooting

### Error: "No tests found"
```bash
# Verificar que los tests estén en la ubicación correcta
./gradlew test --info
```

### Error: SonarQube connection
```bash
# Verificar token y organización
./gradlew sonarqube --info
```

### Error: Chrome/ChromeDriver
```bash
# Para headless testing local
export DISPLAY=:99
Xvfb :99 -screen 0 1024x768x24 &
```

## 📞 Soporte
Si tienes problemas con la integración, revisa:
1. Los logs del pipeline
2. La configuración de tokens
3. Los reportes de SonarCloud
4. La documentación oficial de cada herramienta
