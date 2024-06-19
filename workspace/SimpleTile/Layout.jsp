<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %> 
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %> 
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<html>
	<head>
		<title><tiles:getAsString name="title" /></title>
	</head>
	<body>
		<table width="100%">
			<tr>
				<td colspan="2">
					<tiles:insert attribute="header" />
				</td>
			</tr>
			<tr>
				<td width="80">
					<tiles:insert attribute="menu" />
				</td>
				<td>
					<tiles:insert attribute="body" />
					<br>The J2EE components retrieved via putList are:
					<br><tiles:importAttribute />
					<%! int i = 1; %>
					<logic:iterate id="item" name="j2ee">
						<%= i++ %>
						<bean:write name="item" /><br>
					</logic:iterate>
					<tiles:useAttribute id="websiteString" name="website" classname="java.lang.String" scope="page" />
					<p>The string "website" retrieved using useAttribute is: <bean:write name="websiteString" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<tiles:insert attribute="footer" />
				</td>
			</tr>
		</table>
	</body>
</html>