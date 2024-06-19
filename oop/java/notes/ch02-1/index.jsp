<%--
	file: index.jsp
	desc: Test installation for Glassfish
--%>
<html>
	<head>
		<title>Hello World - Test the J2EE SDK Installation</title>
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
</head>
