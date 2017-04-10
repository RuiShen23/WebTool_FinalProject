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
     

<div class="col-xs-2 browser_sidebar search_padding">
        <div class="form-group">
            <input type="text" name="q" placeholder="Search recipes..." class="search-query form-control food_input" style="margin-top:15px; width: 100%;">
        </div>
        <div class="browse_type">
            <h4>Type</h4>
            <ul class="nav nav-pills nav-stacked">
                <li class="recipe active">
                    <a class="recipe" href="/food/browse/?type=recipe">All Foods</a>
                </li>
                <li class="food">
                    <a class="food" href="/food/browse/?type=vegan">Vegan</a>
                </li>
            </ul>
        </div>      
    </div>


<div class="col-xs-10 search_padding results_view">
    <div class="row food_table_header_right">
        <div class="col-xs-11">
            <div class="row">
                <div class="col-xs-1 food_table_column_header">
                    Image
                </div>
                <div class="col-xs-3 food_table_column_header">
                    Title
                </div>
                <div class="col-xs-8">
                    <div class="row">
                        <div class="col-xs-1" /></div>
                        <a href="/food/browse/?type=recipe&amp;order_by=-calories" class="col-xs-2 food_table_column_header sort_nutrient_link">
                            Calories                        
                            <div class="hidden_arrow light_icon">
                                <span class="glyphicon glyphicon glyphicon-chevron-down" />
                            </div>                        
                        </a>
                        <a href="/food/browse/?type=recipe&amp;order_by=-carbs" class="col-xs-2 food_table_column_header sort_nutrient_link">
                            Carbs
                            <div class="hidden_arrow light_icon">
                                <span class="glyphicon glyphicon glyphicon-chevron-down" />
                            </div>                        
                        </a>
                        <a href="/food/browse/?type=recipe&amp;order_by=-fats" class="col-xs-2 food_table_column_header sort_nutrient_link">
                            Fat                       
                            <div class="hidden_arrow light_icon">
                                <span class="glyphicon glyphicon glyphicon-chevron-down"/>
                            </div>                        
                        </a>
                        <a href="/food/browse/?type=recipe&amp;order_by=-proteins" class="col-xs-2 food_table_column_header sort_nutrient_link">
                            Protein                        
                            <div class="hidden_arrow light_icon">
                                <span class="glyphicon glyphicon glyphicon-chevron-down">
                            </div>                        
                        </a>
                    </div>            
                </div>
            </div>
        </div>
    </div>

	<div class="row food_result">
        <div class="col-xs-11" style="padding:0px 0px">
            <a class="result_row" href="/recipe/view/corn-and-bell-pepper-chowder,45662/"> </a>
        </div>
        <div class="col-xs-1" style="padding:0px 0px">
            <div class="big_favorite_food" data-id="45662" style="display: block">
        </div>
    </div>

	<div class="bottom_pagination search_padding">
    
        <div class="inline_block">
            Results <strong>1 - 20</strong> out
            of 1000+
        </div>
        <div class="inline_block" style="margin-left: 20px">
            <span class="current">
                Page 1 of 50+
            </span>
            <a class="change_page" href="/food/browse/?type=recipe&amp;page=2" data-page="2">
            	<span class="glyphicon glyphicon glyphicon-chevron-right" />
            </a>            
        </div>    
	</div>
</div>

    
</body>
</html>






