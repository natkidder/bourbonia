<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html>
	<head>
		<title>Manage Your Resumes</title>
		<html:base />
	<head>
	<body>
		<h1>Manage Your Resumes</h1>
		<html:errors/>

		<html:form action="/ActionAdd" method="post">
		<p></p>
<!-- 
		<html:submit>
            <bean:message key="addResume.open.submit"/> 
        </html:submit>
 -->
		    <input type="submit" name="step" value="Register"/>
		</html:form> 

		<html:form action="/ActionSearch" method="post">
			<p></p>
<!-- 	  	<input type="submit" value="Search Resumes"/> -->        
		<html:submit>
            <bean:message key="findResume.open.submit"/> 
        </html:submit>
		</html:form>

	</body>
</html:html>