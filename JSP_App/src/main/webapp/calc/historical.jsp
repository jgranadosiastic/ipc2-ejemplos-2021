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
                    <table id="table" class="table table-bordered table-striped">
                        <thead>
                            <tr class="table-info">
                                <th scope="col">
                                    <div class="th-inner ">ID</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th scope="col">
                                    <div class="th-inner ">Numero 1</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th scope="col">
                                    <div class="th-inner ">Numero 2</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th scope="col">
                                    <div class="th-inner ">Operación</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th scope="col">
                                    <div class="th-inner ">Resultado</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th scope="col">
                                    <div class="th-inner "></div>
                                    <div class="fht-cell"></div>
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${historicals}" var="record">
                                <tr>
                                    <th scope="row">${record.id}</th>
                                    <td>${record.numero1}</td>
                                    <td>${record.numero2}</td>
                                    <td>${record.operacion}</td>
                                    <td>
                                        <a href='#' onclick="openDetailsModal('${pageContext.request.contextPath}', ${record.id})">${record.resultado}</a>
                                    </td>
                                    <td>
                                        <a href="details-servlet?edit=true&id=${record.id}" 
                                           class="btn btn-lg btn-block btn-outline-primary">
                                            Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <jsp:include page="/includes/footer.jsp" />
        </div>

        <div id="myModal" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Detalle</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body" id="modal-content">
                        <p>Modal body text goes here.</p>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
