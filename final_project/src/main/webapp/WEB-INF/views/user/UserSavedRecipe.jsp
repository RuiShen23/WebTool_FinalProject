<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Saved Recipe</title>
</head>
<body>
	<form action="remove" method="post">
		<table border="1">
			<tr>
				<td>Recipe Number</td>
				<td>Remove</td>
				<td>Food Name</td>
				<td>Quantity</td>
			</tr>
			<c:forEach var="recipe" items="${user.savedRecipe}" varStatus="s">
				<tr>
					<td rowspan='${fn:length(recipe.recipeItems)+1}'>${s.count}</td>
					<td rowspan='${fn:length(recipe.recipeItems)+1}'><input type="checkbox" name="favRecipes" value="${recipe.recipeId}"/></td>
					<c:forEach var="recipeItem" items="${recipe.recipeItems}">
					<tr>
						<td>${recipeItem.food.name}</td>
						<td>${recipeItem.quantity}</td>
					</tr>
					</c:forEach>
				</tr>
				<tr>
			</c:forEach>	
		</table>
		<input type="submit" value="Remove Saved Recipe" />	
	</form>
</body>
</html>