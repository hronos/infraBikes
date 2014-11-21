<%-- 
    Document   : addMotorcycle
    Created on : 16-Nov-2014, 14:42:45
    Author     : Anna
--%>
<!--form style needed-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <link href="/infraBike/jsp/header_css.css" rel="stylesheet" type="text/css"/>
        <style>
            div.formrow {background:rgba(204, 204, 204, 0.54);border:2px solid #8B8B7E;margin:0 0 5px 0;float:left;width:100%;padding:6px 0;}
            div.formrow label {float:left;display:block;width:15em;font-weight:bold;padding:0 6px;}
            div.formrow label:hover {background:#FFFF66;cursor:pointer;}
            div.formrow fieldset {border:1px solid gray;margin:0 6px;}
            div.formrow fieldset span {display:block;}
            div.formrow fieldset span label {float:none;display:inline;}
            div.formrow fieldset legend {font-weight:bold;}
            div.requiredRow {border:2px solid #049;}
        </style>
    </head>
    <%  String username; String role_name = "";
    int current_role = (Integer) request.getAttribute("role");
    username = (String) request.getAttribute("username"); %>
    <body>
         <div class="center">
        <%@ include file="header.jsp" %>
        
        <form action="/infraBike/webapi/Model/Add" method="POST">
            <div class="formrow">
                <label for="model_name" id="Username-ariaLabel" >Model Name:</label> <input type="text" name="model_name"> <br />
            </div>
            <div class="formrow">
                <label for="top_speed" id="Username-ariaLabel" >Top Speed:</label> <input type="text" name="top_speed" /><br />
            </div>
            <div class="formrow">
                <label for="Weight" id="Username-ariaLabel" >Weight:</label> <input type="text" name="weight" /><br />
            </div>
            <div class="formrow">
                <label for="seat_height" id="Username-ariaLabel" >Seat Height:</label> <input type="text" name="seat_height" /><br />
            </div>
            <div class="formrow">
               <label for="frame" id="Username-ariaLabel" >Frame: </label> <input type="text" name="frame" /><br />
            </div>
            <div class="formrow">
                <label for="tank" id="Username-ariaLabel" >Tank: </label> <input type="text" name="tank" /><br />
            </div>
            <div class="formrow">
                <label for="engine_size" id="Username-ariaLabel" >Engine Size:</label> <input type="text" name="engine_size" /><br />
            </div>
            <div class="formrow">
                <label for="front_breakes" id="Username-ariaLabel" >Front Brakes:</label> <input type="text" name="front_brakes" /><br />
            </div>
            <div class="formrow">
                <label for="rear_brakes" id="Username-ariaLabel" >Rear Brakes:</label> <input type="text" name="rear_brakes" /><br />
            </div>
            <div class="formrow">
            
                <label for="front_tyre" id="Username-ariaLabel" >Front Tyre Size:</label> <input type="text" name="front_tyre" /><br />
            </div>
            <div class="formrow">
                <label for="rear_tyre" id="Username-ariaLabel" >Rear Tyre Size:</label> <input type="text" name="rear_tyre" /><br />
            </div>
            <div class="formrow">
                <label for="power" id="Username-ariaLabel" >Power(kw): </label> <input type="text" name="power" /><br />
            </div>
            <div class="formrow">
                <label for="serial" id="Username-ariaLabel" >Serial: </label> <input type="text" name="serial" /><br />
            </div>
            <div class="formrow">
                <label for="colour" id="Username-ariaLabel" >Colour: </label> <input type="text" name="colour" /><br />
            </div>
            <div class="formrow">
                <label for="price" id="Username-ariaLabel" >Price: </label> <input type="text" name="price" /><br />
            </div>
            <div class="formrow">
                <label for="prod_weight" id="Username-ariaLabel" >Product Weight: </label> <input type="text" name="prod_weight" /><br />
            </div>
            <div class="formrow">
                <label for="Id" id="Username-ariaLabel" >Id: </label> <input type="text" name="Id" /><br />
            </div>
            
            <div class="formrow">
                <label for="Id" id="Username-ariaLabel" >Id Part: </label> <input type="text" name="id_part" /><br />
            </div>
            <input type="submit" value="Add" />
            
        </form>
         </div>
    </body>
</html>
