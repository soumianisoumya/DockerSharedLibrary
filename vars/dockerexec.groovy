def call(String args){
  echo "path=${args}"
  docker.build("soumianisoumya/dockersharedlibrary:${BUILD_NUMBER}") 
  sh "docker images"
  }
