pipeline {

    agent any

    parameters {
        choice(name: 'ACTION', choices: ['Build', 'Remove all'], description: 'Pick something')
    }
    stages {
        stage('Building') {
            when{
                environment name: 'ACTION', value: 'Build'
            }
            steps {
                withDockerRegistry(credentialsId: 'dockerhub', url: 'https://index.docker.io/v1/') {
                    sh 'docker compose up -d --build'
                }
            }
        }
        stage('Building') {
                    when{
                        environment name: 'ACTION', value: 'Build'
                    }
                    steps {
                        withDockerRegistry(credentialsId: 'dockerhub', url: 'https://index.docker.io/v1/') {
                            sh 'echo Finished building and deploying.'
                        }
                    }
                }
        stage('Removing all') {
            when{
                environment name: 'ACTION', value: 'Remove all'
            }
            steps {
                sh 'docker compose down -v '
            }
        }
    }
    post {
        // Clean after build
        always {
            cleanWs()
        }
    }
}
