<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="stores.*" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="/infraBike/jsp/header_css.css" rel="stylesheet" type="text/css"/>
        <link href="/infraBike/jsp/edit_form.css" rel="stylesheet" type="text/css"/>
        <link href="/infraBike/dynatable/jquery.dynatable.css" rel="stylesheet" type="text/css"/>
        <script src="http://code.jquery.com/jquery-1.7.2.min.js" type="text/javascript"></script>
        <script src="/infraBike/dynatable/jquery.dynatable.js" type="text/javascript"></script>
        <style type="text/css">
            #usr-span {
                display: none;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Profile</title>   
        <script>
              // getting JSON from the document works, but of what use is that?
            $(document).ready( function() {
            
            var obj = ${profile};
            
            input = JSON.stringify(obj);
            
            $("#usr-span").html(input);
            
            
              $('#my-final-table').dynatable({
                dataset: {
                  records: JSON.parse($('#usr-span').text())
                },
                table: {
                  copyHeaderClass: true
                }
              }); 
            });
        </script>    
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <%
                    LoggedIn lg2 = (LoggedIn) session.getAttribute("LoggedIn");
                    if (lg != null) {
                        String user = lg2.getUsername();
                   
                        String role = lg2.getRole();
                        %>
                        
                           
  <table id="my-final-table">
  <thead>
<%if (role.equals("customer")) {%>
    <th>idCustomer</th>
    <th>username</th>
    <th>firstName</th>
    <th>lastName</th>
    <th>location</th>
    <th>phoneNumber</th>
    <th>email</th>
    <th>roleName</th><%}else if(role.equals("dealer")){
 %>
    <th>idDealer</th>
    <th>username</th>
    <th>name</th>
    <th>location</th>
    <th>phone</th>
    <th>personalEmail</th>
    <th>dealerEmail</th>
    <%}else{%>
    
    <th>idUser</th>
    <th>username</th>
    <th>email</th>
   <%--<th><a href="/infraBike/webapi/Profile/" id="delete" onclick="deleteUser()">Delete user</a></th> --%>
  
    
   
    
    
<%}}%>


  </thead>
  <tbody>
  </tbody>
</table>

<form class="form-container">
<div class="form-title"><h2>Edit Profile</h2></div>
<div class="form-title">Name</div>
<input class="form-field" type="text" name="firstname" /><br />
<div class="form-title">Email</div>
<input class="form-field" type="text" name="email" /><br />
<div class="submit-container">
<input class="submit-button" type="submit" value="Submit" />
</div>
</form>
  
<span id="usr-span"></span>  
    </body>
</html>
