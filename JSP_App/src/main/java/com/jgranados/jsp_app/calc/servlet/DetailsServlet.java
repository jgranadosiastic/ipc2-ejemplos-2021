/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jgranados.jsp_app.calc.servlet;

import com.jgranados.jsp_app.calc.db.DBCalculator;
import com.jgranados.jsp_app.calc.db.Record;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jose
 */
@WebServlet(name = "DetailsServlet", urlPatterns = {"/calc/DetailsServlet"})
public class DetailsServlet extends HttpServlet {

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
        Integer id = 0;
        try {
            id = Integer.valueOf(request.getParameter("id"));

            DBCalculator db = new DBCalculator();
            Optional<Record> record = db.getHistoricalById(id);
            if (record.isPresent()) {
                request.setAttribute("record", record.get());
                request.getRequestDispatcher("details.jsp?id=" + id).forward(request, response);
            } else {
                response.sendRedirect("error.jsp?msg=No existe elemento con ID: " + id);
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("error.jsp?msg=Id invalido.");
        }
    }
}
