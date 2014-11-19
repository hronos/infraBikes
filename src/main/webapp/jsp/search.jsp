<%-- 
    Document   : search
    Created on : Nov 4, 2014, 6:33:59 PM
    Author     : xinyili
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <h1>Search</h1>
        <div>
            <input type="text" name="search_field" value="" size="60"/><br>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" name="" value="Model" />Model&nbsp;&nbsp;
            <input type="radio" name="" value="Engine size" />Engine size&nbsp;&nbsp;
            <input type="radio" name="" value="Keyword" />Keyword&nbsp;&nbsp;
            <br><br>
        </div>
        <div>
            &nbsp;&nbsp;&nbsp;&nbsp;<a href="#">Advanced Search</a>
            <br><br><br><br>
        </div>
        <div>
            <hr>
        </div>
        <br><br>
        <h3>Search results</h3>
        <div>
            &nbsp;&nbsp;&nbsp;&nbsp;<a href="#">Search result link</a>
            <br><br>
            &nbsp;&nbsp;&nbsp;&nbsp;<a href="#">Search result link</a>
            <br><br>
            &nbsp;&nbsp;&nbsp;&nbsp;<a href="#">Search result link</a>
            <br><br>
            &nbsp;&nbsp;&nbsp;&nbsp;<a href="#">Search result link</a>
            <br><br>
        </div>
    </body>
</html>
