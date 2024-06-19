<%@ taglib uri="/tags/struts-tile" prefix="tiles" %>
<tiles:insert page="layout.jsp" flush="true">
	<tiles:put name="title" value="JTutor.net - My First Tiles Application" />
	<tiles:put name="header" value="header.jsp" />
	<tiles:put name="footer" value="footer.jsp" />
	<tiles:put name="menu" value="menu.jsp" />
	<tiles:put name="body" value="body.jsp" />
</tiles:insert>