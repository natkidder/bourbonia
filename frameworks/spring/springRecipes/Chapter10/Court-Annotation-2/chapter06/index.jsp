<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<c:import url="../header.jsp"/>

<h4>Chapter 6:  Importing text</h4>
<a href="../index.jsp">[Return to main page]</a>

<ul>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="06"/>
    <c:param name="file" value="page1.jsp"/>
    <c:param name="desc" value="headers and footers: sample page #1"/>
  </c:import>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="06"/>
    <c:param name="file" value="page2.jsp"/>
    <c:param name="desc" value="headers and footers: sample page #2"/>
  </c:import>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="06"/>
    <c:param name="file" value="source.jsp"/>
    <c:param name="desc" value="communication using scoped variables"/>
  </c:import>
</ul>

<c:import url="../footer.jsp"/>
