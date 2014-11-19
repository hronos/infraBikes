<%-- 
    Document   : model
    Created on : Nov 4, 2014, 7:24:16 PM
    Author     : xinyili
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="infra.css" rel="stylesheet" type="text/css">
        <script src="tabsheet.js"></script>
        <title>model</title>
    </head>
    <body onload="init()">
        <%@ include file="header.jsp" %>
        <h1>Model</h1>
        
        <ul id="tabs">
        <li><a href="#Model specifications">Model specification</a></li>
        <li><a href="#parts">Parts</a></li>
        </ul>
        
        <div class="tabContent" id="model">
        
        </div>
        
        <div class="tabContent" id="parts">
        
        </div>

    </body>
</html>
