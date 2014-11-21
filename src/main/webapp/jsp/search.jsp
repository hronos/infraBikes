<%-- 
    Document   : search
    Created on : Nov 4, 2014, 6:33:59 PM
    Author     : xinyili
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.util.ArrayList"%>
<%@page import ="java.util.Iterator"%>
<%@page import =" java.util.ListIterator"%>
<%@page import =" uk.ac.dundee.computing.infrabike.dto.MotorcycleLo"%>
<%@page import="stores.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/infraBike/jsp/header_css.css" rel="stylesheet" type="text/css"/>
        <title>Search</title>
    </head>

    <body>
        <div class="center">
        <%@ include file="header.jsp" %>
        <%ArrayList<MotorcycleLo> list = new ArrayList<MotorcycleLo>();
            list = (ArrayList<MotorcycleLo>) request.getAttribute("list");%>

        <%
            LoggedIn lg2 = (LoggedIn) session.getAttribute("LoggedIn");
            if (lg2 != null) {
                String user = lg2.getUsername();

                String role = lg2.getRole();
        %>


        <h1>Search</h1>
        <div>
            <form action="/infraBike/webapi/Model" method="POST">
                <input type="text" name="search_field" value="" size="60"/><br>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <input type="radio" name="type" value="Model" />Model&nbsp;&nbsp;
                <input type="radio" name="type" value="Engine size" />Engine size&nbsp;&nbsp;

                <input type="submit" value="Search">
                <br><br>
            </form>
        </div>
        <div>
            <%-- &nbsp;&nbsp;&nbsp;&nbsp;<a href="#">Advanced Search</a> --%>
        </div>
        <div>
            <hr>
        </div>
        <h3>Search results</h3>

        <div>
            <%
                ListIterator<MotorcycleLo> litr = list.listIterator();
                while (litr.hasNext()) {
                    MotorcycleLo mot = litr.next();
            %>
            <a href="/infraBike/webapi/Model/<%=mot.getIdModel()%>" style="width: 120px; height: 60px"> 
                Model: <%=mot.getModelName()%>  
                Colour: <%=mot.getColor()%> 
                Price: <%=mot.getPrice()%> 
            </a>      

            <%if (role.equals("admin")) {%> 
            <a href="/infraBike/webapi/Model/Delete/<%=mot.getIdModel()%>" id="delete" >Delete</a> 
            <input type="hidden" id="id" value="<%=mot.getIdModel()%>">
            <br><br>
            <%}
                }
                if (role.equals("admin")) {%>
            <a href="/infraBike/webapi/Model/Add/" id="add" >Add</a>
            <%}
                }%>

        </div>
        </div>
    </body>
</html>
