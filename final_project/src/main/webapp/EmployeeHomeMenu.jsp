<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Employee Home Menu</title>
	</head>
	<body>
		Hello ${employee.username}. <br>
		<a href="home.jsp" target="_top">Home page</a><br>
		<a href="employee/logout" target="_top">Log out</a><br><br>
	    <div id="employee-pns">
		    <c:if test="${employee.accountType == 'pns'}">
		  		<a href="employee/pns-manage-recipe" target="contents">Manage menus</a><br> 
		  		<a href="employee/pns-manage-food" target="contents">Manage food</a><br>
		    </c:if> 
	    </div>
	    
	    <div id="employee-admin">
		    <c:if test="${employee.accountType == 'admin'}">
		    	<a href="employee/admin-manage-accounts" target="contents">Manage Account</a><br> 
		    	<a href="employee/admin-manage-food" target="contents">Manage Product Price</a><br> 
		    </c:if>
	    </div>
	</body>
</html>