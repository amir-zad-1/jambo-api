# Jambo Product REST-API Service

### Technologies:
**API:**
1. Java 1.8
2. Framework: Spring Boot
3. Database: H2 (In-memory)

**Integration Test App:**
1. Node.js
2. Test Framework: mocha


#### Endpoints
     1. http://localhost:8080/
        1.1 [GET] => Returns basic information about the API.
     
     2. http://localhost:8080/reset 
        2.1 [POST]=> Deletes all data and resets the service.
     
     3. http://localhost:8080/products
        3.1 [GET] => Returns all products.
        3.2 [GET]/[productid] => Returns a product with the given id.
        3.3 [POST] => Adds a new product according to the rules.
        3.4 [PUT] => Updates the given product according to the rules.
        3.5 [DELETE] => Removes a product with the given id.

#### Run the Project
    cd [root directory of repository]
    mvn spring-boot:run
    curl localhost:8080


#### Run Integration Tests
 Note: Requires node.js to be installed.
    
     cd [root directory of repository]
     mvn spring-boot:run&
     cd testApp
     npm i
     mocha integrationTests.js
     
![Test Results](/testApps/tests.png?raw=true "Test Results")

    


