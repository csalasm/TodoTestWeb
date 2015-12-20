/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.facades.UsuarioFacade;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.jpa.Usuario;
import viewBean.ResultadosViewBean;

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
        HttpSession session = request.getSession(true);
        u = (Usuario)session.getAttribute("user");
        if (u == null) { // Si esta autenticado, redirigimos a la pantalla principal
            redirectToLogin(request, response);
            return;
        }
        
        Usuario user = usuarioFacade.find(u.getDni());
        int success = usuarioFacade.totalSuccess(user);
        int fails = usuarioFacade.totalFail(user);
        BigDecimal average = new BigDecimal(usuarioFacade.average(user)).setScale(2, RoundingMode.CEILING);
        int totalTest = usuarioFacade.totalTest(user);        
        ResultadosViewBean rvb = new ResultadosViewBean(user,success,fails,average,totalTest);
        
        request.setAttribute("usuario", rvb);
        
        
        redirectResultStudent(request,response);
        
        
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

    private void redirectToLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }

    private void redirectResultStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/ResultsStudent.jsp");
        rd.forward(request, response);
    }

}
