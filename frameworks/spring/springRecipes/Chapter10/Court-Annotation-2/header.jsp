<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

<title>JSP Standard Tag Library: Learning JSTL</title>
<style type="text/css">
<!--
body {
 Font-family: Arial,Helvetica,sans-serif;
 font-size: 13px;
 font-style: normal;
 line-height: normal;
 font-weight: normal;
 color: #000000;
 text-decoration: none
 background:transparent;
}

td {
 font-family: Arial,Helvetica,sans-serif;
 font-size: 13px;
 font-style: normal;
 line-height: normal;
 font-weight: normal;
 color: #000000;
 text-decoration: none
 background:transparent;
}

th {
 font-family: Arial,Helvetica,sans-serif;
 font-size: 13px;
 font-style: normal;
 line-height: normal;
 font-weight: bold;
 color: #000000;
 text-decoration: none
 background:transparent;
}

.normal {
 Font-family: Arial,Helvetica,sans-serif;
 font-size: 13px;
 font-style: normal;
 line-height: normal;
 font-weight: normal;
 color: #000000;
 text-decoration: none
 background:transparent;
}

.menu {
 font-family: Arial,Helvetica,sans-serif;
 font-size: 10px;
 font-style: normal;
 line-height: normal;
 font-weight: normal;
 color: #cc0000;
 text-decoration: none
 background:transparent;
}

.menublack {
 font-family: Arial,Helvetica,sans-serif;
 font-size: 10px;
 font-style: normal;
 line-height: normal;
 font-weight: normal;
 color: #000000;
 text-decoration: none
 background:transparent;
}

.menubold {
 font-family: Arial,Helvetica,sans-serif;
 font-size: 11px;
 font-style: normal;
 line-height: normal;
 font-weight: bold;
 color: #000000;
 text-decoration: none
 background:transparent;
}

.menugrey {
 font-family: Arial,Helvetica,sans-serif;
 font-size: 10px;
 font-style: normal;
 line-height: normal;
 font-weight: normal;
 color: #999999;
 text-decoration: none
 background:transparent;
}

b {
 font-family: Arial,Helvetica,sans-serif;
 font-size: 13px;
 font-style: normal;
 line-height: normal;
 font-weight: bold;
 color: #000000;
 text-decoration: none
 background:transparent;
}

a:link {
 font-family: Arial,Helvetica,san-serif;
 font-style: normal;
 line-height: normal;
 color: #cc0000;
 text-decoration: none;
 background:transparent;
}

a:visited {
 font-family: Arial,Helvetica,san-serif;
 font-style: normal;
 line-height: normal;
 color: #cc0000;
 text-decoration: none;
 background:transparent;
}

a:hover {
 text-decoration:underline;
}
-->
</style>

</head>
<body bgcolor="#ffffff">


<table border=0 cellpadding=0 cellspacing=0 width=100%>
<tr>
<td align="right" width=150>
<a name="top_of_page">
<img src="<c:url value="/images/dance_small.gif"/>" hspace="0" vspace="0">
</a></td>

<td width=20><img src="<c:url value="/images/spacer.gif"/>" width="16" hspace="0" vspace="0" height="1"></td>

<td valign=top align="center">
<a href="http://www.manning.com"><img src="<c:url value="/images/logo.gif"/>" border=0 alt="Manning Publications"></a>
</td>
</tr>


<tr><td><img src="<c:url value="/images/spacer.gif"/>" width="130" hspace="0" vspace="0" height="12"></td></tr>

<tr>
<td valign=top align="right" width=150>

<!-- left column table -->
<table cellpadding=0 cellspacing=0 border=0 align=right>

<tr><td align=right><div class="menubold">JSP&nbsp;Standard<br>Tag&nbsp;Library:<br>Learning&nbsp;JSTL</td>
<tr><td>&nbsp;</td>

<tr><td align=right><div class="menubold">Inside&nbsp;the&nbsp;book</div></td>
<tr><td align=right><div class="menu"><a 
href="http://www.manning.com/getpage.html?project=bayern&filename=contents.html">Table&nbsp;of&nbsp;Contents</a></div></td>

<tr><td>&nbsp;</td>

<tr><td align=right><div class="menubold">About&nbsp;the&nbsp;book</div></td>
<tr><td align="right"><div class="menu"><a href="http://www.manning.com/bayern/index.html#author">About&nbsp;the&nbsp;author</a></div></td>
<tr><td>&nbsp;</td><tr><td align="right"><div class="menubold"><a href="http://www.manning.com">The Publisher</a></div></td>
<tr><td align="right"><div class="menu"><a href="http://www.manning.com/forthcoming.html">In&nbsp;press</a></div></td>
<tr><td align="right"><div class="menu"><a href="http://www.manning.com/development.html">Under&nbsp;development</a></div></td>
<tr><td align="right"><div class="menu"><a href="http://www.manning.com/newbooks.html">Recently&nbsp;published</a></div></td>
<tr><td align="right"><div class="menu"><a href="http://www.manning.com/ebooks.html">ebooks</a></div></td>
<tr><td align="right"><div class="menu"><a href="http://www.manning.com/catalog_subject.html">Catalog</a></div></td>
<tr><td align="right"><div class="menu"><a href="http://www.manning.com/comments.html">Contact us</a></div></td>


<tr><td>&nbsp;</td><tr><td align=right><div class="menubold"><a href="http://www.manning.com/mcart/orderpage.html?project=bayern"> Order</a></div></td>
</table>
</td>

<td></td>
<!-- column 3 -->
<td valign=top>
<table border=0>
<tr><td valign=top>
<img src="<c:url value="/images/cover150.jpg"/>" alt="JSP Standard Tag Library: Learning JSTL" height=180 width=150 hspace=0 border=0></td>

<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td valign=top>
<b><font size=+1>JSP Standard Tag Library: Learning JSTL</font></b><br><b><a href="#author">Shawn Bayern</a></b><br><br>June 2002, Softbound, 400 pages<br>
ISBN 1930110529<br>
<p>
You can order this book from your bookstore<br>
by using the ISBN and title listed above.
</td>
</table>

<p>

<table border="0" cellpadding="0" cellspacing="0" hspace="3" vspace="3" width="280" align="right">
<tr><td align=center>
<a href="http://www.manning.com/mcart/orderpage.html?project=bayern"><image src="<c:url value="/images/stay2.jpg"/>" height=43 width=200 alt="Join the Mailing List" border=0></a>
</td>
<tr><td align=center>
<b><font size=-1>
JOIN THE MAILING LIST
</b>
</td>
</table>
<table border=0 vspace=3 cellpadding=10 cellspacing=0>
<tr bgcolor="#e0e0ee" align=center> 
<td>Visit the Author's book site: <a 
href="http://www.jstlbook.com">www.jstlbook.com</a>
</td>
</tr>
</table>

<br /> <br />
