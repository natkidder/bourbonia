<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<c:import url="../header.jsp"/>

<h4>Chapter 11:  Common tasks</h4>
<a href="../index.jsp">[Return to main page]</a>

<ul>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="11"/>
    <c:param name="file" value="checkboxForm.html"/>
    <c:param name="desc" value="form that submits data to checkbox.jsp"/>
  </c:import>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="11"/>
    <c:param name="file" value="dateForm.jsp"/>
    <c:param name="desc" value="form that submits data to dateHandler.jsp"/>
  </c:import>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="11"/>
    <c:param name="file" value="formCycle.jsp"/>
    <c:param name="desc" value="form that accepts input until it is valid"/>
  </c:import>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="11"/>
    <c:param name="file" value="useErrorPage.jsp"/>
    <c:param name="desc" value="uses a sample error page"/>
  </c:import>
</ul>

<c:import url="../footer.jsp"/>
