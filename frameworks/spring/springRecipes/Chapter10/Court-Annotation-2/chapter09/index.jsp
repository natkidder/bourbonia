<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<c:import url="../header.jsp"/>

<h4>Chapter 9:  Database-driven pages</h4>
<a href="../index.jsp">[Return to main page]</a>

<ul>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="09"/>
    <c:param name="file" value="printQuery.jsp"/>
    <c:param name="excludeLink" value="true" />
    <c:param name="desc" value="generic query printer (not meant to be run directly)"/>
  </c:import>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="09"/>
    <c:param name="file" value="dbSetup.jsp"/>
    <c:param name="desc" value="initializes counter table for counter.jsp page"/>
  </c:import>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="09"/>
    <c:param name="file" value="counter.jsp"/>
    <c:param name="desc" value="sample counter (must set up database first before running)"/>
  </c:import>
</ul>

<c:import url="../footer.jsp"/>
