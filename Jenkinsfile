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
        dockerexec "/var/lib/jenkins/workspace/sas2/"
    }
    stage('instance creation'){
        echo 'creating an instance'   
        terraformexec "/var/lib/jenkins/workspace/sas2/terraform/"
    }
}
