# api-para transferencia de arquivos local para storage S3 ou banco de dados que você ecolher

#Executando o projeto
mvn clean install package
java -jar springS3Amazon-api.jar

# Criando a image do docker
mvn clean install package docker:build -DskipTests


#  docker-compose
RUN : docker-compose up
