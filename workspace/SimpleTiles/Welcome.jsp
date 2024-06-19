<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<HTML>
<HEAD>
<TITLE>Welcome!</TITLE>
<html:base/>
</HEAD>
<BODY>
<H3>Welcome World!</H3>
<html:errors/>
<UL>
<LI><html:link forward="logon">Sign in</html:link></LI>
<logic:present name="user">
<LI><html:link forward="logoff">Sign out</html:link></LI>
</logic:present>
</UL>
<IMG src='designed_by_jv.jpg' alt='Powered by Struts'>
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
