<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<c:set var="totalCount" scope="session" value="100"/>
<c:set var="perPage" scope="session" value="20"/>

<c:forEach
    var="boundaryStart"
    begin="0"
    end="${totalCount - 1}"
    step="${perPage}">

    <a href="?start=<c:out value="${boundaryStart}"/>">
      [
        <c:out value="${boundaryStart}"/>
         -
        <c:out value="${boundaryStart + perPage - 1}"/>
      ]
    </a>
</c:forEach>

<c:forEach
    var="current"
    varStatus="status"
    begin="${param.start}"
    end="${param.start + perPage - 1}">
  <c:if test="${status.first}">
    <ul>
  </c:if>
  <li><c:out value="${current}"/></li>
  <c:if test="${status.last}">
    </ul>
  </c:if>
</c:forEach>

