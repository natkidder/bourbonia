<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>

<c:choose>
  <c:when test="${empty param.messageBoard or
                  empty param.name or
                  empty param.subject or
                  empty param.body}">
    <font color="red">
      Error: you need to enter a name and subject.  Please
      go back and try again.
    </font>
  </c:when>
  <c:otherwise>

    <jsp:useBean id="currentDate"
      class="java.util.Date"/>

    <sql:update>
     insert into
       messages(message_board, sent_date, author, subject, body)
       values(?, ?, ?, ?, ?)
     <sql:param value="${param.messageBoard}"/>
     <sql:dateParam value="${currentDate}"/>
     <sql:param value="${param.name}"/>
     <sql:param value="${param.subject}"/>
     <sql:param value="${param.body}"/>
    </sql:update>

    <jsp:forward page="viewMessages.jsp" />
  </c:otherwise>
</c:choose>

