/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.servlets;

import java.sql.Connection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.glassfish.jersey.server.mvc.Viewable;
import uk.ac.dundee.computing.infrabike.dao.DatabaseDAO;
import uk.ac.dundee.computing.infrabike.dto.PartV;
import uk.ac.dundee.computing.infrabike.models.WarehouseModel;

/**
 *
 * @author Anna
 */
@Stateless
@Path("Part")
public class PartVFascade extends AbstractFacade<PartV>{
     private EntityManager em;

    public PartVFascade() {
        super(PartV.class);
    }
    
    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public PartV find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<PartV> findAll() {
        return super.findAll();
    }
    
    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id) {
        
    }
    @POST
    
    public Viewable insertDetail(@FormParam("name") String name, @FormParam("part_type") String part,@FormParam("price") int price,@FormParam("quantity") int quantity,@FormParam("id_warehouse") int wid,@FormParam("id_supplier") int sid) {
         boolean success=false;
        
        try{  
        DatabaseDAO db = new DatabaseDAO();
        WarehouseModel c = new WarehouseModel();
         Connection conn = db.Get_Connection();
           success= c.addDetail(conn,name,part,price,quantity,wid,sid);
            }
        catch(Exception e)
        {
             System.out.println("fail1");
        }        
        if(success){ return new Viewable("/works",null);}
        else return new Viewable("/works",null);
      
     
    }
    
    
    @Override
    protected EntityManager getEntityManager() {
        em = Persistence.createEntityManagerFactory("uk.ac.dundee.computing_infraBike_war_1.0-SNAPSHOTPU").createEntityManager();
        return em;
    }
    
}
