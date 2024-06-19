<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
 <title><spring:message code="welcome.title" text="Welcome" /></title>
</head>

<body>
<p>golf.jsp</p>
<c:set var="totalCount" scope="session" value="100"/>
<c:out value="${totalCount}"/>
 <h2><spring:message code="welcome.message"
        text="Welcome to Court Reservation System" /></h2> 

 Today is <fmt:formatDate value="${today}" pattern="yyyy-MM-dd" />. 
</body>
</html>
