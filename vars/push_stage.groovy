def call(String credId, String imageName, String imageTag){
  withCredentials([usernamePassword(credentialsId: credId, usernameVariable:"username", passwordVariable:"password")]){
    sh '''
      echo "pushing stage"
      docker login -u $username -p $password
      docker image tag $(imageName):$(imageTag) $username/$(imageName):$(imageTag)
      docker push $username/$(imageName):$(imageTag)
    '''
  }
}
