<html>
	<head>
		<title>Chapter 7 JSP Pool Example</title>
		<%@ page import="java.sql.*, javax.sql.*, java.io.*, javax.naming.*" contentType="text/html; charset=ASCII" %>
	</head>

	<body>
		<h1>Chapter 7 JSP Pool Example</h1>

		<%
			InitialContext context = new InitialContext();
//			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/countries");
			DataSource dataSource = (DataSource) context.lookup("MySql");
			Connection conn = null;
			Statement stmt = null;
			ResultSet rset = null;
			try {
				conn = dataSource.getConnection();
				stmt = conn.createStatement();
				rset = stmt.executeQuery("select * from countries");
				if (rset.next())  {  // if any rows were returned
		%>
		<table width="100%" border="1">
		<tr align="left">
			<th>Country</th><th>ISO Code</th><th>Region</th>
		</tr>
		<%
					do {
		%>
		<tr><td><%= rset.getString(1) %></td> <td><%= rset.getString(2) %></td> <td><%= rset.getString(3) %></td> </tr>
		<%
					} while( rset.next() ) ;
		%>
		</table>
		<%
				} else {
		%>
		<p>No results from query
		<%
				}
			} catch(Exception e) {
		%>
		<%= e.getMessage() %>
		<%
				e.printStackTrace();
			} finally {
				if (rset != null) { rset.close(); }
				if (stmt != null) { stmt.close(); }
				if (conn != null) { conn.close(); }
				if (context != null) { context.close(); }
			}
		%>
	</body>
</html>
