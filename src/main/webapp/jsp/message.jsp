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
        
        <title>Message</title>
    </head>
    <body>
        <p>Message: <c:out value="${msg}"/></p>
        <p> Please click <a href="http://localhost:8080/infraBike/">here</a> 
            to go back to index page now</p>
        
    </body>
</html>
