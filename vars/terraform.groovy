def call() {
    pipeline {
        agent {
            node {
                label 'Buffer'
            }
        }

        parameters {
            string(name: 'INFRA_ENV', defaultValue: '', description: 'Enter Env like dev or prod')
        }

        stages {
            stage('Terraform init') {
                steps {
                    sh "terraform init -backend-config=env-${INFRA_ENV}/state.tfvars"
                }
            }
        }
    }
}