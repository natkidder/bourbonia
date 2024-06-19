<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Analyst Management</title>
	</head>
	<body>
		<%@ page import="java.util.*" %>
		<h1>Analyst Management Form</h1>
		<form action="ProcessAnalyst" method="POST">
			<table>
			<%
				ArrayList analysts = (ArrayList)request.getAttribute("data");
				if (analysts == null)  {
				%>
					<h2>Attribute is Null</h2>
				<%
				} else {
					for (int i = 0; i < analysts.size(); i++)  {
						String analyst = (String)analysts.get(i);
				%>
					<tr>
						<td>
							<input type="checkbox" name="checkbox" value="<%= analyst %>"
						</td>
						<td>
							<%= analyst %>
						</td>
					</tr>
				<%
				}
			}
			%>
			</table>
			<input type="submit" value="Delete Selected" name="delete"><p>
			<input type="text" size="40" name="addname">
			<input type="submit" value="Add New Analyst" name="add">
		</form>
	</body>
</html>
