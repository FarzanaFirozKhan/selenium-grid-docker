pipeline {
    agent any
    
    stages {
        stage('Build Docker Images') {
            steps {
                // Build Docker images using Docker Compose
                bat "docker-compose -f ${WORKSPACE}\\docker-compose.yml build"
            }
        }
        stage('Run Docker Containers') {
            steps {
                // Run Docker containers using Docker Compose
                bat "docker-compose -f ${WORKSPACE}\\docker-compose.yml up -d"
            }
        }
        stage('Run Tests') {
            steps {
                // Run TestNG tests with parameters
                bat "mvn clean test -Dtestngfile=${WORKSPACE}\\testng.xml -Dbrowser=chrome"
            }
        }
    }

    post {
        always {
            // Cleanup: Stop and remove Docker containers
            bat "docker-compose -f ${WORKSPACE}\\docker-compose.yml down"
        }
    }
}
