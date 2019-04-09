@Library('my_shared_library')_
node {
 
    stage('Checkout external proj') {
        git branch: 'master',
            credentialsId: 'github',
            url: 'https://github.com/soumianisoumya/DockerSharedLibrary.git'
        

        sh "ls -lat"
    }
    
    stage('image create'){
         echo 'creating an image'
        docexec "/var/lib/jenkins/workspace/DockerDemo/"
    }
 
  stage('git remove'){
        sh 'rm -rf /var/lib/jenkins/workspace/DockerDemo/*'
    }
    
}
