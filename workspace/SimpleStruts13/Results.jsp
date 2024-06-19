<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>

<%@ page import="pdata.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<%@ page isELIgnored ="false" %> 

<html:html>
<body bgcolor="lightblue">
    <h3>My First Struts Application </h3>
    <ul> 
        <li>${personalDataBean.firstname} </li> 
        <li>${personalDataBean.lastname} </li>
        <li>${personalDataBean.address} </li>
        <li>${personalDataBean.city} </li>
        <li>${personalDataBean.state} </li>
    </ul> <br>
</body>
</html:html> 
