# myreddit

## Prérequis

- IntelliJ
- Java SDK 11
- Docker

## Mise en place de la Base de Données

docker run --name monmysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:latest

docker exec -it monmysql mysql -u root -proot -e "CREATE DATABASE amsdb"


