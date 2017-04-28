<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>PNS Manage Food</title>
	</head>
<body>

	View Recipes: 
	<select id="recipeCategory" onchange="showTable()">
		<option value="none">-</option>
		<option value="breakfast">Breakfast</option>
		<option value="lunch">Lunch</option>
		<option value="snack">Snack</option>
		<option value="dinner">Dinner</option>
	</select>
	<div id="divRecipeTable">
		<table id="recipeTable" border="1">
		<thead>
		<tr>
			<td>Recipe ID</td>
			<td>Category</td>
			<td>Cooking Instruction</td> 
			<td>Food</td>
			<td>Quantity</td>
		</tr>
		</thead>
		<tbody id="tbody">

		</tbody>
		</table>
	</div>
	<br><br><br>
	
	
	<div id="newRecipe">
	Create New Recipe
	<jsp:useBean id="recipe" class="com.neu.final_project.pojo.Recipe" scope="request"/>
	<form:form action="/final_project/employee/pns-manage-recipe/create" method="post" modelAttribute="recipe">
	<select name="category">
		<option value="breakfast">Breakfast</option>
		<option value="lunch">Lunch</option>
		<option value="snack">Snack</option>
		<option value="dinner">Dinner</option>
	</select>
	<table>
		<thead>
			<tr>
				<td>Recipe Item</td>
				<td>Quantity</td>
				<td>Food</td>
				<td>Cooking Instruction</td>
			</tr>
		<thead>
		<tbody id="addRecipeTbody">
			<tr>					
				<td>1</td>
				<td><input type="number" name="recipeItems[0].quantity" min="1" required /></td>
				<td><select id="foodTable" name="foodIds">
					<option value="none">-</option>
						<c:forEach var="food" items="${allFoodList}">
							<option value="${food.foodId}" >${food.name}</option>
						</c:forEach>	
					</select>
				</td>
				<td><input type="text" name="cookingInstruction"/></td>					
			</tr>
		</tbody>
	</table>
		<br>
		<button type="button" onclick='addRow();return false'>Add a new row</button>
		<br><br>
		<input type="submit" value="Create New Recipe" />
	</form:form>
	</div>



	<script>
		var rowCount = 1;
	
		function addRow()
		{
			var tr = '';
			tr += '<td><select id="foodTable" name="foodIds">';
			tr += '<option value="none">-</option>';
			tr += '<c:forEach var="food" items="${allFoodList}">';
			tr += '<option value="${food.foodId}">${food.name}</option>';
			tr += '</c:forEach></select>';
			
			var newRow = document.getElementById("addRecipeTbody").insertRow(rowCount);
			var cell1 = newRow.insertCell(0);
			var cell2 = newRow.insertCell(1);
			var cell3 = newRow.insertCell(2);
			var cell4 = newRow.insertCell(3);
			
			cell1.innerHTML = (rowCount+1);
			cell2.innerHTML = '<input type="number" name="recipeItems['+rowCount+'].quantity" required/>';
			cell3.innerHTML = tr;
			cell4.innerHTML = '<td><input type="text" name="cookingInstruction"/></td>';
			rowCount = rowCount + 1;
		}
	
	
		function showTable()
	    {
		   	var xmlHttp = new XMLHttpRequest();
		   	var recipeCategory = document.getElementById("recipeCategory").value;
		   	var url = "/final_project/employee/pns-manage-recipe/view-by-category?recipeCategory="+recipeCategory;
		   	
		   	xmlHttp.onreadystatechange=function()
		    {
		    	if(xmlHttp.readyState==4 && xmlHttp.status==200)
		     	{	      				      			
		    		var recipeList = JSON.parse(xmlHttp.responseText);		    		
		    		var trStr = '';
		    		
		    		for (var i=0;i<recipeList.length;i++)
		    		{		    			
		    			trStr += '<tr class="example">';
		    			trStr += '<td rowspan='+recipeList[i].recipeItems.length+'>' + recipeList[i].recipeId + '</td>';
		    			trStr += '<td rowspan='+recipeList[i].recipeItems.length+'>' + recipeList[i].category + '</td>';
		    			trStr += '<td rowspan='+recipeList[i].recipeItems.length+'>' + recipeList[i].cookingInstruction + '</td>';
		    			trStr += '<td>' + recipeList[i].recipeItems[0].food.name + '</td>';
		    			trStr += '<td>' + recipeList[i].recipeItems[0].quantity + '</td>';
		    			trStr += '</tr>';  
		    			for (var t=1;t<recipeList[i].recipeItems.length;t++)
		    			{
		    				trStr += '<td>' + recipeList[i].recipeItems[t].food.name + '</td>';
			    			trStr += '<td>' + recipeList[i].recipeItems[t].quantity + '</td>';
			    			trStr += '</tr>';  
		    			}
		    		}
		    		document.getElementById("tbody").innerHTML = trStr;
		     	}
		    }
		    xmlHttp.open("get",url,true);
		   	xmlHttp.setRequestHeader("Content-type", "application/json");
		   	xmlHttp.setRequestHeader("Accept","application/json");
		    xmlHttp.send(null);
	    }  
	</script>
</body>
</html>