<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!-- taglib prefix="html" uri="http://struts.apache.org/tags-html"  -->

<html>
	<head>
	<title>Find a Resume</title>
	<script src="clientHint.js"></script>
	</head>
	<body>
	<html:errors/>
	<h3>Resume Form</h3>	

	<html:form action="/ActionResume" method="POST"> <!-- POST because a lot of info -->
    
        <p>Email: <input type="text" name="email" size="30" onkeyup="showHint(this.value)" />
      	<p>Suggestions: <span id="txtHint"></span></p>

    <input type="submit" name="step" value="Find"/>

    </html:form>
	
	</body>
</html>