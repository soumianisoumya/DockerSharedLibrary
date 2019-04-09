def call(String args){
  echo "path=${args}"
  echo "BLA BLA BLAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
  sh "docker build -t jenkins-tomcat:${BUILD_NUMBER} . -f Dockerfile" 
  sh "docker build -t jenkins-sql:${BUILD_NUMBER} . -f db.Dockerfile"
  sh "docker tag jenkins-tomcat:${BUILD_NUMBER} jenkins-tomcat:latest" 
  sh "docker tag jenkins-sql:${BUILD_NUMBER} jenkins-sql:latest"
  sh "docker images"
  }
