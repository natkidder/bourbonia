<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<c:import url="../header.jsp"/>

<h4>Chapter 12:  Dynamic features for web sites</h4>
<a href="../index.jsp">[Return to main page]</a>

<ul>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="12"/>
    <c:param name="file" value="dbSetup.jsp"/>
    <c:param name="desc" value="initializes database tables for sample apps"/>
  </c:import>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="12"/>
    <c:param name="file" value="surveyLink.html"/>
    <c:param name="desc" value="sample lead-in to survey application"/>
  </c:import>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="12"/>
    <c:param name="file" value="messageBoardLink.html"/>
    <c:param name="desc" value="sample lead-in to message board application"/>
  </c:import>
</ul>

<c:import url="../footer.jsp"/>
