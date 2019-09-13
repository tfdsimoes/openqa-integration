# OpenAQ integration

These is a resolution for the test of Dept

## Tests
There is integration and unitary tests, to run:
```bash
$ ./mvnw test
```

## To Run
To run the program just run the following command:
```bash
$ ./mvnw spring-boot:run
```

The server will be running in the port 8080

## Endpoints available

To help in the root of the project there is a [Postman](https://www.getpostman.com/) collection

* Get Countries

localhost:8080/air-quality/countries?page=1&size=1

page - page number  
size - size of the page to retrieve
 
* Get Cities

localhost:8080/air-quality/cities?country=ES&page=1&size=1

country - country to filter  
page - page number  
size - size of the page to retrieve

* Get Locations of a City

localhost:8080/air-quality/cities/{city}/locations?page=1&size=1

city - name of the city
page - page number  
size - size of the page to retrieve

* Get Air Quality of Location

localhost:8080/air-quality/locations/{location}/air-quality

location - name of the location    
page - page number  
size - size of the page to retrieve

* Get Parameters information

localhost:8080/air-quality/parameters

## Endpoints swagger
When the server is running the endpoint documentation can be accessed in ```http://localhost:8080/swagger-ui.html```
