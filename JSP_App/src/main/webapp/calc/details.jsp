<%-- 
    Document   : result
    Created on : 19 ago. 2021, 15:25:23
    Author     : jose
--%>

<%@page import="com.jgranados.jsp_app.calc.db.Record"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                    <div class="card mb-4 shadow-sm">
                        <div class="card-header">
                            <h4 class="my-0 font-weight-normal">${record.operacion}</h4>
                        </div>
                        <div class="card-body">
                            <h1 class="card-title pricing-card-title">${record.resultado}</h1>
                            <ul class="list-unstyled mt-3 mb-4">
                                <li>${record.numero1}</li>
                                <li>${record.numero2}</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page="/includes/footer.jsp" />
        </div>
    </body>
</html>
