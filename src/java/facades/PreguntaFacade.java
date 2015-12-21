/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.jpa.Categoria;
import model.jpa.Pregunta;
import model.jpa.Test;

/**
 *
 * @author csalas
 */
@Stateless
public class PreguntaFacade extends AbstractFacade<Pregunta> {

    @PersistenceContext(unitName = "TodoTestWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PreguntaFacade() {
        super(Pregunta.class);
    }

    public List<Pregunta> findPreguntasByNum(Categoria categoriaId, Test test) {
        List<Pregunta> lista_pregunta;
        lista_pregunta = em.createQuery("SELECT p FROM Pregunta p WHERE p.idCategoria = :categoriaId")
                .setParameter("categoriaId", categoriaId)
                .getResultList();
        return lista_pregunta;
    }

}
