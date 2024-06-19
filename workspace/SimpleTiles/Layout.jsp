<%@ taglib uri="/tags/struts-tile" prefix="tiles" %>
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
				</td>
				<td colspan="2">
					<tiles:insert attribute="footer" />
				</td>
			</tr>
		</table>
	</body>
</html>
