/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.servlets;

import java.sql.Connection;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.glassfish.jersey.server.mvc.Viewable;
import uk.ac.dundee.computing.infrabike.dao.DatabaseDAO;
import uk.ac.dundee.computing.infrabike.dto.OrderItemV;
import uk.ac.dundee.computing.infrabike.models.OrderModel;

/**
 *
 * @author Anna
 */
@Stateless
@Path("Order")
public class OrderFascade {
 
   @POST 
   @Path("{id}")
   public Viewable editOrder(@PathParam("id")String id,@FormParam("id_d")String id_d,@FormParam("delivery")String delivery,@FormParam("id_c")String id_c,@FormParam("region")String region)
   {
   int Id=Integer.parseInt(id);
   int Id_d=Integer.parseInt(id_d);
   int Id_c=Integer.parseInt(id_c);
   int d=Integer.parseInt(delivery);
   
   try{  
        DatabaseDAO db = new DatabaseDAO();
        OrderModel c = new OrderModel();
        Connection conn = db.Get_Connection();
        c.updateOrder(Id,Id_d,d,region,Id_c,conn);
        }
        catch(Exception e)
        {
             
        }
   return new Viewable("/test", null); 
   }
   
   @POST 
   @Path("{id}/Item/{idI}")
   public Viewable editItem(@PathParam("id")String id,@PathParam("idI")String idI,@FormParam("serial")String serial)
   {
   int Id=Integer.parseInt(id);
   int IdI=Integer.parseInt(idI);
   int s=Integer.parseInt(serial);
   
   try{  
        DatabaseDAO db = new DatabaseDAO();
        OrderModel c = new OrderModel();
        Connection conn = db.Get_Connection();
        c.updateItem(Id,IdI,s,conn);
            }
        catch(Exception e)
        {
             
        }
   return new Viewable("/test", null); 
   }
   
   @PUT
   public Viewable addOrder(@FormParam("id_d")String id_d,@FormParam ("delivery")String delivery,@FormParam("id_c")String id_c,@FormParam ("serial")String serial,@FormParam("region")String region)
   {
       int Id_d=Integer.parseInt(id_d);
       int Id_c=Integer.parseInt(id_c);
       int d=Integer.parseInt(delivery);
       int s=Integer.parseInt(serial);
       
       try{  
        DatabaseDAO db = new DatabaseDAO();
        OrderModel c = new OrderModel();
        Connection conn = db.Get_Connection();
        c.addOrder(Id_d,d,region,Id_c,s,conn);
            }
        catch(Exception e)
        {
             
        }
       return new Viewable("/test", null);
   }
   
   @PUT
   @Path("Item")
   public Viewable addOrderItem(@FormParam("id")String id,@FormParam("serial")String serial)
   {
       int s=Integer.parseInt(serial);
       int Id=Integer.parseInt(id);
       try{  
        DatabaseDAO db = new DatabaseDAO();
        OrderModel c = new OrderModel();
        Connection conn = db.Get_Connection();
        c.addOrderItem(Id,s,conn);
            }
        catch(Exception e)
        {
             
        }
        return new Viewable("/test", null);
   }
   
   @GET 
   @Path("{user}")
   public Viewable showOrder(@PathParam("user")String user)
   {
       try{  
        DatabaseDAO db = new DatabaseDAO();
        OrderModel c = new OrderModel();
        Connection conn = db.Get_Connection();
        //sesion role daniel will fix it:D
        int role=6;
        c.showOrder(role, user, conn);
            }
        catch(Exception e)
        {
             
        }
        return new Viewable("/test", null);
   
   }
   
   
   
   @GET
   public Viewable showOrders()
   {
       try{  
        DatabaseDAO db = new DatabaseDAO();
        OrderModel c = new OrderModel();
        Connection conn = db.Get_Connection();
        c.showOrders(conn);
            }
        catch(Exception e)
        {
             
        }
        return new Viewable("/test", null);
   }
   
   
  
   @DELETE
   public Viewable deleteOrders(@FormParam("id")String id)
   {
       int Id=Integer.parseInt(id);
       try{  
           
        DatabaseDAO db = new DatabaseDAO();
        OrderModel c = new OrderModel();
        Connection conn = db.Get_Connection();
        c.deleteOrder(Id, conn);
            }
        catch(Exception e)
        {
             
        }
        return new Viewable("/test", null);
   
   }
   
   @DELETE
   @Path("Item")
   public Viewable deleteItem(@FormParam("id")String id)
   {
       int Id = Integer.parseInt(id);
       try{  
        DatabaseDAO db = new DatabaseDAO();
        OrderModel c = new OrderModel();
        Connection conn = db.Get_Connection();
        c.deleteItem(Id,conn);
            }
        catch(Exception e)
        {
             
        }
        return new Viewable("/test", null);
   
   }
   
    
}
