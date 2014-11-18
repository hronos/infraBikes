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
import uk.ac.dundee.computing.infrabike.dto.WarehouseLo;
import uk.ac.dundee.computing.infrabike.models.WarehouseModel;

/**
 *
 * @author Anna
 */
@Stateless
@Path("Warehouse")
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
          return new Viewable("/test", null);
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
