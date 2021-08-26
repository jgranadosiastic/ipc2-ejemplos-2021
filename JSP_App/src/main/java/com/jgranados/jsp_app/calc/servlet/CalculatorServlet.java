/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgranados.jsp_app.calc.servlet;

import com.jgranados.jsp_app.calc.Calculator;
import com.jgranados.jsp_app.calc.CalculatorException;
import com.jgranados.jsp_app.calc.Operation;
import com.jgranados.jsp_app.calc.db.DBCalculator;
import com.jgranados.jsp_app.calc.db.Record;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jose
 */
@WebServlet(name = "CalculatorServlet", urlPatterns = {"/calc/calculator-servlet"})
public class CalculatorServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Calculator calc = new Calculator();

        String operationParam = request.getParameter("operation");
        try {
            calc.setNumber1(request.getParameter("number1"));
            calc.setNumber2(request.getParameter("number2"));

            String result = calc.executeOperation(operationParam);

            Record historico = new Record();
            historico.setNumero1(calc.getNumber1());
            historico.setNumero2(calc.getNumber2());
            historico.setOperacion(Operation.valueOf(operationParam));
            historico.setResultado(result);

            DBCalculator dBCalculator = new DBCalculator();
            dBCalculator.save(historico);

            response.sendRedirect(
                    String.format("result.jsp?result=%s&errorMsg=&error=false", result)
            );
        } catch (CalculatorException e) {
            response.sendRedirect(
                    String.format("result.jsp?result=&errorMsg=%s&error=true", e.getMessage())
            );
        }

    }

}
