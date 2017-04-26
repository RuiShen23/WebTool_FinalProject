<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Account Detail</title>
</head>
<body>
	<form:form action="manage-user" method="post" modelAttribute="user">
		<table>
			<tr>
				<td>Account ID:</td>
				<td>${user.id}</td>
				<td><input type="hidden" name="id" value="${user.id}"/></td>
			</tr>
			<tr>
				<td>User name:</td>
				<td>${user.username}</td>
				<td><input type="hidden" name="username" value="${user.username}"/></td>
				<td><input type="hidden" name="password" value="${user.password}"/></td>
			</tr>
			<tr>
				<td>Email Address:</td>
				<td>${user.email}</td>
				<td><input type="hidden" name="email" value="${user.email}"/></td>
			</tr>
			<tr>
				<td>Account Type:</td>
				<td>${user.accountType}</td>
				<td><input type="hidden" name="accountType" value="${user.accountType}"/></td>
			</tr>
		</table>
		
		<input type="submit" value="Delete Account" name="update" />
	</form:form>
</body>
</html>