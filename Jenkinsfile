pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                // Clean and build the project
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                // Run the TestNG suite
                sh 'mvn test -Dsurefire.suiteXmlFiles=Selenium/TestNGSuite.xml'
            }
        }
    }
    post {
        always {
            // Archive the test results
            junit 'Selenium/target/surefire-reports/*.xml'
        }
    }
}
