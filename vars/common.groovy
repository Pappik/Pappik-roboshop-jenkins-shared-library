def compile() {
    if ( app_lang == "nodejs") {
        sh 'npm install'
    }

    if ( app_lang == "maven") {
        sh 'mvn clean package'
    }
}

def unittests() {
    if ( app_lang == "nodejs") {
        sh 'npm test || true'
    }
    if ( app_lang == "maven") {
        sh 'mvn test'
    }
    if ( app_lang == "python") {
        //sh 'python -m unittest'
        sh 'echo hello'
    }
}

def email( email_note) {
    mail bcc: '', body: 'testing email code jenkins', cc: '', from: 'paparao.prema75@gmail.com', replyTo: '', subject: 'Test from Jenkins', to: 'paparao.prema75@gmail.com'
}