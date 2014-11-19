<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="infra.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>
    <body>
        <br>
        <br>
        <br>
        <br>
        <br>
        <h1 style="text-align: center">Infrabike Information System</h1>
        <h4 style="text-align: center">Please login to use the system</h4>
        <form method="Post"  action="/infraBike/webapi/User">
              <div id="Rform">
                <div id="tags">
                <!--ul>
                    <li>User Name </li>
                    <li>Password </li>
                </ul-->
                </div>
                  <div id="inpurW" align="center">
                      <input type="text" name="login" placeholder="Login"><br/>
                      <br>
                      <input type="password" name="password" placeholder="Password"><br/>
                </div>
              </div>
              </br>
               <div id="button" class="div1">
                   <input type="submit" value="Login" id="button" class="button1"> 
               </div>
              
            </form>
    </body>
</html>
