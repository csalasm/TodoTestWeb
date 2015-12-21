/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import com.itextpdf.text.DocumentException;
import controller.DoTestServlet;
import facades.ExamenFacade;
import facades.TestFacade;
import sessionBeans.TestSessionBean;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.jpa.Examen;
import model.jpa.ExamenPK;
import model.jpa.Pregunta;
import model.jpa.Respuesta;
import model.jpa.Test;
import model.jpa.Usuario;
import utils.Chronometer;
import utils.PDF;
import viewBean.PreguntaViewBean;

/**
 *
 * @author andresbailen93
 */
public class TestActions {
    ExamenFacade examenFacade = lookupExamenFacadeBean();
    TestFacade testFacade = lookupTestFacadeBean();

    private TestSessionBean tsb;
    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final HttpSession session;
    private String testID;
    private String lastAnswer = "";
    private final Usuario user;

    public TestActions(TestSessionBean tsb, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        this.tsb = tsb;
        this.request = request;
        this.response = response;
        this.session = session;
        this.user  = (Usuario)session.getAttribute("user");
    }
    
    public void setTestID(String testID) {
        this.testID = testID;
    }
    
    public void manageTest() throws ServletException, IOException {
        if (tsb == null) { // Es la primera pregunta
            Test t = testFacade.find(Long.valueOf(testID));
            Chronometer.stopChronometer();
            tsb = new TestSessionBean(t, 0);
            if (t.getDuracion() == 0) {
                tsb.setTestWithoutTime(true);
                Chronometer.setTestWithoutTime(true);
            }
            else
                Chronometer.startChronometer(t.getDuracion()*60);
            
            // test - preguntaActual
            session.setAttribute("test", tsb); // Guardamos en la sesión el test que estamos haciendo
            // Recuperamos la primera pregunta y sus respuestas
            List<Pregunta> questionList = new ArrayList(t.getPreguntaCollection()); 
            List<Respuesta> answerList = new ArrayList(questionList.get(0).getRespuestaCollection());
            request.setAttribute("question", new PreguntaViewBean(t.getNombre(), questionList.get(0), answerList, 1, questionList.size(), tsb.getNoTime() ,Chronometer.getTime()));
            return;
        }
        
        if ((request.getParameter("answer") == null || lastAnswer.equals(request.getParameter("answer"))) && Chronometer.getTime() > 0) { // No ha seleccionado pregunta
            List<Pregunta> questionList = new ArrayList(tsb.getTest().getPreguntaCollection());
            List<Respuesta> answerList = new ArrayList(questionList.get(tsb.getCurrentQuestion()).getRespuestaCollection());
            PreguntaViewBean pvb = new PreguntaViewBean(tsb.getTest().getNombre(),
                    questionList.get(tsb.getCurrentQuestion()),
                    answerList,
                    tsb.getCurrentQuestion() + 1,
                    questionList.size(),
                    tsb.getNoTime(),
                    Chronometer.getTime()
            );
            if (tsb.getCurrentQuestion() == questionList.size() - 1) {
                pvb.setLastQuestion(true);
                tsb.setLastQuestion(true);
            }
            request.setAttribute("question", pvb);
            request.setAttribute("answer", false);
            return;
        }
        if (!tsb.isLastQuestion() && Chronometer.getTime() > 0) { // Si no es la ultima pregunta
            lastAnswer = request.getParameter("answer");
            tsb.addUserAnswer(Long.valueOf(request.getParameter("answer")));
            tsb.setCurrentQuestion(tsb.getCurrentQuestion() + 1);
            List<Pregunta> questionList = new ArrayList(tsb.getTest().getPreguntaCollection());
            List<Respuesta> answerList = new ArrayList(questionList.get(tsb.getCurrentQuestion()).getRespuestaCollection());
            PreguntaViewBean pvb = new PreguntaViewBean(tsb.getTest().getNombre(),
                    questionList.get(tsb.getCurrentQuestion()),
                    answerList,
                    tsb.getCurrentQuestion() + 1,
                    questionList.size(),
                    tsb.getNoTime(),
                    Chronometer.getTime()
            );
            if (tsb.getCurrentQuestion() == questionList.size() - 1) { // Es la ultima pregunta
                pvb.setLastQuestion(true);
                tsb.setLastQuestion(true);
            }
            request.setAttribute("question", pvb);
        } else { // Es la ultima pregunta o finalizó el tiempo del test, corregimos
            if (request.getParameter("answer") != null) {
                tsb.addUserAnswer(Long.valueOf(request.getParameter("answer")));
            }
            correctTest();
            PreguntaViewBean pvb = new PreguntaViewBean(tsb.getTest().getNombre(), null, null, 0, 0, false, 0);
            pvb.setMark(tsb.getMark().toString());
            pvb.setPdf(generatePDF());
            request.setAttribute("question", pvb);
        }
    }
    
    private void correctTest() {
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
        calcMark(correct, fail, testQuestions.size());
    
    }
    
    private void calcMark(int correct, int fail, int numQuestions) {
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
        e.setNota(new BigDecimal(mark).setScale(2, RoundingMode.CEILING));
        e.setTest(tsb.getTest());
        tsb.setMark(new BigDecimal(mark).setScale(2, RoundingMode.CEILING));
        
        //examenFacade.create(e);
        
    }
    
    private boolean generatePDF() {
        if (tsb.getTest().getPreguntaCollection().size() == tsb.getUserAnswers().size()) {
            ArrayList<ArrayList<Respuesta>> questionAnswerList = new ArrayList();
            ArrayList<Pregunta>questionList = new ArrayList(tsb.getTest().getPreguntaCollection());
            for (Pregunta p: questionList)
                questionAnswerList.add(new ArrayList(p.getRespuestaCollection()));
            PDF pdf = new PDF(request.getServletContext().getRealPath(""), questionList, questionAnswerList);
            try {
                pdf.createPDF(tsb.getTest().getNombre(), user.getNombre()+" "+user.getApellidos(), String.valueOf(tsb.getMark()),user.getDni()+".pdf");
                return true;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DoTestServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(DoTestServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return false;
    }

    private TestFacade lookupTestFacadeBean() {
        try {
            Context c = new InitialContext();
            return (TestFacade) c.lookup("java:global/TodoTestWeb/TestFacade!facades.TestFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private ExamenFacade lookupExamenFacadeBean() {
        try {
            Context c = new InitialContext();
            return (ExamenFacade) c.lookup("java:global/TodoTestWeb/ExamenFacade!facades.ExamenFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
}
