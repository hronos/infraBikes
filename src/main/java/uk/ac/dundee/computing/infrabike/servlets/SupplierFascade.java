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
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import org.glassfish.jersey.server.mvc.Viewable;
import uk.ac.dundee.computing.infrabike.dao.DatabaseDAO;
import uk.ac.dundee.computing.infrabike.dao.SupplierDAO;
import uk.ac.dundee.computing.infrabike.dao.WarehouseDAO;
import uk.ac.dundee.computing.infrabike.dto.SupplierLo;
import uk.ac.dundee.computing.infrabike.models.SupplierModel;

/**
 *
 * @author Anna
 */
@Stateless
@Path("Supplier")
public class SupplierFascade {
    
    
    @PUT
    public Viewable addSupplier(@FormParam("name")String name,@FormParam("location")String location,@FormParam("phone")String phone,@FormParam("email")String email)
    {
        boolean success=false;
        int ph=Integer.parseInt(phone);
         try{  
             
        DatabaseDAO db = new DatabaseDAO();
        SupplierModel c = new SupplierModel();
        Connection conn = db.Get_Connection();
        success= c.addSupplier(name,location,ph,email,conn);
            }
        catch(Exception e)
        {
             
        }        
         return new Viewable("/test", null);
    }
      
    @GET
    @Produces("text/html")
    public Viewable getIt(@Context HttpServletRequest request) {
        System.out.println("/supplier called");       
        try {        
        DatabaseDAO db = new DatabaseDAO();
        SupplierDAO sup = new SupplierDAO();
        ArrayList supData = null;
        
        Connection conn = db.Get_Connection();
        supData = sup.showSuppliers(conn, null, null);
        
        Gson gson = new Gson();
        
        String suppliers = gson.toJson(supData);
        
        out.println("{\"Supplier\":"+suppliers+"}");
        
        
        conn.close();
        out.close();
        
        request.setAttribute("supplier", suppliers);
        
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
        return new Viewable("/supplier", null);
    }
    
    @GET
    @Path("{name}")
    public Viewable showSupplier(@PathParam("name")String name)
    {
      
         try{  
        DatabaseDAO db = new DatabaseDAO();
        SupplierModel c = new SupplierModel();
        Connection conn = db.Get_Connection();
        SupplierLo wh= c.showSupplier(name,conn);
            }
        catch(Exception e)
        {
             
        }        
          return new Viewable("/test", null);
    }
    
    @GET
    
    public Viewable showSuppliers()
    {
      
         try{  
        DatabaseDAO db = new DatabaseDAO();
        SupplierModel c = new SupplierModel();
        Connection conn = db.Get_Connection();
        ArrayList wh= c.showSuppliers(conn);
            }
        catch(Exception e)
        {
             
        }        
          return new Viewable("/test", null);
    }
            
    @DELETE
    @Path("{name}")
    public Viewable deleteSupplier(@PathParam("name")String name)
    {
     boolean success=false;
         try{  
        DatabaseDAO db = new DatabaseDAO();
        SupplierModel c = new SupplierModel();
        Connection conn = db.Get_Connection();
        success= c.deleteSupplier(name,conn);
            }
        catch(Exception e)
        {
             
        }        
          return new Viewable("/test", null);
    }
             
    @POST
    @Path("{name}")
    public Viewable updateSupplier(@PathParam("name")String name,@FormParam("location")String location,@FormParam("phone")String phone,@FormParam("email")String email)
    {
        int ph=Integer.parseInt(phone);
        boolean success=false;
         try{  
        DatabaseDAO db = new DatabaseDAO();
        SupplierModel c = new SupplierModel();
        Connection conn = db.Get_Connection();
        success= c.updateSupplier(name,location,ph,email,conn);
            }
        catch(Exception e)
        {
             
        }      
          return new Viewable("/test", null);
    }
    
  
    
}
