/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewBean;

import model.jpa.Usuario;

/**
 *
 * @author alejandroruiz
 */
public class ResultadosViewBean {
    
    private Usuario user;
    private int success;
    private int fails;
    private double average;
    private int totalTest;

    public ResultadosViewBean(Usuario usuario, int success, int fails, double average, int totalTest) {
        this.user = usuario;
        this.success = success;
        this.fails = fails;
        this.average = average;
        this.totalTest = totalTest;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario usuario) {
        this.user = usuario;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public int getFails() {
        return fails;
    }

    public void setFails(int fails) {
        this.fails = fails;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public int getTotalTest() {
        return totalTest;
    }

    public void setTotalTest(int totalTest) {
        this.totalTest = totalTest;
    }
    
    
    
}
