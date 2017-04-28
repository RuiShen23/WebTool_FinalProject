<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Admin Manage Account</title>
	</head>
<body>
	
	View Accounts: 
	<select id="accountType" onchange="showTable()">
		<option value="none">-</option>
		<option value="registered">Registered-User</option>
		<option value="premier">Premier-User</option>
		<option value="pns">PNS</option>
	</select>
	<div id="divAccountTable">
		<table id="accountTable" border="1">
		<thead>
		<tr>
			<td>Account ID</td>
			<td>User name</td>
			<td>Email</td>
			<td>Account Type</td>
		</tr>
		</thead>
		<tbody id="tbody">
		
		</tbody>
		</table>
	</div>
	<br><br><br>
	Add PNS:
	<div id="divAddPns">
		<form:form action="/final_project/employee/admin-manage-accounts/add" method="post" modelAttribute="employee">
			<jsp:useBean id="employee" class="com.neu.final_project.pojo.Employee" scope="request" />
			<table>
				<tr>
					<td>Username:</td>
					<td><form:input type="text" size="30" id="UserName" path="username" /></td>
					<td><form:errors path="username" /></td>
					<td>
						<!-- username already exist error onkeyup="checkname();"-->
					</td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:input type="password" size="30" id="Password" path="password" /></td>
					<td><form:errors path="password" /></td>
				</tr>
				<tr>
					<td>Repeat Password:</td>
					<td><input type="password" size="30" id="ConfirmPassword" onkeyup="checkPass(); return false;"/></td>
					<td><span id="PasswordConfirmMessage"></span></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input type="email" size="30" id="email" path="email"/></td>
					<td><form:errors path="email" /></td>
					<!-- email already exist error -->
				</tr>
				<tr>
					<td>First Name:</td>
					<td><form:input type="text" size="30" id="firstName" path="firstName" /></td>
					<td><form:errors path="firstName" /></td>
					<!-- email already exist error -->
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><form:input type="text" size="30" id="lastName" path="lastName" /></td>
					<td><form:errors path="lastName" /></td>
					<!-- email already exist error -->
				</tr>
				<tr>
					<td></td>
					<td><input type="submit"
						value="                  Create                  " /></td>
					<td>${message}</td>
				</tr>
			</table>
		</form:form>
	</div>
	
	<script>
		function showTable()
	    {
		   	var xmlHttp = new XMLHttpRequest();
		   	var accountType = document.getElementById("accountType").value;
		   	var url = "/final_project/employee/admin-view-accounts";
		   			 
		    xmlHttp.onreadystatechange=function()
		    {
		    	if(xmlHttp.readyState==4 && xmlHttp.status==200)
		     	{	      				      			
		    		var accountList = JSON.parse(xmlHttp.responseText);
		    		
		    		var trStr = '';
		    		for (var i=0;i<accountList.length;i++)
		    		{		    			
		    			trStr += '<tr class="example">';
		    			trStr += '<td>' + '<a href="/final_project/employee/admin-manage-accounts/view?accountId='+ accountList[i].id + '">' + accountList[i].id +'</a>'+ '</td>';		    			
		    			trStr += '<td>' + accountList[i].username + '</td>';
		    			trStr += '<td>' + accountList[i].email + '</td>';
		    			trStr += '<td>' + accountList[i].accountType + '</td>';
		    			trStr += '</tr>';  
		    		}
		    		document.getElementById("tbody").innerHTML = trStr;
		     	}
		    }
		    xmlHttp.open("post",url,true);
		   	xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		   	xmlHttp.setRequestHeader("Accept","application/json");
		    xmlHttp.send("accountType="+accountType);
	    }     	
	
	
		function checkPass() 
		{
			var password = document.getElementById('Password');
			var confirmPassword = document.getElementById('ConfirmPassword');
			var message = document.getElementById('PasswordConfirmMessage');
			var goodColor = "#66cc66";
			var badColor = "#ff6666";

			if (password.value == confirmPassword.value) {
				confirmPassword.style.backgroundColor = goodColor;
				message.style.color = goodColor;
				message.innerHTML = "Passwords Match!"
			} else {
				confirmPassword.style.backgroundColor = badColor;
				message.style.color = badColor;
				message.innerHTML = "Passwords Do Not Match!"
			}
		}
	</script>
</body>
</html>