<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html>
<head>
<title><bean:message key="title.application"/></title>
</head>
<body>

<font size="+1"><bean:message key="title.application"/></font><br>

<hr width="100%" noshade="true">

&#149; <bean:message key="link.employee.add"/><br>
&#149; <html:link forward="search"><bean:message key="link.employee.search"/></html:link><br>

</body>
</html>