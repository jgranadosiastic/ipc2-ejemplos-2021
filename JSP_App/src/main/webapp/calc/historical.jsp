<%-- 
    Document   : result
    Created on : 19 ago. 2021, 15:25:23
    Author     : jose
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.jgranados.jsp_app.calc.db.Record"%>
<%@page import="com.jgranados.jsp_app.calc.db.Record"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.jgranados.jsp_app.calc.CalculatorException"%>
<%@page import="com.jgranados.jsp_app.calc.Calculator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    List<Record> list = (ArrayList<Record>) request.getAttribute("historicals");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="/includes/resources.jsp" />
        <title>Historical</title>
    </head>
    <body>
        <jsp:include page="/includes/header.jsp" />
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <%
                        for (Record record : list) {
                                out.print("Id:" + record.getId());
                                out.print("<br />");
                                out.print("<a href='DetailsServlet?id=" + record.getId() + "'>");
                                out.print("Resultado: " + record.getResultado());
                                out.print("<a />");
                                out.print("<br />");
                                out.print("<br />");
                            }
                    %>
                </div>
            </div>
            <jsp:include page="/includes/footer.jsp" />
        </div>
    </body>
</html>
