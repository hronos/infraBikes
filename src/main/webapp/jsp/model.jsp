<%-- 
    Document   : model
    Created on : 20-Nov-2014, 11:57:09
    Author     : Anna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="stores.*" %>
<%@page import="uk.ac.dundee.computing.infrabike.dto.*" %>
<%@page import ="java.util.ArrayList"%>
<%@page import ="java.util.Iterator"%>
<%@page import =" java.util.ListIterator"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/infraBike/jsp/infra.css" rel="stylesheet"/>
        <link href="/infraBike/jsp/header_css.css" rel="stylesheet" type="text/css"/>
        <link href="/infraBike/dynatable/jquery.dynatable.css" rel="stylesheet" type="text/css"/>
        <script src="/infraBike/jsp/tabsheet.js"></script>
        <title>JSP Page</title>
        
    </head>
    
    <body onload="init()">
        <div class="center">
        <%int id;
           id= (Integer) request.getAttribute("id");    %>
          <%MotorcycleLo mot;
           mot= (MotorcycleLo) request.getAttribute("mot");    %>
          <%ArrayList <MotPartLo> part;
           part= (ArrayList<MotPartLo>) request.getAttribute("part");    %>
         <%@ include file="header.jsp" %>
        <h3>Model <%=mot.getModelName() %></h3> 
        <h3>Colour <%=mot.getColor() %></h3> 
        <h3>Price <%=mot.getPrice() %></h3> 
        <h3>Product Weight <%=mot.getProdWeight() %></h3>     
       
<ul id="tabs">
        <li  onclick="showTab()"><a href="#about">Model specification</a></li>
        <li onclick="showTab()"><a href="#advantages">Model Parts</a></li>
       
</ul>  
<div class="tabContent" id="about">
   </br > </br>
   
    <h4>Name: <%= mot.getModelName()%> </h4>
    <h4>Top speed: <%=mot.getTopSpeed() %> </h4>
    <h4>Weight: <%= mot.getWeight()%> </h4>
    <h4>Seat Height: <%= mot.getSeatHeight()%> </h4>
    <h4>Engine: <%= mot.getEngineSizeCc()%> </h4>
    <h4>Power: <%= mot.getPowerKw()%> </h4>
    <h4>Front Tyre Size: <%= mot.getFrontTyreSize()%> </h4>
    <h4>Rare Tyre Size: <%= mot.getRearTyreSize()%> </h4>
  <div>
     </div>
  
</div>
    

<div class="tabContent" id="advantages">
    
    </br > </br>
 
  
  <% 
                ListIterator<MotPartLo> litr = part.listIterator();
                while (litr.hasNext()) {
                    MotPartLo motPart = litr.next();
                %>
               
                <h4>Type: <%= motPart.getPartType() %> </h4>
                <h4>Name: <%= motPart.getPartName() %> </h4>            
            <br><br>
            <%}%>
  
  <div>
    
  </div>
</div>
        
       
            <%
            LoggedIn lg2 = (LoggedIn) session.getAttribute("LoggedIn");
            if (lg2 != null) {
                String user = lg2.getUsername();

                String role = lg2.getRole();
        %>
        <%if(role.equals("admin")){%> <a id="buttons" href="/infraBike/webapi/Model/Update/<%=mot.getIdModel()%>">Update</a><%}}%>
 
    
       <footer>@Project done by Group 4 for AC32006/AC52001 module</footer> 
        </div>
    </body>
    
  
    
    
</html>
