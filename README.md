# Spring boot, Hibernate, MySQL REST API

A simple Spring boot application that demonstrates the usage of RESTful API using Spring boot, Hibernate and MySQL. 

## Tools and Technologies used

* Java 
* Spring boot
* MySQL
* JPA
* Hibernate
* Maven

## Steps to install

**1. Clone the application**

```bash
git clone https://github.com/aljaaaymp/isbn-back-end.git
```

**2. Create MySQL database**

```sql
CREATE DATABASE isbn
```
	
**3. Change MySQL Username and Password as per your MySQL Installation**
	
+ open `src/main/resources/application.properties` file.

+ change `spring.datasource.username` and `spring.datasource.password` as per your installation
	
**4. Run the app**

$ mvn spring-boot:run


The server will start on port 8080.
	
## Explore Rest APIs

The app defines following CRUD APIs.


    POST /isbn/employee/publisher
    
    GET /isbn/employee/publisher
    
    POST /isbn/employee/addAuthor
    
    GET /isbn/employee/getAuthor
    
    POST /isbn/employee/book
    
    GET /isbn/employee/book
    
    GET /isbn/onebook/{bookIsbn}
    
    PUT isbn/{bookId}/authors/{authorId}
    
    PUT isbn/{bookId}/publisher/{publisherId}


You can test them using postman or any other rest client.
