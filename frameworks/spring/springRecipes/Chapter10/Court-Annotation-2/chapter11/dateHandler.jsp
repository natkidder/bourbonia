<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<fmt:parseDate
  var="date"
  parseLocale="en_US"
  value="${param.month} ${param.day}, ${param.year}"/>

You were born
<fmt:formatDate
  value="${date}"
  dateStyle="full"/>.

