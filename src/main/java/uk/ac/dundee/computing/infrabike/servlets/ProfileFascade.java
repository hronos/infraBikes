/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.servlets;

import com.google.gson.Gson;
import static java.lang.System.out;
import java.sql.Connection;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import org.glassfish.jersey.server.mvc.Viewable;
import uk.ac.dundee.computing.infrabike.dao.DatabaseDAO;
import uk.ac.dundee.computing.infrabike.dao.UserDAO;
import uk.ac.dundee.computing.infrabike.dto.Profile;

import uk.ac.dundee.computing.infrabike.models.UserModel;

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
    @Path("{username}")
    @Produces("text/html")
    public Viewable find(@PathParam ("username")String username, @Context HttpServletRequest request) {
       
        try{  
        DatabaseDAO db = new DatabaseDAO();
        UserModel c = new UserModel();
        Connection conn = db.Get_Connection();
        Profile profiles=new Profile();
        profiles = c.findUser(username, conn);
        
        Gson gson = new Gson();
        ArrayList userData = null;
     
        String profile="";
                if(profiles.getCustomer()!=null)
                {
                 
                    profile=gson.toJson(profiles.getCustomer());
                }
                else if(profiles.getDealer()!=null)
                {   
                    profile=gson.toJson(profiles.getDealer());
                }
                else 
                {
                    profile=gson.toJson(profiles.getUser());
                }
        
        out.println("{\"Profile\":"+profile+"}");
        
        
        conn.close();
        //out.close();
        
        request.setAttribute("profile", "["+profile+"]");
        
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
        
        return new Viewable("/profile", null);
    }
    
   
    @GET
    @Path("Update/{username}")
    public Viewable edit(@PathParam("username")String username,@Context HttpServletRequest request)
    {
        //int Id=Integer.parseInt(id);
        Profile profile=null;
         try{
        DatabaseDAO db = new DatabaseDAO();
        Connection conn = db.Get_Connection();
        UserModel c = new UserModel();
         
        profile=c.findUser(username, conn); ; 
        }catch(Exception e)
        {
          
        }
        
        request.setAttribute("profile", profile);
       
    return new Viewable("/editProfile", null);
    }
     
    
    @GET
    @Produces("text/html")
    public Viewable allProfiles(@PathParam ("username")String username, @Context HttpServletRequest request) {
        try{  
        DatabaseDAO db = new DatabaseDAO();
        UserDAO c = new UserDAO();
        Connection conn = db.Get_Connection();
       
        
        Gson gson = new Gson();
        ArrayList userData =   c.viewUsers(conn);;
     
         String profile="";
                
                    profile=gson.toJson(userData);
                
        
        out.println("{\"Profile\":"+profile+"}");
        
        
        conn.close();
        out.close();
        
        request.setAttribute("profile", profile);
        
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
        
        return new Viewable("/profile", null);
    }

    
    @POST
    @Path("Update/Customer/{id}")
     public Viewable editCustomer(@PathParam("id") String id,@FormParam("first_name") String first_name,@FormParam("username") String username,@FormParam("last_name")String last_name,@FormParam("location")String location,@FormParam("phone_number")String phone_number,@FormParam("emailUser")String emailUser,@Context HttpServletRequest request) {
     boolean success;
         try{  
       DatabaseDAO db = new DatabaseDAO();
        UserDAO c = new UserDAO();
        Connection conn = db.Get_Connection();
        int Id=Integer.parseInt(id);
        success=c.editCustomer(Id,username,first_name,last_name,location,phone_number,emailUser,conn);  
        
        UserModel m=new UserModel();
        Profile profiles=new Profile();
        profiles = m.findUser(username, conn);
        
        Gson gson = new Gson();
        ArrayList userData = null;
     
        String profile="";
                if(profiles.getCustomer()!=null)
                {
                 
                    profile=gson.toJson(profiles.getCustomer());
                }
                else if(profiles.getDealer()!=null)
                {   
                    profile=gson.toJson(profiles.getDealer());
                }
                else 
                {
                    profile=gson.toJson(profiles.getUser());
                }
        
        out.println("{\"Profile\":"+profile+"}");
        
        
        conn.close();
        //out.close();
        
        request.setAttribute("profile", "["+profile+"]");
         }
     catch(Exception e)
     {
     }
         
         return new Viewable("/profile", null);
     }
     
     @POST
    @Path("Update/Dealer/{id}")
     public Viewable editDealer(@PathParam("id") String id,@FormParam("name") String name,@FormParam("location")String location,@FormParam("phone")String phone,@FormParam("emailUser")String emailUser,@FormParam("email")String email,@FormParam("username")String username,@Context HttpServletRequest request) {
     boolean success=false;
         try{  
       DatabaseDAO db = new DatabaseDAO();
        UserDAO c = new UserDAO();
        Connection conn = db.Get_Connection();
        int Id=Integer.parseInt(id);
        success=c.editDealer(Id,username,name,location,phone,emailUser,email,conn);  
        
        UserModel m=new UserModel();
         Profile profiles=new Profile();
        profiles = m.findUser(username, conn);
        
        Gson gson = new Gson();
        ArrayList userData = null;
     
        String profile="";
                if(profiles.getCustomer()!=null)
                {
                 
                    profile=gson.toJson(profiles.getCustomer());
                }
                else if(profiles.getDealer()!=null)
                {   
                    profile=gson.toJson(profiles.getDealer());
                }
                else 
                {
                    profile=gson.toJson(profiles.getUser());
                }
        
        out.println("{\"Profile\":"+profile+"}");
        
        
        conn.close();
        //out.close();
        
        request.setAttribute("profile", "["+profile+"]");
     }
     catch(Exception e)
     {
     }
              
     
         
          return new Viewable("/profile", null);
     }
     
    @POST
    @Path("Update/User/{id}")
     public Viewable editUser(@PathParam("id")String id,@FormParam("emailUser")String emailUser,@FormParam("username")String username,@Context HttpServletRequest request) {
      boolean success;
         try{  
       DatabaseDAO db = new DatabaseDAO();
        UserDAO c = new UserDAO();
        Connection conn = db.Get_Connection();
        int Id=Integer.parseInt(id);
        success=c.editUser2(Id,emailUser,conn); 
        UserModel m=new UserModel();
         Profile profiles=new Profile();
        profiles = m.findUser(username, conn);
        
        Gson gson = new Gson();
        ArrayList userData = null;
     
        String profile="";
                if(profiles.getCustomer()!=null)
                {
                 
                    profile=gson.toJson(profiles.getCustomer());
                }
                else if(profiles.getDealer()!=null)
                {   
                    profile=gson.toJson(profiles.getDealer());
                }
                else 
                {
                    profile=gson.toJson(profiles.getUser());
                }
        
        out.println("{\"Profile\":"+profile+"}");
        
        
        conn.close();
        //out.close();
        
        request.setAttribute("profile", "["+profile+"]");
     }
     catch(Exception e)
     {
     }
         
          return new Viewable("/profile", null);
     }
}
    /*
   
    
}

    
    */
    
