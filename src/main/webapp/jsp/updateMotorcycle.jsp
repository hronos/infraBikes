<%-- 
    Document   : updateMotorcycle
    Created on : 16-Nov-2014, 16:56:24
    Author     : Anna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Motorcycle</title>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <form action="/infraBike/webapi/Motorcycle/Update" method="POST">
          Id Model: <input type="text" name="idModel"> <br />
          Model Name: <input type="text" name="model_name"> <br />
          Top Speed: <input type="text" name="top_speed" /><br />
          Weight: <input type="text" name="weight" /><br />
          Seat Height: <input type="text" name="seat_height" /><br />
          Frame: <input type="text" name="frame" /><br />
          Tank: <input type="text" name="tank" /><br />
          Engine Size: <input type="text" name="engine_size" /><br />
          Front Brakes: <input type="text" name="front_brakes" /><br />
          Rear Brakes: <input type="text" name="rear_brakes" /><br />
          Front Tyre Size: <input type="text" name="front_tyre" /><br />
          Rear Tyre Size: <input type="text" name="rear_tyre" /><br />
          Power(kw): <input type="text" name="power" /><br />
          Serial: <input type="text" name="serial" /><br />
          Colour: <input type="text" name="colour" /><br />
          Price: <input type="text" name="price" /><br />
          Id: <input type="text" name="Id" /><br />
          
          <input type="submit" value="Add" />
    </body>
</html>
