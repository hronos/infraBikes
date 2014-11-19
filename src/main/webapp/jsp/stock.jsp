<%-- 
    Document   : stock
    Created on : 10-Nov-2014, 20:11:57
    Author     : Anna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stock Page</title>
    </head>
    <body>
        <%@ include file="header.jsp" %>
     <p>Add part</p>
      <form method="POST"  action="/infraBike/webapi/Part"
                <ul>
                    <li>Name <input type="text" name="name" value=""></li>
                    <li>Part type <input type="text" name="part_type" value=""></li>
                    <li>Price <input type="text" name="price"></li>
                    <li>Quantity <input type="text" name="quantity"></li>
                    <li>Warehouse <input type="text" name="id_warehouse"></li>
                    <li>Supplier <input type="text" name="id_supplier"></li>
                           
                </ul>
                <br/>
                <input type="submit" value="Add"> 
            </form>
        
    </body>
</html>
