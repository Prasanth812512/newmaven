def gitDownload(repo)
{
   git "https://github.com/intelliqittrainings/${repo}.git"
}

def mavenBuild()
{
    sh 'mv package'
}
def TestDeployment(ip,contextPath)
{
    deploy adapters: [tomcat9(credentialsId: "038ca199-1def-446a-83db-f608949d0d7a", path: "", url: "http://${ip}:8080")], contextPath: "${contextPath}", war: "**/*.war"
}
def RunSelenium(jobname)
{


    //git 'https://github.com/intelliqittrainings/FunctionalTesting.git'

	sh "java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar"
    
}
def TestDelivary(ip,contextPath)
{
    deploy adapters: [tomcat9(credentialsId: "da243dab-b795-47c6-867f-f87e2f7d3a12", path: "", url: "http://${ip}:8080")], contextPath:"${contextPath}", war: "**/*.war"  
}

