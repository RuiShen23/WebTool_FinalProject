<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>Employee login</title>
</head>

<body>
	<form action="/final_project/employee/login" method="post">
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" size="20" name="username"/></td>
                <td>${errorMessage}</td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" size="20" name="password"/></td>
            </tr>  
            <tr>
            	<td> </td>
            	<td><input type="submit" value="             Log in             "/> </td>
            </tr>  
        </table>
	</form>
</body>
</html>
