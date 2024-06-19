<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!-- taglib prefix="html" uri="http://struts.apache.org/tags-html"  -->

<html>
	<head>
		<title>Register</title>
		<link rel="stylesheet" type="text/css" href="forms.css" />
	</head>
	<body>
	<html:errors/>
	<h3>Register -- New Profile</h3>	

	<html:form action="/ActionAddResume" method="POST" enctype="multipart/form-data"> <!-- last attribute to get file dialog box to work -->
	<jsp:useBean id="resumeAddForm" scope="session" class="app.ResumeAddForm" />
	
    First Name: <input type="text" name="firstName" size="30" value="<bean:write name="resumeAddForm" property="firstName"/>"/>
    &nbsp;&nbsp;MI: <input type="text" name="mi" size="1" value="<bean:write name="resumeAddForm" property="mi"/>"/>
    &nbsp;&nbsp;Last Name: <input type="text" name="lastName" size="30" value="<bean:write name="resumeAddForm" property="lastName"/>"/>
    
    <table>
    <tr>
    	<td align="right">Currently employed?</td>
    	<td>
   	    <html:select property="currEmployed">
			<html:options collection="listCurrEmpl" property="value" labelProperty="label" />
    	</html:select>
    	</td>
    </tr>
    </table>
    <table>
    <tr><td align="right"><b>Address</b></td></tr>
    <tr>
        <td align="right">Street:</td>
        <td align="left"><input type="text" name="street" size="50" value="<bean:write name="resumeAddForm" property="street"/>"/></td>
    </tr>
    <tr>
    	<td align="right">Apt, Suite, etc.:</td>
    	<td align="left"><input type="text" name="apt" size="30"  value="<bean:write name="resumeAddForm" property="apt"/>"/></td>
    </tr>
    </table>
    <table>
    <tr>
    	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td></td>
    	<td align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;City:</td>
    	<td align="left"><input type="text" name="city" length="20" value="<bean:write name="resumeAddForm" property="city"/>"/></td>
    	<td align="right">State:</td>
    	<td>
    	<html:select property="state">
			<html:options collection="listStates" property="value" labelProperty="label" />
    	</html:select>
    	</td>
     	<td align="right">Zip:</td>
    	<td align="left"><input type="text" name="zip" length="10" value="<bean:write name="resumeAddForm" property="zip"/>"/></td>
    </tr>
    </table>
    <table>
    <tr><td><b>Contact Information</b></td></tr>
    <tr>
    	<td align="right">Home:</td>
    	<td align="left"><input type="text" name="hphone" length="20" value="<bean:write name="resumeAddForm" property="hphone"/>"/></td>
    	<td align="right">Office:</td>
    	<td align="left"><input type="text" name="ophone" length="20" value="<bean:write name="resumeAddForm" property="ophone"/>"/></td>
    	<td align="right">Cell:</td>
    	<td align="left"><input type="text" name="cphone" length="20" value="<bean:write name="resumeAddForm" property="cphone"/>"/></td>
    </tr>
    </table>
    
    <table>
    <tr>
        <td align="right">Sex:</td>
    	<td>
   	    <html:select property="gender">
			<html:options collection="listGender" property="value" labelProperty="label" />
    	</html:select>
        </td>   
        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
        <td align="right">&nbsp;&nbsp;Date of Birth</td><td width="20"/>
        <td align="right">Month:</td>
    	<td> 
   	    <html:select property="birthMth">
			<html:options collection="listMth" property="value" labelProperty="label" />
    	</html:select>
    	</td>    
    	<td align="right">Day:</td>
    	<td> 
   	    <html:select property="birthDay">
			<html:options collection="listDay" property="value" labelProperty="label" />
    	</html:select>
		</td>
    	<td align="right">Year:</td>
    	<td> 
   	    <html:select property="birthYr">
			<html:options collection="listYr" property="value" labelProperty="label" />
    	</html:select>
		</td>    
    </tr>
    </table>
    <table>
    	<tr>
        	<td align="right">* Email (This will be your login):</td>
    		<td align="left"><input type="text" name="email" size="30" value="<bean:write name="resumeAddForm" property="email"/>"></td>
     	</tr>
    </table>
    <table>
    	<tr>
         	<td align="right">* Password:</td>
    		<td align="left"><input type="password" name="passwd1" size="15"></td>
    	</tr>
    	<tr>
         	<td align="right">* Re-Enter Password:</td>
    		<td align="left"><input type="password" name="passwd2" size="15"></td>
    	</tr>
    </table>
    <p>* indicates required field</p>
 
<!--   
    <html:submit property="step" >
    	<bean:message key="button.save"/>
    </html:submit>

<html:submit value="Add Resume"/>   
 -->

	<input type="submit" name="step" value="Submit"/>
	<input type="submit" name="step" value="Home"/>

    </html:form>
	
	</body>
</html>