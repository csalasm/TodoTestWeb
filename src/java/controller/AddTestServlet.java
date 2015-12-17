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
import java.util.Collection;
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
         //Recuperamos la sesión
        Usuario u;
       HttpSession session = request.getSession();
        u = (Usuario)session.getAttribute("user");
        if (u == null) { // Si esta autenticado, redirigimos a la pantalla principal
            redirectToLogin(request, response);
            return;
        }
        
        //Recuperamos los parámetros del Servlet
        AddTestParameters atp = new AddTestParameters(request);
        
        if(testFacade.existTestName(atp, u)){
            System.out.println("Existe");
        }else{
            System.out.println("No existe");
        }
        
        
        //Crear el objeto
        Test test = new Test();
        test.setNombre(atp.getName());
        test.setDni(u);
        test.setDuracion(Integer.parseInt(atp.getDuration()));
        test.setResta(Short.parseShort(atp.getSubtraction()));
        test.setActivo((short)(false?1:0));
        
        //Insertar en la base de datos
        //testFacade.create(test);
        
        
        redirectAddQuestion(request,response);
       
        

        }
    
private void redirectToLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
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

    private void redirectAddQuestion(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/AddQuestion.jsp");
        rd.forward(request, response);
        
    }

}
