/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.actions;

import javax.persistence.EntityManager;
import model.jpa.Usuario;

/**
 *
 * @author csalas
 */
public class UserActions {
    private EntityManager entityManager;
    
    public UserActions(EntityManager em) {
        entityManager = em;
    }
    
    public Usuario login(String user, String password) {
        Usuario u = entityManager.find(Usuario.class, user);
        return u;
        
    }
    
    
    
}
