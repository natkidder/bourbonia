<%--
  Run this file before using the other JSP pages in this directory to
  set up your database tables.
--%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>

<%-- Sets up 'user' table --%>
<sql:update>
  create table users (
    user varchar(20) primary key,
    password varchar(20) not null,
    rss varchar(255) not null
  )
</sql:update>
