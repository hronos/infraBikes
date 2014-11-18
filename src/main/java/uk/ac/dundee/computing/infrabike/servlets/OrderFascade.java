/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.servlets;

import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import org.glassfish.jersey.server.mvc.Viewable;

/**
 *
 * @author Anna
 */
@Stateless
@Path("Order")
public class OrderFascade {
 
   @POST
   public Viewable editOrder()
   {
   
   }
   
   @PUT
   public Viewable addOrder()
   {
   }
   
   @GET 
   @Path("{user}")
   public Viewable showOrder()
   {
   
   }
   
   @GET
   public Viewable showOrders()
   {
       
   }
  
   @DELETE
   public Viewable deleteOrders()
   {
       
   
   }
   
    
}
