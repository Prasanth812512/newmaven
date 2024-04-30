pipeline {
    agent { label 'Jenkins-Agent' }
    tools {
        jdk 'Java17'
        maven 'Maven3'
    }
   
   stages{
        stage("checkout from github"){
            steps{
                git branch: 'master',
                url:'https://github.com/Prasanth812512/newmaven.git'
                echo 'pulled from github successfully'
            }
        }
        stage("compile the code to executable format"){
            steps{
                sh "mvn compile"
                echo 'converted the code from human readable to machine readable '
            }
        }
        stage("testing the code"){
            steps{
                sh "mvn test"
                echo 'run and execute the test cases written in selenium'
            }
        }
        stage("code review to check quality of code"){
            steps{
                sh "mvn pmd:pmd"
                echo 'code review done'
            }
        }
        stage("convert the code to package"){
            steps{
                sh "mvn clean package"
                echo 'convert the files to war file'
            }
        }
    }
	   }
