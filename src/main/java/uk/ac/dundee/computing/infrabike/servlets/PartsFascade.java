/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.servlets;

import java.sql.Connection;
import java.util.ArrayList;
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
import static uk.ac.dundee.computing.infrabike.dto.DealerV_.name;
import static uk.ac.dundee.computing.infrabike.dto.MotorcycleLo_.price;
import uk.ac.dundee.computing.infrabike.dto.PartLo;
import static uk.ac.dundee.computing.infrabike.dto.PartV_.quantity;
import uk.ac.dundee.computing.infrabike.models.WarehouseModel;

/**
 *
 * @author Anna
 */
@Stateless
@Path("Part")
public class PartsFascade {
    
    @PUT
    public Viewable addPart(@FormParam("name") String name, @FormParam("part_type") String part,@FormParam("price") int price,@FormParam("quantity") int quantity,@FormParam("id_warehouse") int wid,@FormParam("id_supplier") int sid) {
         boolean success=false;
        
        try{  
        DatabaseDAO db = new DatabaseDAO();
        WarehouseModel c = new WarehouseModel();
         Connection conn = db.Get_Connection();
           success= c.addPart(conn,name,part,price,quantity,wid,sid);
            }
        catch(Exception e)
        {
             
        }        
        if(success){ return new Viewable("/works",null);}
        else return new Viewable("/works",null);
      
     
    }
    
    
    @POST
    public Viewable updatePart(@FormParam("name") String name, @FormParam("part_type") String part,@FormParam("price") int price,@FormParam("quantity") int quantity,@FormParam("id_warehouse") int wid,@FormParam("id_supplier") int sid)
    {
        boolean success;
        try{  
        DatabaseDAO db = new DatabaseDAO();
        WarehouseModel c = new WarehouseModel();
        Connection conn = db.Get_Connection();
        success= c.updatePart(conn, sid, name, part, price, quantity);
            }
        catch(Exception e)
        {
             
        }      
        
    }
    
    @GET
    @Path("{name}")
    public Viewable showPart(@PathParam("name")String name)
    {
    
        PartLo part=new PartLo();
        try{  
        DatabaseDAO db = new DatabaseDAO();
        WarehouseModel c = new WarehouseModel();
        Connection conn = db.Get_Connection();
        part = c.showPart(conn, name);
            }
        catch(Exception e)
        {
             
        }      
         //return list;
    }
    
    @GET
    public Viewable showParts()
    {
        ArrayList list=new ArrayList();
      try{  
        DatabaseDAO db = new DatabaseDAO();
        WarehouseModel c = new WarehouseModel();
        Connection conn = db.Get_Connection();
         list= c.showParts(conn);
            }
        catch(Exception e)
        {
             
        }      
         //return list; 
    }
    
    
    @DELETE
     @Path("{id}")
    public Viewable deletePart(@PathParam ("id")int id)
    {
        boolean success= false;
         try{  
        DatabaseDAO db = new DatabaseDAO();
        WarehouseModel c = new WarehouseModel();
        Connection conn = db.Get_Connection();
        success= c.deletePart(conn, id);
            }
        catch(Exception e)
        {
             
        }      
    }

    
    }
    

