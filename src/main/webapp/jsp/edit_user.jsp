<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@page contentType="text/html" pageEncoding="UTF-8" %>
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
    int current_role = (int) request.getAttribute("role");
    username = (String) request.getAttribute("username"); 
    switch(current_role){
        default:
             throw new IllegalArgumentException("Invalid role");
        case 1:
            role_name = "admin";
            break;
        case 2:
            role_name = "marketing";
            break;
        case 3:
            role_name = "manager";
            break;
        case 4:
            role_name = "tech";
            break;
        case 5:
            role_name = "warehouse keeper";
            break;
        case 6:
            role_name = "customer";
            break;
        case 7:
            role_name = "dealer";
            break;
            
    }%>
    
    <body>
        <%@ include file="header.jsp" %>
        <h1>Edit user</h1>
        User: <%= username %>
        Current role: <%= role_name %>
        
        <form method="post" action="/infraBike/webapi/Users/<%= username %>">
<div class="formrow">
	<label for="txt_Username" id="Username-ariaLabel" >Username</label>
        <input id="txt_Username" name="txt_Username" value="<%= username %>"  type="text" aria-labelledby="Username-ariaLabel" disabled/>
</div>
<div class="formrow">
	<label for="sel_Role" id="Role-ariaLabel">Role</label>
	<select id="sel_Role" name="sel_Role" aria-labelledby="Role-ariaLabel">
		<option value="admin">admin</option>
		<option value="marketing">marketing</option>
		<option value="manager">manager</option>
		<option value="tech">tech</option>
		<option value="warehouse_keeper">warehouse_keeper</option>
		<option value="customer">customer</option>
		<option value="dealer">dealer</option>
	</select>
</div>
<div class="row">
<input type="submit" value="Save" />
</div>
</form>

        
 

    </body>
</html>
