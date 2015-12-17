/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.facades;

import controller.parameters.AddTestParameters;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.jpa.Test;
import model.jpa.Usuario;

/**
 *
 * @author csalas
 */
@Stateless
public class TestFacade extends AbstractFacade<Test> {
    @PersistenceContext(unitName = "TodoTestWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TestFacade() {
        super(Test.class);
    }
    
    public boolean existTestName(AddTestParameters atp, Usuario u){
        boolean exist = false;
        //Coleccion de test creados por ese profesor
        Collection<Test> TestList = u.getTestCollection();
        for(Test t : TestList){
            if(t.getNombre().equals(atp.getName())){
                exist = true;
            }
            
        }
        return exist;
    }
    
}
