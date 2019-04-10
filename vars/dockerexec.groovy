def call(String args){
  echo "path=${args}"
  docker.build("soumianisoumya/sharedlibrary:${BUILD_NUMBER}") 
  sh "docker images"
  }
