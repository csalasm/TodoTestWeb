/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.facades.UsuarioFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.jpa.Examen;
import model.jpa.Usuario;

/**
 *
 * @author alejandroruiz
 */
@WebServlet(name = "ResultStudentServlet", urlPatterns = {"/ResultStudentServlet"})
public class ResultStudentServlet extends HttpServlet {

    @EJB
    UsuarioFacade usuarioFacade;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         //Recuperamos la sesión
        Usuario u;
        /*HttpSession session = request.getSession(true);
        u = (Usuario)session.getAttribute("user");
        
        if (u != null) { // Si esta autenticado, redirigimos a la pantalla principal
            processErrorLogin(request, response);
            return;
        }*/
        u = usuarioFacade.find("77774444A");
        int success = usuarioFacade.totalSuccess(u);
        int fails = usuarioFacade.totalFail(u);
        double average = usuarioFacade.average(u);
        int totalTest = usuarioFacade.totalTest(u);
        
        request.setAttribute("usuario", u);
        request.setAttribute("success",success);
        request.setAttribute("fails", fails);
        request.setAttribute("average", average);
        request.setAttribute("total",totalTest);
        
        
        
        processResultStudent(request,response);
        
        
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void processErrorLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ERROR_LOGIN", "true");
        RequestDispatcher rd = getServletContext().getNamedDispatcher("/login.jsp");
        rd.forward(request, response);
        
    }

    private void processResultStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("ResultsStudent.jsp");
        rd.forward(request, response);
    }

}
