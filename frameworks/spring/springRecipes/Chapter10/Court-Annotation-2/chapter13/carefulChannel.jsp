<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<c:catch var="error">
  <c:import var="body" url="${param.page}"/>
</c:catch>
<c:if test="${not empty error}">
  <c:set var="body">
    This channel failed to load.  Sorry.
    <!-- Here's why: <c:out value="${error}"/> -->
  </c:set>
</c:if>

<table width="100%">
 <tr>
  <td class="heading">
    <c:out escapeXml="false" value="${param.headline}"/>
  </td>
 </tr>
 <tr>
  <td>
    <c:out escapeXml="false" value="${body}"/>
  </td>
 </tr>
</table>

