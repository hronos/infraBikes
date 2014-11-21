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
    Profile profile = (Profile)request.getAttribute("profile"); %>
    <body>
        <div class="center">
         <%@ include file="header.jsp" %>
         
        <h1>Update your profile</h1>
         <%
                    LoggedIn lg2 = (LoggedIn) session.getAttribute("LoggedIn");
                    if (lg2 != null) {
                        String user = lg2.getUsername();
                   
                        String role = lg2.getRole();
         %>
       
        <%if(role.equals("customer")){%>
        <form action="/infraBike/webapi/Profile/Update/Customer/<%=profile.getCustomer().getIdCustomer()%>" method="POST">
            
            <div class="formrow">
                <label for="username" id="Username-ariaLabel" >Username:</label>
                <input type="text" name="username" value="<%=profile.getCustomer().getUsername() %>"  readonly/><br />
                
            </div>
            <div class="formrow">
                <label for="firstname" id="Username-ariaLabel" >First Name:</label>
                    <input type="text" name="sirstname" value="<%=profile.getCustomer().getFirstName()%>"/><br />
            </div>
            <div class="formrow">
                <label for="lastname" id="Username-ariaLabel" >Last Name:</label>
                    <input type="text" name="lastname" value="<%=profile.getCustomer().getLastName()%>"/><br />
            </div>
            <div class="formrow">
                <label for="location" id="Username-ariaLabel" >Location:</label>
                    <input type="text" name="location" value="<%=profile.getCustomer().getLocation()%>"/><br />
            </div>
            <div class="formrow">
               <label for="phone" id="Username-ariaLabel" >Phone Number: </label> 
                    <input type="text" name="phone" value="<%=profile.getCustomer().getPhoneNumber()%>"/><br />
            </div>
            <div class="formrow">
                <label for="email" id="Username-ariaLabel" >Email: </label> 
                    <input type="text" name="email" value="<%=profile.getCustomer().getEmail()%>"/><br />
            </div>
        
          
            <input type="submit" value="Edit" />
            
        </form>
      <%}else if(role.equals("dealer")){%>
      <form action="/infraBike/webapi/Profile/Update/Dealer/<%=profile.getDealer().getIdDealer()%>" method="POST">
            
            <div class="formrow">
                <label for="username" id="Username-ariaLabel" >Username:</label>
                    <input type="text" name="username" value="<%=profile.getDealer().getUsername()%>" readonly/><br />
                <br />
            </div>
            <div class="formrow">
                <label for="name" id="Username-ariaLabel" >Name:</label> 
                    <input type="text" name="name" value="<%=profile.getDealer().getName()%>"/><br />
            </div>
            <div class="formrow">
                <label for="location" id="Username-ariaLabel" >Location:</label> 
                    <input type="text" name="location" value="<%=profile.getDealer().getLocation()%>"/><br />
            </div>
            <div class="formrow">
                <label for="phone" id="Username-ariaLabel" >Phone Number:</label>
                    <input type="text" name="phone" value="<%=profile.getDealer().getPhone()%>"/><br />
            </div>
            <div class="formrow">
               <label for="emailUser" id="Username-ariaLabel" >Personal Email: </label> 
                    <input type="text" name="emailUser" value="<%=profile.getDealer().getPersonalEmail()%>"/><br />
            </div>
            <div class="formrow">
                <label for="email" id="Username-ariaLabel" >Dealer Email: </label> 
                    <input type="email" name="colour" value="<%=profile.getDealer().getDealerEmail()%>"/><br />
            </div>
           
        
            
            
            
            <input type="submit" value="Edit" />
            
        </form>
      <%}else{ %>
      <form action="/infraBike/webapi/Profile/Update/User/<%=profile.getUser().getIdUser()%>" method="POST">
            
            <div class="formrow">
                <label for="username" id="Username-ariaLabel" >User Name:</label>
                    <input type="text" name="username" value="<%=profile.getUser().getUsername()%> readonly"/><br />
                <br />
            </div>
            <div class="formrow">
                <label for="emailUser" id="Username-ariaLabel" >Email:</label> 
                    <input type="text" name="emailUser" value="<%=profile.getCustomer().getEmail()%>"/><br />
            </div>
           
            
            
            <input type="submit" value="Edit" />
            
        </form>
     <%}}%>        
        <footer>@Project done by Group 4 for AC32006/AC52001 module</footer> </div>
    </body>
</html>
