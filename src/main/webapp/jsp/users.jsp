

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>

        <style>
            .jsontotable table, .jsontotable th, .jsontotable td {
                border: 1px solid black;
                margin: 10px;
            }

            code {
                white-space: normal;
            }
        </style>
        <link rel="stylesheet" type="text/css" href="/infraBike/jsp/header_css.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
        <script>
            var json = (${users});
            var $users = [${users}];



        </script>
    </head>
    <body>
        <div class="center">
        <%@ include file="header.jsp" %>
        <h1>Users</h1>
        Value: [<c:out value="${users}"/>]
        <div class="container">
            <div id="jsontotable-arr" class="jsontotable"></div>
            <div id="jsontotable-obj" class="jsontotable"></div>
            <div id="jsontotable-objwithdata" class="jsontotable"></div>
            <div id="jsontotable-str" class="jsontotable"></div>
        </div>
        <script src="../js/libs/jquery/jquery.min.js" type="text/javascript"></script>
        <script src="../js/libs/jquery.jsontotable.js" type="text/javascript"></script>
        <script type="text/javascript">
            var obj = ${users};

            input = JSON.stringify(obj);
            $("#jsontotable-obj")
                    .append($("<h1></h1>").html("JSON To Table (Has Header)"))
                    .append($("<h2></h2>").html("Input"))
                    .append($("<code></code>").html(input))
                    .append($("<h2></h2>").html("Output"));

            $.jsontotable(obj, {id: "#jsontotable-obj"});

            $("#jsontotable-obj")
        </script>
        </div>
    </body>
</html>
