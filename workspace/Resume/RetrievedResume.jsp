<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!-- taglib prefix="html" uri="http://struts.apache.org/tags-html"  -->

<html>
	<head><title>User Profile</title>
	<link rel="stylesheet" type="text/css" href="forms.css" />
	</head>
	<body>
	<html:errors/>

	<h3>User Profile</h3>	

	<html:form action="/ActionUpdResume" method="POST" enctype="multipart/form-data">
	<jsp:useBean id="resumeUpdForm" scope="session" class="app.ResumeUpdForm" />

    First Name: <input type="text" name="firstName" size="30" value="<bean:write name="resumeUpdForm" property="firstName"/>"/>

    &nbsp;&nbsp;MI: <input type="text" name="mi" size="1" value="<bean:write name="resumeUpdForm" property="mi"/>"/>
    &nbsp;&nbsp;Last Name: <input type="text" name="lastName" size="30" value="<bean:write name="resumeUpdForm" property="lastName"/>"/>
    
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
        <td align="left"><input type="text" name="street" size="50" value="<bean:write name="resumeUpdForm" property="street"/>"/></td>
    </tr>
    <tr>
    	<td align="right">Apt, Suite, etc.:</td>
    	<td align="left"><input type="text" name="apt" size="30" value="<bean:write name="resumeUpdForm" property="apt"/>"/></td>
    </tr>
    </table>
    <table>
    <tr>
    	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td></td>
    	<td align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;City:</td>
    	<td align="left"><input type="text" name="city" length="20" value="<bean:write name="resumeUpdForm" property="city"/>"/></td>
    	<td align="right">State:</td>
    	<td>
    	  	<html:select property="state">
				<html:options collection="listStates" property="value" labelProperty="label" />
    		</html:select>
		</td>
     	<td align="right">Zip:</td>
    	<td align="left"><input type="text" name="zip" length="10" value="<bean:write name="resumeUpdForm" property="zip"/>"/></td>
    </tr>
    </table>
    <table>
    <tr><td><b>Contact Information</b></td></tr>
    <tr>
    	<td align="right">Home:</td>
    	<td align="left"><input type="text" name="hphone" length="20" value="<bean:write name="resumeUpdForm" property="hphone"/>"/></td>
    	<td align="right">Office:</td>
    	<td align="left"><input type="text" name="ophone" length="20" value="<bean:write name="resumeUpdForm" property="ophone"/>"/></td>
    	<td align="right">Cell:</td>
    	<td align="left"><input type="text" name="cphone" length="20" value="<bean:write name="resumeUpdForm" property="cphone"/>"/></td>
    </tr>
    </table>
   <table>
    <tr>
        <td align="right">Email:</td>
    	<td align="left"><input type="text" name="email" size="30" readonly="readonly" class="input-readonly" value="<bean:write name="resumeUpdForm" property="email"/>"/></td>
    	<td align="left"><input type="hidden" name="id" size="5" value="<bean:write name="resumeUpdForm" property="id"/>"/></td>
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

	<br></br>
    <table>
    <tr><td><b>Most Recent Work Location&nbsp;&nbsp;</b></td>
    	<td align="right">City:</td>
    	<td align="left"><input type="text" name="workCity" length="20" value="<bean:write name="resumeUpdForm" property="workCity"/>"</td>
    	<td align="right">State:</td>	
   	    <td>
   			<html:select property="workState">
				<html:options collection="listStates" property="value" labelProperty="label" />
    		</html:select>
    	</td>

    </tr>
    </table>
         
    <table> 
    <tr><td><b>Salary Expectation&nbsp;&nbsp;</b></td>
       	<td align="right">Low:</td>
    	<td align="left"><input type="text" name="lowSalaryStr" length="10"  value="<bean:write name="resumeUpdForm" property="lowSalary"/>"/></td>
    	<td align="right">High:</td>
    	<td align="left"><input type="text" name="highSalaryStr" length="10" value="<bean:write name="resumeUpdForm" property="highSalary"/>"/></td>
    </tr>
    </table>
    <table>
    <tr>
        <td align="right">Relocation Preference:</td>
    	<td align="left"><input type="text" name="relocation" length="30" value="<bean:write name="resumeUpdForm" property="relocation"/>"/></td>
        <td align="right">Comments:</td>
        <td align="left"><input type="textarea" name="commentsStr" size="40" cols="5" value="<bean:write name="resumeUpdForm" property="comments"/>"/></td>
    </tr>
    <table>
    <tr><td><b>Skills</b></td></tr>
    <tr>
    	<td><select name="skill">
            <option>Hibernate</option>
            <option>JSP</option>
            <option>Servlets</option>
            <option>Spring</option>
            <option>Struts</option>
    	</select></td>    	
       	<td align="right">Years Experience:</td>
    	<td align="left"><input type="text" name="yearsExpStr" length="2" value="<bean:write name="resumeUpdForm" property="yearsExp"/>"/></td>
    </tr>
    </table>
    <p><p>Upload Resume File:	
    <html:file property="fileSelected" size="50" /> <br/>
    <!-- can use a bean:message here to place a message from ApplicationResources.txt -->
    <br>Can upload only files in the following formats:  doc, docx, htm, html, pdf, txt
    
  
    <br><br></br>
    <table><tr>
		<td align="left" width="7%"><input type="submit" name="step" value="Update" /></td>
		<td align="left" width="7%"><input type="submit" name="step" value="Home"/></td><td ></td>
		<td align="right" width="70%"><input type="submit" name="step" value="Remove"/></td>
	</tr></table>
	
	</html:form>
	</body>
</html>