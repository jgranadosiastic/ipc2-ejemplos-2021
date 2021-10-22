package com.jgranados.calcappapi.operations.api.controllers;

import com.jgranados.calcappapi.operations.db.DBConnectionSingleton;
import com.jgranados.calcappapi.operations.db.DBConnectionSingletonCalculos;
import com.jgranados.calcappapi.operations.services.ReportService;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author jose
 */
@WebServlet(name = "ReportServlet", urlPatterns = {"/files/report-servlet"})
public class ReportController extends HttpServlet {

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

        ReportService reportService = null;

        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename=reporte.pdf");

        String report = request.getParameter("report");

        try {
            if (report == null || report.equals("") || report.equals("1")) {
                reportService = new ReportService(DBConnectionSingletonCalculos.getDBConnectionSingleton().getConnection());
                reportService.printReport(response.getOutputStream());
            } else if (report.equals("2")) {
                reportService = new ReportService(DBConnectionSingleton.getDBConnectionSingleton().getConnection());
                String startDateStr = request.getParameter("start");
                String endDateStr = request.getParameter("end");
                reportService.printReportWithParams(response.getOutputStream(), LocalDate.parse(startDateStr), LocalDate.parse(endDateStr));
            } else if (report.equals("3")) {
                reportService = new ReportService(DBConnectionSingleton.getDBConnectionSingleton().getConnection());
               reportService.printReportWithBeans(response.getOutputStream());
            } else if (report.equals("4")) {
                reportService = new ReportService(DBConnectionSingleton.getDBConnectionSingleton().getConnection());
               reportService.printReportWithComplexBeans(response.getOutputStream());
            }
        } catch (IOException | JRException e) {
            // manejar la excepcion
            e.printStackTrace();
        }

    }

}
