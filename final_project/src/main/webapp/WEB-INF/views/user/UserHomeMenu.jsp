<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Hello ${user.username}.
	<a href="/user/logout" target="contents">Log out</a><br>
	<a href="/user/view/saved-recipe" target="contents">Manage Saved Recipes</a><br>
    <a href="/user/view/unwanted-food" target="contents">Manage Unwanted Food</a><br>
    <a href="/user/view/orders" target="contents">View Orders</a><br>
    <a href="/user/create/recipe" target="contents">Create New Recipes</a><br>      
    
    <a href="/user/upgrade-premier-user" target="contents">Upgrade to Premier</a><br>   
    <a href="/user/generate/weekly-menu" target="contents">Generate Weekly Menu</a><br> 
    <a href="/user/communication/pns" target="contents">Contact PNS</a><br> 
</body>
</html>