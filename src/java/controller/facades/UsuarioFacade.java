/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.jpa.Usuario;

/**
 *
 * @author csalas
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {
    @PersistenceContext(unitName = "TodoTestWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario login(String user, String password) {
        Usuario u = find(user);
        if (u == null) // Usuario no existe
            return null;
        
        if (!u.getPassword().equals(password)) // Password incorrecto
            return null;
        
        return u;
    }
    
}
