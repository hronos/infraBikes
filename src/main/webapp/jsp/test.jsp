

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
            var json = (${users});
            var $users = [${users}];
            var obj = ${users};
            
            input = JSON.stringify(obj);
            
            $("#usr-span").html(input);
            
            
              $('#my-final-table').dynatable({
                dataset: {
                  records: JSON.parse($('#usr-span').text())
                },
                table: {
                  copyHeaderClass: true
                }
              }); 
            });
        </script>    
    </head>
    <body>
        
<table id="my-final-table">
  <thead>
    <th>idUser</th>
    <th>username</th>
    <th>password</th>
    <th>idRole</th>
    <th>email</th>
  </thead>
  <tbody>
  </tbody>
</table>

<span id="usr-span"></span>  
        
</body>
</html>
