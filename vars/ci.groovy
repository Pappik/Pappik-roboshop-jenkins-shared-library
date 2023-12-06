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
                    steps {
                        script {
                            sh "sonar-scanner -Dsonar.host.url=http://172.31.38.43:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=cart"
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