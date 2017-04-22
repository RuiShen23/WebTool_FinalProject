<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>User Register</title>
</head>

<!-- ajax: 检查username和email是不是已经存在 -->

<body>

	<form:form action="/user/register" method="post" modelAttribute="user">
		<table>
			<tr>
				<td>Username:</td>
				<td><form:input type="text" size="30" name="username" id="UserName" path="user.username" onkeyup="checkname();" /></td>
				<td><form:errors path="account.username" /></td>
				<td><!-- username already exist error --></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input type="password" size="30" name="password" id="Password" path="user.password"/></td>
				<td><form:errors path="account.password" /></td>
			</tr>
			<tr>
				<td>Repeat Password:</td>
				<td><input type="password" size="30" name="confirmPassword"
					id="ConfirmPassword" onkeyup="checkPass(); return false;" /></td>
				<td><span id="PasswordConfirmMessage"></span></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input type="text" size="30" name="email" id="email" path="user.email"/></td>
				<td><form:errors path="account.email" /></td>
				<!-- email already exist error -->
			</tr>
			<tr>
				<td></td>
				<td><input type="submit"
					value="                  Register                  " /></td>
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
				pass2.style.backgroundColor = goodColor;
				message.style.color = goodColor;
				message.innerHTML = "Passwords Match!"
			} else {
				pass2.style.backgroundColor = badColor;
				message.style.color = badColor;
				message.innerHTML = "Passwords Do Not Match!"
			}
		}
	</script>

</body>
</html>
