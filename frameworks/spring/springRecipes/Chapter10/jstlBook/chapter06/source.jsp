<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<c:set var="input" scope="request" value="INPUT TEXT" />
Calling target.jsp...
<hr />
<c:import url="target.jsp" />
<hr />
source.jsp received back: <c:out value="${requestScope.output}" />

