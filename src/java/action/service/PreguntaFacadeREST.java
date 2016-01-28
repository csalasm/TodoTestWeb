/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import model.jpa.MyQuestion;
import model.jpa.Pregunta;
import model.jpa.Respuesta;
import model.jpa.Test;

/**
 *
 * @author csalas
 */
@Stateless
@Path("model.jpa.pregunta")
public class PreguntaFacadeREST extends AbstractFacade<Pregunta> {
    @PersistenceContext(unitName = "TodoTestWebPU")
    private EntityManager em;

    public PreguntaFacadeREST() {
        super(Pregunta.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Pregunta entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Long id, Pregunta entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Pregunta find(@PathParam("id") Long id) {
        return super.find(id);
    }
    
    @GET
    @Path("test/{idTest}")
    @Produces({"application/json"})
    public List<Pregunta> getPreguntasFromTest(@PathParam("idTest") Integer idTest) {
        Test t = (Test)em.createQuery("SELECT t FROM Test t WHERE t.idTest = :idTest")
                .setParameter("idTest", idTest)
                .getSingleResult();
        
        return (List<Pregunta>) t.getPreguntaCollection();
    }
    
    /*@GET
    @Path("test2/{idTest}")
    @Produces({"application/json"})
    public Response getPreguntasFromTest2(@PathParam("idTest") Integer idTest) {
        MyQuestion mq = null;
        ArrayList<GenericEntity> mqList = new ArrayList<>();
        GenericEntity<MyQuestion> ge;
        Test t = (Test)em.createQuery("SELECT t FROM Test t WHERE t.idTest = :idTest")
                .setParameter("idTest", idTest)
                .getSingleResult();
        
        // Para cada pregunta, obtenemos las respuestas
        for (Pregunta p: t.getPreguntaCollection()) {
            mq = new MyQuestion(p, (List<Respuesta>) p.getRespuestaCollection());
            ge = new GenericEntity<>(mq, MyQuestion.class);
            mqList.add(ge);
        }
        //
        GenericEntity<ArrayList<GenericEntity>> lge;
        lge = new GenericEntity<>(mqList, ArrayList.class);
        return Response.ok(lge).build();
    }*/

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Pregunta> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Pregunta> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
