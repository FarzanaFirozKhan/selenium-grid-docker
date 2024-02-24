pipeline {
    agent any
    
    stages {
        stage('Build Docker Images') {
            steps {
                // Build Docker images using Docker Compose
                sh 'docker-compose -f /path/to/docker-compose.yml build'
            }
        }
        stage('Run Docker Containers') {
            steps {
                // Run Docker containers using Docker Compose
                sh 'docker-compose -f /path/to/docker-compose.yml up -d'
            }
        }
        stage('Run Tests') {
            steps {
                // Run TestNG tests with parameters
                sh 'mvn clean test -Dtestngfile=/path/to/testng.xml -Dbrowser=chrome'
            }
        }
    }

    post {
        always {
            // Cleanup: Stop and remove Docker containers
            sh 'docker-compose -f /path/to/docker-compose.yml down'
        }
    }
}
