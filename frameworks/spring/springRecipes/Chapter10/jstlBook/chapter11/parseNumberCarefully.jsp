<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<p>You entered "<c:out value="${param.favorite}"/>". </p>

<c:catch var="parsingError">

  <fmt:parseNumber var="fav" value="${param.favorite}"/>

  <p>As far as I can tell, this corresponds to the
  number <c:out value="${fav}"/>.</p>

  <p>If you multiply this number by 2 and add 1, you get
  <c:out value="${fav * 2 + 1}"/>.  I like that number
  better.</p>
</c:catch>

<c:if test="${not empty parsingError}">
  Sorry, this doesn't look like a number to me.
  Perhaps you're in the wrong country?
</c:if>

