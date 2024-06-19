<%--
  Run this file before using the other JSP pages in this directory to
  set up your database tables.
--%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>


<%-- Sets up 'survey_results' table --%>
<sql:update>
  create table survey_results (
    survey_id integer,
    choice varchar(30)
  )
</sql:update>

<%-- Sets up 'messages' table --%>
<sql:update>
  create table messages (
    message_board integer,
    sent_date timestamp,
    author varchar(30),
    subject varchar(30),
    body varchar(255)
  )
</sql:update>
