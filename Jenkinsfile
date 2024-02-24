pipeline {
    agent any
    
    // Define tools section
    tools {
        // Define JDK tool with the specified name and type
        jdk 'JAVA_HOME'
        // Define Maven tool with the specified name and type
        maven 'MAVEN_HOME'
    }
    
    stages {
        stage('Run Docker Containers') {
            steps {
                // Run Docker containers using Docker Compose
                bat "docker-compose -f ${WORKSPACE}\\docker-compose.yaml up -d"
            }
        }
        stage('Clean mvn') {
            steps {
                // Run mvn clean using the specified Maven tool
                bat "mvn clean"
            }
        }
        stage('Run Tests') {
            steps {
                // Run mvn test using the specified Maven tool
                bat "mvn test -Dtestngfile=${WORKSPACE}\\src\\test\\java\\TestNG.xml -Dbrowser=chrome"
            }
        }
    }

    post {
        always {
            // Cleanup: Stop and remove Docker containers
            bat "docker-compose -f ${WORKSPACE}\\docker-compose.yaml down"
        }
    }
}
