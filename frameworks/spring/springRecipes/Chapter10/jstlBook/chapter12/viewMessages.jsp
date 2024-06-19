<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<c:choose>
  <c:when test="${empty param.messageBoard}">
    <font color="red">
      Error: viewMessages.jsp called incorrectly!
    </font>
  </c:when>
  <c:otherwise>

    <sql:query var="result">
      select * from messages
        where message_board = ?
        order by sent_date
      <sql:param value="${param.messageBoard}" />
    </sql:query>

    <c:choose>
      <c:when test="${result.rowCount == 0}">
        <p>
          Currently, there are no messages in this message board.
          Be the first to post a message by filling in the form
          below!
        </p>
      </c:when>
      <c:otherwise>
        <c:forEach items="${result.rows}" var="row">
          <p>
          From: <c:out value="${row.AUTHOR}" /> <br />
          Date: <c:out value="${row.SENT_DATE}" /> <br />
          Subject: <c:out value="${row.SUBJECT}" /> <br />
          <blockquote>
             <tt><c:out value="${row.BODY}" /></tt>
          </blockquote>
          <hr />
        </c:forEach>
      </c:otherwise>
    </c:choose>

    <form method="post" action="<c:url value="/chapter12/postMessage.jsp"/>">
      <p>
      <b>New message</b> <br />
      Name: <input type="text" name="name" /> <br />
      Subject: <input type="text" name="subject" /> <br />
       <textarea cols="30" rows="5" name="body"></textarea> <br />
      <input type="hidden" name="messageBoard"
        value="<c:out value="${param.messageBoard}" />" />
      <input type="submit" value="Post!" />
      </p>
    </form>

  </c:otherwise>
</c:choose>

