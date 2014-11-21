<%-- 
    Document   : addMotorcycle
    Created on : 16-Nov-2014, 14:42:45
    Author     : Anna
--%>
<!--form style needed-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import =" uk.ac.dundee.computing.infrabike.dto.MotorcycleLo"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <link href="/infraBike/jsp/header_css.css" rel="stylesheet" type="text/css"/>
        <style>
            div.formrow {background:#ffc;border:2px solid #ffc;margin:0 0 5px 0;float:left;width:100%;padding:6px 0;}
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
    username = (String) request.getAttribute("username"); 
    MotorcycleLo mot = (MotorcycleLo)request.getAttribute("mot"); %>
    <body>
        <div class="center">
        <%@ include file="header.jsp" %>
        
        <form action="/infraBike/webapi/Model/Update" method="POST">
            <div class="formrow">
                <label for="model_name" id="Username-ariaLabel" >Model Name:</label>
                <input type="text" name="model_name" value="<%=mot.getModelName()%>">
                <br />
            </div>
            <div class="formrow">
                <label for="top_speed" id="Username-ariaLabel" >Top Speed:</label> <input type="text" name="top_speed" value="<%=mot.getTopSpeed()%>"/><br />
            </div>
            <div class="formrow">
                <label for="Weight" id="Username-ariaLabel" >Weight:</label> <input type="text" name="weight" value="<%=mot.getWeight()%>"/><br />
            </div>
            <div class="formrow">
                <label for="seat_height" id="Username-ariaLabel" >Seat Height:</label> <input type="text" name="seat_height" value="<%=mot.getSeatHeight()%>" /><br />
            </div>
            <div class="formrow">
               <label for="frame" id="Username-ariaLabel" >Frame: </label> <input type="text" name="frame" value="<%=mot.getFrame()%>"/><br />
            </div>
            <div class="formrow">
                <label for="tank" id="Username-ariaLabel" >Tank: </label> <input type="text" name="tank" value="<%=mot.getTank()%>"/><br />
            </div>
            <div class="formrow">
                <label for="engine_size" id="Username-ariaLabel" >Engine Size:</label> <input type="text" name="engine_size" value="<%=mot.getEngineSizeCc()%>"/><br />
            </div>
            <div class="formrow">
                <label for="front_breakes" id="Username-ariaLabel" >Front Brakes:</label> <input type="text" name="front_brakes" value="<%=mot.getFrontBrakes()%>"/><br />
            </div>
            <div class="formrow">
                <label for="rear_brakes" id="Username-ariaLabel" >Rear Brakes:</label> <input type="text" name="rear_brakes" value="<%=mot.getRearBrakes()%>"/><br />
            </div>
            <div class="formrow">
            
                <label for="front_tyre" id="Username-ariaLabel" >Front Tyre Size:</label> <input type="text" name="front_tyre" value="<%=mot.getFrontTyreSize()%>"/><br />
            </div>
            <div class="formrow">
                <label for="rear_tyre" id="Username-ariaLabel" >Rear Tyre Size:</label> <input type="text" name="rear_tyre" value="<%=mot.getRearBrakes()%>"/><br />
            </div>
            <div class="formrow">
                <label for="power" id="Username-ariaLabel" >Power(kw): </label> <input type="text" name="power" value="<%=mot.getPowerKw()%>"/><br />
            </div>
            <div class="formrow">
                <label for="serial" id="Username-ariaLabel" >Serial: </label> <input type="text" name="serial" value="<%=mot.getSerial()%>"/><br />
            </div>
            <div class="formrow">
                <label for="colour" id="Username-ariaLabel" >Colour: </label> <input type="text" name="colour" value="<%=mot.getColor()%>"/><br />
            </div>
            <div class="formrow">
                <label for="price" id="Username-ariaLabel" >Price: </label> <input type="text" name="price" value="<%=mot.getPrice()%>"/><br />
            </div>
            <div class="formrow">
                <label for="prod_weight" id="Username-ariaLabel" >Product Weight: </label> <input type="text" name="prod_weight" value="<%=mot.getProdWeight()%>"/><br />
            </div>
            <input type="text" name="idModel" value="<%=mot.getIdModel()%>"/>
            
            
            <input type="submit" value="Edit" />
            
        </form>
       <footer>@Project done by Group 4 for AC32006/AC52001 module</footer> </div>
    </body>
</html>
