def call() {
    pipeline {
        agent {
            label 'workstation'
        }

        stages {

            stage('Build/Compile'){
                steps {
                    common.compile()
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

        }


    }
}
