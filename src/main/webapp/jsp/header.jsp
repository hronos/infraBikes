<%-- 
    Document   : header
    Created on : 04-Nov-2014, 13:11:00
    Author     : Anna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="stores.*" %>

        <div id="container">
            <div id="logo">
               <img class="displayed" src="/infraBike/image.jpg">
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
                            <li><a href="">Profile</a></li>
                            <li><a href="">Motorcycles</a></li>
                            <li><a href="">Orders</a></li>
                            <% } else if (role.equals("admin")){%>
                            <li><a href="">Motorcycles</a></li>
                            <li><a href="">Orders</a></li>
                            <li><a href="">Reports</a></li>
                             <li><a href="">Warehouse</a></li>
                            <ul>
                                <li><a href="">Stock</a></li>
                                <li><a href="">Info</a></li>
                            </ul>
                            <li><a href="/infraBike/webapi/Users">Users</a></li>
                            <% }} %>
                </ul>   
            </div>
        </div>
