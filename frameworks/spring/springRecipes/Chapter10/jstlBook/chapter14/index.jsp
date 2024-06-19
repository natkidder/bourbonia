<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<c:import url="../header.jsp"/>

<h4>Chapter 14:  Control and performance</h4>
<a href="../index.jsp">[Return to main page]</a>

<ul>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="14"/>
    <c:param name="file" value="scriptfree.tld"/>
    <c:param name="excludeLink" value="true"/>
    <c:param name="desc" value="sample TLD for JSTL's ScriptFreeTLV"/>
  </c:import>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="14"/>
    <c:param name="file" value="permitted.tld"/>
    <c:param name="excludeLink" value="true"/>
    <c:param name="desc" value="sample TLD for JSTL's PermittedTaglibsTLV"/>
  </c:import>
</ul>

<c:import url="../footer.jsp"/>
