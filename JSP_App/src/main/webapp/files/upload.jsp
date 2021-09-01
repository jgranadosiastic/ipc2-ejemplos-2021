<%-- 
    Document   : upload
    Created on : 1 sep. 2021, 14:16:46
    Author     : jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload</title>
    </head>
    <body>
        <form method="POST" action="upload-servlet" enctype="multipart/form-data">
            <label for="datafile">Seleccione un archivo</label>
            <input type="file" name="datafile">
            <br>
            <button type="submit">Subir</button>
        </form>
    </body>
</html>
