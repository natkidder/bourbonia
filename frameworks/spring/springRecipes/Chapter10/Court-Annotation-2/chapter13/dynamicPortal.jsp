<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
 <title> </title>
 <style>
   body,td {
    font-family: arial,verdana,helvetica,sans-serif;
    font-size: 8pt;
    vertical-align: top;
   }
   .heading {
    background-color: #444444;
    color: #ffffff;
    font-family: arial,verdana,helvetica,sans-serif;
    font-size: 12pt;
    font-stylet: bold;
   }
   h1 {
    font-size: 12pt;
    margin-bottom: 0px;
   }
   h2 {
    font-size: 10pt;
    margin-bottom: 0px;
   }
 </style>
</head>
<body>

<c:import url="header.jsp"/>

<table width="100%">

 <tr>
  <td width="40%"> 
   <c:import url="channel.jsp">
    <c:param name="headline" value="JSTL" />
    <c:param name="page" value="introText.jsp" />
   </c:import>
   <c:import url="channel.jsp">
    <c:param name="headline" value="Message board" />
    <c:param name="page" value="/chapter12/viewMessages.jsp?messageBoard=1" />
   </c:import>
  </td>
  <td width="40%">
   <c:import url="channel.jsp">
    <c:param name="headline"
      value="Internet news (from <i>internet.com</i>)" />
    <c:param name="page" value="rss.jsp" />
   <c:param name="rssUrl"
     value="http://headlines.internet.com/internetnews/top-news/news.rss" />
   </c:import>

   <c:choose>
    <c:when test="${not empty sessionScope.rss}">
     <c:set var="userRss" value="${sessionScope.rss}"/>
    </c:when>
    <c:otherwise>
     <c:set var="userRss"
       value="http://www.slashdot.org/slashdot.rdf"/>
    </c:otherwise>
   </c:choose>

   <c:import url="channel.jsp">
    <c:param name="headline" value="Current RSS feed" />
    <c:param name="page" value="rss.jsp" />
    <c:param name="rssUrl" value="${userRss}" />
   </c:import>
  </td>
  <td width="20%"> 
   <c:import url="channel.jsp">
    <c:param name="headline" value="Survey" />
    <c:param name="page" value="asksurvey.jsp" />
   </c:import>
   <c:import url="channel.jsp">
    <c:param name="headline" value="Counter" />
    <c:param name="page" value="counter.jsp" />
   </c:import>
  </td>
 </tr>

</table>

</body>
</html>
