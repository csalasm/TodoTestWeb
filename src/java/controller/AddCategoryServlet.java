/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.facades.CategoriaFacade;
import controller.parameters.AddCategoryParameters;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.jpa.Categoria;
import model.jpa.Usuario;

/**
 *
 * @author Jesus
 */
@WebServlet(name = "AddCategoryServlet", urlPatterns = {"/AddCategoryServlet"})
public class AddCategoryServlet extends HttpServlet {

    @EJB
    private CategoriaFacade categoriaFacade;

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
        AddCategoryParameters atp = new AddCategoryParameters(request);

        List<Categoria> list_cat = categoriaFacade.findByName(atp.getCategoryName());
        Categoria categoria;
        
        if (list_cat.size() == 0) { //No existe ninguno con el nombre. buscado
            categoria = new Categoria();
            categoria.setNombre(atp.getCategoryName());
            System.out.println(atp.getCategoryName());
            categoriaFacade.create(categoria);   //Crea la nueva categoria
            processAddCategory(request, response);
        }else{
            processErrorAddCategory(request,response); 
        }
        
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

    private void processErrorAddCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ADD_CATEGORY_OK", "false");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddTest.jsp");
        rd.forward(request, response);
    }

    private void processAddCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ADD_CATEGORY_OK", "true");        
        List<Categoria> categoria_list = categoriaFacade.findAll();
        request.setAttribute("categories", categoria_list);
        
        RequestDispatcher rd = request.getRequestDispatcher("/AddQuestion.jsp");
        rd.forward(request, response);
    }
}
