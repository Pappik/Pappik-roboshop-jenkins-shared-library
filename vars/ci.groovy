def call() {
    pipeline {
        agent {
            label 'workstation'
        }

        stages {

            stage('Build/Compile'){
                steps {
                    script {

                        common.compile()
                    }
                }
            }

            stage('Unit Test') {
                steps{
                    echo 'unit test'
                }
            }

            stage('Quality control'){
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
}
