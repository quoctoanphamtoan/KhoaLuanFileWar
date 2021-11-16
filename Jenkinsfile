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
               url: 'http://ec2-13-213-2-201.ap-southeast-1.compute.amazonaws.com:8080/')],
               contextPath: 'khoaluan', war: '**/*.war'
           }
        }

    }
}