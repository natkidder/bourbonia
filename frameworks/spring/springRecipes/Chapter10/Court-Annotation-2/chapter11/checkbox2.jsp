<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<c:choose>
 <c:when test="${not empty paramValues.feedback}">
  You described our customer service as
  <ul>
  <c:forEach items="${paramValues.feedback}" var="adj">
    <c:choose>
      <c:when test="${adj == 'satisfactory'}">
         <font size="+2">
      </c:when>
      <c:otherwise>
         <font size="-2">
      </c:otherwise>
    </c:choose>
    <li><c:out value="${adj}"/></li>
    </font>
  </c:forEach>
 </c:when>
 <c:otherwise>
  You didn't choose any feedback checkboxes.
 </c:otherwise>
</c:choose> 

