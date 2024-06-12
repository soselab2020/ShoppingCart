pipeline {
    agent any
	tools {
        // 配置SonarQube Scanner工具
        sonarQubeScanner 'MySonarScanner'
    }
    environment {
        // 配置SonarQube的名稱（這個名稱在Jenkins的SonarQube servers設置中定義）
        SONARQUBE_ENV = 'MySonarQube'
    }
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
		stage('SonarQube analysis') {
            steps {
                script {
                    // 在這裡調用SonarQube Scanner
                    def scannerHome = tool 'SonarQube Scanner'
                    withSonarQubeEnv('scannerHome') {
                        bat "${MySonarScanner}/bin/sonar-scanner -Dsonar.projectKey=my_project_key -Dsonar.projectName=my_project_name -Dsonar.sources=src"
                    }
                }
            }
        }
    }
}