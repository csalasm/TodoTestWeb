/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import java.util.List;
import javax.persistence.EntityManager;
import model.jpa.Categoria;
import model.jpa.Pregunta;
import model.jpa.Test;

/**
 *
 * @author csalas
 */
public class QuestionActions {
    private EntityManager entityManager;
    
    public QuestionActions(EntityManager em) {
        this.entityManager = em;
    }
    public List<Pregunta> QuestionFromCategory(Categoria categoria){
        return entityManager.createQuery("SELECT p FROM Pregunta p WHERE p.idCategoria = :idcategoria")
                .setParameter("idcategoria", categoria.getIdCategoria())
                .getResultList();
    }
    /*public List<Pregunta> QuestionFromTest(Test test){
        return entityManager.createQuery("SELECT p FROM pregunta p, pregunta_test pt WHERE p.id_pregunta = pt.id_pregunta AND pt.id_test = :idtest ORDER BY random()")
                .setParameter("idtest",test.getIdTest())
                .getResultList();
         
     WHERE PREGUNTA_TEST.ID_PREGUNTA = PREGUNTA.ID_PREGUNTA AND PREGUNTA_TEST.ID_TEST = ? ORDER BY dbms_random.value
    }
     */
}
