<%-- 
    Document   : dealer
    Created on : 19-Nov-2014, 20:47:22
    Author     : Fury
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <script src="http://code.jquery.com/jquery-1.7.2.min.js" type="text/javascript"></script>
        <link href="/infraBike/jsp/header_css.css" rel="stylesheet" type="text/css"/>
        <script src="/infraBike/dynatable/jquery.dynatable.js" type="text/javascript"></script>
        <link href="/infraBike/dynatable/jquery.dynatable.css" rel="stylesheet" type="text/css"/>
        
        
        <style type="text/css">
            #usr-span {
                display: none;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dealer</title>
        
        <script>
              // getting JSON from the document works, but of what use is that?
            $(document).ready( function() {
            var json = (${dealer});
            var $users = [${dealer}];
            var obj = ${dealer};
            
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
                    return '<a href="Dealer/'+v.idDealer+'">Edit</a>';
                    }   
                }
              }); 
            });
        </script>    
    </head>
    <body>
        <div class="center">
        <%@ include file="header.jsp" %>
        <table id="my-final-table">
  <thead>
    <th>idDealer</th>
    <th>username</th>
    <th>name</th>
    <th>location</th>
    <th>phone</th>
    <th>personalEmail</th>
    <th>dealerEmail</th>
    <th>link</th>
 
  </thead>
  <tbody>
  </tbody>
</table>

<span id="usr-span"></span>  
        </div>
    </body>
</html>
