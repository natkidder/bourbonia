<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
<head>
<title>ABC, Inc. Human Resources Portal - Employee Search</title>
</head>
<body>

<font size="+1">
ABC, Inc. Human Resources Portal - Add Employee
</font><br>
<hr width="100%" noshade="true">

<html:errors/>

<html:form action="/admin/add">

<table>
<tr>
<td align="right"><bean:message key="label.add.name"/>:</td>
<td><html:text property="name"/></td>
</tr>
<tr>
<td align="right"><bean:message key="label.add.ssNum"/>:</td>
<td><html:text property="ssNum"/> (xxx-xx-xxxx)</td>
</tr>
<tr>
<td></td>
<td><html:submit/></td>
</tr>
</table>

</html:form>


</body>
<html>