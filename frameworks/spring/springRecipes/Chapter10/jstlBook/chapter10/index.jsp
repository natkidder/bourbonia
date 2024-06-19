<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<c:import url="../header.jsp"/>

<h4>Chapter 10:  Formatting and internationalization</h4>
<a href="../index.jsp">[Return to main page]</a>

<ul>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="10"/>
    <c:param name="file" value="parseNumber.jsp?favorite=5000"/>
    <c:param name="desc" value="parses a number from a request parameter"/>
  </c:import>
</ul>

<c:import url="../footer.jsp"/>
