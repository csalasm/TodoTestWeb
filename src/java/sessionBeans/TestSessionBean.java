/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import java.math.BigDecimal;
import java.util.ArrayList;
import model.jpa.Test;

/**
 *
 * @author csalas
 */
public class TestSessionBean {
    private Test test;
    private int currentQuestion;
    private ArrayList<Long> userAnswers;
    private boolean lastQuestion = false;
    private BigDecimal mark = new BigDecimal(0);

    public TestSessionBean(Test test, int currentQuestion) {
        this.test = test;
        this.currentQuestion = currentQuestion;
        userAnswers = new ArrayList();
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public int getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(int currentQuestion) {
        this.currentQuestion = currentQuestion;
    }
    
    public void addUserAnswer(Long ans) {
        userAnswers.add(ans);
    }
    
    public ArrayList<Long> getUserAnswers() {
        return userAnswers;
    }
    
    public void setLastQuestion(boolean lastQuestion) {
        this.lastQuestion = lastQuestion;
    }
    
    public boolean isLastQuestion() {
        return lastQuestion;
    }
    
    public void setMark(BigDecimal mark) {
        this.mark = mark;
    }
    
    public BigDecimal getMark() {
        return mark;
    }
    
    
}
