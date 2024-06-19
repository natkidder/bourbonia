<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>

<sql:query var="result">
  select * from users where user=? and password=?
  <sql:param value="${param.user}" />
  <sql:param value="${param.pw}" />
</sql:query>
<c:choose>
  <c:when test="${result.rowCount > 0}">
    <c:set var="user" scope="session" value="${param.user}" />
    <c:set var="rss" scope="session"
      value="${result.rows[0].RSS}" />
  </c:when>
  <c:otherwise>
    <c:set var="failedLogin" scope="request" value="true"/>
  </c:otherwise>
</c:choose>
<jsp:forward page="dynamicPortal.jsp" />


