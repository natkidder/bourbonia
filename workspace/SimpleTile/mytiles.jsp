<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %> <%@
taglib uri="http://struts.apache.org/tags-html" prefix="html" %> <%@
taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %> <%@
taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insert page="Layout.jsp" flush="true">
	<tiles:putList name="j2ee">
		<tiles:add value="Servlets" />
		<tiles:add value="JSP" />
		<tiles:add value="Struts" />
		<tiles:add value="EJB" />
	</tiles:putList>
	<tiles:put name="title" value="JTutor.net - My First Tiles Application" />
	<tiles:put name="header" value="header.jsp" />
	<tiles:put name="footer" value="footer.jsp" />
	<tiles:put name="menu" value="menu.jsp" />
	<tiles:put name="body" value="body.jsp" />
	<tiles:put name="website" value="www.JTutor.net" />
</tiles:insert>