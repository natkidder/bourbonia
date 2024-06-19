<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!-- taglib prefix="html" uri="http://struts.apache.org/tags-html"  -->

<html>
	<head><title>Add a Resume</title></head>
	<body>
	<html:errors/>
	<h3>Resume Form -- New Resume</h3>	

	<html:form action="/ActionResume" method="POST" enctype="multipart/form-data"> <!-- last attribute to get file dialog box to work -->
	
    First Name: <input type="text" name="firstName" size="30"/>
    &nbsp;&nbsp;MI: <input type="text" name="mi" size="1"/>
    &nbsp;&nbsp;Last Name: <input type="text" name="lastName" size="30"/>
    
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
        <td align="left"><input type="text" name="street" size="50"/></td>
    </tr>
    <tr>
    	<td align="right">Apt, Suite, etc.:</td>
    	<td align="left"><input type="text" name="apt" size="30"/></td>
    </tr>
    </table>
    <table>
    <tr>
    	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td></td>
    	<td align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;City:</td>
    	<td align="left"><input type="text" name="city" length="20"/></td>
    	<td align="right">State:</td>
    	<td>
    	<html:select property="state">
			<html:options collection="listStates" property="value" labelProperty="label" />
    	</html:select>
    	</td>
     	<td align="right">Zip:</td>
    	<td align="left"><input type="text" name="zip" length="10"/></td>
    </tr>
    </table>
    <table>
    <tr><td><b>Contact Information</b></td></tr>
    <tr>
    	<td align="right">Home:</td>
    	<td align="left"><input type="text" name="hphone" length="20"/></td>
    	<td align="right">Office:</td>
    	<td align="left"><input type="text" name="ophone" length="20"/></td>
    	<td align="right">Cell:</td>
    	<td align="left"><input type="text" name="cphone" length="20"/></td>
    </tr>
    </table>
   <table>
    <tr>
        <td align="right">Email:</td>
    	<td align="left"><input type="text" name="email" size="30"></td>
     </tr>
    </table>
    <table>
    <br>&nbsp;
    <tr><td><b>Most Recent Work Location&nbsp;&nbsp;</b></td>
    	<td align="right">City:</td>
    	<td align="left"><input type="text" name="workCity" length="20"/></td>
    	<td align="right">State:</td>	
   	    <td>
   	    <html:select property="workState">
			<html:options collection="listStates" property="value" labelProperty="label" />
    	</html:select>
    	</td>

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
    <br>&nbsp;    	            
    <tr><td><b>Salary Expectation&nbsp;&nbsp;</b></td>
       	<td align="right">Low:</td>
    	<td align="left"><input type="text" name="lowSalaryStr" length="10"/></td>
    	<td align="right">High:</td>
    	<td align="left"><input type="text" name="highSalaryStr" length="10"/></td>
    </tr>
    </table>
    <table>
    <tr>
        <td align="right">Relocation Preference:</td>
    	<td align="left"><input type="text" name="relocation" length="30"/></td>
        <td align="right">Comments:</td>
        <td align="left"><input type="textarea" name="commentsStr" size="40" cols="5"/></td>
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
    	<td align="left"><input type="text" name="yearsExpStr" length="2"/></td>
    </tr>
    </table>
    <p><p>Upload Resume File:	
    <html:file property="fileSelected" size="50" /> <br/>
    <br>Can upload only files in the following formats:  doc, docx, htm, html, pdf, txt
    
    <br><br></br>

<!--   
    <html:submit property="step" >
    	<bean:message key="button.save"/>
    </html:submit>

<html:submit value="Add Resume"/>   
 -->

	<input type="submit" name="step" value="Insert"/>
	<input type="submit" name="step" value="Home"/>

    </html:form>
	
	</body>
</html>