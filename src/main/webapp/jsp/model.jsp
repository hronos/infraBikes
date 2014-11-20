<%-- 
    Document   : model
    Created on : Nov 4, 2014, 7:24:16 PM
    Author     : xinyili
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="stores.*" %>

<!DOCTYPE html>
<html>
    <head>
        
        
     
        <link href="/infraBike/jsp/infra.css" rel="stylesheet" type="text/css"/>
      
        <link href="/infraBike/dynatable/jquery.dynatable.css" rel="stylesheet" type="text/css"/>
        <script src="http://code.jquery.com/jquery-1.7.2.min.js" type="text/javascript"> </script>
        <script src="/infraBike/dynatable/jquery.dynatable.js" type="text/javascript"> </script>
        
        <script src="tabsheet.js"></script>
        <style type="text/css">
            #usr-span {
                display: none;
            }
        </style>
        
        <title>Motorcycle</title>
        <script>
              // getting JSON from the document works, but of what use is that?
            $(document).ready( function() {
            
            var obj = ${model};
            
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
    <body onload="init()">
        
        <h1>Model</h1>

        <%
                    LoggedIn lg2 = (LoggedIn) session.getAttribute("LoggedIn");
                    if (lg2 != null) {
                        String user = lg2.getUsername();
                   
                        String role = lg2.getRole();
        %>
                        
        <ul id="tabs">
        <li><a href="#Model specifications">Model specification</a></li>
        <li><a href="#parts">Parts</a></li>
        </ul>
 <table id="my-final-table">
  <thead>
      <th>color</th>
      <th>price</th>
      <th>productWeight</th>
        <div class="tabContent" id="model">
            

                <th>modelName</th>
                <th>topSpeed</th>
                <th>weight</th>
                <th>seatHeight</th>
                <th>engineSizeCC</th>
                <th>power</th>
                <th>frontTyreSize</th>
                <th>rearTyreSize </th>

    
   
    
    
<%}%>


  
            
        </div>
        
        <div class="tabContent" id="parts">
        
            
                
                <th>partName</th>
                <th>partType</th>
                
            
            
        </div>
</thead>
  <tbody>
  </tbody>
</table>
    </body>
</html>      
      

