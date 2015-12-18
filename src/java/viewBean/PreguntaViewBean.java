/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewBean;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.util.Collection;
import model.jpa.Pregunta;
import model.jpa.Respuesta;

/**
 *
 * @author csalas
 */
public class PreguntaViewBean {
    private String testName;
    private Pregunta question;
    private Collection<Respuesta> answerList;
    private boolean lastQuestion = false;
    private String mark;
    private int currentQuestion;
    private int totalQuestions;

    public PreguntaViewBean(String testName, Pregunta question, Collection<Respuesta> answerList, int currenQuestion, int totalQuestions) {
        this.testName = testName;
        this.question = question;
        this.answerList = answerList;
        this.currentQuestion = currenQuestion;
        this.totalQuestions = totalQuestions;
    }

    public Pregunta getQuestion() {
        return question;
    }

    public void setQuestion(Pregunta question) {
        this.question = question;
    }

    public Collection<Respuesta> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(Collection<Respuesta> answerList) {
        this.answerList = answerList;
    }
    
    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }
    
    public void setLastQuestion(boolean last) {
        this.lastQuestion = last;
    }
    
    public boolean isLastQuestion() {
        return lastQuestion;
    }
    
    public void setMark(String mark) {
        this.mark = mark;
    }
    
    public String getMark() {
        return mark;
    }
    
    public int getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(int currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }
    
}
