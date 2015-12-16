/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.facades;

import java.util.List;
import javax.persistence.EntityManager;
import model.jpa.Pregunta;
import model.jpa.Test;

/**
 *
 * @author andresbailen93
 */
public class TestActions {

    private EntityManager entityManager;

    public TestActions(EntityManager em) {
        this.entityManager = em;
    }
    public List<Pregunta> TestFromDni(Test test){
        return entityManager.createQuery("SELECT t FROM Test t WHERE t.dni = :testdni")
                .setParameter("testdni", test.getDni())
                .getResultList();
    }
}
