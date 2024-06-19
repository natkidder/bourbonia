<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<c:import url="../header.jsp"/>

<h4>Chapter 8:  Working with XML fragments</h4>
<a href="../index.jsp">[Return to main page]</a>

<ul>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="08"/>
    <c:param name="file" value="transform.jsp"/>
    <c:param name="desc" value="example of XSLT transformation within JSTL page"/>
  </c:import>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="08"/>
    <c:param name="file" value="simpleRss.jsp?rssUrl=http://politicalwire.com/headlines.xml"/>
    <c:param name="desc" value="naive Rich Site Summary (RSS) viewer"/>
  </c:import>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="08"/>
    <c:param name="file" value="rss.jsp?rssUrl=http://www.slashdot.org/slashdot.rdf"/>
    <c:param name="desc" value="complete Rich Site Summary (RSS) viewer"/>
  </c:import>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="08"/>
    <c:param name="file" value="rssFollow.jsp?rssUrl=http://politicalwire.com/headlines.xml"/>
    <c:param name="desc" value="experimental RSS viewer that follows links in an RSS file"/>
  </c:import>
</ul>

<c:import url="../footer.jsp"/>
