pipeline {
	agent any

	triggers {
		pollSCM('* * * * *')
	}	

	stages{
        stage('Build'){
            steps {
                sh 'mvn clean package'
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }

    	stage ('Deploy to Staging'){
            steps {
                sh "scp -v -o StrictHostKeyChecking=no -i /home/jordi/jenkins/tomcat-demo.pem **/target/*.war ec2-user@3.16.150.250:/var/lib/tomcat/webapps"
            }
        }
    }
}