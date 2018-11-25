# Jambo Product REST-API Service

### Technologies:
**API:**
1. Java 1.8
2. Framework: Spring Boot
3. Database: H2 (In-memory)


#### Endpoints
     1. http://localhost:8080/
        1.1 [GET] => Returns basic information about the API.

     2. http://localhost:8080/reset
        2.1 [POST]=> Deletes all data and resets the service.

     3. http://localhost:8080/products
        3.1 [GET] => Returns all the products
        3.2 [GET]/[productid] => Returns the product with the given id.
        4.3 [POST] => Adds a new product according to the rules.
        4.4 [PUT] => Updates the given product according to the rules.
        3.5 [DELETE] => Removes the product with the given id.

#### Build project in jar file
  `mvn install -DskipTests=true`

#### Build the docker image
  `docker build -t product-service .`
  
#### Run project inside a docker container
  `docker run -d  -p 8081:8080  --name product-api product-service`

#### Run the Project
    cd [root directory of repository]
    mvn spring-boot:run
    curl localhost:8080
