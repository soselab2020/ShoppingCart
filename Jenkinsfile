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
				// bat "java -jar ShoppingCart-1.0-SNAPSHOT.jar"
            }
        }		
		stage('SonarQube Scan') {
            steps {
				withSonarQubeEnv('MySonarQube'){
					bat "mvn sonar:sonar -Dsonar.token=squ_d35411f5dbac485938804d541c6c1b704afbd1ce"
				}	
			}
        }
		stage('Quality Gate') {
            steps {
                script {
                    timeout(time: 1, unit: 'MINUTES') {
                        def qg = waitForQualityGate()
                        if (qg.status != 'OK') {
                            error "Pipeline aborted due to quality gate failure: ${qg.status}"
                        }
                    }
                }
            }
        }		
    }
}