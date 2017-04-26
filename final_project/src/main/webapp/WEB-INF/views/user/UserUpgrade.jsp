<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upgrade to primier</title>
</head>
<body>
(supposed to be a ssl security payment...however failed due to time constraint)  <br><br><br>

	<c:if test="${user.accountType == 'registered'}">		    
		<form action="upgrade-premier-user/upgrade" method="post" target="_top">
			Please confirm you are upgrading to premier account: <input type="checkbox" name="upgrade" value="upgrade">	
			<input type="submit" value="Submit"/><br>
		</form>	
		You will be logged out once you click on Submit regardless.
	</c:if> 

</body>
</html>