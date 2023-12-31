def call() {
    try {
        pipeline {
            agent {
                label 'workstation'
            }

            stages {

                stage('Build/Compile') {
                    steps {
                        script {

                            common.compile()
                        }
                    }
                }

                stage('Unit Test') {
                    steps {
                        script {

                            common.unittests()
                        }
                    }
                }

                stage('Quality control') {
                    environment {
                        SONAR_USER= '$(aws ssm get-parameters --region us-east-1 --names sonarqube.user --with-decryption --query Parameters[0].Value | sed \'s/"//g\')'
                        SONAR_PASS= '$(aws ssm get-parameters --region us-east-1 --names sonarqube.pass --with-decryption  --query Parameters[0].Value| sed \'s/"//g\')'
                    }
                    steps {
                        script {
                            //sh "echo ${SONAR_USER}; echo "sonar" "
                            sh "sonar-scanner -Dsonar.host.url=http://172.31.38.43:9000 -Dsonar.login=${SONAR_USER} -Dsonar.password=${SONAR_PASS} -Dsonar.projectKey=cart"
                        }
                    }
                }

                stage('upload code to central repo') {
                    steps {
                        echo 'Upload'
                    }
                }

            }


        }
    } catch(Exception e) {
        common.email("Failed")
    }
}