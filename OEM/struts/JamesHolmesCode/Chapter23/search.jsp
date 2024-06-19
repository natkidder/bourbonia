<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
<head>
<title>ABC, Inc. Human Resources Portal - Employee Search</title>
<script language="JavaScript">
  var request;

  function getCount() {
    var url = "/MiniHr/count.do";
  
    // Perform the AJAX request using a non-IE browser.
    if (window.XMLHttpRequest) {
      request = new XMLHttpRequest();
      
      // Register callback function that will be called when
      // the response is generated from the server.
      request.onreadystatechange = updateCount;
      
      try {
      	request.open("GET", url, true);
      } catch (e) {
         alert("Unable to connect to server to retrieve count.");
      }

      request.send(null);
    // Perform the AJAX request using an IE browser.
    } else if (window.ActiveXObject) {
      request = new ActiveXObject("Microsoft.XMLHTTP");
      
      if (request) {
      	// Register callback function that will be called when
        // the response is generated from the server.
        request.onreadystatechange = updateCount;
        
        request.open("GET", url, true);
        request.send();
      }
    }
  }
  
  // Callback function to update page with count retrieved from server.
  function updateCount() {
    if (request.readyState == 4) {
      if (request.status == 200) {
      	var count = request.responseText;

        document.getElementById('employeeCount').innerHTML = count;
      } else {  
        alert("Unable to retrieve count from server.");
      }
    }    
  }
</script>
</head>
<body>

<font size="+1">
ABC, Inc. Human Resources Portal - Employee Search
</font><br>
<hr width="100%" noshade="true">

<html:errors/>

<html:form action="/search">

<table>
<tr>
<td align="right">Current Employee Count:</td>
<td>
  <i><span id="employeeCount">?</span></i>
  <input type="button" value="Get Count" onclick="getCount();">
</td>
</tr>
<tr>
<td colspan="2"><br></td>
</tr>
<tr>
<td align="right"><bean:message key="label.search.name"/>:</td>
<td><html:text property="name"/></td>
</tr>
<tr>
<td></td>
<td>-- or --</td>
</tr>
<tr>
<td align="right"><bean:message key="label.search.ssNum"/>:</td>
<td><html:text property="ssNum"/> (xxx-xx-xxxx)</td>
</tr>
<tr>
<td></td>
<td><html:submit/></td>
</tr>
</table>

</html:form>

<logic:present name="searchForm" property="results">

<hr width="100%" size="1" noshade="true">

<bean:size id="size" name="searchForm" property="results"/>
<logic:equal name="size" value="0">
<center><font color="red"><b>No Employees Found</b></font></center>
</logic:equal>

<logic:greaterThan name="size" value="0">
<table border="1">
<tr>
<th>Name</th>
<th>Social Security Number</th>
</tr>
<logic:iterate id="result" name="searchForm" property="results">
<tr>
<td><bean:write name="result" property="name"/></td>
<td><bean:write name="result" property="ssNum"/></td>
</tr>
</logic:iterate>
</table>
</logic:greaterThan>

</logic:present>

</body>
<html>