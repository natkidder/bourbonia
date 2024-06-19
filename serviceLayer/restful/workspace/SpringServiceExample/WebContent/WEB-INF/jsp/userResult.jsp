<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Submitted User Information By Nat</h2>
   <table>
    <tr>
        <td>UserID</td>
        <td>${userid}</td>
    </tr>
    <tr>
        <td>First Name</td>
        <td>${firstName}</td>
    </tr>
    <tr>
        <td>Last Name</td>
        <td>${lastName}</td>
    </tr>    
    <tr>
        <td>Email</td>
        <td>${email}</td>
    </tr>
</table>  
</body>
</html>