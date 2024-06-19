<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<tiles:definition id="mydefn1" page="layoutDefn.jsp">
	<tiles:put name="title" value="JTutor.net - Using Definition in Tiles" />
	<tiles:put name="header" value="header.jsp" />
	<tiles:put name="footer" value="footer.jsp" />
	<tiles:put name="menu" value="menu.jsp" />
	<tiles:put name="body" value="body.jsp" />
</tiles:definition>

<tiles:insert beanName="mydefn1" flush="true">
	<tiles:put name="title" value="Using overloaded definitions in tiles"/>
	<tiles:put name="body" value="newbody.jsp" />
</tiles:insert>
<tiles:insert beanName="mydefn1" flush="true" />