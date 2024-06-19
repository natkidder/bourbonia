set CLASSPATH=.;%J2EE_HOME%\lib\j2ee.jar;%J2EE_HOME%\lib\appserv-rt.jar;StockListBmpAppClient.jar
java -Dorg.omg.CORBA.ORBInitialHost=localhost -Dorg.omg.CORBA.ORBInitialPort=3700 client.StockClient