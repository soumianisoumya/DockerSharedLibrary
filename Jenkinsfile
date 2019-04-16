@Library('my_library')_
node {
 
 def credentials = 'docker-credentials'
  
 def dockerImage
 def mvnHome
   def app
   stage('Preparation') { 
      git 'https://github.com/soumianisoumya/DockerSharedLibrary.git'
      mvnHome = tool 'mvn1'
   }
   
   stage('App Build') {
       sh "echo ${BUILD_NUMBER}"
       sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
   }
 
   stage('image create'){
         echo 'creating an image'
         dockerImage = dockerexec "/var/lib/jenkins/workspace/DockerDemo/"
        // dockerImage = docker.build("saumyaprashar/docker-demo:${BUILD_NUMBER}")
    }
  
  stage('Push Docker Image') {
      docker.withRegistry('https://registry.hub.docker.com',credentials) {
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
