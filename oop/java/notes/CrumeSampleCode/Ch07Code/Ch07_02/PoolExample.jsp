<html>
  <head>
    <title>Chapter 7 JSP Pool Example</title>
    <%@ page import="java.sql.*, javax.sql.*, java.io.*, javax.naming.*" 
        contentType="text/html; charset=ASCII" %>
  </head>

  <body>
    <h1>Chapter 7 JSP Pool Example</h1>

<%
    InitialContext context = new InitialContext();
    DataSource dataSource =
      (DataSource) context.lookup("java:comp/env/jdbc/countries");
    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;
    try {
      conn = dataSource.getConnection();
      stmt = conn.createStatement();
      rset = stmt.executeQuery("select * from COUNTRIES");
      if (rset.next()) {
%>
    <table width="100%" border="1">
      <tr align="left">
        <th>Country</th><th>iso code</th><th>region</th>
      </tr>
<%
        do {
%>
      <tr>
        <td><%= rset.getString(1) %></td>
        <td><%= rset.getString(2) %></td>
        <td><%= rset.getString(3) %></td>
      </tr>
<%
        } while (rset.next());
%>
    </table>
<%
      } else {
%>
    No results from query
<%
      }
    } catch (SQLException e) {
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
