<%-- 
    Document   : model
    Created on : 20-Nov-2014, 11:57:09
    Author     : Anna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/infraBike/jsp/infra.css" rel="stylesheet"/>
        <link href="/infraBike/jsp/header_css.css" rel="stylesheet" type="text/css"/>
        <script src="/infraBike/jsp/tabsheet.js"></script>
        <title>JSP Page</title>
        
    </head>
    
    <body onload="init()">
        
        <%int id;
           id= (Integer) request.getAttribute("id");    %>
          
         <%@ include file="header.jsp" %>
        <h1>Hello World!</h1>
              
<ul id="tabs">
        <li  onclick="showTab()"><a href="#about">Model specification</a></li>
        <li onclick="showTab()"><a href="#advantages">Model Parts</a></li>
       
</ul>  
<div class="tabContent" id="about">
  <h2>Model</h2>
  <div>
     </div>
</div>
    

<div class="tabContent" id="advantages">
    
    </br > </br>
  <h2>Model</h2>
  <div>
    
  </div>
</div>
            
 
    
        
        
    </body>
    
  
    
    
</html>
