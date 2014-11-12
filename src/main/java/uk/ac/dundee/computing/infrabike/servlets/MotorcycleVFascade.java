/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.servlets;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import uk.ac.dundee.computing.infrabike.dao.DatabaseDAO;
import uk.ac.dundee.computing.infrabike.dto.MotorcycleAll;
import uk.ac.dundee.computing.infrabike.dto.MotorcycleLo;
import uk.ac.dundee.computing.infrabike.dto.MotorcycleSpecV;
import uk.ac.dundee.computing.infrabike.dto.MotorcycleV;
import uk.ac.dundee.computing.infrabike.models.MotorcycleModel;


/**
 *
 * @author dlennart
 */
@Stateless
@Path("MotorcycleV")
public class MotorcycleVFascade extends AbstractFacade<MotorcycleV> {
    //@PersistenceContext(unitName = "uk.ac.dundee.computing_infraBike_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public MotorcycleVFascade() {
        super(MotorcycleV.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        em = Persistence.createEntityManagerFactory("uk.ac.dundee.computing_infraBike_war_1.0-SNAPSHOTPU").createEntityManager();
        return em;
    }
    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public MotorcycleAll find(@PathParam("id") Integer id) {
        DatabaseDAO db = new DatabaseDAO();
        MotorcycleModel c = new MotorcycleModel();
        MotorcycleSpecV spec=c.findSpec(id);
        MotorcycleLo motorcycle =c.findMotorcycle(id) ;
        MotorcycleAll m= new MotorcycleAll();
        m.setSpec(spec);
        m.setMotorcycle(motorcycle);
        return m;
    }
   /* @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(UserV entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, UserV entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        em = getEntityManager();
        UserV em2= em.merge(super.find(id));
        em.remove(em2);
        //super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public MotorcycleV find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<UserV> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<UserV> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    
    
    
    
    
    @POST
    public Viewable register(@FormParam("username") String username, @FormParam("password")String password,@FormParam("email")String email)
    {
        boolean success=false;
        try{  
        DatabaseDAO db = new DatabaseDAO();
        UserModel c = new UserModel();
         Connection conn = db.Get_Connection();
           success= c.register(conn, username, password,email);
            }
        catch(Exception e)
        {
        }        
        if(success){ return new Viewable("/works",null);}
        else return new Viewable("/works",null);
      
    }*/
}