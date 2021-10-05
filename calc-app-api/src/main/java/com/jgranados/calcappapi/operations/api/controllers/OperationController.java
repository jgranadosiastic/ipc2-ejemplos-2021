package com.jgranados.calcappapi.operations.api.controllers;

import com.jgranados.calcappapi.operations.api.converter.BackendErrorModelConverter;
import com.jgranados.calcappapi.operations.api.converter.OperationConverter;
import com.jgranados.calcappapi.operations.api.converter.OperationResponseConverter;
import com.jgranados.calcappapi.operations.api.model.BackendErrorModel;
import com.jgranados.calcappapi.operations.api.model.OperationApiModel;
import com.jgranados.calcappapi.operations.api.model.OperationApiResponseModel;
import com.jgranados.calcappapi.operations.db.DBCalculator;
import com.jgranados.calcappapi.operations.domain.Historial;
import com.jgranados.calcappapi.operations.services.Calculator;
import com.jgranados.calcappapi.operations.services.CalculatorException;
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

        // -- esto se repite, asi que alguien mas se encargue de leer el body.
        String body = "";
        String line = reader.readLine();
        while (line != null) {
            body = body + line;
            line = reader.readLine();
        }
        System.out.println("body:");
        System.out.println(body);
        
        // --

        OperationConverter converter = new OperationConverter(OperationApiModel.class);
        OperationApiModel model = converter.fromJson(body);

        Calculator calc = new Calculator(model, new DBCalculator());

        try {
            Historial historial = calc.executeOperationAndSaveHistorial();
            OperationResponseConverter converterResp = new OperationResponseConverter(OperationApiResponseModel.class);

            OperationApiResponseModel responseModel = new OperationApiResponseModel(historial.getIdHistorial(), historial.getResultado());

            response.getWriter().append(converterResp.toJson(responseModel));
            
        } catch (CalculatorException e) {
            BackendErrorModelConverter errorConverter = new BackendErrorModelConverter(BackendErrorModel.class);
            BackendErrorModel errorModel = new BackendErrorModel(e.getMessage());
            
            response.getWriter().append(errorConverter.toJson(errorModel));
            response.setStatus(response.SC_BAD_REQUEST);
            e.printStackTrace();
        } catch (Exception e) {
            BackendErrorModelConverter errorConverter = new BackendErrorModelConverter(BackendErrorModel.class);
            BackendErrorModel errorModel = new BackendErrorModel(e.getMessage());
            
            response.getWriter().append(errorConverter.toJson(errorModel));
            response.setStatus(response.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }

    }

}
