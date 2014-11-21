<%-- 
    Document   : customers
    Created on : Nov 3, 2014, 10:53:37 AM
    Author     : dlennart
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/infraBike/jsp/header_css.css">
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers</title>
    </head>
    <body>
        <div class="center">
        <%@ include file="header.jsp" %>
        <h1>Customers</h1>
        
        <script type='text/javascript'>
        $(document).ready(function()
        {
        $.ajax
        ({
        type: "GET",
        url: "webapi/Customers",
        dataType:"json",
        success: function(data)
        {
        if(data.Customers.length)
        {
        $.each(data.Customers, function(i,data)
        {
        var cust_data="<div id='cust"+data.id_customer+"'>"+data.first_name+"</div>";
        $(cust_data).appendTo("#content");
        });
        }
        else
        {
        $("#content").html("No Results");
        }
        }
        });
        $('#UpdateButton').click(function() 
        {
        // Previous Post
        });
        return false;
        });
        });
        </script>

<textarea id='Message'></textarea><br/>
<input type='button' value=' Update ' id='UpdateButton'/>
<div id='content'></div>
     <footer>@Project done by Group 4 for AC32006/AC52001 module</footer>   </div>
    </body>
</html>
