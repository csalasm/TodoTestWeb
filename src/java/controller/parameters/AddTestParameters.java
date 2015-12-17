/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.parameters;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author alejandroruiz
 */
public class AddTestParameters {
    private String name;
    private String duration;
    private String subtraction;
    private String author;
    
    public AddTestParameters(HttpServletRequest request){
        this.name = request.getParameter("testname");
        this.duration = request.getParameter("duration");
        this.subtraction = request.getParameter("puntuation");
        this.author = request.getParameter("username");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSubtraction() {
        return subtraction;
    }

    public void setSubtraction(String subtraction) {
        this.subtraction = subtraction;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    
    
    
}
