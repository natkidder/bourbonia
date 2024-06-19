<!-- Crume, p.144 -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="/core_rt" prefix="c_rt" %>
<%@ taglib uri="/format" prefix="fmt" %>

<html>
	<head>
		<title>JSTL Q2</title>
	</head>
	
	<body>
		<h1>JSTL Question 2</h1>
		<h2>How do I use the JSTL?</h2>
		
		<jsp:useBean id="questions" class="ch04.Questions">
			<jsp:setProperty name="questions" property="topic" value="EL" />
		</jsp:useBean>
		
		<table border="1">
			<!-- the literal JSTL tag will be in the left column, the evaluated JSTL tag in the right column -->
			<tr> <th>tag</th> <th>result</th> <tr>
			
			<!-- this tag uses c_rt:out to send the value of an EL to the response -->
			<tr>
				<td> &lt;c_rt:out value="${'${'}questions.topic}"/&gt; </td>
				<td><c_rt:out value="questions.topic=${questions.topic}"/></td>
			</tr>
			
			<!-- this tag uses c_rt:set to set the property of a JavaBean -->
			<tr>
				<td>
					&lt;c_rt:set target="${'${'}questions}" property="topic" value="JSTL" /&gt; 
					<c:rt:set target="${questions}" property="topic" value="JSTL" />
				</td>
				<td> < c_rt:out value="questions.topic=${questions.topic}" /> </td>
			</tr>
			
			<!-- this tag uses c_rt:if to determine whether to to create another row -->
			<c_rt:if test="${questions.topic} == 'EL'">
				<tr> <td>This row will not be created</td> <td></td> <tr>
			</c_rt:if>
			
			<c_rt:if test="${questions.topic == 'JSTL'}">  <!-- same as Crume -->
				<tr>
					<td>This row was created because the c_rt:if tag returned was true</td>
					<td></td>
				</tr>
			</c_rt:if>
		</table>
		
		<p>multiplication table, 1-5</p>
		
		<!-- use the forEach tag to create a table -->
		<table border="1">
			<tr>
				<td></td> <td>1</td> <td>2</td> <td>3</td> <td>4</td> <td>5</td>
			</tr>
			<c_rt:forEach var="i" begin="1" end="5">
				<tr>
					<td> <c_rt:out value="${i}"/></td>
					<c_rt:forEach var="j" begin="1" end="5">
						<td><c_rt:out value="${i*j}"/></td>
					</c_rt:forEach>
				</tr>
			</c_rt:forEach>
		</table>
		
		<h2>Formatting numbers</h2>
		<br>
		&lt; fmt:formatNumber value="23.456" type="number" /&gt;
		    results in <fmt:formatNumber value="23.456" type="number" />;
		<br>
		&lt;fmt:formatNumber type="currency"&gt;23.456&lt;/fmt:formatNumber&gt;
			results in <fmt:formatNumber type="currency"> 23.456 </fmt:formatNumber>
		<br>
		&lt;fmt:formatNumber value=".23456" type="percent"/&gt;
			results in <fmt:formatNumber value=".23456" type="percent" />
		<br>
		&lt:fmt:formatNumber value=".23456" type="percent" minFractionDigits="2"/&gt;
			results in <fmt:formatNumber value=".23456" type="percent" minFractionDigits="2" />
			
	</body>
</html>
