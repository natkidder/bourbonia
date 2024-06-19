<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC Form Handling for Web Services</title>
</head>
<body>

	<h2>User Information</h2>
	<form:form method="POST" action="http://localhost:8080/SpringServiceExample/service/user/filePath/post/form">
		<table>
			<tr>
				<td><form:label path="filePath">File Path</form:label></td>
				<td><form:input path="filePath" /></td>
				<td><form:label path="fileComments">File Comments</form:label></td>
				<td><form:input path="fileComments" /></td>				
			</tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>