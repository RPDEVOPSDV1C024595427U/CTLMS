pipeline {
    agent any
    
    environment {
        MAVEN_HOME = tool 'Maven' 
    }
    
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/your-repo/your-project.git', branch: 'main'
            }
        }
        
        stage('Build') {
            steps {
                sh "${MAVEN_HOME}/bin/mvn clean install"
            }
        }
    }
}
