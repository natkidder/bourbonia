<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC Form Handling for Web Services</title>
</head>
<body>

	<h2>User Information</h2>
	<form:form method="POST" action="http://localhost:8080/SpringServiceExample/service/teamYear/post/form">
		<table>
			<tr>
				<td><form:label path="id">ID</form:label></td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="city">City</form:label></td>
				<td><form:input path="city" /></td>
				<td><form:label path="nickname">Nickname</form:label></td>
				<td><form:input path="nickname" /></td>
			</tr>
			<tr>
				<td><form:label path="year">Year</form:label></td>
				<td><form:input path="year" /></td>
				<td><form:label path="wins">Wins</form:label></td>
				<td><form:input path="wins" /></td>
				<td><form:label path="losses">Losses</form:label></td>
				<td><form:input path="losses" /></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>