         @WebServices and @WebServiceProviders under standalone Tomcat

Tomcat 6 has a subdirectory

        TOMCAT_HOME/lib

that contains the JAR files that the runtime requires. (Tomcat 5
included a lib/common subdirectory as well but Tomcat 6 has 
simplifed things.) Anyway, the boilerplate web.xml for a
@WebService or @WebServiceProvider deployed under standalone 
Tomcat includes these two sections:

   <listener>
     <listener-class>
        com.sun.xml.ws.transport.http.servlet.WSServletContextListener
     </listener-class>
   </listener>

   <servlet>
      <servlet-name>TempConvertWS</servlet-name>
      <servlet-class>
        com.sun.xml.ws.transport.http.servlet.WSServlet
      </servlet-class>
   </servlet>

The roles of the WSServletContextListener and the WSServlet are explained
in the book. For now, the issue is that these artifacts are part of the 
Metro release, not part of the Tomcat release. Here's the quickest way to 
get things up and running assuming that TOMCAT_HOME is the install directory 
for Tomcat and jaxws-ri is the install directory for Metro:

1. Stop Tomcat if it's already running.

2. Copy the JAR files from jaxws-ri/lib to TOMCAT_HOME/lib.

3. Start Tomcat.

The deployable WAR files for @WebServices and @WebServiceProviders
now can be dropped into TOMCAT_HOME/webapps. Without the Metro JAR 
files, Tomcat will issue a fatal error because it won't find the
WSServletContextListener to parse the sun-jaxws.xml configuration
file that's part of the deployed WAR file.

;;;;

For the examples secured through Tomcat, remember to create a certificate with the
keytool. Test by opening a browser to:

        https://localhost:8443

The browser may object immediately that the Tomcat certificate is self-signed and
then ask for guidance in accepting it.

;;;;

The tauth.wsdl file can be used with wsimport to generate the client artifacts for the
ClientAuth application. (The current artifacts have my machine's paths hardwired into them.)

;;;;

There are vanilla Perl scripts (sslAuth.pl and sslAuthREST.pl) to ease execution of the
authentication clients. The path to the keystore needs to edited in each.

;;;;

I've included two tomcat-users.xml files: one with plaintext passwords, one with an
SHA digest of a password. Either file gets copied into TOMCAT_HOME/conf/tomcat-users.xml
and Tomcat must be restarted thereafter.

;;;; 

The WAR files are ready to deploy under either standalone Tomcat or Glassfish.
