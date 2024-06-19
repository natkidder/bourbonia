<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<c:choose>
 <c:when test="${not empty paramValues.feedback}">
  You described our customer service as
  <ul>
  <c:forEach items="${paramValues.feedback}" var="adj">
    <li><c:out value="${adj}"/></li>
  </c:forEach>
  </ul>
 </c:when>
 <c:otherwise>
  You didn't choose any feedback checkboxes.
 </c:otherwise>
</c:choose>

