<%-- 
    Document   : editProfile
    Created on : 20-Nov-2014, 23:24:49
    Author     : Anna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import =" uk.ac.dundee.computing.infrabike.dto.Profile"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Update</title>
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
    Profile profile = (Profile)request.getAttribute("prifile"); %>
    <body>
         <%@ include file="header.jsp" %>
        <h1>Update your profile</h1>
        
       
        
        <form action="/infraBike/webapi/Model/Update" method="POST">
            <div class="formrow">
                <label for="model_name" id="Username-ariaLabel" >Model Name:</label>
                
                <br />
            </div>
            <div class="formrow">
                <label for="top_speed" id="Username-ariaLabel" >Top Speed:</label> <br />
            </div>
            <div class="formrow">
                <label for="Weight" id="Username-ariaLabel" >Weight:</label> <br />
            </div>
            <div class="formrow">
                <label for="seat_height" id="Username-ariaLabel" >Seat Height:</label><br />
            </div>
            <div class="formrow">
               <label for="frame" id="Username-ariaLabel" >Frame: </label> <br />
            </div>
            <div class="formrow">
                <label for="tank" id="Username-ariaLabel" >Tank: </label> <br />
            </div>
        
            <input type="text" name="idModel" value=""/>
            
            
            <input type="submit" value="Edit" />
            
        </form>
    </body>
</html>
