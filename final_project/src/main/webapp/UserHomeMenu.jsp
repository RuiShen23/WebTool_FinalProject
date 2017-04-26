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
		<a href="home.jsp" target="_top">Home page</a><br>
		<a href="user/logout" target="_top">Log out</a><br><br>
		<a href="user/user-saved-recipe/view" target="contents">Manage Saved Recipes</a><br>
	    <a href="user/user-unwanted-food/view" target="contents">Manage Unwanted Food</a><br>
	    </div>
	    
	    <div id="registered_user_functions">
		    <c:if test="${user.accountType == 'registered'}">
		  		<a href="user/upgrade-premier-user" target="contents">Upgrade to Premier</a><br> 
		    </c:if> 
	    </div>
	    
	    <div id="premier_user_functions">
		    <c:if test="${user.accountType == 'premier'}">
		    	<a href="user/generate-weekly-recipe" target="contents">Generate Weekly Menu</a><br> 
		    </c:if>
	    </div>
	</body>
</html>