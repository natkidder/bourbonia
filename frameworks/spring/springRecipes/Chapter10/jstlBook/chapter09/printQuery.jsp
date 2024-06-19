<c:forEach
    items="${requestScope.result.rowsByIndex}"
    var="row"
    varStatus="s">
  <c:if test="${s.first}">
    <table>
    <tr>
      <c:forEach
          items="${requestScope.result.columnNames}"
          var="col">
        <th><c:out value="${col}"/></th>
      </c:forEach>
    </tr>
  </c:if>
  <tr>
    <c:forEach items="${row}" var="value">
      <td><c:out value="${value}"/></td>
    </c:forEach>
  </tr>
  <c:if test="${s.last}">
    </table>
  </c:if>
</c:forEach>

