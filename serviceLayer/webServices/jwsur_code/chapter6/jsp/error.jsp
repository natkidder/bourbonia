<%@ page isErrorPage = "true" %>
<html>
<% response.setStatus(400); %>
<body>
<h2><%= exception.toString() %></h2>
<p>Bad data: please try again.</p>
<p><a href = "index.html">Return to home page</a></p>
</body></html>    
