def call(){
  sh '''
    echo "deploying stage"
    docker compose up -d
  '''
}
