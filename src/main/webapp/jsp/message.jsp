<%-- 
    Document   : message
    Created on : Nov 16, 2014, 3:19:10 PM
    Author     : dlennart
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/infraBike/jsp/header_css.css">
        <title>Error</title>
    </head>
    <body>
        
        <%@ include file="header.jsp" %>
        <div class="center">
        <p>Message: <c:out value="${msg}"/></p>
        <p> Please click <a href="http://localhost:8080/infraBike/">here</a> 
            to go back to index page now</p>
        
     <footer>@Project done by Group 4 for AC32006/AC52001 module</footer>   </div>
    
    </body>
</html>
