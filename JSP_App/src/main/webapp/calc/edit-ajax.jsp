<%-- 
    Document   : index
    Created on : 19 ago. 2021, 15:20:13
    Author     : jose
--%>

<%@page import="com.jgranados.jsp_app.calc.db.Record"%>
<%@page import="com.jgranados.jsp_app.calc.Operation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    Record record;
%>
<%
    record = (Record) request.getAttribute("record");
%>
<!DOCTYPE html>

<form method="POST" action="details-servlet">
    <div class="mb-3">
        <label for="idRecord">ID:</label>
        <label class="form-control">${record.id}</label>
        <input type="hidden" name="id" value="${record.id}"/>
    </div>
    <div class="mb-3">
        <label for="number1">Numero 1:</label>
        <input type="number" class="form-control" id="number1" name="number1" placeholder="Numero 1" required
               value="${record.numero1}">
    </div>
    <div class="mb-3">
        <label for="number2">Numero 2:</label>
        <input type="number" class="form-control" id="number2" name="number2" placeholder="Numero 2" required
               value="${record.numero2}">
    </div>
    <div class="mb-3">
        <label for="operation">Operacion: </label>
        <select name="operation" class="custom-select d-block w-100" id="operation" required>
            <option value="ADD" <%if (record.getOperacion().equals(Operation.ADD)) {
                                        out.print("selected");
                                    }%>>Suma</option>
            <option value="MULTI" <%=record.getOperacion().equals(Operation.MULTI) ? "selected" : ""%>>Multiplicacion</option>
            <option value="GREATER" <%=record.getOperacion().equals(Operation.GREATER) ? "selected" : ""%>>Obtener Mayor</option>
            <option value="POW" <%=record.getOperacion().equals(Operation.POW) ? "selected" : ""%>>Potencia n1^n2</option>
            <option value="BINARY" <%=record.getOperacion().equals(Operation.BINARY) ? "selected" : ""%>>Conversion Binaria</option>
        </select>
    </div>
    <div class="mb-3">
        <label for="result">Resultado:</label>
        <input class="form-control" id="result" name="result" placeholder="Resultado" required
               value="${record.resultado}">
    </div>
    <hr class="mb-4">
    <button type="submit" class="btn btn-primary btn-lg btn-block">Grabar</button>
</form>