<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>Welcome to Menu Generator</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
   	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>     
	<div class="functions">
		<a href="employee/login">Employee Login</a> <br/>
		<a href="user/login">User Login</a> <br/>
		<a href="user/register">User Register</a> <br/>		
	</div>
    <br/>
	<div class="main_question">
    	<form action="recipe/daily/generate" method="post">
	      	I would like to take 
	      	<input id="caloriesNumber" type="number" size="10" min="700"/> 
          	Calories in
	      	<select id="mealNumber">
	      		<option value="2meals">2</option>
	        	<option value="3meals">3</option>
	        	<option value="4meals">4</option>
	        </select> 
            meals. 
	      	<input type="button" onclick="getGeneratedMenu()" value="Generate menu"/>
		</form>
	</div>
     
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button class="btn_calculateCal" name="calculateCal" data-toggle="modal" data-target="#myModal">Not sure?</button>
   	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"  aria-labelledby="myModalLabel" aria-hidden="true">
   		<div class="modal-dialog">
   			<div class="modal-content">
        		<div class="modal-header">
            		<button type="button" class="close" data-dismiss="modal" aria-hidden="true"> &times; </button>
            		<h2 class="modal-title" id="myModalLabel"> Nutrition Calculator </h2>
         		</div>
         			
            	<form action="user/nutrition-calculator" method="post">
	            	<div class="modal-body">                
	                    <table>
	                        <tr>
	                            <td style="width:10%;">
	                                <label for="height_feet" class="">Height</label>
	                            </td>
	                            <td style="width:90%;">
	                                <input type="number" name="height_feet" id="height_feet" size="3" min="0" value="" /> ft 
	                                <input type="number" name="height_inches" id="height_inches" size="3" min="0" value=""/> in
	                            </td>
	                        </tr>
	                        <tr>
	                            <td><label for="weight_pounds" class="">Weight</label></td>
	                            <td><input type="number" name="weight_pounds" id="weight_pounds" size="3" min="0" step="any" class="bigger" value=""/> lbs</td>
	                        </tr>
	                        <tr>
	                            <td><label for="age" class="">Age</label></td>
	                            <td><input type="number" name="age" id="age" size="3" min="0" value="" /></td>
	                        </tr>
	                        <tr>
	                        	<td><label for="gender" class="">Gender</label></td>
	                            <td><select name="gender" id="gender"><option value="female">Female</option><option value="male">Male</option></select></td>
	                        </tr>
	                	</table>                       
	         		</div>
	          		
	         		<div class="modal-footer">
	            		<button type="button" class="btn btn-default" data-dismiss="modal"> Close </button>
	            		<button type="button" class="btn btn-primary" onclick="getCalorie()"> Calculate </button>
	         		</div>
         		</form> 
				<div class="calculate-result">				       				
	       		 &nbsp;&nbsp;&nbsp;&nbsp;<span id="calculatedCalorie"></span>
	         	</div>
	         	<br>				
			</div>			
      	</div>
     </div>
     
     
     <div id="generated_menu">
		<table id="menuTable">
		<thead>
		<tr>
			<td>Recipe Number</td>
			<td>Food Name</td>
			<td>Quantity</td>
			<td>Account Type</td>
		</tr>
		</thead>
		<tbody id="tbody">
		<tr id="content" class="core_table">
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>	
		</tbody>
		</table>
	</div>
     
     
     <script type="text/javascript">
	     function getCalorie()
	     {
	    	var xmlHttp = new XMLHttpRequest();
	    	var url = "${pageContext.request.contextPath}/user/nutrition-calculator";
	    	var height_feet = document.getElementById("height_feet").value;
	    	var height_inches = document.getElementById("height_inches").value;
	    	var weight_pounds = document.getElementById("weight_pounds").value;
	    	var age = document.getElementById("age").value;
	    	var gender = document.getElementById("gender").value;
	    	
	    	var param = "height_feet=" + height_feet + "&height_inches=" + height_inches + "&weight_pounds=" + weight_pounds + "&age=" + age + "&gender=" + gender
	  
	      	xmlHttp.onreadystatechange=function()
	      	{
	    		if(xmlHttp.readyState==4 && xmlHttp.status==200)
	      		{	      				      			
	      			document.getElementById("calculatedCalorie").innerHTML = "Recommended calorie is:" + xmlHttp.responseText;
	      		}
	      	}
	      	xmlHttp.open("post",url,true);
	    	xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	    	xmlHttp.setRequestHeader("Accept","text/plain");
	      	xmlHttp.send(param);
	     }     	
	     
	     
	     function getGeneratedMenu()
	     {
	    	 var xmlHttp = new XMLHttpRequest();
	    	 var url = "${pageContext.request.contextPath}/recipe/daily/generate";
	    	 var caloriesNumber = document.getElementById("caloriesNumber").value;
		     var mealNumber = document.getElementById("mealNumber").value;
		     var param = "caloriesNumber=" + caloriesNumber + "&mealNumber=" + mealNumber
		     
		     xmlHttp.onreadystatechange=function()
			 {
			 	if(xmlHttp.readyState==4 && xmlHttp.status==200)
			    {	      				      			
			    	var menu = JSON.parse(xmlHttp.responseText);
			    		
			    	var trStr = '';
			    	for (var i=0;i<menu.length;i++)
			    	{		    			
			    		trStr += '<tr class="example">';
			    		trStr += '<td>' + menu[i].recipeItemId + '</td>';
			    		for (var l=0;l<menu[i].length;l++)
			    		{
			    			trStr += '<td>' + menu[i][l].food.name + '</td>';
				    		trStr += '<td>' + menu[i][l].quantity + '</td>';
			    		}
			    		trStr += '</tr>';  
			    	}
			    	document.getElementById("tbody").innerHTML = trStr;
			     }
			 }
		     xmlHttp.open("post",url,true);
		     xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		 	 xmlHttp.setRequestHeader("Accept","application/json");
		     xmlHttp.send(param);
	     }
     </script>

</body>
</html>









