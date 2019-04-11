def call(String args){
  echo "path=${args}"
  app = docker.build("soumianisoumya/sharedlibrary:${BUILD_NUMBER}") 
  sh "docker images"
  }
