<%-- 
    Document   : index
    Created on : 19 ago. 2021, 15:20:13
    Author     : jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="/includes/resources.jsp" />
        <title>Calculadora</title>
    </head>
    <body>
        <jsp:include page="/includes/header.jsp" />
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <form method="POST" action="calculator-servlet">
                        <div class="mb-3">
                            <label for="number1">Numero 1:</label>
                            <input type="number" class="form-control" id="number1" name="number1" placeholder="Numero 1" required>
                        </div>
                        <div class="mb-3">
                            <label for="number2">Numero 2:</label>
                            <input type="number" class="form-control" id="number2" name="number2" placeholder="Numero 2" required>
                        </div>
                        <div class="mb-3">
                            <label for="operation">Operacion: </label>
                            <select name="operation" class="custom-select d-block w-100" id="operation" required>
                                <option value="ADD">Suma</option>
                                <option value="MULTI">Multiplicacion</option>
                                <option value="GREATER">Obtener Mayor</option>
                                <option value="POW">Potencia n1^n2</option>
                                <option value="BINARY">Conversion Binaria</option>
                            </select>
                        </div>
                        <hr class="mb-4">
                        <button type="submit" class="btn btn-primary btn-lg btn-block">Calcular</button>
                    </form>

                </div>
            </div>
            <jsp:include page="/includes/footer.jsp" />
        </div>
    </body>
</html>
