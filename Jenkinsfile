pipeline{
    agent any
    stages{
        stage('Build'){
           steps{
                sh 'mvn clean package'
           }
        }

         stage('Deploy'){
           steps{
               deploy adapters: [tomcat7(credentialsId: 'bfaf0f27-c751-41e3-9335-97a41a423571', path: '',
               url: 'http://ec2-18-141-197-102.ap-southeast-1.compute.amazonaws.com/')],
               contextPath: 'khoaluan', war: '**/*.war'
           }
        }

    }
}