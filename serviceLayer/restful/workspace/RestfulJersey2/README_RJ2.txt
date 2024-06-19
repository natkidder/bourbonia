HelloWorldService: put in CREST or web browser   http://localhost:8080/RestfulJersey2/rest/hello/<word>    where <word> can be any string
if that doesn't work, check the .settings file under context-root

ReadFile: put in CREST or web browser   http://localhost:8080/RestfulJersey2/rest/ReadFile/<filename>    where <filename> is a file in c:\tmp

============================ OrdersService =======================================
# Add a new order for Bob with ID 1
curl -X PUT http://localhost:8080/orders-server/orders/1?customer_name=bob 

# Check the status of the order
curl -X GET http://localhost:8080/orders-server/orders/1 

# See all the orders in the system
curl -X GET http://localhost:8080/orders-server/orders/list
====================== HelloWorldServiceNamedParams ==============================
   One parameter:
http://localhost:8080/RestfulJersey2/rest/helloNamedParams/firstName/?name=bob  
      Jersey Say: bob
http://localhost:8080/RestfulJersey2/rest/helloNamedParams/firstName
      Jersey Say: jack
   Two parameters:
http://localhost:8080/RestfulJersey2/rest/helloNamedParams2/fullName/?firstName=Steve&lastName=Bullock
      Jersey Say: Steve Bullock
http://localhost:8080/RestfulJersey2/rest/helloNamedParams2/fullName/?firstName=Steve
      Jersey Say: Steve Tarkenton     
http://localhost:8080/RestfulJersey2/rest/helloNamedParams2/fullName            
      Jersey Say: Fran Tarkenton
=================================================================================

Employee: put in CREST   http://localhost:8080/RestfulJersey2/rest/user/employee   where the request entity is

    <Employee>
        <employeeName>[name]</employeeName>
    </Employee>

    where [name] can be any string
    
    Add to the header the following: (With REST console use custom headers)
    
        Content-Type: application/xml
        Accept: application/xml
        
 ====================== File Upload ==============================       
http://localhost:8080/RestfulJersey2/FileUpload.html
submit should take you to  http://localhost:8080/RestfulJersey2/rest/file/upload
==================================================================

also, http://localhost:8080/RestfulJersey2/rest/application.wadl will delineate the different resources

ensure you have Tomcat running in the local Eclipse workspace
