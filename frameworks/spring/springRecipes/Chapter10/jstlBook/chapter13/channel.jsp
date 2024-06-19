<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<c:import var="body" url="${param.page}"/>

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

