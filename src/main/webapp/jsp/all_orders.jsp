

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="../dynatable/jquery.dynatable.css" rel="stylesheet" type="text/css"/>
        <script src="http://code.jquery.com/jquery-1.7.2.min.js" type="text/javascript"></script>
        <script src="../dynatable/jquery.dynatable.js" type="text/javascript"></script>
        <style type="text/css">
            #usr-span {
                display: none;
            }
        </style>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
        
        
        <script>
              // getting JSON from the document works, but of what use is that?
            $(document).ready( function() {
            var json = (${orders});
            var $users = [${orders}];
            var obj = ${orders};
            
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
                    return '<a href="Users/'+v.username+'">Edit</a>';
                    }   
                }
              }); 
            });
        </script>    
    </head>
    <body>
    <div class="center">    
<table id="my-final-table">
  <thead>
    <th>name</th>
    <th>serial</th>
    <th>idOrder</th>
    <th>deliveryPrice</th>
    <th>region</th>
    <th>color</th>
    <th>price</th>
    
    
  </thead>
  <tbody>
  </tbody>
</table>

<span id="usr-span"></span>  
    </div>
</body>
</html>
