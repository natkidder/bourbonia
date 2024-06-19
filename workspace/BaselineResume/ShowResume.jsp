<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.Enumeration"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resume Properties</title>
</head>
<body>
<p>Properties for the Resume you Just Entered</p>

<% 
//out.print((String) request.getParameter("comments")); 
Enumeration enum1 = request.getParameterNames();
while (enum1.hasMoreElements())   {
	String pname = (String) enum1.nextElement();
	String[] pvalues = request.getParameterValues(pname);
	out.print("Name [" + pname + "] values: ");
	for (int i=0; i<pvalues.length; i++)  {
		out.print(pvalues[i]);
	}
	out.println("<br>");
}
%>


</body>
</html>