pipeline {
	agent any
	parameters {
		string(name: 'tomcat_dev', defaultValue: '3.16.150.250', description: 'Staging server')
		string(name: 'tomcat_prod', defaultValue: ' ', description: 'Production server')
	}	
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

	        stage ('Deployments'){
                stage ('Deploy to Staging'){
                    steps {
                        sh "scp -i /home/jordi/jenkins/tomcat-demo.pem **/target/*.war ec2-user@3.16.150.250/var/lib/tomcat/webapps"
                    }
                }
	        }
	    }
}