/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.facades.UsuarioFacade;
import controller.parameters.LoginParameters;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.jpa.Usuario;

/**
 *
 * @author csalas
 */
public class LoginServlet extends HttpServlet {
    @EJB
    private UsuarioFacade usuarioFacade;
   

    @Override
    public void init() throws ServletException {
        super.init();
    }
    
    
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
        
        Usuario u;
        HttpSession session = request.getSession(true);
        u = (Usuario)session.getAttribute("user");
        if (u != null) { // Si esta autenticado, redirigimos a la pantalla principal
            redirectToLogin(request, response);
            return;
        }
        
        // Recuperamos parámetros del servlet
        LoginParameters lp = new LoginParameters(request);
        // Recuperamos la sessión por si el usuario está autenticado

        // Recuperamos el usuario
        u = usuarioFacade.login(lp.getUser(), lp.getPassword());
        
        if (u == null) { // Error en los datos
            request.setAttribute("error_login", true);
            redirectToLogin(request, response);
            return;
        }
        
        
       

        session.setAttribute("user", u);
        request.setAttribute("user", u);
        redirectToMain(u, request, response);

            
    }
    
    private void redirectToLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("Session_Loggin","false");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
    
    private void redirectToMain(Usuario u, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd;
        if (u.getEsProf() == 0)
            rd = getServletContext().getRequestDispatcher("/MainPageStudent.jsp");
        else
            rd = getServletContext().getRequestDispatcher("/MainPageTeacher.jsp");
        rd.forward(request, response);
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

    

}
