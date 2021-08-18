<%-- 
    Document   : indexget
    Created on : 17 ago. 2021, 16:08:12
    Author     : jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index GET</title>
    </head>
    <body>
        <%! int valor = 50;%>
        <h1>Hola mundo!!</h1>
        scriptlet
        <p id="p1" class="parrafo-rojo">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse imperdiet eleifend turpis vitae aliquam. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Vivamus finibus malesuada orci eget tincidunt. Phasellus at est aliquam, molestie sem a, tincidunt arcu. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin tincidunt lacus non arcu tempor dignissim. Ut accumsan faucibus magna, et ullamcorper quam rutrum ut. Nam lorem nisl, suscipit a tempus eget, pellentesque id nulla.</p>
        <%
            String textoVal = request.getParameter("texto");
            if (textoVal != null && textoVal.equalsIgnoreCase("id2")) {
        %>
        <p id="id2">
            Maecenas non ultrices est. Sed ultricies metus varius nunc auctor, et tincidunt nibh convallis. Curabitur pharetra pharetra nibh, a placerat diam tristique vitae. Aenean at diam purus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla vitae tincidunt lacus, sed accumsan turpis. Aenean commodo eros leo, vehicula mattis ipsum volutpat ac. Quisque at varius ipsum.
        </p>
        <%
            }

        %>
        <h1><%= suma(valor, valor * 2)%></h1>
    </body>
</html>

<%!

    int suma(int num1, int num2) {
        return num1 + num2;
    }
%>
