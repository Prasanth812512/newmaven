pipeline
{
    agent any
    stages
    {
        stage('Continuous Download')
        {
            steps
            {
               script
               {
                    try
                {
                    git 'https://github.com/Prasanth812512/newmaven.git'
                }
                catch(Exception e1)
                {
                    mail bcc: '', body: 'Jenkins is unable to download from the remote GitHub.', cc: '', from: '', replyTo: '', subject: 'Download Failed', to: 'padachalap@gmail.com'
                    exit(1)
                }
               }
            }
        }
        
        stage('Continuous Build')
        {
            steps
            {
               script
               {
                    try
                {
                    sh'mvn package'
                }
                catch(Exception e2)
                {
                    mail bcc: '', body: 'Jenkins is unable to Build.', cc: '', from: '', replyTo: '', subject: 'Build Failed', to: 'padachalap@gmail.com'
                    exit(1)
                }
               }
            }
        }
		stage('Continuous Deployment')
        {
            steps
            {
               script
               {
                    try
                {
					deploy adapters: [tomcat9(credentialsId: '038ca199-1def-446a-83db-f608949d0d7a', path: '', url: 'http://172.31.19.238:8080')], contextPath: 'app', war: '**/*.war'
                }
                catch(Exception e3)
                {
                    mail bcc: '', body: 'Jenkins is unable to Deploy.', cc: '', from: '', replyTo: '', subject: 'Deployment Failed', to: 'padachalap@gmail.com'
                    exit(1)
                }
               }
            }
        }
		stage('Continuous Testing')
        {
            steps
            {
               script
               {
                    try
                {
                    git 'https://github.com/intelliqittrainings/FunctionalTesting.git'
					sh 'java -jar /var/lib/jenkins/workspace/DeclarativePipeline/testing.jar'
                }
                catch(Exception e4)
                {
                    mail bcc: '', body: 'Jenkins is unable to Testing.', cc: '', from: '', replyTo: '', subject: 'Testing Failed', to: 'padachalap@gmail.com'
                    exit(1)
                }
               }
            }
        }
		stage('Continuous Delivery')
        {
            steps
            {
               script
               {
                    try
                {
                  deploy adapters: [tomcat9(credentialsId: 'da243dab-b795-47c6-867f-f87e2f7d3a12', path: '', url: 'http://172.31.28.192:8080')], contextPath: 'testprod', war: '**/*.war'  
                }
                catch(Exception e5)
                {
                    mail bcc: '', body: 'Jenkins is unable to Delivery.', cc: '', from: '', replyTo: '', subject: 'Delivery Failed', to: 'padachalap@gmail.com'
                    exit(1)
                }
               }
            }
        }
    }
}
