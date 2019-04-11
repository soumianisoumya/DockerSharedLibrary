@Library('my_library')_
node {
 
 
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
       def dockerImage = dockerexec "/var/lib/jenkins/workspace/DockerDemo/"
        // dockerImage = docker.build("saumyaprashar/docker-demo:${BUILD_NUMBER}")
    }
  
  stage('Push Docker Image') {
      docker.withRegistry('https://registry.hub.docker.com','docker-credentials') {
        dockerImage.push("${BUILD_NUMBER}")
        dockerImage.push("latest")
      }
  } 
  
  stage('git remove'){
        sh 'rm -rf /var/lib/jenkins/workspace/DockerDemo/*'
    }
    
}
