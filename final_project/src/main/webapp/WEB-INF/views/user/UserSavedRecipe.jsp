<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Saved Recipe</title>
</head>
<body>
	<table>
		<tr>
			<td>Recipe Number</td>
			<td>Food Name</td>
			<td>Quantity</td>
		</tr>
		<tr>
			<c:forEach var="recipe" items="${recipeList}" varStatus="s">
				<td>${s}</td>
				<c:forEach var="recipeItem" items="${recipe}">
					<td>${recipeItem.food.name}</td>
					<td>${recipeItem.quantity}</td>
				</c:forEach>			
			</c:forEach>
		</tr>
	</table>
</body>
</html>