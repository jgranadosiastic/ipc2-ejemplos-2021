package com.jgranados.calcappapi.operations.api.controllers;

import com.google.gson.Gson;
import com.jgranados.calcappapi.operations.api.converter.OperationConverter;
import com.jgranados.calcappapi.operations.api.model.OperationApiModel;
import com.jgranados.calcappapi.operations.db.DBCalculator;
import com.jgranados.calcappapi.operations.db.Record;
import com.jgranados.calcappapi.operations.services.Calculator;
import com.jgranados.calcappapi.operations.services.Operation;
import java.io.BufferedReader;
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
@WebServlet(name = "OperationController", urlPatterns = {"/operations"})
public class OperationController extends HttpServlet {

    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

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
        BufferedReader reader = request.getReader();
        String body = "";
        String line = reader.readLine();
        while (line != null) {
            body = body + line;
            line  = reader.readLine();
        }
        System.out.println("body:");
        System.out.println(body);
        OperationConverter converter = new OperationConverter(OperationApiModel.class);
        
        OperationApiModel model = converter.fromJson(body);
        
        System.out.println("object");
        System.out.println(model);
        
        Calculator calc = new Calculator(model);
        
        Record record = new Record();
        record.setNumero1(model.getNumber1());
        record.setNumero2(model.getNumber2());
        record.setOperacion(Operation.valueOf(model.getOperator()));
        try {
            record.setResultado(calc.executeOperation(model.getOperator()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        DBCalculator dbCalc = new DBCalculator();
        dbCalc.save(record);
        
        response.getWriter().append(converter.toJson(model));
        
        
    }

}
