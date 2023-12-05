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
        sh 'npm test'
    }
    if ( app_lang == "maven") {
        sh 'mvn test'
    }
    if ( app_lang == "python") {
        sh 'python -m unittest'
    }
}

def email( email_note) {
    println email_note
}