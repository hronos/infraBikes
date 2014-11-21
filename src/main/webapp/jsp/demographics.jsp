<%-- 
    Document   : demographics
    Created on : 20-Nov-2014, 19:28:15
    Author     : Fury
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="/infraBike/jsp/header_css.css" rel="stylesheet" type="text/css"/>
        <link href="../dynatable/jquery.dynatable.css" rel="stylesheet" type="text/css"/>
        <script src="http://code.jquery.com/jquery-1.7.2.min.js" type="text/javascript"></script>
        <script src="../dynatable/jquery.dynatable.js" type="text/javascript"></script>
     
        <style type="text/css">
            #usr-span {
                display: none;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Demographics</title>
        
        <script>
              // getting JSON from the document works, but of what use is that?
            $(document).ready( function() {
            var json = (${demographics});
            var $users = [${demographics}];
            var obj = ${demographics};
            
            input = JSON.stringify(obj);
            
            $("#usr-span").html(input);
            
            
              $('#my-final-table').dynatable({
                dataset: {
                  records: JSON.parse($('#usr-span').text())
                },
                table: {
                  copyHeaderClass: true
                },
                writers: {
                    link: function(v) {
                    return '<a href="Demographics/'+v.region+'">Edit</a>';
                    }   
                }
              }); 
            });
        </script>    
    </head>
    <body>
        
        <%@ include file="header.jsp" %>
        <table id="my-final-table">
  <thead>
    <th>region</th>
    <th>population</th>
    <th>averageAge</th>
    <th>married</th>
    <th>commuting</th>
    <th>crimeStats</th>
    <th>traffic_info</th>
    <th>parking</th>
    <th>snowyDays</th>
    <th>rainyDays</th>
    <th>averageTemperature</th>
    
  </thead>
  <tbody>
  </tbody>
</table>
<h1>Graphs for marketing</h1>
        <h4>  <a href="/infraBike/jsp/demo.jsp">Population graph</a> </h4>
        <h4> <a href="/infraBike/jsp/charts.jsp">Commuting graph</a> </h4>
<span id="usr-span"></span>  
    </body>
    </head>
   
</html>
