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

	<form:form action="manage-employee" method="post" modelAttribute="employee">
		<table>
			<tr>
				<td>Account ID:</td>
				<td>${employee.id}</td>
				<td><input type="hidden" name="id" value="${employee.id}"/></td>
			</tr>
			<tr>
				<td>User name:</td>
				<td>${employee.username}</td>
				<td><input type="hidden" name="username" value="${employee.username}"/></td>
				<td><input type="hidden" name="password" value="${employee.password}"/></td>
			</tr>
			<tr>
				<td>Email Address:</td>
				<td>${employee.email}</td>
				<td><input type="hidden" name="email" value="${employee.email}"/></td>
			</tr>
			<tr>
				<td>Account Type:</td>
				<td>${employee.accountType}</td>
				<td><input type="hidden" name="accountType" value="${employee.accountType}"/></td>
			</tr>
			<tr>
				<td>First name:</td>
				<td><input type="text" value="${employee.firstName}" name="firstName"/></td>
			</tr>
			<tr>
				<td>Last name:</td>
				<td><input type="text" value="${employee.lastName}" name="lastName"/></td>
			</tr>
		</table>
		
		<input type="submit" value="Submit Changes" name="update" />
		<input type="submit" value="Delete Account" name="update" />
	</form:form>
</body>
</html>