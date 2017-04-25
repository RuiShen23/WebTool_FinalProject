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
	    <div id="employee-pns">
		    <c:if test="${employee.accountType == 'pns'}">
		  		<a href="recipe/pns-manage" target="contents">Manage menus</a><br> 
		  		<a href="food/pns-manage" target="contents">Manage food</a><br>
		  		<a href="message/from-premier-user" target="contents">View Messages From Premier Users</a><br>  
		    </c:if> 
	    </div>
	    
	    <div id="employee-admin">
		    <c:if test="${employee.accountType == 'admin'}">
		    	<a href="employee/manage-accounts" target="contents">Manage Account</a><br> 
		    	<a href="food/admin-manage" target="contents">Manage Product Price</a><br> 
		    </c:if>
	    </div>
	</body>
</html>