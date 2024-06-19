<%-- 
    Document   : fileUpload
    Created on : Feb 18, 2009, 7:12:59 PM
    Author     : eswar@vaannila.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File Upload</title>
    </head>
    <body>
        <html:errors />
        <html:form action="/fileUploadAction" method="post" enctype="multipart/form-data">
            File : <html:file property="fileSelected" size="50" /> <br/>
            <html:submit />
        </html:form>
    </body>
</html>
