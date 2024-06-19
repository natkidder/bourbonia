<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!-- taglib prefix="html" uri="http://struts.apache.org/tags-html"  -->

<html:html>
<head>
    <title>Form for entering Personal Data</title>
    <html:base />
</head>

<body>
    <html:form method="post" action="/Results">
        <table border="0">
            <tr> 
                <td width="50">
                    <bean:message key="${personalData.add.firstname}"/>
                </td>
                <td> 
                    <html:text property = "firstname" size = "30"/>
                </td>
            </tr>
            <tr> 
                <td width="35">
                    <bean:message key="personalData.add.lastname"/>
                </td>
                <td> 
                    <html:text property="lastname" size="30"/>
                </td>
            </tr>
            <tr> 
                <td width="35">
                    <bean:message key="personalData.add.address"/>
                </td> 
                <td> 
                    <html:text property="address" size="80"/>
                </td>
            </tr>
            <tr> 
                <td width="35">
                    <bean:message key="personalData.add.city"/>
                </td>
                <td>
                    <html:text property="city" size="30"/>
                </td>
            </tr>
            <tr>
                <td width="35">
                    <bean:message key="personalData.add.state"/>
                </td> 
                <td>
                    <html:text property="state" size="30"/>
                </td>
            </tr>
        </table>

        <br />

        <html:submit>
            <bean:message key="personalData.add.submit"/> 
        </html:submit>

    </html:form>

</body>
</html:html> 