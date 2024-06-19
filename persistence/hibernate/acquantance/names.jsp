<html>
	<jsp:useBean id="acq" class="web.Acquantance" scope="session"/>
	<head> <title>Acquantances</title> </head>

	<body>
		<h1>Acquantances</h1>
		<form action="names.jsp" method="post">
			<p>First Name:
			<input type="text" name="fname" value="<jsp getProperty name="acq" property="fname"/>" />
			<p>Last Name:
			<input type="text" name="lname" value="<jsp getProperty name="acq" property="lname"/>" />
			<input type="submit" value="next"/>
		</form>
	</body>
</html>

