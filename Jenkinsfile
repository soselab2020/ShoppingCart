pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat "mvn clean compile"
            }
        }
        stage('Test') {
            steps {
                bat "mvn test"
            }
        }
        stage('Deploy') {
            steps {
                bat "mvn package"
                // bat "java -jar ShoppingCart-1.0-SNAPSHOT.jar"
            }
        }
        stage('SonarQube Scan') {
            steps {
                withSonarQubeEnv('MySonarQube') {
                    bat "mvn sonar:sonar -Dsonar.token=sqa_6d93f8b366cfdde26d93775021d2d3b72710a1cc"
                }				
            }
        }
    }
}
