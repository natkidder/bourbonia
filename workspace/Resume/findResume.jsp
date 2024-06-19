<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!-- taglib prefix="html" uri="http://struts.apache.org/tags-html"  -->

<html>
	<head>
		<title>Login</title>
		<script src="clientHint.js"></script>
		<link rel="stylesheet" type="text/css" href="forms.css" />
	</head>
	<body>
	<html:errors/>
	<h3>Login</h3>	

	<html:form action="/ActionFind" method="POST"> <!-- POST because a lot of info -->
    
        <p>Login (your email address): <input type="text" name="email" size="30" onkeyup="showHint(this.value)" />
<!--    <p>Suggestions: <span id="txtHint"></span></p> --> <!-- RESTORE IF YOU WANT HINTS -->
      	<p>Password <input type="password" name="passwd1" size="30"/></p>
		<p><p></p>If you forgot your password, please ___________________</p>

    <input type="submit" name="step" value="Login"/>
    <input type="submit" name="step" value="Home"/>

    </html:form>
	
	</body>
</html>