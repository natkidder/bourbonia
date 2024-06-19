<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>

<sql:transaction>

  <sql:update>
    update counter set counter = counter + 1
  </sql:update>
  <sql:query var="result">
    select * from counter
  </sql:query>
  <c:set var="count" value="${result.rows[0].counter}" />

</sql:transaction>

<p>
  This site has been accessed
  <b><c:out value="${count}" /></b>
  times!
</p>

<p>
 <a target="_blank"
   href="<c:url value="/chapter12/viewMessages.jsp">
           <c:param name="messageBoard" value="3"/>
         </c:url>">
  Discuss this counter
 </a>
</p>

