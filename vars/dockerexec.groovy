def call(String args){
  echo "path=${args}"
  app = docker.build("saumyaprashar/sharedlibrary:${BUILD_NUMBER}") 
  sh "docker images"
  }
