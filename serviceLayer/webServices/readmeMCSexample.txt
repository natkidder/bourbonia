
The ch06.mcs.Echo example requires X.509 Version 3 certificates but Glassfish (v2ur2) comes only with
X.509 Version 1 certifcates. The Metro website

            https://metro.dev.java.net/guide/Configuring_Keystores_and_Truststores.html

walks through the upgrade. Further, the two deployment files currently have the path to the
Glassfish keystore and truststore hardwired; hence, these need to be updated for your 
environment.

