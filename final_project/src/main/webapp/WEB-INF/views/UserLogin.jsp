<!DOCTYPE html>
<html>
<head>
	<title>Welcome to Menu Generator</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
   	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<div id="top_nav" class="navbar navbar-default navbar-static-top" role="navigation">
    	<div class="container">
        	<div class="navbar-header">
             	<a class="navbar-brand" href="/"> 
                	Menu Generator
                </a>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/">Generate menu</a></li>
                    <li><a href="#">View All Food</a></li>
                    <li class="dropdown user-dropdown"> 
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"> 
                            ${user.username} <strong class="caret"></strong> 
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">User Profile</a></li>
                            <li><a href="#">Account Info</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Log out</a></li>
    
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <a class="btn btn-primary pull-right register-button" href="/user/register-free-account/">Sign up</a>
                    <a class="btn btn-default pull-right register-button" href="/user/login/">Login</a>                        
                </ul>
             </div>
        </div>
	</div>
     
	<form action="/user/login" method="post">
        <table>
            <tr>
                <td>Email:</td>
                <td><input type="text" size="20" /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" size="20" /></td>
            </tr>  
            <tr>
            	<td> </td>
            	<td><input type="submit" value="             Log in             "/> </td>
            </tr>  
        </table>
	</form>
</body>
</html>
