pipeline {
    agent any

    environment {
        // Variables para DockerHub
        DOCKER_IMAGE = "jblacker2022/employee-microservice"
        DOCKER_TAG = "latest"

        // Variables para SonarQube
        SONAR_URL = 'http://<SONARQUBE_SERVER>'
        SONAR_TOKEN = '<SONAR_TOKEN>'
    }

    tools {
        maven 'Maven' // Asegúrate de configurar Maven en Jenkins
        jdk 'Java 11' // Configura Java 11 en Jenkins
    }

    stages {
        stage('Setup') {
            steps {
                echo 'Setting up permissions for mvnw...'
                sh 'chmod +x ./mvnw' // Ajusta los permisos del archivo mvnw
            }
        }

        stage('Build') {
            steps {
                echo 'Building the application...'
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Testing (JUnit + Jacoco)') {
            steps {
                echo 'Running tests and generating coverage report...'
                sh './mvnw test'
                sh './mvnw jacoco:report'
            }
        }

        stage('Sonar Analysis') {
            steps {
                echo 'Analyzing code quality with SonarQube...'
                withSonarQubeEnv('SonarQube') {
                    sh "./mvnw sonar:sonar -Dsonar.projectKey=employee-microservice -Dsonar.host.url=${SONAR_URL} -Dsonar.login=${SONAR_TOKEN}"
                }
            }
        }

        stage('Quality Gate') {
            steps {
                script {
                    timeout(time: 5, unit: 'MINUTES') {
                        def qg = waitForQualityGate()
                        if (qg.status != 'OK') {
                            error "Pipeline aborted due to quality gate failure: ${qg.status}"
                        }
                    }
                }
            }
        }

        stage('Docker Build & Push') {
            steps {
                echo 'Building and pushing Docker image...'
                script {
                    sh 'docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} .'
                    withDockerRegistry([credentialsId: 'dockerhub-credentials', url: 'https://index.docker.io/v1/']) {
                        sh 'docker push ${DOCKER_IMAGE}:${DOCKER_TAG}'
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
