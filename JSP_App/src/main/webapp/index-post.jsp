<%-- 
    Document   : indexpost.jsp
    Created on : 17 ago. 2021, 16:23:13
    Author     : jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="destino-post.jsp">
            <label>Nombre:</label>
            <input name="nombre"/>
            
            <label>Apellido:</label>
            <input name="apellido"/>
            
            <button type="submit">Enviar</button>
        </form>
    </body>
</html>
