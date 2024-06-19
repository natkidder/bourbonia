<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> --%>
 
<html>
<head>
<title>golf.jsp</title>
</head>

<body>
<c:set var="totalCount" scope="page" value="100"/>
<c:out value="Total Count: ${totalCount}"/>
<p>golf.jsp</p>
</body>
</html>