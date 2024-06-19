# AWS Lambda
* The runtime settings handler is [package].[class]::[method]

# Maven
## Add Maven Utilities
* Right-click on the project name, select *Properties* and click *Convert to Maven Project*

## Get Dependencies into the Build Path
* To get dependencies to appear in your Build Path Libraries, do:
  * run `mvn clean dependency:purge-local-repository` in the shell at directory containing the pom.xml.  That will download the code libraries (usually in a JAR file) into the $M2_REPO directories
  * right-click the project and select *Maven -> Update Project*.  That will get it to add the Maven Dependencies libraries into the project build path