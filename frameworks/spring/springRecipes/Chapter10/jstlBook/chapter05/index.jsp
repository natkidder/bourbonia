<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<c:import url="../header.jsp"/>

<h4>Chapter 5:  Controlling flow with loops</h4>
<a href="../index.jsp">[Return to main page]</a>

<ul>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="05"/>
    <c:param name="file" value="scroll.jsp"/>
    <c:param name="desc" value="<i>paging</i> through numbers"/>
  </c:import>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="05"/>
    <c:param name="file" value="scrollAlternate.jsp"/>
    <c:param name="desc" value="<i>paging</i> through numbers, alternating rows"/>
  </c:import>
</ul>

<c:import url="../footer.jsp"/>
