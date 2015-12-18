/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.facades.ExamenFacade;
import controller.facades.PreguntaFacade;
import controller.facades.TestFacade;
import controller.sessionBeans.TestSessionBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.jpa.Examen;
import model.jpa.ExamenPK;
import model.jpa.Pregunta;
import model.jpa.Respuesta;
import model.jpa.Test;
import model.jpa.Usuario;
import viewBean.PreguntaViewBean;

/**
 *
 * @author csalas
 */
public class DoTestServlet extends HttpServlet {
    @EJB
    private TestFacade testFacade;
    @EJB
    private ExamenFacade examenFacade;
    private Usuario user;
    

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
        HttpSession session = request.getSession(true);
        user = (Usuario)session.getAttribute("user");
        if (user == null) { // Si no esta autenticado, redirigimos a la pantalla principal
            redirectToLogin(request, response);
            return;
        }
        TestSessionBean tsb = (TestSessionBean)session.getAttribute("test");
        manageTest(tsb, session, request, response);
    }
    
    private void manageTest(TestSessionBean tsb, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      if (tsb == null) { // Es la primera pregunta
            // Inicializamos la estructura
            Test t = testFacade.find(Long.valueOf(request.getParameter("id")));
            // test - preguntaActual
            session.setAttribute("test", new TestSessionBean(t, 0)); // Guardamos en la sesión el test que estamos haciendo
            // Recuperamos la primera pregunta y sus respuestas
            List<Pregunta> questionList = new ArrayList(t.getPreguntaCollection()); 
            List<Respuesta> answerList = new ArrayList(questionList.get(0).getRespuestaCollection());
            request.setAttribute("question", new PreguntaViewBean(t.getNombre(), questionList.get(0), answerList, 1, questionList.size()));
            redirectToQuestion(request, response);
        }
        else { // Es otra pregunta del test
            if (request.getParameter("answer") == null) { // No ha seleccionado pregunta
                List<Pregunta> questionList = new ArrayList(tsb.getTest().getPreguntaCollection()); 
                List<Respuesta> answerList = new ArrayList(questionList.get(tsb.getCurrentQuestion()).getRespuestaCollection());
                PreguntaViewBean pvb = new PreguntaViewBean(tsb.getTest().getNombre(), questionList.get(tsb.getCurrentQuestion()), answerList, tsb.getCurrentQuestion()+1,questionList.size());
                if (tsb.getCurrentQuestion() == questionList.size()-1) {
                    pvb.setLastQuestion(true);
                    tsb.setLastQuestion(true);
                }         
                request.setAttribute("question", pvb);
                request.setAttribute("answer", false);
                redirectToQuestion(request, response);
                return;
            }
            if (!tsb.isLastQuestion()) { // Si no es la ultima pregunta
                tsb.addUserAnswer(Long.valueOf(request.getParameter("answer")));
                tsb.setCurrentQuestion(tsb.getCurrentQuestion() + 1);
                List<Pregunta> questionList = new ArrayList(tsb.getTest().getPreguntaCollection()); 
                List<Respuesta> answerList = new ArrayList(questionList.get(tsb.getCurrentQuestion()).getRespuestaCollection());
                PreguntaViewBean pvb = new PreguntaViewBean(tsb.getTest().getNombre(),
                        questionList.get(tsb.getCurrentQuestion()),
                        answerList,
                        tsb.getCurrentQuestion() +1 ,
                        questionList.size()
                );
                if (tsb.getCurrentQuestion() == questionList.size()-1) { // Es la ultima pregunta
                    pvb.setLastQuestion(true);
                    tsb.setLastQuestion(true);
                }
                request.setAttribute("question", pvb);
                redirectToQuestion(request, response);
            }
            else { // Es la ultima pregunta, corregimos
                tsb.addUserAnswer(Long.valueOf(request.getParameter("answer")));
                correctTest(tsb);
                PreguntaViewBean pvb = new PreguntaViewBean(tsb.getTest().getNombre(), null, null, 0, 0);
                pvb.setMark(tsb.getMark().toString());
                request.setAttribute("question", pvb);
                redirectToQuestion(request, response);
            }   
        }
    }
    
    private void correctTest(TestSessionBean tsb) {
        int correct = 0;
        int fail = 0;
        List<Respuesta> questionsAnswer = null;
        List<Pregunta> testQuestions = new ArrayList(tsb.getTest().getPreguntaCollection());
        // Si ha respondido preguntas
        if (tsb.getUserAnswers().size() > 0) {
            for (int i=0; i<testQuestions.size(); i++) {
                Pregunta p = testQuestions.get(i);
                // Recuperamos cual es su respuesta correcta
                questionsAnswer = new ArrayList(p.getRespuestaCollection());
                Respuesta correctAnswer = null;
                for(Respuesta r: questionsAnswer) {
                    if (r.getCorrecta() == 1) {
                        correctAnswer = r;
                        break;
                    }
                }
                // Si la respuesta es correcta
                if (tsb.getUserAnswers().size() > i) {
                    if (correctAnswer.getIdRespuesta().equals(tsb.getUserAnswers().get(i)))
                        correct++;
                    else
                        fail++;
                }
            }
        }
        calcMark(tsb, correct, fail, testQuestions.size());
    
    }
    
    private void calcMark(TestSessionBean tsb, int correct, int fail, int numQuestions) {
        double mark;
        double answerMark = (double)10/(numQuestions);
        // Comprobamos la configuración del test
     
        if (tsb.getTest().getResta() == 0)
            mark = answerMark*correct;
        else { // Una mal resta una bien, por tanto sería tener el doble de fallos
            if (tsb.getTest().getResta() == 1)
                mark = (answerMark * correct) - (answerMark * fail);
            else 
                mark = (answerMark * correct) - (answerMark * fail/tsb.getTest().getResta());
            
            mark = Math.round(mark*100.0)/100.0;
        }
        if (mark < 0)
            mark = 0;
        
        // Guardamos el examen realizado
        Examen e = new Examen();
        ExamenPK ePK= new ExamenPK();

        ePK.setDni(user.getDni());
        ePK.setIdTest(tsb.getTest().getIdTest());
        
        e.setExamenPK(ePK);
        e.setAciertos((short) correct);
        e.setFallos((short) fail);
        e.setFecha(new Date(Calendar.getInstance().getTime().getTime()));
        e.setNota(new BigDecimal(mark));
        tsb.setMark(new BigDecimal(mark));
        
        //examenFacade.create(e);
    }
        
    private void redirectToLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
    
    private void redirectToQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/TestAnswer.jsp");
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
