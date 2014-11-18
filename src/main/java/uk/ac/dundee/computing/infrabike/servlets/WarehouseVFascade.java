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
import javax.servlet.annotation.WebServlet;
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
import uk.ac.dundee.computing.infrabike.dao.UserDAO;
import uk.ac.dundee.computing.infrabike.dao.WarehouseDAO;
import uk.ac.dundee.computing.infrabike.dto.WarehouseLo;
import uk.ac.dundee.computing.infrabike.models.WarehouseModel;

/**
 *
 * @author Anna
 */
@Stateless
@Path("Warehouse")
@WebServlet(name = "Warehouse", urlPatterns = {"/Warehouse"})
public class WarehouseVFascade {
    
    
    @PUT
    public Viewable addWarehouse(@FormParam("location")String location,@FormParam("storage_size")String storage_size,@FormParam("phone")String phone)
    {
        boolean success=false;
         try{  
        DatabaseDAO db = new DatabaseDAO();
        WarehouseModel c = new WarehouseModel();
        Connection conn = db.Get_Connection();
        int s=Integer.parseInt(storage_size);
        success= c.addWarehouse(conn, location, s, phone);
            }
        catch(Exception e)
        {
             
        }        
         return new Viewable("/test", null);
    }
      
    @GET
    @Produces("text/html")
    public Viewable getIt(@Context HttpServletRequest request) {
        System.out.println("/warehouse called");       
        try {        
        DatabaseDAO db = new DatabaseDAO();
        WarehouseDAO war = new WarehouseDAO();
        ArrayList warehouseData = null;
        
        Connection conn = db.Get_Connection();
        warehouseData = war.getWarehouses(conn, null, null);
        
        Gson gson = new Gson();
        
        String warehouses = gson.toJson(warehouseData);
        
        out.println("{\"Warehouses\":"+warehouses+"}");
        
        
        conn.close();
        out.close();
        
        request.setAttribute("warehouses", warehouses);
        
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
        return new Viewable("/warehouse_info", null);
    }
    
    @GET
    @Path("{location}")
    public Viewable showWarehouse(@PathParam("location")String location)
    {
      
         try{  
        DatabaseDAO db = new DatabaseDAO();
        WarehouseModel c = new WarehouseModel();
        Connection conn = db.Get_Connection();
        WarehouseLo wh= c.showWarehouse(location, conn);
            }
        catch(Exception e)
        {
             
        }        
          return new Viewable("/warehouse_info", null);
    }
            
    @DELETE
    @Path("{id}")
    public Viewable deleteWarehouse(@PathParam("id")String id)
    {
     boolean success=false;
         try{  
        DatabaseDAO db = new DatabaseDAO();
        WarehouseModel c = new WarehouseModel();
        Connection conn = db.Get_Connection();
        int Id=Integer.parseInt(id);
        success= c.deleteWarehouse(conn, Id);
            }
        catch(Exception e)
        {
             
        }        
          return new Viewable("/test", null);
    }
             
    @POST
    
    public Viewable updateWarehouse(@FormParam("id")String id,@FormParam("storage_size")String storage_size,@FormParam("phone")String phone)
    {
     boolean success=false;
         try{  
        DatabaseDAO db = new DatabaseDAO();
        WarehouseModel c = new WarehouseModel();
        Connection conn = db.Get_Connection();
        int Id=Integer.parseInt(id);
        int s=Integer.parseInt(storage_size);
        success= c.updateWarehouse(conn, Id, s, phone);
            }
        catch(Exception e)
        {
             
        }
          return new Viewable("/test", null);
    }
    
  
    
}
