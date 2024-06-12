pipeline {
    agent any

    stages {
        stage('Build'){
            steps {                
                bat "mvn clean install"
				bat "mvn sonar:sonar -Dsonar.login=squ_d35411f5dbac485938804d541c6c1b704afbd1ce"
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