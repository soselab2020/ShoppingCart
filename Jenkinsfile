pipeline {
    agent any

    stages {
        stage('Build'){
            steps {                
                bat "mvn clean install"				
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
				// bat "java -jar ShoppingCart-1.0-SNAPSHOT.jar"
            }
        }		
		stage('SonarQube Scan') {
            steps {
				bat "mvn sonar:sonar -Dsonar.login=squ_d35411f5dbac485938804d541c6c1b704afbd1ce"
				bat "start http://127.0.0.1:9000"
			}
        }        			
    }
}