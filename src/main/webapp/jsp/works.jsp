<%-- 
    Document   : works
    Created on : Nov 2, 2014, 7:38:18 PM
    Author     : dlennart
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@page import="stores.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%

                    LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
                    if (lg != null) {
                        String user = lg.getUsername();
                        String role = lg.getRole();
                        if (lg.getloggedin()) {
                            %>

<!DOCTYPE html>
<html>
    <body>
        User: <%=lg.getUsername()%>
        Role: <%=lg.getRole()%>
        <% } }%>
    </body>
</html>
