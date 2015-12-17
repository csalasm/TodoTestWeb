/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.actions.UserActions;
import model.jpa.Usuario;

/**
 *
 * @author csalas
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {
    @PersistenceContext(unitName = "TodoTestWebPU")
    private EntityManager em;
    UserActions ua;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
        ua = new UserActions(em);
    }
    
    public Usuario login(String user, String password) {
        return ua.login(user, password);
    }
    
}
