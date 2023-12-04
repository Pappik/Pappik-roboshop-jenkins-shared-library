def call() {
    pipeline {
        agent {
            label 'ansible'
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
