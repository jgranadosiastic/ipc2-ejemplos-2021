<%-- 
    Document   : result
    Created on : 19 ago. 2021, 15:25:23
    Author     : jose
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.jgranados.jsp_app.calc.CalculatorException"%>
<%@page import="com.jgranados.jsp_app.calc.Calculator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="msg" class="com.jgranados.jsp_app.calc.servlet.ResultMessage"/>
<jsp:setProperty name="msg" property="*"/>
<%! /*String result = "";
    String mensajeError = "";
    boolean hayError = false;*/
%>
<%
   /* result = request.getParameter("result");
    mensajeError = request.getParameter("mensaje-error");
    hayError = Boolean.valueOf(request.getParameter("hay-error"));*/
    /*
    Calculator calc = new Calculator();

    try {
        calc.setNumber1(request.getParameter("number1"));
        calc.setNumber2(request.getParameter("number2"));

        result = calc.executeOperation(request.getParameter("operation"));
    } catch (CalculatorException e) {
        mensajeError = e.getMessage();
        hayError = true;
    }
*/
    //pageContext.setAttribute("bandera", hayError);

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        <h1>Resultado!</h1>
        
        <c:if test="${msg.error}">
            <h2>Hay un error:</h2>
            <p>${msg.errorMsg}</p>
        </c:if>
        <c:if test="${!msg.error}">
            <h2>El resultado es ${msg.result}</h2>
        </c:if>
        
        <!--
        
        <% 
            //if (mensajeError.length() == 0) {
        %>
        <h2>El resultado es <%/*result*/%></h2>
        <% /*} else {*/%>
        <h2>Hay un error:</h2>
        <p><%/*mensajeError */%></p>
        <%
            //}
        %>
        
        -->
        <a href="index.jsp">Regresar!</a>
    </body>
</html>
