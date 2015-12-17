/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.facades.TestFacade;
import controller.parameters.AddTestParameters;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.jpa.Test;
import model.jpa.Usuario;

/**
 *
 * @author alejandroruiz
 */
@WebServlet(name = "AddTestServlet", urlPatterns = {"/AddTestServlet"})
public class AddTestServlet extends HttpServlet {
    
    @EJB
    private TestFacade testFacade;

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
        
        if (u != null) { // Si esta autenticado, redirigimos a la pantalla principal
            processErrorLogin(request, response);
            return;
        }
        
        //Recuperamos los parámetros del Servlet
        AddTestParameters atp = new AddTestParameters(request);
        
        //Crear el objeto
        Test test = new Test();
        test.setNombre(atp.getName());
        test.setDni(u);
        test.setDuracion(Integer.parseInt(atp.getDuration()));
        test.setResta(Short.parseShort(atp.getSubtraction()));
        test.setActivo((short)(false?1:0));
        
        //Insertar en la base de datos
        testFacade.create(test);
        
        
        processAddQuestion(request,response);
       
        

        }
    
private void processErrorLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ERROR_LOGIN", "true");
        RequestDispatcher rd = getServletContext().getNamedDispatcher("/login.jsp");
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

    private void processAddQuestion(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/AddQuestio.jsp");
        rd.forward(request, response);
        
    }

}
