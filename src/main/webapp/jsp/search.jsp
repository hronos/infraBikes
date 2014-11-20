<%-- 
    Document   : search
    Created on : Nov 4, 2014, 6:33:59 PM
    Author     : xinyili
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.util.ArrayList"%>
<%@page import =" java.util.ListIterator"%>
<%@page import =" uk.ac.dundee.computing.infrabike.dto.MotorcycleLo"%>
<%@page import ="java.util.Iterator"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    
    <body>
        <%ArrayList <MotorcycleLo> list =new ArrayList <MotorcycleLo>();
          list= (ArrayList <MotorcycleLo>) request.getAttribute("list");%>
        <h1>Search</h1>
        <div>
            <form action="/infraBike/webapi/Model" method="POST">
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
            <% 
                ListIterator<MotorcycleLo> litr = list.listIterator();
                while (litr.hasNext()) {
                    MotorcycleLo mot = litr.next();
                %>
                &nbsp;&nbsp;&nbsp;&nbsp;<a href="/infraBike/webapi/Model/<%=mot.getIdModel()%>"> Model: <%=mot.getModelName()%>  Colour: <%=mot.getColor()%> Price: <%=mot.getPrice()%> </a>
            
            <br><br>
            <%}%>
            
            
        </div>
    </body>
</html>
