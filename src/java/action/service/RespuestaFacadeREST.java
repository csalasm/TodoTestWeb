/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.service;

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
import model.jpa.Pregunta;
import model.jpa.Respuesta;

/**
 *
 * @author csalas
 */
@Stateless
@Path("model.jpa.respuesta")
public class RespuestaFacadeREST extends AbstractFacade<Respuesta> {
    @PersistenceContext(unitName = "TodoTestWebPU")
    private EntityManager em;

    public RespuestaFacadeREST() {
        super(Respuesta.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Respuesta entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Long id, Respuesta entity) {
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
    public Respuesta find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Respuesta> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("pregunta/{id}")
    @Produces({"application/json"})
    public List<Respuesta> findRespuestaFromTest(@PathParam("id") Long id) {
        Pregunta p = (Pregunta) em.createQuery("SELECT p FROM Pregunta p WHERE p.idPregunta = :idPregunta")
                       .setParameter("idPregunta", id).getSingleResult();
        
        return (List<Respuesta>)p.getRespuestaCollection();
    }
    
    

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Respuesta> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
