<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Menu Generator</title>
</head>

<body>
<p>Welcome to Menu Generator!</p>


<div>
	<!--这里该有一段JS/Interpreter来判断登录状态，如果已经登录了就只显示第三个button，如果没有就不显示第三个button-->
	<button type="submit" name="login" formaction="/user/login" formmethod="get" >Log in</button>
	<button type="submit" name="register" formaction="/user/register" formmethod="get">Register</button> 
    <!--并不知道该怎么搞，有点关系姑且放到一起了-->
	<button type="submit" name="userhome" formaction="/user/userhome" formmethod="post">User Home</button>
</div>
<br>

<div>
	<blockquote>
	  <a href="跳到menus page">View All Food</a> <br>
  </blockquote>
</div>

<div>
	<blockquote>
    	<form action="/generate" method="post">
	      I would like to take 
	      <input id="caloriesNumber" type="number" size="8"/> Calories in
	      	<select id="mealNumber">
	        	<option value="2meals">2</option>
	        	<option value="3meals">3</option>
	        	<option value="4meals">4</option>
	        	</select> meals. I would like to eat
	      			<select id="eatType">
	        			<option value="anything">anything</option>
	        			<option value="vagen">vegan</option>
          			</select>
	      <input type="submit" value="Generate menu"/>
		</form>
        <!--这里需要对齐CaloriesNumber的input, 点完需要出来一个弹窗...呃，还不太会-->
		<button type="submit" name="calculateCal" formaction="/calculateCal" formmethod="post">Not sure?</button>
	</blockquote> 
</div>

<!-- 这下面是隐藏的，直到返回上边menu的结果再显示 -->
<div>
	<!--这一部分是显示菜单。用c:for each根据上边mealNumber来显示meal数量-->
    	<!--每个meal中，还是用c:for each, 每顿饭都会存一个food number, 生成一个table, 只是为了好看一点, 每个前面有个select box-->
    
    
    <!-- 最下有一个add to cart-->
</div>


</body>
</html>
