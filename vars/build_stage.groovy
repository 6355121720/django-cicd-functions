def call(String imageName, String imageTag){
  sh '''
  echo "building stage"
  sudo docker rm -f $(docker ps -aq) || sudo docker rmi -f $(docker images -aq) || true
  docker build -t ${imageName}:${imageTag} .
  '''
}
