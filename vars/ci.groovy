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
                        echo 'quality control'
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