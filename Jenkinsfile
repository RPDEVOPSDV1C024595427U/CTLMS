pipeline {
    agent any
    
    environment {
        MAVEN_HOME  = tool 'maven'
        DOCKER_CLI  = '/usr/bin/docker'
        DB_URL      = credentials('jenkins-ctlms-dburl')
        DB_USERNAME = credentials('jenkins-ctlms-dbusername')
        DB_PASSWORD = credentials('jenkins-ctlms-dbpassword')
        MYSQL_ROOT_PASSWORD = credentials('jenkins-ctlms-mysql-root-password')
        CTLMS_DB_USER = credentials('jenkins-ctlms-dbusername')
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
        stage('Generate SQL Script') {
            steps {
                script {
					sh "(echo 'CREATE ROLE 'webapp_users';' >> ${WORKSPACE}/mysql/init.sql)"
                    sh "(echo 'GRANT SELECT,INSERT,UPDATE,DELETE,EXECUTE,ALTER,CREATE,DROP,INDEX ON ctlms.* TO 'webapp_users';' >> ${WORKSPACE}/mysql/init.sql)"
                    sh "(echo 'CREATE USER \"${CTLMS_DB_USER}\"@\"localhost\" IDENTIFIED BY \"${CTLMS_DB_PASSWORD}\" DEFAULT ROLE 'webapp_users';' >> ${WORKSPACE}/mysql/init.sql)"
                }
            }
        }        
        stage('Build Docker Images') {
            steps {
                script {
                    sh "${DOCKER_CLI} compose build --force-recreate"
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
