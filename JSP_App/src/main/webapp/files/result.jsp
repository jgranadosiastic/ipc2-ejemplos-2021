<%-- 
    Document   : result
    Created on : 1 sep. 2021, 14:57:25
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
        <h1>Download!</h1>
        <a href="download-servlet?path=<%= request.getParameter("path")%>"> descargar </a>
    </body>
</html>
