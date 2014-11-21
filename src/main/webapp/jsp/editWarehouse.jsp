<%-- 
    Document   : editWarehouse
    Created on : 21-Nov-2014, 10:30:35
    Author     : Anna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import =" uk.ac.dundee.computing.infrabike.dto.WarehouseLo" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <link href="/infraBike/jsp/header_css.css" rel="stylesheet" type="text/css"/>
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
    username = (String) request.getAttribute("username"); 
    WarehouseLo war = (WarehouseLo)request.getAttribute("warehouse"); %>
    
    <body>
        <div class="center">
          <%@ include file="header.jsp" %>
        <form action="/infraBike/webapi/Warehouse/Update/<%=war.getLocation()%>" method="POST">
            <div class="formrow">
                <label for="storage_size" id="Username-ariaLabel" >Storage Size:</label>
                <input type="text" name="storage_size" value="<%=war.getStorageSize()%>">
                <br />
            </div>
                <div class="formrow">
                <label for="phone" id="Username-ariaLabel" >Phone:</label>
                <input type="text" name="phone" value="<%=war.getPhone()%>">
                <br />
                 </div>
          <input type="submit" value="Edit" />
                
        </form>
        </div>
    </body>
</html>
