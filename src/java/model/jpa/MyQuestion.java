/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.jpa;

import java.util.List;

/**
 *
 * @author csalas
 */
public class MyQuestion {
    public Pregunta p;
    public List<Respuesta> respuestas;
    
    public MyQuestion(Pregunta p, List<Respuesta> respuestas) {
        this.p = p;
        this.respuestas = respuestas;
    }
    
}
