/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.servlets;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import uk.ac.dundee.computing.infrabike.dto.UserV;

import uk.ac.dundee.computing.infrabike.dto.WarehouseV;

/**
 *
 * @author Anna
 */
@Stateless
@Path("WarehouseV")
public class WarehouseVFascade extends AbstractFacade<WarehouseV>{
    
     private EntityManager em;

    public WarehouseVFascade() {
        super(WarehouseV.class);
    }
    
    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public WarehouseV find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<WarehouseV> findAll() {
        return super.findAll();
    }
    
    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id) {
        ;
    }
    
    
    @Override
    protected EntityManager getEntityManager() {
        em = Persistence.createEntityManagerFactory("uk.ac.dundee.computing_infraBike_war_1.0-SNAPSHOTPU").createEntityManager();
        return em;
    }
    
}
