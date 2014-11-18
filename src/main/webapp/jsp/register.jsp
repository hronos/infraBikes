<%-- 
    Document   : register
    Created on : 05-Nov-2014, 23:36:08
    Author     : Anna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/forms.css" rel="stylesheet" type="text/css"/>
        <script src="../dynatable/vendor/jquery-1.7.2.min.js" type="text/javascript"></script>
    </head>
    <body>
        
        
        <form method="POST"  action="/infraBike/webapi/UserV">
                <ul>
                    <li>User Name <input type="text" name="username" value=""></li>
                    <li>Password <input type="password" name="password" value=""></li>
                    <li>Email <input type="email" name="email"></li>
                           
                </ul>
                <br/>
                <input type="submit" value="Register"> 
        </form>
        <script>
            $(document).ready(function() {
                $("#register").click(function() {
                    
                    var name = $("#name").val();
                    var email = $("#email").val();
                    var password = $("#password").val();
                    var cpassword = $("#cpassword").val();
                    if (name === '' || email === '' || password === '' || cpassword === '') {
                        alert("Please fill all fields...!!!!!!");
                    } else if ((password.length) < 5) {
                        alert("Password should atleast 5 character in length...!!!!!!");
                    } else if (!(password).match(cpassword)) {
                        alert("Your passwords don't match. Try again?");
                    } else {
                        $.ajax({
                            type: "POST",
                            url: "/infraBike/webapi/UserV",
                            success: function(msg){
                                alert("Registration sucessful");
                            },
                            error: function(){
                                alert("Problem");
                            },
                        });
                    }
                });
            });
            
        
        </script>
<div class="cont">
    <section id="content">
        <form class="form" method="post" action="#">
        <h1>Registration</h1>
        
        <input type="text" name="dname" placeholder="Username" id="name">
        
        <input type="text" name="demail" placeholder="Email" id="email">
        
        <input type="password" name="password" placeholder="Password" id="password">
        
        <input type="password"  placeholder="Confirm password" name="cpassword" id="cpassword">
        <div>
        <input type="submit" name="register" id="register" value="Register">
        </div>
        
    </form>
        <div class="button">
        </div>
    </section>
</div>        

    </body>
</html>
