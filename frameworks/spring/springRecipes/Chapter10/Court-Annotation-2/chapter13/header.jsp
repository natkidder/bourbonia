<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<table width="100%">
<tr>
 <td>
  <h1>The JSTL portal</h1>
  <c:choose>
   <c:when test="${empty sessionScope.user}">
    Welcome, <b>guest</b>!
   </c:when>
   <c:otherwise>
    Welcome back, <b><c:out value="${sessionScope.user}"/></b>!
   </c:otherwise>
  </c:choose>
 </td>
 <td align="right">
 <c:if test="${empty sessionScope.user}">
  <form method="post" action="login.jsp">						
   User: <input type="text" name="user" size="10" />				
   Password: <input type="password" name="pw" size="10" />			
   <input type="submit" value="Log in" />						
   <a href="register.jsp">New user?</a>						
  </form>											
 </c:if>
 </td>
</tr>
</table>
<hr />

