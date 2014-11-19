

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="stores.*" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="/infraBike/jsp/header_css.css" rel="stylesheet" type="text/css"/>
        <link href="/infraBike/dynatable/jquery.dynatable.css" rel="stylesheet" type="text/css"/>
        <script src="http://code.jquery.com/jquery-1.7.2.min.js" type="text/javascript"></script>
        <script src="/infraBike/dynatable/jquery.dynatable.js" type="text/javascript"></script>
        <style type="text/css">
            #usr-span {
                display: none;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Warehouses</title>
        
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
    <th>Id</th>
    <th>Username</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Location</th>
    <th>Phone Number</th>
    <th>Email</th>
    <th>Role Name</th><%}else if(role.equals("dealer")){
 %>
    <th>Id</th>
    <th>Username</th>
    <th>Name</th>
    <th>Location</th>
    <th>Phone Number</th>
    <th>Personal Email</th>
    <th>Dealer Email</th>
    <%}}%>
  </thead>
  <tbody>
  </tbody>
</table>

<span id="usr-span"></span>  
    </body>
</html>