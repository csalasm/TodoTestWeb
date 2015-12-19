/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.facades;

import java.util.List;
import controller.parameters.AddTestParameters;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    

    public List<Test> getActiveTest() {
        //return (List<Test>) em.createNamedQuery("Test.findByActivo").setParameter("activo", 1).getResultList();
        return (List<Test>) em.createQuery("SELECT t FROM Test t WHERE t.activo = 1 AND t.idTest NOT IN(SELECT e.test.idTest FROM Examen e)").getResultList();
    }
    
    public List<Test> findByNameAndDni(String testName, Usuario u){
        
        Query query = em.createQuery("SELECT t FROM Test t WHERE t.nombre = :nombre AND t.dni = :usuario")
                .setParameter("nombre", testName)
                .setParameter("usuario",u);
                
        List<Test> listTest = query.getResultList();
        return listTest;
    }
    
        public List returnTestfromUser(Usuario user) {
        Query query = em.createQuery("SELECT t FROM Test t WHERE t.dni = :nombre").setParameter("nombre", user);
        List<Test> test_list = query.getResultList();
        return test_list;
    }
    
}
