pipeline {
    agent any
    tools {
        maven 'M3'
        jdk 'jdk17'
    }
    options {
        skipStagesAfterUnstable()
    }
    stages {
        //stage('Git Checkout') {
        //    steps {
        //        script {
        //            git branch: 'main', url: 'https://github.com/jessoussi/authentication-service/'
        //        }
        //    }
        //}
        stage ('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }
        stage ('Scan SonarQube') {
            steps {
                withSonarQubeEnv(installationName:'SonarQube'){
                    bat 'mvn clean install sonar:sonar'
                }
            }
        }
        stage ('Test') {
            steps {
                bat 'mvn -Dmaven.test.failure.ignore=true clean install'
            }
        }
        stage('Deploy') {
            steps {
                echo "Deployment application à venir !!!"
            }
        }
    }
}