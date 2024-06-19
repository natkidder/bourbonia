<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>

<c:choose>
  <c:when test="${empty param.surveyId or empty param.choice}">
    <font color="red">
      Error: survey.jsp called incorrectly!
    </font>
  </c:when>
  <c:otherwise>

    <sql:update>
      insert into survey_results(survey_id, choice)
        values(?, ?)
      <sql:param value="${param.surveyId}" />
      <sql:param value="${param.choice}" />
    </sql:update>

    <sql:query var="result">
      select choice, count(choice) from survey_results
        where survey_id = ?
        group by choice
      <sql:param value="${param.surveyId}" />
    </sql:query>

    <c:set var="total" value="0"/>
    <c:forEach items="${result.rowsByIndex}" var="row">
      <c:set var="total" value="${total + row[1]}"/>
    </c:forEach>

    Total votes: <c:out value="${total}"/> <br />

    <c:forEach items="${result.rowsByIndex}" var="row">
      <b><c:out value="${row[0]}"/></b> has
      <c:out value="${row[1]}"/> votes
      (<fmt:formatNumber type="percent"
         value="${row[1] / total}"/>)
      <br />
    </c:forEach>

    <hr />

    <c:forEach items="${result.rowsByIndex}"
        var="row" varStatus="s">
      <c:if test="${s.first}">
        <table>
      </c:if>

      <tr>
       <td><c:out value="${row[0]}"/></td>
       <td>
        <table>
         <tr>
          <td bgcolor="blue">
           <c:forEach
             begin="1"
             end="${row[1] * 100 / total}">&nbsp;</c:forEach>
          </td>
         </tr>
        </table>
       </td>
      </tr>

      <c:if test="${s.last}">
        </table>
      </c:if>
    </c:forEach>

  </c:otherwise>
</c:choose>

