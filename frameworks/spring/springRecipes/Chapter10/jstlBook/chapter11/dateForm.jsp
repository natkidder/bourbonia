<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<form method="post" action="dateHandler.jsp">

  Please enter your birthday:

  <select name="month">
    <option value="Jan">January</option>
    <option value="Feb">February</option>
    <option value="Mar">March</option>
    <option value="Apr">April</option>
    <option value="May">May</option>
    <option value="Jun">June</option>
    <option value="Jul">July</option>
    <option value="Aug">August</option>
    <option value="Sep">September</option>
    <option value="Oct">October</option>
    <option value="Nov">November</option>
    <option value="Dec">December</option>
  </select>

  <select name="day">
    <c:forEach begin="1" end="31" var="day">
      <option><c:out value="${day}"/></option>
    </c:forEach>
  </select>

  <select name="year">
    <c:forEach begin="1930" end="2003" var="year">
      <option><c:out value="${year}"/></option>
    </c:forEach>
  </select>

  <input type="submit" value="Submit" />

</form>

