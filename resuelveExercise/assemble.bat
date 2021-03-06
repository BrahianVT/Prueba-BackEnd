
@ECHO OFF

call  mvn clean package

docker build --tag=rest-nomina:1.0 --rm=true .
echo "Levantando container con el api"
docker-compose up
