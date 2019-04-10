def call(String args){
  echo "path=${args}"
  sh "docker build -t jenkins-tomcat:${BUILD_NUMBER} ." 
  sh "docker images"
  }
