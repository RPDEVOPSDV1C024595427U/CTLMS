pipeline {
    agent any
    
    environment {
        MAVEN_HOME  = tool 'maven'
        DOCKER_CLI  = '/usr/bin/docker'
        DB_URL      = credentials('jenkins-ctlms-dburl')
        DB_USERNAME = credentials('jenkins-ctlms-dbusername')
        DB_PASSWORD = credentials('jenkins-ctlms-dbpassword')
        MYSQL_ROOT_PASSWORD = credentials('jenkins-ctlms-mysql-root-password')
        CTLMS_DB_USER = credentials('jenkins-ctlms-dbuser')
        CTLMS_DB_PASSWORD = credentials('jenkins-ctlms-dbpassword')
    }
    
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/RPDEVOPSDV1C024595427U/CTLMS.git', branch: 'CTLMS96-PomFileUpdateAndTesting-Jason'
            }
        }     
        stage('Build') {
            steps {
                sh "${MAVEN_HOME}/bin/mvn clean install -DskipTests"
            }
        }
        stage('Copy War File') {
            steps {
                script {
                    sh "cp ${WORKSPACE}/target/ctlms.war ${WORKSPACE}/tomcat/ctlms.war"
                }
            }
        }
        stage('Run Scripts') {
            steps {
                script {
                    sh "${WORKSPACE}/mysql/script.sh"
                }
            }
        }        
        stage('Build Docker Images') {
            steps {
                script {
                    sh "${DOCKER_CLI} compose build"
                }
            }
        }
        stage('Deploy Containers') {
            steps {
                script {
                    sh "${DOCKER_CLI} compose down"
                    sh "${DOCKER_CLI} compose up -d"
                    sleep 30
                }
            }
        }
        stage('Test') {
            steps {
                sh "${MAVEN_HOME}/bin/mvn test"
            }
        }          
    }
}
