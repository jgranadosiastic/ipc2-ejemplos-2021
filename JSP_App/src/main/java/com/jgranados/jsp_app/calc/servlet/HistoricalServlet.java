/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgranados.jsp_app.calc.servlet;

import com.jgranados.jsp_app.calc.db.DBCalculator;
import com.jgranados.jsp_app.calc.db.Record;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jose
 */
@WebServlet(name = "HistoricalServlet", urlPatterns = {"/calc/historical-servlet"})
public class HistoricalServlet extends HttpServlet {

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
        List<Record> list = new ArrayList<>();
        DBCalculator db = new DBCalculator();
        list = db.getAllHistoricals();
        
        request.setAttribute("historicals", list);
        request.getRequestDispatcher("historical.jsp").forward(request, response);
    }

}
