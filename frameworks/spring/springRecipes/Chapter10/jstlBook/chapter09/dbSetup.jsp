<%--
  Run this file before using the other JSP pages in this directory to
  set up your database tables.
--%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>

<%-- Sets up 'counter' table --%>
<sql:update>
  create table counter (
    counter integer
  )
</sql:update>
<sql:update>
  insert into counter(counter) values(0)
</sql:update>

