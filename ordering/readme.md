run mysql
docker run --name=order-db --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=ordering" mysql:5.7

docker run -p 6603:3306 --name=order-db --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=ordering" mysql:5.7
docker run -p 3306:3306 --name=order-db --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=ordering" mysql:5.7

to build the project and generate the war file
`mvn clean install`

# import db
mysql -horder-db  -uroot -proot ordering < scripts/dump.sql

To build the docker image

`docker build -t ordering-service .`


Run ordering service

`docker run -d  -p 8080:8080  --name ordering ordering-service`

`docker run -d  --link order-db:order-db -p 8080:8080  --name order-api ordering-service` 
--link order-db:order-db

client - 8080

gateway - 8081

product - 8082

order - 8082