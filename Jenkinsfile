pipeline {
    agent any
    
    tools {
        jdk 'JDK-15' // Configurar en Jenkins Global Tool Configuration
        gradle 'Gradle-7' // Configurar en Jenkins Global Tool Configuration
    }
    
    environment {
        SONAR_TOKEN = credentials('sonar-token') // Configurar en Jenkins Credentials
        CHROME_BIN = '/usr/bin/google-chrome'
        DISPLAY = ':99'
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
                echo 'Código descargado correctamente'
            }
        }
        
        stage('Build') {
            steps {
                echo 'Compilando el proyecto...'
                sh './gradlew clean build -x test'
            }
        }
        
        stage('Unit Tests') {
            steps {
                echo 'Ejecutando pruebas unitarias...'
                sh './gradlew test'
            }
            post {
                always {
                    publishTestResults testResultsPattern: 'build/test-results/test/*.xml'
                    publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'build/reports/tests/test',
                        reportFiles: 'index.html',
                        reportName: 'Unit Test Report'
                    ])
                }
            }
        }
        
        stage('Selenium Tests') {
            steps {
                echo 'Ejecutando pruebas de Selenium...'
                script {
                    try {
                        // Iniciar Xvfb para headless browser
                        sh 'Xvfb :99 -screen 0 1024x768x24 &'
                        sleep 5
                        
                        // Ejecutar pruebas de Selenium con Cucumber
                        sh './gradlew test -Dcucumber.options="--tags @Test"'
                    } catch (Exception e) {
                        currentBuild.result = 'UNSTABLE'
                        echo "Algunas pruebas de Selenium fallaron: ${e.getMessage()}"
                    }
                }
            }
            post {
                always {
                    // Publicar reportes de Cucumber
                    publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'target/cucumber-reports',
                        reportFiles: 'index.html',
                        reportName: 'Cucumber Report'
                    ])
                    
                    // Archivar screenshots si existen
                    archiveArtifacts artifacts: 'target/screenshots/**/*.png', fingerprint: true, allowEmptyArchive: true
                }
            }
        }
        
        stage('Code Coverage') {
            steps {
                echo 'Generando reporte de cobertura...'
                sh './gradlew jacocoTestReport'
            }
            post {
                always {
                    publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'build/jacocoHtml',
                        reportFiles: 'index.html',
                        reportName: 'JaCoCo Coverage Report'
                    ])
                }
            }
        }
        
        stage('SonarQube Analysis') {
            steps {
                echo 'Ejecutando análisis de SonarQube...'
                withSonarQubeEnv('SonarQube') { // Configurar en Jenkins
                    sh './gradlew sonarqube -Dsonar.login=$SONAR_TOKEN'
                }
            }
        }
        
        stage('Quality Gate') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
    
    post {
        always {
            echo 'Pipeline completado'
            cleanWs() // Limpiar workspace
        }
        success {
            echo 'Pipeline ejecutado exitosamente!'
            emailext (
                subject: "✅ Pipeline Exitoso: ${env.JOB_NAME} - ${env.BUILD_NUMBER}",
                body: "El pipeline se ejecutó correctamente.\n\nVer detalles: ${env.BUILD_URL}",
                to: "${env.CHANGE_AUTHOR_EMAIL}"
            )
        }
        failure {
            echo 'Pipeline falló'
            emailext (
                subject: "❌ Pipeline Fallido: ${env.JOB_NAME} - ${env.BUILD_NUMBER}",
                body: "El pipeline falló.\n\nVer detalles: ${env.BUILD_URL}",
                to: "${env.CHANGE_AUTHOR_EMAIL}"
            )
        }
        unstable {
            echo 'Pipeline inestable - algunas pruebas fallaron'
        }
    }
}
