@Library('my_library')_
node {
 
 
    stage('Checkout external proj') {
        git branch: 'master',
            credentialsId: 'github',
            url: 'https://github.com/soumianisoumya/DockerSharedLibrary.git'
        

        sh "ls -lat"
    }
  
   stage('image create'){
         echo 'creating an image'
        dockerexec "/var/lib/jenkins/workspace/DockerDemo/"
    }
  
  stage('Push Docker Image') {
      docker.withRegistry('https://registry.hub.docker.com','docker-credentials') {
        app.push("${BUILD_NUMBER}")
        app.push("latest")
      }
  } 
  
  stage('git remove'){
        sh 'rm -rf /var/lib/jenkins/workspace/DockerDemo/*'
    }
    
}
