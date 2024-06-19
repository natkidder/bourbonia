<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<c:import url="../header.jsp"/>

<h4>Chapter 13:  Case study in building a web site</h4>
<a href="../index.jsp">[Return to main page]</a>

<ul>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="13"/>
    <c:param name="file" value="dbSetup.jsp"/>
    <c:param name="desc" value="sets up the portal's user database."/>
  </c:import>
   <b>Note:</b> You should also run 'dbSetup.jsp' from chapter 12.
  <c:import url="/link.jsp">
    <c:param name="chapter" value="13"/>
    <c:param name="file" value="simplePortal.jsp"/>
    <c:param name="desc" value="simple, static portal"/>
  </c:import>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="13"/>
    <c:param name="file" value="dynamicPortal.jsp"/>
    <c:param name="desc" value="dynamic portal"/>
  </c:import>
</ul>

<c:import url="../footer.jsp"/>
