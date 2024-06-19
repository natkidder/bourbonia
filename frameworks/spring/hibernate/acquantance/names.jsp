<html>
	<jsp:useBean id="acq" class="web.Acquantance" scope="session"/>
	<jsp:setProperty name="acq" property="*" />
	<head> <title>Acquantances</title> </head>

	<body>
		<h1>Acquantances</h1>
		<form action="names.jsp" method="post">
			<p>First Name:
			<input type="text" name="fname" />
			<p>Last Name:
			<input type="text" name="lname" />
			<input type="submit" value="GetPerson"/>
		</form>
	</body>
</html>

