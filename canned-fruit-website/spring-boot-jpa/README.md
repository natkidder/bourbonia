# About
- This Java application constitutes the middle layer of a website operated by a canned fruit distributor.  
- It uses the Spring Boot framework, with Hibernate JPA as its ORE and Spring Frameworks as its API framework.  It also has spring batch jobs that create JSON files that the view layer can read in lieu of calling this application.

# Prerequisites
- A good working knowledge of Java, Spring and build tools

# Platforms

## Hardware
- A good laptop with at least 32 GB of RAM.  I bought a KurieTim with those specs at Wal-Mart relatively cheaply and it's served me very well.

## PostgreSQL
- You may use another database if you wish; I've had some success with H2 or Derby.
- Hibernate JPA will instantiate most of the objects for you, but you need to add the following views (all written for PostgreSQL)
#EE canned_fruit_no_order
```
 SELECT cf.id,
    cf.fruit
   FROM canned_fruit cf
     LEFT JOIN ( SELECT coi.canned_fruit_id
           FROM customer_order co
             JOIN customer_order_item coi ON co.id = coi.cust_ord_id) aa ON aa.canned_fruit_id = cf.id
  WHERE aa.canned_fruit_id IS NULL
  GROUP BY cf.id, cf.fruit
  ORDER BY cf.fruit, cf.id;
```
### customers_no_orders
```
 SELECT c.id,
    c.business_name,
    c.outlet_name,
    c.poc_first,
    c.poc_last,
    c.poc_email
   FROM customer c
     JOIN address a ON c.id = a.customer_id
     LEFT JOIN ( SELECT co.customer_id
           FROM customer_order co) aa ON c.id = aa.customer_id
  WHERE aa.customer_id IS NULL
  GROUP BY c.id, c.business_name, c.outlet_name, c.poc_first, c.poc_last, c.poc_email
  ORDER BY c.business_name, c.outlet_name, c.poc_first, c.poc_last, c.poc_email;  ```  
### shipping_no_order
```
 SELECT s.id
   FROM shipping s
     LEFT JOIN customer_order co ON s.id = co.shipping_id
  WHERE co.shipping_id IS NULL
  GROUP BY s.id
  ORDER BY s.id;
```
- Homework assignment: create a way to remove orders that have a final status (eg. cancelled, complete) from the schema
## Java
- Java 21 (you may go higher if you wish)
- Java libraries (all publically available)
## Build Tools
- Maven (you may switch to Gradle, however the below assumes Maven)

### Compile
- `mvn clean install`  Run when you update pom.xml dependencies
- You may load into Eclipse, make the project a Maven one, and run an M2 configuration

### Run
```
mvn spring-boot:run
```
It also reconstitutes the database objects if you set in *application.properties* the property *spring.jpa.hibernate.ddl-auto=create*

# Test
### insert
- command line: `curl -X POST -H "Content-Type: application/json" --data '@./golf.json' http://localhost:8081/api/tutorials`
  - *@./golf.json* means look in that file for the POST Body
  - *8081* is the port being exposed, as specified in the *application.properties server.port* number
  - golf.json can look like this:
  ```
  {
  "title": "Introduction to JPA",
  "description": "First step in learning Java Persistence API"
  }
  ```
  If you wish to add sample data, then add in the following order:
  1. Mediums
  2. Canned fruit offering, or just "canned fruit",each of which contains a medium
  3. Shipping terms, or just "shipping"
  4. Customers, each of which contains one or more addresses
  5. Customer orders, each of which contains:
  	a. One or more Order items, each of which contains a canned fruit offering paired with a count
  	b. One customer
  	c. One shipping term
  	d. One shipping address, drawn from one of the customer's addresses
  
## APIs
(Incomplete but representative list)  
- `curl -X DELETE http://localhost:8081/api2/cannedFruit/${id}`
- `curl -X DELETE http://localhost:8081/api2/customer/${id}`
- `curl -X DELETE http://localhost:8081/api2/customerOrder/${id}`
- `curl -X DELETE http://localhost:8081/api2/medium/${id}`
- `curl -X DELETE http://localhost:8081/api2/shipping/${id}`
- `curl -X GET "http://localhost:8081/api2/cannedFruit/idCollection${id_list}"`
- `curl -X GET "http://localhost:8081/api2/customer/${id}"`
- `curl -X GET "http://localhost:8081/api2/customer/pocEmail/${pocEmailAddress}"`
- `curl -X GET "http://localhost:8081/api2/customer?businessName=${businessName}&outletName=${outletName}&pocFirst=${pocFirstName}&pocLast=${pocLastName}"`
- `curl -X GET "http://localhost:8081/api2/customer?businessName=&outletName=&pocFirst=&pocLast="  # all customers`
- `curl -X GET http://localhost:8081/api2/cannedFruit   # all canned fruit`
- `curl -X GET http://localhost:8081/api2/cannedFruit/${id}`
- `curl -X GET http://localhost:8081/api2/cannedFruit?fruit=${fruitName}`
- `curl -X GET http://localhost:8081/api2/customerOrder/${id}`
- `curl -X GET http://localhost:8081/api2/customerOrder?pocEmail=   # all customer orders`
- `curl -X GET http://localhost:8081/api2/customerOrder?pocEmail=${pocEmailAddress}`
- `curl -X GET http://localhost:8081/api2/distinctFruits  # all`
- `curl -X GET http://localhost:8081/api2/medium  # all`
- `curl -X GET http://localhost:8081/api2/medium/${id}`
- `curl -X GET http://localhost:8081/api2/shipping # all`
- `curl -X GET http://localhost:8081/api2/shipping/${id}`
- `curl -X GET http://localhost:8081/batch/distinctFruitDoc  # all`
- `curl -X GET http://localhost:8081/batch/mediumDoc  # all`
- `curl -X GET http://localhost:8081/golf/listOddNbrsSq/${id}`
- `curl -X POST -H "Content-Type: application/json" --data "@./${filename}" http://localhost:8081/api2/cannedFruit`
- `curl -X POST -H "Content-Type: application/json" --data "@./${filename}" http://localhost:8081/api2/customer`
- `curl -X POST -H "Content-Type: application/json" --data "@./${filename}" http://localhost:8081/api2/customerOrder`
- `curl -X POST -H "Content-Type: application/json" --data "@./${filename}" http://localhost:8081/api2/medium`
- `curl -X POST -H "Content-Type: application/json" --data "@./${filename}" http://localhost:8081/api2/shipping`
- `curl -X PUT -H "Content-Type: application/json" --data "@./${filename}" http://localhost:8081/api2/customer/${1}`


# Sources

## Spring Boot H2 Database CRUD example: Building Rest API with Spring Data JPA

- Best resource: Many thanks to bezkoder; you got me started. - https://github.com/bezkoder/spring-boot-h2-database-crud

For more detail, please visit:
> [Spring Boot JPA + H2 example: Build a CRUD Rest APIs](https://www.bezkoder.com/spring-boot-jpa-h2-example/)

In this tutorial, we're gonna build a Spring Boot Rest CRUD API example with Maven that use Spring Data JPA to interact with H2 database. You'll know:

- How to configure Spring Data, JPA, Hibernate to work with Database
- How to define Data Models and Repository interfaces
- Way to create Spring Rest Controller to process HTTP requests
- Way to use Spring Data JPA to interact with H2 Database

Front-end that works well with this Back-end
> [Angular 8](https://www.bezkoder.com/angular-crud-app/) / [Angular 10](https://www.bezkoder.com/angular-10-crud-app/) / [Angular 11](https://www.bezkoder.com/angular-11-crud-app/) / [Angular 12](https://www.bezkoder.com/angular-12-crud-app/) / [Angular 13](https://www.bezkoder.com/angular-13-crud-example/) / [Angular 14](https://www.bezkoder.com/angular-14-crud-example/) / [Angular 15](https://www.bezkoder.com/angular-15-crud-example/) / [Angular 16](https://www.bezkoder.com/angular-16-crud-example/) / [Angular 17 Client](https://www.bezkoder.com/angular-17-crud-example/)

> [Vue 2 Client](https://www.bezkoder.com/vue-js-crud-app/) / [Vue 3 Client](https://www.bezkoder.com/vue-3-crud/) / [Vuetify Client](https://www.bezkoder.com/vuetify-data-table-example/)

> [React Client](https://www.bezkoder.com/react-hooks-crud-axios-api/) / [React Redux Client](https://www.bezkoder.com/redux-toolkit-crud-react-hooks/)

More Practice:
> [Spring Boot Validate Request Body](https://www.bezkoder.com/spring-boot-validate-request-body/)

> [Spring Boot File upload example with Multipart File](https://www.bezkoder.com/spring-boot-file-upload/)

> [Spring Boot Pagination & Filter example | Spring JPA, Pageable](https://www.bezkoder.com/spring-boot-pagination-filter-jpa-pageable/)

> [Spring Data JPA Sort/Order by multiple Columns | Spring Boot](https://www.bezkoder.com/spring-data-sort-multiple-columns/)

> [Spring Boot Repository Unit Test with @DataJpaTest](https://www.bezkoder.com/spring-boot-unit-test-jpa-repo-datajpatest/)

> [Spring Boot Rest Controller Unit Test with @WebMvcTest](https://www.bezkoder.com/spring-boot-webmvctest/)

> Cache the result: [Spring Boot Redis Cache example](https://www.bezkoder.com/spring-boot-redis-cache-example/)

> Documentation: [Spring Boot with Swagger 3 example](https://www.bezkoder.com/spring-boot-swagger-3/)

> Reactive Rest API: [Spring Boot WebFlux example](https://www.bezkoder.com/spring-boot-webflux-rest-api/)

> [Deploy Spring Boot App on AWS – Elastic Beanstalk](https://www.bezkoder.com/deploy-spring-boot-aws-eb/)

Exception Handling:
> [Spring Boot @ControllerAdvice & @ExceptionHandler example](https://www.bezkoder.com/spring-boot-controlleradvice-exceptionhandler/)

> [@RestControllerAdvice example in Spring Boot](https://www.bezkoder.com/spring-boot-restcontrolleradvice/)

Associations:
> [Spring Boot One To One example with Spring JPA, Hibernate](https://www.bezkoder.com/jpa-one-to-one/)

> [Spring Boot One To Many example with Spring JPA, Hibernate](https://www.bezkoder.com/jpa-one-to-many/)

> [Spring Boot Many To Many example with Spring JPA, Hibernate](https://www.bezkoder.com/jpa-many-to-many/)

Other databases:
> [Spring Boot JPA + MySQL: CRUD Rest API example](https://www.bezkoder.com/spring-boot-jpa-crud-rest-api/)

> [Spring Boot JPA + PostgreSQL: CRUD Rest API example](https://www.bezkoder.com/spring-boot-postgresql-example/)

Security:
> [Spring Boot + Spring Security JWT Authentication & Authorization](https://www.bezkoder.com/spring-boot-jwt-authentication/)

Fullstack:
> [Vue + Spring Boot example](https://www.bezkoder.com/spring-boot-vue-js-crud-example/)

> [Angular 8 + Spring Boot example](https://www.bezkoder.com/angular-spring-boot-crud/)

> [Angular 10 + Spring Boot example](https://www.bezkoder.com/angular-10-spring-boot-crud/)

> [Angular 11 + Spring Boot example](https://www.bezkoder.com/angular-11-spring-boot-crud/)

> [Angular 12 + Spring Boot example](https://www.bezkoder.com/angular-12-spring-boot-crud/)

> [Angular 13 + Spring Boot example](https://www.bezkoder.com/spring-boot-angular-13-crud/)

> [Angular 14 + Spring Boot example](https://www.bezkoder.com/spring-boot-angular-14-crud/)

> [Angular 15 + Spring Boot example](https://www.bezkoder.com/spring-boot-angular-15-crud/)

> [Angular 16 + Spring Boot example](https://www.bezkoder.com/spring-boot-angular-16-crud/)

> [Angular 17 + Spring Boot example](https://www.bezkoder.com/spring-boot-angular-17-crud/)

> [React + Spring Boot + MySQL example](https://www.bezkoder.com/react-spring-boot-crud/)

> [React + Spring Boot + PostgreSQL example](https://www.bezkoder.com/spring-boot-react-postgresql/)

Run both Back-end & Front-end in one place:
> [Integrate Angular with Spring Boot Rest API](https://www.bezkoder.com/integrate-angular-spring-boot/)

> [Integrate React.js with Spring Boot Rest API](https://www.bezkoder.com/integrate-reactjs-spring-boot/)

> [Integrate Vue.js with Spring Boot Rest API](https://www.bezkoder.com/integrate-vue-spring-boot/)


