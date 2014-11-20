<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="jsp/header_css.css">
        <link href="css/forms.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>
    <body>
        
    <div id ="container">
            <div id="logo">
               <img class="displayed" src="/infraBike/image.jpg">
            </div>
    </div>
    <div class="clearfix"></div>
    <div class="cont">
        
        
	<section id="content">
		<form method="post" action="webapi/Login">
			<h1>Login Form</h1>
			<div>
				<input type="text" placeholder="Username" required="" id="username" name="username" />
			</div>
			<div>
				<input type="password" placeholder="Password" required="" id="password" name="password" />
			</div>
			<div>
				<input type="submit" value="Log in" />
				
				<a href="jsp/register.jsp">Register</a>
			</div>
		</form><!-- form -->
		<div class="button">
		</div><!-- button -->
	</section><!-- content -->
    </div><!-- cont -->
            
    </body>
</html>
