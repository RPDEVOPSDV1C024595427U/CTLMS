pipeline {
    agent any
    options {
        skipDefaultCheckout(true)
    }
    environment {
        MAVEN_HOME  = tool 'maven'
        DOCKER_CLI  = '/usr/bin/docker'
        DB_URL      = credentials('jenkins-ctlms-dburl')
        DB_USERNAME = credentials('jenkins-ctlms-dbusername')
        DB_PASSWORD = credentials('jenkins-ctlms-dbpassword')
        MYSQL_ROOT_PASSWORD = credentials('jenkins-ctlms-mysql-root-password')
        CTLMS_DB_USER = credentials('jenkins-ctlms-dbusername')
        CTLMS_DB_PASSWORD = credentials('jenkins-ctlms-dbpassword')
        SONAR_TOKEN = credentials('jenkins-sonarqube-token')
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
            sh '''
                sed 's/\\DB_USER/${CTLMS_DB_USER}/g; s/\\DB_PASSWORD/${CTLMS_DB_PASSWORD}/g' ${WORKSPACE}/mysql/init.sql.template >> ${WORKSPACE}/mysql/init.sql
            '''
        		}
            }
        }        
        stage('Build Docker Images') {
            steps {
                script {
                    sh "${DOCKER_CLI} compose build --no-cache"
                }
            }
        }
        stage('Deploy Containers') {
            steps {
                script {
                    sh "${DOCKER_CLI} compose down"
                    sh "${DOCKER_CLI} compose up -d"
                    sleep 20
                }
            }
        }
        stage('Clean Up SQL Script') {
            steps {
                script {
                    sh "${DOCKER_CLI} exec mysql-backend rm -f /docker-entrypoint-initdb.d/init.sql"
                }
            }
        }
        stage('Restart Containers') {
            steps {
                script {
                    sh "${DOCKER_CLI} compose restart"
                    sleep 10
                }
            }
        }        
        stage('Test') {
            steps {
                sh "${MAVEN_HOME}/bin/mvn clean test"
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube Server') {  
                    sh '''
                    ${MAVEN_HOME}/bin/mvn sonar:sonar \
                    -Dsonar.projectKey=CTLMS \
                    -Dsonar.host.url=http://localhost:9000 \
                    -Dsonar.login=${SONAR_TOKEN}
                    '''
                }
            }
        }                   
      }     

        post {
        // Clean after build
        always {
            cleanWs(cleanWhenNotBuilt: false,
                    deleteDirs: true,
                    disableDeferredWipeout: true,
                    notFailBuild: true,
                    patterns: [[pattern: '.gitignore', type: 'INCLUDE'],
                               [pattern: '.propsfile', type: 'EXCLUDE']])
              }
        }
}
