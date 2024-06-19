<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<c:import url="../header.jsp"/>

<h4>Chapter 15:  Using JSTL to develop custom tags</h4>
<a href="../index.jsp">[Return to main page]</a>

<ul>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="15"/>
    <c:param name="file" value="Weekday.java"/>
    <c:param name="excludeLink" value="true"/>
    <c:param name="desc" value="simple conditional method"/>
  </c:import>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="15"/>
    <c:param name="file" value="WeekdayTag.java"/>
    <c:param name="excludeLink" value="true"/>
    <c:param name="desc" value="simple conditional tag"/>
  </c:import>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="15"/>
    <c:param name="file" value="TimeTag.java"/>
    <c:param name="excludeLink" value="true"/>
    <c:param name="desc" value="more advanced conditional tag"/>
  </c:import>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="15"/>
    <c:param name="file" value="ForEachLineTag.java"/>
    <c:param name="excludeLink" value="true"/>
    <c:param name="desc" value="custom loop tag"/>
  </c:import>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="15"/>
    <c:param name="file" value="book.tld"/>
    <c:param name="excludeLink" value="true"/>
    <c:param name="desc" value="TLD for sample tags"/>
  </c:import>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="15"/>
    <c:param name="file" value="useWeekdayTag.jsp"/>
    <c:param name="desc" value="weekday tag in action"/>
  </c:import>
  <c:import url="/link.jsp">
    <c:param name="chapter" value="15"/>
    <c:param name="file" value="useTimeTag.jsp"/>
    <c:param name="desc" value="time tag in action (will not print anything for many periods of time)"/>
  </c:import>
</ul>

<c:import url="../footer.jsp"/>
