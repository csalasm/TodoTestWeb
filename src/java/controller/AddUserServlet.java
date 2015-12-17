/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.facades.UsuarioFacade;
import controller.parameters.AddUserParameters;
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

        if (u == null) { // Si no esta autenticado, redirigimos a la pantalla principal
            processErrorLogin(request, response);
            return;
        }
        //Recuperamos los parametros de AddUserParameters
        AddUserParameters adduserparam = new AddUserParameters(request);
        //Instanciamos User added
        Usuario userAdded = new Usuario(adduserparam.getDni(),adduserparam.getName(),adduserparam.getSurname(),adduserparam.getPassword(),(short)((adduserparam.isPermits())?1:0));
        //Llamamos al JPA facade usuario
        System.out.println(adduserparam.getDni());
        usuarioFacade.create(userAdded);
        //COMPROBAR LOS PARAMETROS CON JAVASCRPIT*********************************************************************************
        //COMPROBAR LOS PARAMETROS CON JAVASCRPIT*********************************************************************************
        //COMPROBAR LOS PARAMETROS CON JAVASCRPIT*********************************************************************************
        //COMPROBAR LOS PARAMETROS CON JAVASCRPIT*********************************************************************************
        //COMPROBAR LOS PARAMETROS CON JAVASCRPIT*********************************************************************************
        //COMPROBAR LOS PARAMETROS CON JAVASCRPIT*********************************************************************************
        //COMPROBAR LOS PARAMETROS CON JAVASCRPIT*********************************************************************************
        processMainPageTeacher(request, response);
    }

    private void processErrorLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ERROR_LOGIN", "true");
        RequestDispatcher rd = getServletContext().getNamedDispatcher("/login.jsp");
        rd.forward(request, response);
    }
    private void processMainPageTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //request.setAttribute(name, this);
        RequestDispatcher rd = getServletContext().getNamedDispatcher("/MainPageTeacher.jsp");
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
