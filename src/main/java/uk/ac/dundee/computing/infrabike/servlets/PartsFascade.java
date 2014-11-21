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

import uk.ac.dundee.computing.infrabike.dto.PartLo;

import uk.ac.dundee.computing.infrabike.models.WarehouseModel;

/**
 *
 * @author Anna
 */
@Stateless
@Path("Part")
public class PartsFascade {
    
    @PUT
    public Viewable addPart(@FormParam("name") String name, @FormParam("part_type") String part,@FormParam("price") String price,@FormParam("quantity") String quantity,@FormParam("id_warehouse") String wid,@FormParam("id_supplier") String sid) {
         boolean success=false;
        
        try{  
        DatabaseDAO db = new DatabaseDAO();
        WarehouseModel c = new WarehouseModel();
         Connection conn = db.Get_Connection();
         int s=Integer.parseInt(sid);
         int w=Integer.parseInt(wid);
         int p=Integer.parseInt(price);
         int q=Integer.parseInt(quantity);
           success= c.addPart(conn,name,part,p,q,w,s);
            }
        catch(Exception e)
        {
             
        }        
        if(success){ return new Viewable("/works",null);}
        else return new Viewable("/works",null);
      
     
    }
    
    
    @POST
    public Viewable updatePart(@FormParam("name") String name, @FormParam("part_type") String part,@FormParam("price") String price,@FormParam("quantity") String quantity,@FormParam("id_supplier") String sid)
    {
        boolean success;
        try{  
        DatabaseDAO db = new DatabaseDAO();
        WarehouseModel c = new WarehouseModel();
        Connection conn = db.Get_Connection();
        int p=Integer.parseInt(price);
        int s=Integer.parseInt(sid);
        int q=Integer.parseInt(quantity);
       
        success= c.updatePart(conn, s, name, part, p, q);
            }
        catch(Exception e)
        {
             
        }      
         return new Viewable("/test", null);
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
          return new Viewable("/test", null);
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
          return new Viewable("/test", null);
    }
    
    
    @DELETE
     @Path("{id}")
    public Viewable deletePart(@PathParam ("id")String id)
    {
        boolean success= false;
         try{  
        DatabaseDAO db = new DatabaseDAO();
        WarehouseModel c = new WarehouseModel();
        Connection conn = db.Get_Connection();
        int Id=Integer.parseInt(id);
        success= c.deletePart(conn, Id);
            }
        catch(Exception e)
        {
             
        }      
          return new Viewable("/test", null);
    }

    
    }
    

