From   
http://www.programming-free.com/2014/04/spring-mvc-consuming-restful-web-services.html  to build the web service
http://www.programming-free.com/2014/03/spring-mvc-40-restful-web-service-json.html  to build the Spring MVC interface

    except it reads from a flat file instead of a database
  
test the web service by running either of the following in CREST:

    http://localhost:8080/SpringServiceExample/service/user/json      or
    http://localhost:8080/SpringServiceExample/service/user/json/[number] or
    http://localhost:8080/SpringServiceExample/service/user/xml      or
    http://localhost:8080/SpringServiceExample/service/user/xml/[number] or
    
test the Spring MVC by entering either of the following in a web browser

for simple get:
    http://localhost:8080/SpringServiceExample/listUsers/json
    http://localhost:8080/SpringServiceExample/dispUser/json/[number]  
    http://localhost:8080/SpringServiceExample/listUsers/xml
    http://localhost:8080/SpringServiceExample/dispUser/xml/[number]
for post:
	http://localhost:8080/SpringServiceExample/userEntry       
 
AVOID MAVEN unless you know Tomcat can deal with it

For converting to XML, look at the following:

	http://stackoverflow.com/questions/24551650/spring-mvc-xml-request-returns-406-error
	You might also need some xml processor similar to Jackson, or a JSON to XML converter
	https://github.com/eugenp/REST/issues/1    


   


