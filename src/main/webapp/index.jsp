<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form method="Post"  action="/infraBike/webapi/User">
              <div id="Rform">
                <div id="tags">
                <ul>
                    <li>User Name </li>
                    <li>Password </li>
                </ul>
                </div>
                  <div id="inpurW">
                   <input type="text" name="login" class="menu" value=""> <br/>
          	   <input type="password" name="password" class="menu" value=""><br/>
                </div>
              </div>
              </br>
               <div id="button">  <input type="submit" value="Login" id="button"> </div>
              
            </form>
    </body>
</html>
