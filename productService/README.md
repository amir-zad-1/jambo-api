# Jambo Product REST-API Service

# Volcano REST-API Service

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

     3. http://localhost:8080/reservations/availabledates
        3.1 [GET] => Returns all available dates.

     4. http://localhost:8080/reservations
        4.1 [GET] => Returns all reservations.
        4.2 [GET]/[reservationid] => Returns the reservation with the given id.
        4.3 [POST] => Makes a new reservation according to the rules.
        4.4 [PUT] => Updates a new reservation according to the rules.
        4.5 [DELETE] => Cancels the reservation with the given id.

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





