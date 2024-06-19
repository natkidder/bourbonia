<!--
  Displays the content of the file specified in request
  parameter "filename".
  <%-- Warning!  Can be used to retrieve the source code for
       any file in the 'standard-examples' application.
       It is not advisable to insert any sensitive code
       (even as an experiment) into this application --%>
-->

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<%-- 
  Let's get back the URL as a String so we can use it to
  demonstrate "c:import"
--%>
<% 
   String target = request.getParameter("filename");
   if (target.indexOf("?") != -1)
     target = target.substring(0, target.indexOf("?"));
   pageContext.setAttribute("filename", target);
   pageContext.setAttribute("filepath", application.getResource(target));
%>

<html>
<head>
  <title>Source code for <c:out value="${filename}"/></title>
</head>
<body bgcolor="#FFFFFF">
<h3>Source code for:&nbsp; <c:out value="${filename}"/></h3>
<hr />
<c:import url="${filepath}" var="source"/>
<pre>
<c:out value="${source}"/>
<hr />
</pre>
</body>
</html>
