def call(String args){
  echo "path=${args}"
  sh "docker info"
  sh "docker build -t jenkins-tomcat:${BUILD_NUMBER} ." 
  sh "docker build -t jenkins-sql:${BUILD_NUMBER} . -f db.Dockerfile"
  sh "docker tag jenkins-tomcat:${BUILD_NUMBER} jenkins-tomcat:latest" 
  sh "docker tag jenkins-sql:${BUILD_NUMBER} jenkins-sql:latest"
  sh "docker images"
  }
