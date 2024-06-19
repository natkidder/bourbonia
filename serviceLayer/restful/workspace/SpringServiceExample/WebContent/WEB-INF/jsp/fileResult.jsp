<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>File Information</h2>
   <table>
    <tr>
        <td>File Path</td>
        <td>${filePath}</td>
    </tr>
     <tr>
        <td>File Exists</td>
        <td>${exists}</td>
    </tr> 
    <tr>
        <td>File Comments</td>
        <td>${fileComments}</td>
    </tr>    
</table>  
</body>
</html>