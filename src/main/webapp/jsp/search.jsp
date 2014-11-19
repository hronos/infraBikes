<%-- 
    Document   : search
    Created on : Nov 4, 2014, 6:33:59 PM
    Author     : xinyili
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.util.ArrayList"%>
<%@page import =" java.util.Iterator"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <%ArrayList list = (ArrayList) request.getAttribute("list");%>
    <body>
        <h1>Search</h1>
        <div>
            <form action="/infraBike/webapi/Motorcycle" method="GET">
            <input type="text" name="search_field" value="" size="60"/><br>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" name="type" value="Model" />Model&nbsp;&nbsp;
            <input type="radio" name="type" value="Engine size" />Engine size&nbsp;&nbsp;
            <input type="radio" name="type" value="Keyword" />Keyword&nbsp;&nbsp;
            <input type="submit" value="Search">
            <br><br>
            </form>
        </div>
        <div>
           <%-- &nbsp;&nbsp;&nbsp;&nbsp;<a href="#">Advanced Search</a> --%>
            <br><br><br><br>
        </div>
        <div>
            <hr>
        </div>
        <br><br>
        <h3>Search results</h3>
        
        <div>
            <% Iterator<Object> it = list.iterator();
                while(it.hasNext()){%>
            &nbsp;&nbsp;&nbsp;&nbsp;<a href="#">Search result link</a>
            
            <br><br>
            <%}%>
            
            
        </div>
    </body>
</html>
