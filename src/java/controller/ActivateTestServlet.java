//ActivateTestServlet

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import facades.TestFacade;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
 * @author Jesus
 */
@WebServlet(name = "ActivateTestServlet", urlPatterns = {"/ActivateTestServlet"})
public class ActivateTestServlet extends HttpServlet {

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

        RequestDispatcher rd;

        Usuario u;
        HttpSession session = request.getSession(true);

        u = (Usuario) session.getAttribute("user");
        if (u == null) {
            redirectToLogin(request, response);
            return;
        }

         short activo = 1;
        short desactivado = 0;

        String[] active_test = null;
        
        active_test = request.getParameterValues("activeTests");
        
        if(active_test!=null){
        System.out.println(active_test.toString());
       
        if(active_test.length!=0){

       
       
        Test test;

        List<Test> all_Test = testFacade.findAll();

        for (Test t : all_Test) { //Marco todos como desactivados.
            t.setActivo(desactivado);
            testFacade.edit(t);
        }

        for (String s : active_test) { //Marco como activos los que me indica la vista.

            test = new Test();
            test.setIdTest(Long.parseLong(s));

            Test rec_test = testFacade.find(test.getIdTest());
            rec_test.setActivo(activo);
            testFacade.edit(rec_test);
        }
            }
        } else{
            List<Test> all_Test = testFacade.findAll();

        for (Test t : all_Test) { //Marco todos como desactivados.
            t.setActivo(desactivado);
            testFacade.edit(t);
        }
        }

        redirectToActivateTest(request, response);
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

    private void redirectToActivateTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        request.setAttribute("Activate_Test", "true");
        request.setAttribute("ADD_TEST_OK", "true");
        RequestDispatcher rd = context.getRequestDispatcher("/ShowActiveTestServlet");
        rd.forward(request, response);
    }

    private void redirectToLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
}
