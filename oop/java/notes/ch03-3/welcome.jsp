<!-- Crume, p.75 -->
<%@ page errorPage="/WEB-INF/errorPage.jsp" import="java.util.Iterator,ch03.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Java FAQ Welcome Page</title>
	</head>

	<body>
		<h1>Java FAQ Welcome Page</h1>
		<%
			User user = (User) session.getAttribute( "user" );
			if ( user == null )  {
		%>
		You are not yet registered, please register here: <a href="registrationform.html">register</a>.
		<% 	
			} else {
		%>
		
			Welcome to the Java FAQ

			<%! FaqCategories faqs = new FaqCategories(); %>
			Click a link below for answers to the given topic.
			<%
				Iterator categories = faqs.getAllCategories();
				while ( categories.hasNext() )  {
					String category = (String) categories.next();
			%>
			<p><a href="<%= replaceUnderscore( category ) %>.jsp"><%= category %></a></p>
			<%
				}
			%>
		
			<%@ include file="/WEB-INF/footer.jspf" %>
		<%
			}
		%>

	</body>
</html>

<%! 
	public String replaceUnderscore( String s )  {
		return s.replace( ' ', '_' );
	}
%>
