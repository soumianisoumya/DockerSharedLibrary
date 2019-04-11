def call(String args){
  echo "path=${args}"
  app = docker.build("saumyaprashar/docker-demo:${BUILD_NUMBER}") 
  sh "docker images"
  }
