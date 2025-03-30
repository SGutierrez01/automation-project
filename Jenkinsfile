pipeline {
  agent any

  tools {
    maven 'Maven 3.9.6'
    jdk 'Temurin-17'
  }

  environment {
    ALLURE_RESULTS = 'allure-results'
  }

  stages {
    stage('Build') {
      steps {
        sh 'mvn clean compile'
      }
    }

    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }

    stage('Allure Report') {
      steps {
        allure includeProperties: false, results: [[path: "${ALLURE_RESULTS}"]]
      }
    }
  }
}
