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
                  	<li><a href="#">Browse foods</a></li>
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
     
     
	<div class="main_question">
    	<form action="/generate" method="post">
	      	I would like to take 
	      	<input id="caloriesNumber" type="number" size="10" value=${calculatedCalorie}/> 
          	Calories in
	      	<select id="mealNumber">
	      		<option value="2meals">2</option>
	        	<option value="3meals">3</option>
	        	<option value="4meals">4</option>
	        </select> 
            meals. I would like to eat
	      	<select id="eatType">
	   			<option value="anything">anything</option>
	       		<option value="vagen">vegan</option>
       		</select>
	      	<input type="submit" value="Generate menu"/>
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
            		<h2 class="modal-title" id="myModalLabel"> Nutrition Calculator </h4>
         		</div>
         
         		<div class="modal-body">
            	<form action="/nutrition/calculate" method="post">                
                    <table>
                        <tr>
                            <td style="width:10%;">
                                <label for="height_feet" class="">Height</label>
                            </td>
                            <td style="width:90%;">
                                <input type="number" name="height_feet" id="height_feet" size="3" min="0" value=""> ft 
                                <input type="number" name="height_inches" id="height_inches" size="3" min="0" value=""> in
                            </td>
                        </tr>
                        <tr>
                            <td><label for="weight_pounds" class="">Weight</label></td>
                            <td><input type="number" name="weight_pounds" id="weight_pounds" size="3" min="0" step="any" class="bigger" value=""> lbs</td>
                        </tr>
                        <tr>
                            <td><label for="age" class="">Age</label></td>
                            <td><input type="number" name="age" id="age" size="3" min="0" value=""></td>
                        </tr>
                        <tr>
                        	<td><label for="gender" class="">Gender</label></td>
                            <td><select name="gender" id="gender"><option value="female">Female</option><option value="male">Male</option></select></td>
                        </tr>
                	</table>
                </form>        
         		</div>
         
         		<div class="modal-footer">
            		<button type="button" class="btn btn-default" data-dismiss="modal"> Close </button>
            		<button type="button" class="btn btn-primary"> Calculate </button>
         		</div>
      		</div>
     	</div>
	</div>
     

</body>
</html>









