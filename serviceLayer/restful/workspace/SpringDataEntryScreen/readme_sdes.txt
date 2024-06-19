From  
http://www.programming-free.com/2014/04/spring-mvc-consuming-restful-web-services.html  to build the web service
http://www.programming-free.com/2014/03/spring-mvc-40-restful-web-service-json.html  to build the Spring MVC interface
 
Dynamic Web Project
 
NOTE: THIS WON'T WORK UNLESS YOU ADD THE JARS TO THE LOCAL DIRECTORY.  BETTER YOU WORK WITH SpringServiceExample and WebSiteExample instead
http://localhost:8080/SpringServiceExample/userEntry

========================== File structure:
 
./DataFile.txt
./README_sse2.txt
./src
./src/com
./src/com/programmingfree
./src/com/programmingfree/springservice
./src/com/programmingfree/springservice/controller
./src/com/programmingfree/springservice/controller/ListUsersController.java
./src/com/programmingfree/springservice/controller/SpringServiceController.java
./src/com/programmingfree/springservice/dao
./src/com/programmingfree/springservice/dao/UserService.java
./src/com/programmingfree/springservice/domain
./src/com/programmingfree/springservice/domain/User.java
./src/com/programmingfree/springservice/domain/Users.java
./src/com/programmingfree/springservice/util
./src/com/programmingfree/springservice/util/XMLUtils.java
./WebContent
./WebContent/META-INF
./WebContent/META-INF/MANIFEST.MF
./WebContent/WEB-INF
./WebContent/WEB-INF/jsp
./WebContent/WEB-INF/jsp/dispUser.jsp
./WebContent/WEB-INF/jsp/listUsers.jsp
./WebContent/WEB-INF/jsp/userEntry.jsp
./WebContent/WEB-INF/jsp/userResult.jsp
./WebContent/WEB-INF/lib
./WebContent/WEB-INF/lib/commons-logging-1.1.1.jar
./WebContent/WEB-INF/lib/jackson-annotations-2.4.1.jar
./WebContent/WEB-INF/lib/jackson-core-2.4.1.jar
./WebContent/WEB-INF/lib/jackson-databind-2.4.1.jar
./WebContent/WEB-INF/lib/jsp-api-2.2.jar
./WebContent/WEB-INF/lib/jstl-1.2.jar
./WebContent/WEB-INF/lib/spring-aop-4.0.0.RELEASE.jar
./WebContent/WEB-INF/lib/spring-aspects-4.0.0.RELEASE.jar
./WebContent/WEB-INF/lib/spring-beans-4.0.0.RELEASE.jar
./WebContent/WEB-INF/lib/spring-context-4.0.0.RELEASE.jar
./WebContent/WEB-INF/lib/spring-core-4.0.0.RELEASE.jar
./WebContent/WEB-INF/lib/spring-expression-4.0.0.RELEASE.jar
./WebContent/WEB-INF/lib/spring-framework-bom-4.0.0.RELEASE.jar
./WebContent/WEB-INF/lib/spring-web-4.0.0.RELEASE.jar
./WebContent/WEB-INF/lib/spring-webmvc-4.0.0.RELEASE.jar
./WebContent/WEB-INF/SpringServiceExample_2-servlet.xml
./WebContent/WEB-INF/web.xml
 
Web.xml:
 
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/j2ee" xmlns:web="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd http://xmlns.jcp.org/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" id="WebApp_ID" version="2.4">
  <display-name>Spring Call RESTful</display-name>
  <servlet>
    <servlet-name>SpringServiceExample_2</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>SpringServiceExample_2</servlet-name>
    <url-pattern>/*</url-pattern>
  </servlet-mapping>
  <servlet>
    <servlet-name>jsp</servlet-name>
    <servlet-class>org.apache.jasper.servlet.JspServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>jsp</servlet-name>
    <url-pattern>/WEB-INF/jsp/*</url-pattern>
  </servlet-mapping>
</web-app>
 
SpringServiceExample_2-servlet.xml:
 
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
               xmlns:context="http://www.springframework.org/schema/context"
               xmlns:mvc="http://www.springframework.org/schema/mvc" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
               xmlns:p="http://www.springframework.org/schema/p"
               xsi:schemaLocation="
        http://www.springframework.org/schema/beans   
        http://www.springframework.org/schema/beans/spring-beans-4.0.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context-4.0.xsd
        http://www.springframework.org/schema/mvc
        http://www.springframework.org/schema/mvc/spring-mvc-4.0.xsd">
       
               <context:component-scan base-package="com.programmingfree.springservice.controller" />
              
               <mvc:annotation-driven />
              
               <bean id="viewResolver"
                              class="org.springframework.web.servlet.view.InternalResourceViewResolver">
                              <property name="viewClass"
                                             value="org.springframework.web.servlet.view.JstlView" />
                              <property name="prefix" value="/WEB-INF/jsp/" />
                              <property name="suffix" value=".jsp" />
               </bean>
</beans>
 
userEntry.jsp:
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC Form Handling for Web Services</title>
</head>
<body>
 
               <h2>User Information</h2>
               <form:form method="POST" action="http://localhost:8080/SpringServiceExample_2/service/user/post/form">
                              <table>
                                             <tr>
                                                            <td><form:label path="userid">User ID</form:label></td>
                                                            <td><form:input path="userid" /></td>
                                             </tr>
                                             <tr>
                                                            <td><form:label path="firstName">First Name</form:label></td>
                                                            <td><form:input path="firstName" /></td>
                                             </tr>
                                             <tr>
                                                            <td><form:label path="lastName">Last Name</form:label></td>
                                                            <td><form:input path="lastName" /></td>
                                             </tr>
                                             <tr>
                                                            <td><form:label path="email">email</form:label></td>
                                                            <td><form:input path="email" /></td>
                                             </tr>
                                             <tr>
                                                            <td colspan="2"><input type="submit" value="Submit" /></td>
                                             </tr>
                              </table>
               </form:form>
</body>
</html>
 
 
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
 
import com.programmingfree.springservice.domain.User;
import com.programmingfree.springservice.domain.Users;
 
@Controller
public class ListUsersController {
 
               //@RequestMapping(value = "/listUsers", method = RequestMethod.GET,headers="Accept=application/json")
               @RequestMapping("/listUsers")
               public ModelAndView listUsers() {
                              RestTemplate restTemplate = new RestTemplate();
                              String url="http://localhost:8080/SpringServiceExample_2/service/user/";   
                              List<LinkedHashMap> users=restTemplate.getForObject(url, List.class);
                              return new ModelAndView("listUsers", "users", users);
               }
               @RequestMapping("/listUsers/xml")
               public ModelAndView listUsers2() {
                              RestTemplate restTemplate = new RestTemplate();
                              String url="http://localhost:8080/SpringServiceExample_2/service/user/xml"; 
                              System.out.println("1253-1");
                              Users users = restTemplate.getForObject(url, Users.class);
                              List users2 = users.getUsers();
                              System.out.println("1253-2");
                              return new ModelAndView("listUsers", "users", users2);
               }
 
               @RequestMapping("/dispUser/{userid}")
               public ModelAndView dispUser(@PathVariable("userid") int userid) {
                              RestTemplate restTemplate = new RestTemplate();
                              String url="http://localhost:8080/SpringServiceExample_2/service/user/json/{userid}";
                              User user=restTemplate.getForObject(url, User.class,userid);
                              return new ModelAndView("dispUser", "user", user);
               }
 
               @RequestMapping("/dispUser/xml/{userid}")
               public ModelAndView dispUser2(@PathVariable("userid") int userid) {
                              RestTemplate restTemplate = new RestTemplate();
                              String url="http://localhost:8080/SpringServiceExample_2/service/user/xml/{userid}";
                              User user=restTemplate.getForObject(url, User.class, userid);
                              //List<LinkedHashMap> users = restTemplate.getForObject(url, List.class);
                              System.out.println("1253-2");
                              return new ModelAndView("dispUser", "user", user);
 
               }             
 
               @RequestMapping(value = "/userEntry", method = RequestMethod.GET)
               public ModelAndView userEntry() {
                              // "command" is a Spring MVC keyword needed if you use <form:form> tags
                              return new ModelAndView("userEntry", "command", new User());
               }
 
}
 
 
import java.util.List;
 
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
 
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Node;
 
import com.programmingfree.springservice.dao.UserService;
import com.programmingfree.springservice.domain.User;
import com.programmingfree.springservice.domain.Users;
import com.programmingfree.springservice.util.XMLUtils;
 
@RestController
@RequestMapping("/service/user/")
public class SpringServiceController {
 
               UserService userService=new UserService();
 
               @RequestMapping(value = "/json/{id}", method = RequestMethod.GET, headers="Accept=application/json")
               public User getUser(@PathVariable int id) {
                              User user=userService.getUserById(id);
                              return user;
               }
               @RequestMapping(value = "/xml/{id}", method = RequestMethod.GET, headers="Accept=application/xml")
               public User getUser2(@PathVariable int id) {
                              User user=userService.getUserById(id);
                              System.out.println("1541-1 "+user.getFirstName()); ////
                              return user;
               }
 
               @RequestMapping(value = "/post/xml", method = RequestMethod.POST, consumes = "application/xml")
               public String getUser3(@RequestBody String requestBody) throws JAXBException {
                              System.out.println(requestBody);
                              User user2 = new User();
                              JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
                              Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                              Node node = XMLUtils.stringToNode(requestBody);
                              user2 = (User) jaxbUnmarshaller.unmarshal(node);
                              System.out.println(user2.getFirstName());
                              return "ran SpringByExample post";
               }
 
               @RequestMapping(value = "/post/json", method = RequestMethod.POST, headers="Accept=application/json")
               public String getUser4(User user) {
                              System.out.println("1739-2-userId="+user.getUserid());
                              int id = user.getUserid();
                              User user2=userService.getUserById(id);
                              return "ran SpringByExample post";
               }
 
               @RequestMapping(value = "/post/form", method = RequestMethod.POST)
               public ModelAndView getUser4(@ModelAttribute("SpringWeb")User user, ModelMap modelMap) {
                              user.setFirstName("Mr. "+user.getFirstName());
                              System.out.println("1131-1 - FirstName="+user.getFirstName());
                             
                              // the ModelMap is necessary and is implicitly passed to the ModelAndView, at least if it has no form tag
                              // comment out if you want user propagated to original entry screen
/*                          modelMap.addAttribute("userid", user.getUserid());
                              modelMap.addAttribute("firstName", user.getFirstName());
                              modelMap.addAttribute("lastName", user.getLastName());
                              modelMap.addAttribute("email", user.getEmail());
                              return new ModelAndView("userResult", "command", user);*/
                             
                              return new ModelAndView("userEntry", "command", user);
                              //return "userResult"; // seems to not work here, though it does in MVC_FormHandling
               }
 
               @RequestMapping(method = RequestMethod.GET,headers="Accept=application/json")
               public List<User> getAllUsers() {
                              List<User> users=userService.getAllUsers();
                              return users;
               }
               @RequestMapping(value = "/xml", method = RequestMethod.GET,headers="Accept=application/xml")
               public Users getAllUsers2() {
                              System.out.println("0854-2");
                              Users users=userService.getAllUsers2();
                              return users;
               }
 
}
 
 
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
 
import com.programmingfree.springservice.domain.User;
//import com.programmingfree.springservice.utility.DBUtility;
import com.programmingfree.springservice.domain.Users;
 
public class UserService {
 
               public List<User> getAllUsers() {
                              List<User> users = new ArrayList<User>();
                              try {
                                             System.out.println("1620-2"); ////
                                             FileInputStream fstream = new FileInputStream("c:/nat/training/webServices/restful/workspace/SpringServiceExample_2/DataFile.txt");
                                             // Get the object of DataInputStream
                                             DataInputStream in = new DataInputStream(fstream);
                                             BufferedReader br = new BufferedReader(new InputStreamReader(in));
                                             String strLine;
                                             //Read File Line By Line
                                             while ((strLine = br.readLine()) != null)     {
                                                            String[] attributes = strLine.split("[ ]+");
                                                            User user = new User();
                                                            user.setUserid(Integer.parseInt(attributes[0]));
                                                            user.setFirstName(attributes[1]);
                                                            user.setLastName(attributes[2]);  
                                                            user.setEmail(attributes[3]);
                                                            users.add(user);
                                             }
                                             //Close the input stream
                                             in.close();
                              } catch (FileNotFoundException e) {
                                             // TODO Auto-generated catch block
                                             e.printStackTrace();
                              } catch (NumberFormatException e) {
                                             // TODO Auto-generated catch block
                                             e.printStackTrace();
                              } catch (IOException e) {
                                             // TODO Auto-generated catch block
                                             e.printStackTrace();
                              }
 
                              System.out.println("getAllUsers - size="+users.size()); ////
                              return users;
               }
              
               public Users getAllUsers2()  {
                              List<User> listOfUsers = getAllUsers();
                              Users users = new Users();
                              users.setUsers(listOfUsers);
                              return users;
               }
 
               public User getUserById(int userId) {
                              User user = new User();
                              try {
 
                                             FileInputStream fstream = new FileInputStream("c:/nat/training/webServices/restful/workspace/SpringServiceExample_2/DataFile.txt");
                                             // Get the object of DataInputStream
                                             DataInputStream in = new DataInputStream(fstream);
                                             BufferedReader br = new BufferedReader(new InputStreamReader(in));
                                             String strLine;
                                             //Read File Line By Line
                                             while ((strLine = br.readLine()) != null)     {
                                                            String[] attributes = strLine.split("[ ]+");
                                                            if (Integer.parseInt(attributes[0]) == userId)  {
                                                                           user.setUserid(Integer.parseInt(attributes[0]));
                                                                           user.setFirstName(attributes[1]);
                                                                           user.setLastName(attributes[2]);  
                                                                           user.setEmail(attributes[3]);
                                                            }
                                             }
                                             //Close the input stream
                                             in.close();
                              } catch (FileNotFoundException e) {
                                             // TODO Auto-generated catch block
                                             e.printStackTrace();
                              } catch (NumberFormatException e) {
                                             // TODO Auto-generated catch block
                                             e.printStackTrace();
                              } catch (IOException e) {
                                             // TODO Auto-generated catch block
                                             e.printStackTrace();
                              }
                              return user;
               }
 
}
 
 
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
 
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "userid",
        "firstName",
        "lastName",
        "email"
    })
@XmlRootElement(name="User")
public class User {
               @XmlElement(name="userid")
               private int userid;
               @XmlElement(name="firstName")
               private String firstName;
               @XmlElement(name="lastName")
               private String lastName;
               @XmlElement(name="email")
               private String email;
 
               public int getUserid() {
                              return userid;
               }
               public void setUserid(int userid) {
                              this.userid = userid;
               }
               public String getFirstName() {
                              return firstName;
               }
               public void setFirstName(String firstName) {
                              this.firstName = firstName;
               }
               public String getLastName() {
                              return lastName;
               }
               public void setLastName(String lastName) {
                              this.lastName = lastName;
               }
 
 
               public String getEmail() {
                              return email;
               }
               public void setEmail(String email) {
                              this.email = email;
               }
               @Override
               public String toString() {
                              return "User [userid=" + userid + ", firstName=" + firstName
                                                            + ", lastName=" + lastName + ", email="
                                                            + email + "]";
               }
 
}
 
 
import java.util.List;
 
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
 
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "users"
    })
@XmlRootElement(name="Users")
public class Users {
              
               @XmlElement(name="users")
               private List<User> users;
              
               // keep JAXB happy
               public Users() {}
 
               public List<User> getUsers() {
                              return users;
               }
 
               public void setUsers(List<User> users) {
                              this.users = users;
               }
}
 
 
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
 
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
 
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
 
public class XMLUtils {
 
               /**
               *
               * Convert a string to a Node Object
               *
               * @param xml The xml to convert
               * @return A document Object
               * @throws IOException
               * @throws SAXException
               * @throws ParserConfigurationException
               */
               public static Node stringToNode(String xml)  {
                              Node node = null;
                              if (xml == null)
                                             return null;
 
                              try {
                                             Document document = inputStream2Document(new ByteArrayInputStream(xml.getBytes()));
                                             node = document.getFirstChild();
                              } catch (IOException e) {
                                             // TODO Auto-generated catch block
                                             e.printStackTrace();
                              } catch (SAXException e) {
                                             // TODO Auto-generated catch block
                                             e.printStackTrace();
                              } catch (ParserConfigurationException e) {
                                             // TODO Auto-generated catch block
                                             e.printStackTrace();
                              }
                              return node;
 
               }
 
               /**
               * Convert an inputStream to a Document Object
               * @param inputStream The inputstream to convert
               * @return a Document Object
               * @throws IOException
               * @throws SAXException
               * @throws ParserConfigurationException
               */
               public static Document inputStream2Document(InputStream inputStream) throws IOException, SAXException, ParserConfigurationException {
                              DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
                              newInstance.setNamespaceAware(true);
                              Document parse = newInstance.newDocumentBuilder().parse(inputStream);
                              return parse;
               }
}
 
 
 
 

 
