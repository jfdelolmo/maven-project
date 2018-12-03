pipeline{
	agent any
	stages{
		stage('Build'){
			steps{
				sh 'mvn clean package'
			}
			post{
				success{
					echo 'Now Archiving...'
					archiveArtifacts artifacts: '**/*.war'
				}
			}
		}
		
		stage('Deploy to staging'){
			steps{
				build job: 'Deploy-to-staging'
			}
		}

		stage('Deploy-to-production'){
			steps{
				timeout(time:5, unit:'DAYS'){
					input message: 'Approve PRODUCTION Deployment?'
				}
				build job: 'Deploy-to-prod'
			}
			post{
				success{
					echo 'Code deployed to Production.'
				}
				failure{
					echo 'Deploy failed.'
				}
			}
		}
	}
}