<%-- 
    Document   : destinopost
    Created on : 17 ago. 2021, 16:26:42
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
        <h1>Datos procesados!</h1>
        <h1><%=request.getParameter("nombre") %></h1>
        <h1><%=request.getParameter("apellido") %></h1>
        <%
            response.getWriter().append("<p>HOLA MUNDO DESDE WRITER</p>");
        %>
        
    </body>
</html>
