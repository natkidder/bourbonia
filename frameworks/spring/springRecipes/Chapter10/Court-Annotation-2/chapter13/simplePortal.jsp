<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
 <title>The Nasal Irrigation Alliance</title>
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
<h1>The Nasal Irrigation Alliance</h1>
<hr />

<table width="100%">

 <tr>
  <td width="60%">
   <c:import url="channel.jsp">
    <c:param name="headline" value="Welcome" />
    <c:param name="page" value="welcome.html" />
   </c:import>
   <c:import url="channel.jsp">
    <c:param name="headline" value="Testimonials" />
    <c:param name="page" value="quotes.html" />
   </c:import>
  </td>
  <td width="40%">
   <c:import url="channel.jsp">
    <c:param name="headline" value="Poem of the day" />
    <c:param name="page" value="poetry.html" />
   </c:import>
   <c:import url="channel.jsp">
    <c:param name="headline" value="Links" />
    <c:param name="page" value="links.html" />
   </c:import>
  </td>
 </tr>

</table>

</body>
</html> 

