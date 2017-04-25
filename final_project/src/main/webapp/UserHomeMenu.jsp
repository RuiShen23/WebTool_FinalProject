<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>User Home Page</title>
	</head>
	<body>
		Hello ${user.username}. <br>
		<div id="basic_functions">
		<a href="user/logout" target="contents">Log out</a><br><br>
		<a href="recipe/view/user-saved-recipe" target="contents">Manage Saved Recipes</a><br>
	    <a href="food/view/user-unwanted-food" target="contents">Manage Unwanted Food</a><br>
	    <a href="order/view/user" target="contents">View Orders</a><br>
	    <a href="recipe/create/user" target="contents">Create New Recipes</a><br>      
	    </div>
	    
	    <div id="registered_user_functions">
		    <c:if test="${user.accountType == 'registered'}">
		  		<a href="user/upgrade-premier-user" target="contents">Upgrade to Premier</a><br> 
		    </c:if> 
	    </div>
	    
	    <div id="premier_user_functions">
		    <c:if test="${user.accountType == 'premier'}">
		    	<a href="recipe/generate-weekly-recipe" target="contents">Generate Weekly Menu</a><br> 
		    	<a href="message/communicate-pns" target="contents">Contact PNS</a><br> 
		    </c:if>
	    </div>
	</body>
</html>