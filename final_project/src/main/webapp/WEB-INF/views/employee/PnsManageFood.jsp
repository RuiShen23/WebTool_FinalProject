<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PNS Manage Food</title>
</head>
<body>
	View all food:
	<div id="divFoodTable">
	<form method="post" action="employee/pns-manage-food/modify">
		<table id="foodTable">
		<tr>
			<td>Food Name</td>
			<td>Calories</td>
			<td>Fat</td>
			<td>Carb</td>
			<td>Protein</td>
		</tr>
		<c:forEach var="food" items="${foodList}">
			<tr>
				<td><input type="text" name="names" value="${food.name}"/></td>
				<td><input type="text" name="calories" value="${food.calories}"/></td>
				<td><input type="text" name="fat" value="${food.fat}"/></td>
				<td><input type="text" name="carb" value="${food.carb}"/></td>
				<td><input type="text" name="protein" value="${food.protein}"/></td>
				<td><input type="hidden" name="foodId" value="${food.foodId}"/></td>
			</tr>
		</c:forEach>
		</table>
		<input type="submit" value="Submit changes" />
	</form>	
	</div>
	<br><br>
	
	<form:form action="pns-manage-food/add" method="post" modelAttribute="food" enctype="multipart/form-data">	
	<jsp:useBean id="food" class="com.neu.final_project.pojo.Food" scope="request"/>
		Add food:
		<table>
			<tr>
				<td>Food Name:</td>
				<td><form:input type="text" path="name"/></td>
			</tr>	
			<tr>	
				<td>Calories:</td>
				<td><form:input type="text" path="calories"/></td>
			</tr>
			<tr>
				<td>Fat:</td>
				<td><form:input type="text" path="fat"/></td>
			</tr>
			<tr>
				<td>Carb:</td>
				<td><form:input type="text" path="carb"/></td>
			</tr>
			<tr>
				<td>Protein:</td>
				<td><form:input type="text" path="protein"/></td>
			</tr>
			<tr><td><form:input type="hidden" path="price" value="0"/><td></tr>
			<tr>
				<td>Upload a picture</td>
				<td><form:input type="file" path="photo"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="          Submit food for admin review         " /></td>
			</tr>
			<tr>
				<td>${errorMessage}</td>
			</tr>
		</table>
				
	</form:form>
</body>
</html>
