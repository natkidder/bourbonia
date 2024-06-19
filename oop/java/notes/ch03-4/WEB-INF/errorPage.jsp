<!-- Crume, p. 94 -->

<%@ page isErrorPage="true" import="java.io.PrintWriter" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Error</title>
	</head>
	<body>
		<h1>Error</h1>
		There was an error somewhere
		<p>Here is the stack trace
		
		<% request.setAttribute( "ex", exception ); %>
		<jsp:include page="formatStackTrace.jsp" />
		
		<%@ include file="/WEB-INF/footer.jspf" %>
		
	</body>
</html>
