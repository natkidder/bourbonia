<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>

<c:import var="xml" url="${param.rssUrl}" />
<x:parse var="rss" xml="${xml}" />

<ul>
<x:forEach select="$rss//item">
  <li>
    <a href="<x:out select="link"/>">
      <x:out select="title"/>
    </a>
  </li>
</x:forEach>
</ul>

