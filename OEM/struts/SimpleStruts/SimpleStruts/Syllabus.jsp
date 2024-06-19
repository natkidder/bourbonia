<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<HTML>
<HEAD>
<TITLE>Your J2EE Syllabus</TITLE>
<html:base/>
</HEAD>
<BODY>
<logic:present name="user">
<H3>Welcome <bean:write name="user" property="username"/>!</H3>
</logic:present>
<logic:notPresent scope="session" name="user">
<H3>Welcome World!</H3>
</logic:notPresent>
<html:errors/>

<P>
<H2>Core Java Programming</H2><BR>
Introduction to Java and language fundamentals<BR>
Declaration and Access Control<BR>
Operators and Assignments<BR>
Flow control and Exceptions<BR>
Object orientation, Overloading and Overriding, Constructors and Return types<BR>
java.lang.* - The Math class, String and Wrappers<BR>
Collections<BR>
Threads<BR>
<BR><BR>


<UL>
<LI><html:link forward="logon">Sign in</html:link></LI>
<logic:present name="user">
<LI><html:link forward="logoff">Sign out</html:link></LI>
</logic:present>
</UL>
<IMG src='designed_by_jv.jpg' alt='Designed by Jay & Venkat - JTutor.net'>
</BODY>
</HTML>

<%--

If user is logged in, display "Welcome ${username}!"
Else display "Welcome World!"
Display link to log in page; maintain session id if needed.
If user is logged in, display a link to the sign-out page.

Note: Only the minimum required html or Struts custom tags 
are used in this example.

--%>
