pipeline {
    agent any
    stages {
        stage('Build'){
            steps {                
                bat "mvn clean compile"
            }
        }
        stage('Test'){
            steps{
                bat "mvn test"
            }
        }
        stage('Deploy') {
            steps {
                bat "mvn package"
				bat "java -jar ShoppingCart-1.0-SNAPSHOT.jar"
            }
        }
    }
}