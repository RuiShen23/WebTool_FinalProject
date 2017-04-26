<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>User Register</title>
</head>

<!-- ajax: 检查username和email是不是已经存在 -->

<body>

	<form:form action="user-register" method="post" modelAttribute="user">
		<jsp:useBean id="user" class="com.neu.final_project.pojo.User" scope="request"/>
		<table>
			<tr>
				<td>Username:</td>
				<td><form:input type="text" size="30" id="UserName" path="username"  /></td>
				<td><form:errors path="username" /></td>
				<td><!-- username already exist error onkeyup="checkname();"--></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input type="password" size="30" id="Password" path="password"/></td>
				<td><form:errors path="password" /></td>
			</tr>
			<tr>
				<td>Repeat Password:</td>
				<td><input type="password" size="30" id="ConfirmPassword" onkeyup="checkPass(); return false;" /></td>
				<td><span id="PasswordConfirmMessage"></span></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input type="email" size="30" id="email" path="email"/></td>
				<td><form:errors path="email" /></td>
				<!-- email already exist error -->
			</tr>
			<tr>
				<td></td>
				<td><input type="submit"
					value="                  Register                  " /></td>
				<td>${errorMessage}</td>
			</tr>
		</table>
	</form:form>

	<script>
		function checkPass() {
			var password = document.getElementById('Password');
			var confirmPassword = document.getElementById('ConfirmPassword');
			var message = document.getElementById('PasswordConfirmMessage');
			var goodColor = "#66cc66";
			var badColor = "#ff6666";

			if (password.value == confirmPassword.value) {
				confirmPassword.style.backgroundColor = goodColor;
				message.style.color = goodColor;
				message.innerHTML = "Passwords Match!"
			} else {
				confirmPassword.style.backgroundColor = badColor;
				message.style.color = badColor;
				message.innerHTML = "Passwords Do Not Match!"
			}
		}
	</script>

</body>
</html>
