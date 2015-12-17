/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.parameters;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author andresbailen93
 */
public class AddUserParameters {
    private String dni;
    private String name;
    private String surname;
    private String password;
    private boolean permits;
    
    public AddUserParameters(HttpServletRequest request){
        dni = request.getParameter("DNI");
        name = request.getParameter("Nombre");
        surname = request.getParameter("Apellidos");
        password = request.getParameter("password");
        permits = Boolean.valueOf(request.getParameter("permisos"));
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPermits() {
        return permits;
    }

    public void setPermits(boolean permits) {
        this.permits = permits;
    }
    
}
