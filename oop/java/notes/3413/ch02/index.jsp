<%--
	file: index.jsp
	desc: Test installation of J2EE SDK 1.4
--%>
<html>
	<head>
		<title>Hello World - test the J2EE SDK installation</title>
	</head>
	<body>
		<%
			for (int i=1; i<5; i++)  {
		%>
			<h<%=i%>>Hello World</h<%=i%>>
		<%
			}
		%>
	</body>
</html>
