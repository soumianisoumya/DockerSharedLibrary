def call(String args){
  echo "path=${args}"
  docker.build("soumianisoumya/DockerSharedLibrary:${BUILD_NUMBER}") 
  sh "docker images"
  }
