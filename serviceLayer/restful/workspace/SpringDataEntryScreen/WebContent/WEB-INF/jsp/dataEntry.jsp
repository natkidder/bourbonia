<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC Form Handling for Web Services</title>
</head>
<body>
 
               <h2>User Information</h2>
               <form:form method="POST" action="http://localhost:8080/SpringDataEntryScreen/service/user/post/form">
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