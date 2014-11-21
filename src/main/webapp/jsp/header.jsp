<%-- 
    Document   : header
    Created on : 04-Nov-2014, 13:11:00
    Author     : Anna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="stores.*" %>

        <div id="container">
            <div id="logo">
               <img class="displayed" src="/infraBike/logo.jpg">
            </div>
            <div id="menu_bar">
                <%
                    LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
                    if (lg != null) {
                        String user = lg.getUsername();
                        String role = lg.getRole();
                        System.out.println("Roleee: " + role);
                        if (role.equals("customer")) {
                            %>
                        <ul>
                            <li><a href="/infraBike/webapi/Profile/<%=user%>">Profile</a></li>
                            <li><a href="/infraBike/webapi/Motorcycle">Motorcycles</a></li>
                            <li><a href="/infraBike/webapi/Order/<%=user%>/<%=role%>">Orders</a></li> 
                            <li><a href="/infraBike">Log out</a></li></ul>
                            <% } 
                        else if (role.equals("admin")){%>
                        
                           <ul>
                            <li><a href="/infraBike/webapi/Profile/">Profiles</a></li>
                            <li><a href="/infraBike/webapi/Motorcycle">Motorcycles</a></li>
                            <li><a href="/infraBike/webapi/Order">Orders</a></li>
                             <li><a href="/infraBike/webapi/Warehouse">Warehouses</a></li>
                             <li><a href="/infraBike/webapi/Users">Users</a></li>
                             <li><a href="/infraBike">Log out</a></li></ul>
                             
                            <% } 
                        else if (role.equals("marketing")) { %>
                        <ul>
                            <li><a href="/infraBike/webapi/Profile/<%=user%>">Profile</a></li>
                            <li><a href="/infraBike/webapi/Demographics">Demographics</a></li>
                            <li><a href="/infraBike/webapi/Customer">Customers</a></li>
                            <li><a href="/infraBike/webapi/Users/Dealer">Dealers</a></li>
                            <li><a href="/infraBike/webapi/Supplier">Suppliers</a></li>
                            <li><a href="/infraBike/webapi/Warehouse">Warehouse</a></li>
                            <li><a href="/infraBike/webapi/Motorcycle">Motorcycles</a></li>
                            <li><a href="/infraBike/webapi/Order">Orders</a></li>
                            <li><a href="/infraBike">Log out</a></li></ul>
                        
                        <% }
                        else if(role.equals("manager")) { %>
                        <ul>
                            <li><a href="/infraBike/webapi/Profile/<%=user%>">Profile</a></li>
                            <li><a href="/infraBike/webapi/Customer">Customers</a></li>
                            <li><a href="/infraBike/webapi/Users/Dealer">Dealers</a></li>
                            <li><a href="/infraBike/webapi/Supplier">Suppliers</a></li>
                            <li><a href="/infraBike/webapi/Order">Orders</a></li>
                            <li><a href="/infraBike">Log out</a></li>
                        </ul>
                        <% }
                        else if(role.equals("tech")) { %>
                        <ul>
                            <li><a href="/infraBike/webapi/Profile/<%=user%>">Profile</a></li>
                            <li><a href="/infraBike/webapi/Motorcycle">Motorcycle</a></li>
                            
                                <li><a href="/infraBike">Log out</a></li>
                           
                        </ul>
                        
                        <% }
                       else if(role.equals("warehouse_keeper")) { %>
                        <ul id="nav">
                            <li id="nav-1"><a href="/infraBike/webapi/Profile/<%=user%>">Profile</a></li>
                            <li id="nav-2"><a href="/infraBike/webapi/Warehouse">Warehouse</a></li>
                            <li id="nav-3"><a href="">Parts</a></li>
                            <li id="nav-4"><a href="//infraBike/webapi/Motorcycle">Motorcycles</a></li>
                            <li id="nav-5"><a href="/infraBike/webapi/Supplier">Suppliers</a></li>
                            <li id="nav-6"><a href="/infraBike/webapi/Order">Orders</a></li>
                            <li id="nav-7"><a href="/infraBike">Log out</a></li>
                        </ul>
                        <% }
                        else if(role.equals("dealer")) { %>
                            <ul>
                                <li><a href="/infraBike/webapi/Profile/<%=user%>">Profile</a></li>
                            <li><a href="/infraBike/webapi/Motorcycle">Motorcycles</a></li>
                            <li><a href="/infraBike/webapi/Order/<%=user%>/<%=role%>">Orders</a></li>
                            <li><a href="/infraBike">Log out</a></li></ul>
                        <% }} %>
         
                 
            </div>
        </div>
