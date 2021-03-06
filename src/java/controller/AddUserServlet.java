/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import facades.UsuarioFacade;
import parameters.AddUserParameters;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author andresbailen93
 */
public class AddUserServlet extends HttpServlet {

    @EJB
    private UsuarioFacade usuarioFacade;

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
        u = (Usuario) session.getAttribute("user");

        if (u == null) { // Si esta autenticado, redirigimos a la pantalla principal
            redirectToLogin(request, response);
            return;
        }
        //Recuperamos los parametros de AddUserParameters
        AddUserParameters adduserparam = new AddUserParameters(request);
        //Instanciamos User added
        Usuario userAdded = new Usuario(adduserparam.getDni(), adduserparam.getName(), adduserparam.getSurname(), adduserparam.getPassword(), (short) ((adduserparam.isPermits()) ? 1 : 0));
        //Llamamos al JPA facade usuario
        Usuario CompruebaUsuario = usuarioFacade.find(userAdded.getDni());
        if (CompruebaUsuario == null) {
            usuarioFacade.create(userAdded);
            redirectMainPageTeacher(request, response);
        }
        //usuarioFacade.create(userAdded);
        //redirectMainPageTeacher(request, response);
        if (CompruebaUsuario != null) {
            redirectAddUser(request, response);
        }
    }

    private void redirectAddUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ADD_USER_ERROR", "true");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddUser.jsp");
        rd.forward(request, response);
    }

    private void redirectToLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }

    private void redirectMainPageTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ADD_USER", "true");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/MainPageTeacher.jsp");
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
