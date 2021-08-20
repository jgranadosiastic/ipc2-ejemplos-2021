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
        <title>Calculadora</title>
    </head>
    <body>
        <form method="POST" action="calculator-servlet">
            <fieldset>
                <legend>Calculadora</legend>
                <label for="number1">Numero 1:</label>
                <input name="number1" required type="number"/>
                <br>
                <label for="number2">Numero 2:</label>
                <input name="number2" required type="number"/>
                <br>
                <label for="operation">Operacion:</label>
                <select name="operation" required>
                    <option value="ADD">Suma</option>
                    <option value="MULTI">Multiplicacion</option>
                    <option value="GREATER">Obtener Mayor</option>
                    <option value="POW">Potencia n1^n2</option>
                    <option value="BINARY">Conversion Binario</option>
                </select>
            </fieldset>
            <button type="submit">Calcular</button>
        </form>
    </body>
</html>
