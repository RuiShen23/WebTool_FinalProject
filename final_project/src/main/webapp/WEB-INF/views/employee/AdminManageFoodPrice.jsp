<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Manage Recipe</title>
</head>
<body>
	Please update price for following food: <br>
	
	<form method="POST" action="admin-manage-food/updatePrice">
		<table border="1">
			<tr>
				<th>Food ID</th>
				<th>Food Name</th>
				<th>Price (per serving size)</th>
			</tr>
			<c:forEach var="food" items="${foodList}" >
				<tr>
					<td>${food.foodId}</td>
					<td>${food.name}</td>			
					<td><input type="number" name="price" value="0" min="0"/></td>
					<td><img style="width:128px;height:98px;"  src="<c:url value="/image/${food.photoPath}" />"></td>
					<td><input type="hidden" name="foodId" value="${food.foodId}"/></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Submit Updates">
	</form>
	
	<br><br>
</body>
</html>