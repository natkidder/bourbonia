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

<%-- Display the count --%>
Number of visitors to this page:  <c:out value="${count}"/>

