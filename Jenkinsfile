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
        dockerexec "/var/lib/jenkins/workspace/DockerDemo/"
    }
  
 /* stage('Push Docker Image') {
      docker.withRegistry('https://registry.hub.docker.com','docker-credentials') {
        app.push("${BUILD_NUMBER}")
        app.push("latest")
      }
  } */
  
  stage('Run Container') {
      sh "sudo docker run -p 8085:8080 -d soumianisoumya/dockersharedlibrary"
  }
  stage('git remove'){
        sh 'rm -rf /var/lib/jenkins/workspace/DockerDemo/*'
    }
    
}
