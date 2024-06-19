<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>

<c:import var="xml" url="${param.rssUrl}"/>
<x:parse var="rss" xml="${xml}" />

<ul>
<x:forEach select="$rss//*[name()='item']">
  <li>
    <a href="<x:out select="./*[name()='link']"/>">
      <x:out select="./*[name()='title']" />
    </a>
    <blockquote>
       <x:set var="newUrl" select="string(./*[name()='link'])" />
       <c:import url="${newUrl}"/>
    </blockquote>
  </li>
</x:forEach>
</ul> 

