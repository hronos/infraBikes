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
        
    </head>
    <body>
        
        
         <form method="POST"  action="/infraBike/webapi/User"
                <ul>
                    <li>User Name <input type="text" name="username" value=""></li>
                    <li>Password <input type="password" name="password" value=""></li>
                    <li>Email <input type="email" name="email"></li>
                    
                             
                </ul>
                <br/>
                <input type="submit" value="Register"> 
            </form>

    </body>
</html>
