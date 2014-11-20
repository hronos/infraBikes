<%-- 
    Document   : showUser
    Created on : 20-Nov-2014, 00:06:49
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
        
<table id="my-final-table">
  <thead>
    <th>idUser</th>
    <th>username</th>
    <th>idRole</th>
    <th>role</th>
    <th>email</th>
    <th>link</th>
    
  </thead>
  <tbody>
  </tbody>
</table>

<span id="usr-span"></span>  
        
</body>
</html>
