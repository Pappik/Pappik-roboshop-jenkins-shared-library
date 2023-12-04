def call() {
    pipeline {
        agent {
            label 'workstation'
        }

        stages {

            stage('Build/Compile'){
                steps {
                    echo 'build'
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
