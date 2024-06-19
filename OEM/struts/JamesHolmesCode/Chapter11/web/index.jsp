<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/sslext.tld" prefix="sslext" %>

<%-- Uncomment to force the page to not run under HTTPS --%>
<%--
<sslext:pageScheme secure="false"/>
--%>
<html>
  <head>
    <title>ABC, Inc. Human Resources Portal</title>
  </head>
  <body>
    <font size="+1">ABC, Inc. Human Resources Portal</font><br>
    <logic:notPresent name="user" scope="session">
      <%-- Use this block if using container-managed security
      <html:link page="/admin/admin_login.jsp">Login</html:link>
      --%>
    	<%-- Use this block if using application managed security --%>
    	<bean:cookie id="uname" name="MiniHRUsername" value=""/>
    	<bean:cookie id="pword" name="MiniHRPassword" value=""/>
	    <hr width="100%" noshade="true">
	    <html:form action="/login">
	      Username: <html:text property="username" value="<%=uname.getValue()%>"/><br/>
	      Password: <html:password property="password" value="<%=pword.getValue()%>"/><br/>
	      <html:submit value="Login"/>
      </html:form>
      <html:errors/>
    </logic:notPresent>
    <hr width="100%" noshade="true">
    <ul>
      <logic:present name="user" scope="session">
  	    <logic:equal name="user" property="administrator" value="true">
 	        <li><html:link forward="add">Add an Employee</html:link></li>
        </logic:equal>
      </logic:present>
      <li><html:link forward="search">Search for Employees</html:link></li>
    </ul>	
  </body>
</html>