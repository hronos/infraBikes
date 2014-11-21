<%-- 
    Document   : warehouse_info
    Created on : 10-Nov-2014, 18:10:05
    Author     : Anna
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
        <title>Warehouses</title>
        
        <script>
              // getting JSON from the document works, but of what use is that?
            $(document).ready( function() {
            
            var obj = ${warehouses};
            
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
                    return '<a href="/infraBike/webapi/Warehouse/Update/'+v.idWarehouse+'">Edit</a>';
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
    <th>idWarehouse</th>
    <th>location</th>
    <th>storageSize</th>
    <th>phone</th>
    <th>link</th>
 
  </thead>
  <tbody>
  </tbody>
</table>

<span id="usr-span"></span> 
        </div>
    </body>
</html>
