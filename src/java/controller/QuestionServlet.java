/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.parameters.QuestionParameters;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.facades.QuestionActions;
import model.jpa.Categoria;
import model.jpa.Pregunta;

/**
 *
 * @author csalas
 */
@WebServlet(name = "QuestionServlet", urlPatterns = {"/QuestionServlet"})
@MultipartConfig(fileSizeThreshold = 1024*1024, maxFileSize = 1024*1024*2, maxRequestSize = 1024*1024*2)
public class QuestionServlet extends HttpServlet {
    @PersistenceContext(unitName = "TodoTestWebPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    QuestionActions qa = null;

    @Override
    public void init() throws ServletException {
        super.init();
        qa = new QuestionActions(em);
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
        // Recogemos los parámetros del Servlet
        QuestionParameters questionParameters = new QuestionParameters(request);
        // Construimos una entidad pregunta
        Pregunta p = new Pregunta();
        p.setIdCategoria(em.find(Categoria.class, questionParameters.getCategoryID()));
        p.setTexto(questionParameters.getQuestionText());
        p.setImagen(questionParameters.getImage());
        persist(p);

        //request.setAttribute("pregunta", preg);
        //String image = Base64.getEncoder().encodeToString(preg.getImagen());
        //request.setAttribute("image", image);
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/image.jsp");
        rd.forward(request, response);
    }
    
   
    
    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
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

}
