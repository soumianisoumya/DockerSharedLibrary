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
       def dockerImage = dockerexec "/var/lib/jenkins/workspace/DockerDemo/"
        // dockerImage = docker.build("saumyaprashar/docker-demo:${BUILD_NUMBER}")
    }
  
  stage('Push Docker Image') {
      docker.withRegistry('https://registry.hub.docker.com','docker-credentials') {
        dockerImage.push("${BUILD_NUMBER}")
        dockerImage.push("latest")
      }
  } 
 
   stage('Run Container') {
      sh "sudo docker run -p 8085:8080 -d saumyaprashar/docker-demo"
  }
  
  stage('git remove'){
        sh 'rm -rf /var/lib/jenkins/workspace/DockerDemo/*'
    }
    
}
