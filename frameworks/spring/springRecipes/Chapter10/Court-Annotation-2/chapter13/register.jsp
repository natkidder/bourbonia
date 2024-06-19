<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<c:if test="${param.submitted}">
  <c:if test="${empty param.name}" var="noName" />
  <c:if test="${empty param.pw}" var="noPw" />
  <c:if test="${empty param.url}" var="noUrl" />

  <c:if
   test="${not (noName or noPw or noUrl or 
                requestScope.takenName)}">
    <c:set value="${param.name}" var="name" scope="request"/>
    <c:set value="${param.pw}" var="pw" scope="request"/>
    <c:set value="${param.url}" var="url" scope="request"/>
    <jsp:forward page="doRegister.jsp" />
  </c:if>
</c:if>

<html>

<head>
 <style>
   body, td {
    font-family: arial,verdana,helvetica,sans-serif;
    font-size: 8pt;
    vertical-align: top;
   }
  </style>
</head>
<body>
<h1>Welcome to the JSTL portal.</h1>
<p><b>To sign up for an account, please enter the information
below.  All fields are required.</b></p>

<form method="post">
<input type="hidden" name="submitted" value="true" />
<table>
 <tr>
  <td>Enter a username:</td>
  <td>
    <input type="text" name="name" size="10"
      value="<c:out value="${param.name}"/>"
    />
    <c:if test="${noName}">
      <br /><font color="red">You must enter a username</font>
    </c:if>
    <c:if test="${requestScope.takenName}">
      <br /><font color="red">Sorry, that username 
        is already taken. Please choose another.</font>
    </c:if>
  </td>
 </tr>
 <tr>
  <td>Enter a password:</td>
  <td>
    <input type="password" name="pw" size="10"
      value="<c:out value="${param.pw}"/>"
    />
    <c:if test="${noPw}">
      <br /><font color="red">You must enter a password</font>
    </c:if>
  </td>
 </tr>
 <tr>
  <td>Enter the URL for <br />your favorite RSS channel:</td>
  <td>
    <input type="text" name="url" size="40"
      value="<c:out value="${param.url}"/>"
    />
    <c:if test="${noUrl}">
      <br /><font color="red">You must enter a url</font>
    </c:if>
  </td>
 </tr>
</table>
<input type="submit" value="Register!" />
</form>

</body>
</html> 

