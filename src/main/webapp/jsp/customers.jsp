<%-- 
    Document   : customers
    Created on : 20-Nov-2014, 14:16:24
    Author     : Fury
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="/infraBike/jsp/header_css.css" rel="stylesheet" type="text/css"/>
        <link href="../dynatable/jquery.dynatable.css" rel="stylesheet" type="text/css"/>
        <script src="http://code.jquery.com/jquery-1.7.2.min.js" type="text/javascript"></script>
        <script src="../dynatable/jquery.dynatable.js" type="text/javascript"></script>
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
            var json = (${customers});
            var $users = [${customers}];
            var obj = ${customers};
            
            input = JSON.stringify(obj);
            
            $("#usr-span").html(input);
            
            
              $('#my-final-table').dynatable({
                dataset: {
                  records: JSON.parse($('#usr-span').text())
                },
                table: {
                  copyHeaderClass: true
                },
                writers: {
                    link: function(v) {
                    return '<a href="Customer/'+v.idCustomer+'">Edit</a>';
                    }   
                }
              }); 
            });
        </script>    
    </head>
    <body>
         <div class="center">
        <%@ include file="header.jsp" %>
        <table id="my-final-table">
  <thead>
    <th>idCustomer</th>
    <th>username</th>
    <th>firstName</th>
    <th>lastName</th>
    <th>location</th>
    <th>phoneNumber</th>
    <th>email</th>
    <th>roleName</th>
  </thead>
  <tbody>
  </tbody>
</table>

<span id="usr-span"></span>  
        <footer>@Project done by Group 4 for AC32006/AC52001 module</footer> </div>
    </body>
</html>