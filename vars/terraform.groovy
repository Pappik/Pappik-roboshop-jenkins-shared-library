def call() {
    pipeline {
        agent {
            label 'workstation'
        }

//        parameters {
//            string(name: 'INFRA_ENV', defaultValue: '', description: 'Enter Env like dev or prod')
//        }

        stages {
            stage(' init') {
                steps {
                    script {
                        sh 'echo hello'
                    }

                   // sh 'terraform init -backend-config=env-${INFRA_ENV}/state.tfvars'
                }
            }
        }
    }
}