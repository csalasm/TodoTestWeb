/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.facades;

import javax.persistence.EntityManager;

/**
 *
 * @author csalas
 */
public class QuestionActions {
    private EntityManager entityManager;
    
    public QuestionActions(EntityManager em) {
        this.entityManager = em;
    }
    
     
}
