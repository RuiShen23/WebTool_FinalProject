<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Unwanted Food</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Food Name</td>
			<td>Calories</td>
			<td>Fat</td>
			<td>Carb</td>
			<td>Protein</td>
			<td>Price</td>
		</tr>
		<c:forEach var="food" items="${user.unwantedFood}">
		<tr>
			<td>${food.name}</td>
			<td>${food.calories}</td>
			<td>${food.fat}</td>
			<td>${food.carb}</td>
			<td>${food.protein}</td>
			<td>${food.price}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>