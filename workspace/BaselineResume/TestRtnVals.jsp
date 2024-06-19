<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test JSP Page</title>
</head>
<body>
<%@ page language="java"%>
<%! int var = 0; 
int getVar() {return var;}
%>
<% var++;  
%>
Welcome!  You are visitor <%=getVar() %>

<input type="text" name="home" length="20" value=<%=(String) request.getParameter("home") %>></input>
</body>
</html>