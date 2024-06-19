<!-- LB 667, Book 7, Chapter 3
 Illustrates directives, expressions and declarations
 Place JSP file in c:/tomcat/webapps/jsp-examples/LoweAndBurd
 Then run http://localhost:8080/jsp-examples/LoweAndBurd/DeclarationJSP.jsp
 -->

 <html>
 	<head>
 		<title>Date JSP with Declaration</title>
 	</head>
 	<%@ page import="java.text.*" %>
 	<%@ page import="java.util.*" %>
 	<body>
 		<h1>
 			Today is <%= getTodaysDate() %>
 			<br>
 			Have a Nice Day
 		</h1>
 	</body>
 </html>

<%!
private String getTodaysDate()  {
	DateFormat df = DateFormat.getDateInstance( DateFormat.FULL );
	Date dtToday = new Date();
	return df.format( dtToday );
}
%>
