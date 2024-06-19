<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>

<sql:transaction isolation="serializable">
  <sql:query var="result">					
    select user from users where user=?			
    <sql:param value="${requestScope.name}"/>			
  </sql:query>							
  <c:if test="${result.rowCount > 0}"			
        var="takenName"						
        scope="request">					
    <jsp:forward page="register.jsp" />			
  </c:if>								
  <sql:update>							
    insert into users(user, password, rss)		
      values(?, ?, ?);						
    <sql:param value="${requestScope.name}"/>			
    <sql:param value="${requestScope.pw}"/>			
    <sql:param value="${requestScope.url}"/>			
  </sql:update>							
</sql:transaction>
<c:set var="user" scope="session" value="${requestScope.name}"/>
<jsp:forward page="dynamicPortal.jsp"/>
