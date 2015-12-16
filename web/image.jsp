<%-- 
    Document   : image
    Created on : 15-dic-2015, 13:19:54
    Author     : csalas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${pregunta.texto}</h1>
        <img src="data:image/jpeg;base64, ${image} " width="240" height="360"/>
    </body>
</html>
