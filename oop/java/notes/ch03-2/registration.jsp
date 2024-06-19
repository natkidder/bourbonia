<!-- Crume, p.77 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTC HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Register User</title>
	</head>
	<body>
		<h1>Register User</h1>
		
		<jsp:useBean id="user" scope="session" class="ch03.User">
			<jsp:setProperty name="user" property="*" />
		</jsp:useBean>
		
		Welcome new user, these are the values you submitted:
		
		<p>Your first name is <%= user.getFirstName() %>. </p>
		<p>Your last name is <jsp:getProperty name="user" property="surname" />
		<p>Your user ID is <jsp:getProperty name="user" property="loginName" />
		<p>Your age is <jsp:getProperty name="user" property="age"  />
		<br>
		
		You selected these topics:
		
		<%
			String[] topics = request.getParameterValues( "topics" );
			if ( topics == null ) {
				topics = new String[] { "no topics" };
			}
			for ( int i = 0; i < topics.length; i++ ) {
		%>
		<br><%= topics[i] %>
		<%
			}
		%>
		<br>
		
		<p>Go to <a href="welcome.jsp">Topic List Page</a> </p>
		<%@ include file="/WEB-INF/footer.jspf" %>
	
	</body>
</html>
