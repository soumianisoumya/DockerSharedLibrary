def call(String args){
  echo "path=${args}"
  sh "docker.build(\"soumianisoumya/DockerSharedLibrary:${BUILD_NUMBER}\")" 
  sh "docker images"
  }
