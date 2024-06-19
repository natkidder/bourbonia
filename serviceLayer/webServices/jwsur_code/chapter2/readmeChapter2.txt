The wsimport-generated artifacts are not included in the JAR file because
Amazon continually updates the WSDL. To make sure that the client examples
against Amazon use the current artifacts, you'll need to run wsimport
against their WSDL. For the client AmazonClientW, for example, the 
command would be:

  % wsimport -keep -p awsClient \
    http://ecs.amazonaws.com/AWSECommerceService/AWSECommerceService.wsdl 

The client is then compiled as usual:

  % javac AmazonClientW.java

and executed. You'll need an AWSE key, which is free, to run the clients.


For the AmazonClientU and the AmazonAsyncClient, the wsimport commands are:

% wsimport -keep -p awsClient2 \  
  http://ecs.amazonaws.com/AWSECommerceService/AWSECommerceService.wsdl \
  -b custom.xml .


% wsimport -keep -p awsClient3 \  
  http://ecs.amazonaws.com/AWSECommerceService/AWSECommerceService.wsdl \
  -b customAsync.xml .

