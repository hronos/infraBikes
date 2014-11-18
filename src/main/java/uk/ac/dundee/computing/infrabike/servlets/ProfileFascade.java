/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.servlets;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
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
import uk.ac.dundee.computing.infrabike.dto.Profile;
import uk.ac.dundee.computing.infrabike.models.UserModel;
import uk.ac.dundee.computing.infrabike.models.WarehouseModel;

/**
 *
 * @author Anna
 */
@Stateless
@Path("Profile")
public class ProfileFascade {
    
/**
 *
 * @author Anna
 */
   
    
    
    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Profile find(@PathParam("id") String id) {
        Profile profile=new Profile();
        try{  
        DatabaseDAO db = new DatabaseDAO();
        UserModel c = new UserModel();
        Connection conn = db.Get_Connection();
        int Id=Integer.parseInt(id);
           profile=c.findUser(Id,conn);
            }
        catch(Exception e)
        {
             System.out.println("fail1");
        }   
        return profile;
    }
    
    @POST
    @Path("Customer/{id}")
     public Viewable editCustomer(@PathParam("id") String id,@FormParam("first_name") String first_name,@FormParam("last_name")String last_name,@FormParam("location")String location,@FormParam("phone_number")String phone_number,@FormParam("emailUser")String emailUser,@FormParam("password") String password) {
     boolean success;
         try{  
       DatabaseDAO db = new DatabaseDAO();
        UserModel c = new UserModel();
        Connection conn = db.Get_Connection();
        int Id=Integer.parseInt(id);
        success=c.editCustomer(Id,first_name,last_name,location,phone_number,emailUser,password,conn);  
     }
     catch(Exception e)
     {
     }
         
         return new Viewable("/test", null);
     }
     
     @POST
    @Path("Dealer/{id}")
     public Viewable editDealer(@PathParam("id") String id,@FormParam("name") String name,@FormParam("location")String location,@FormParam("phone")String phone,@FormParam("emailUser")String emailUser,@FormParam("password") String password,@FormParam("email")String email) {
     boolean success=false;
         try{  
       DatabaseDAO db = new DatabaseDAO();
        UserModel c = new UserModel();
        Connection conn = db.Get_Connection();
        int Id=Integer.parseInt(id);
        success=c.editDealer(Id,name,location,phone,emailUser,password,email,conn);  
     }
     catch(Exception e)
     {
     }
         
          return new Viewable("/test", null);
     }
     
    @POST
    @Path("User/{id}")
     public Viewable editUser(@PathParam("id")String id,@FormParam("password") String password,@FormParam("emailUser")String emailUser) {
      boolean success;
         try{  
       DatabaseDAO db = new DatabaseDAO();
        UserModel c = new UserModel();
        Connection conn = db.Get_Connection();
        int Id=Integer.parseInt(id);
        success=c.editUser(Id,password,emailUser,conn);  
         
     }
     catch(Exception e)
     {
     }
         
          return new Viewable("/test", null);
     }
    
    
   
    
}

    
    
    
