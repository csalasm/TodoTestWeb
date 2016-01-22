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
import javax.ws.rs.core.PathSegment;
import model.jpa.Examen;
import model.jpa.ExamenPK;

/**
 *
 * @author csalas
 */
@Stateless
@Path("model.jpa.examen")
public class ExamenFacadeREST extends AbstractFacade<Examen> {
    @PersistenceContext(unitName = "TodoTestWebPU")
    private EntityManager em;

    private ExamenPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;dni=dniValue;idTest=idTestValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        model.jpa.ExamenPK key = new model.jpa.ExamenPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> dni = map.get("dni");
        if (dni != null && !dni.isEmpty()) {
            key.setDni(dni.get(0));
        }
        java.util.List<String> idTest = map.get("idTest");
        if (idTest != null && !idTest.isEmpty()) {
            key.setIdTest(new java.lang.Long(idTest.get(0)));
        }
        return key;
    }

    public ExamenFacadeREST() {
        super(Examen.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Examen entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, Examen entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        model.jpa.ExamenPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Examen find(@PathParam("id") PathSegment id) {
        model.jpa.ExamenPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Examen> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Examen> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
