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
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import org.glassfish.jersey.server.mvc.Viewable;
import uk.ac.dundee.computing.infrabike.dao.DatabaseDAO;
import uk.ac.dundee.computing.infrabike.dao.MotorcycleDAO;
import uk.ac.dundee.computing.infrabike.dto.MotPartLo;
import uk.ac.dundee.computing.infrabike.dto.MotorcycleLo;
import uk.ac.dundee.computing.infrabike.models.MotorcycleModel;


/**
 *
 * @author dlennart
 */
@Stateless
@Path("Model")
public class MotorcycleVFascade  {
    //@PersistenceContext(unitName = "uk.ac.dundee.computing_infraBike_war_1.0-SNAPSHOTPU")
  

    
    @POST
    public Viewable findMotorcycles(@FormParam("type")String type,@FormParam("search_field")String search, @Context HttpServletRequest request) {
            ArrayList <MotorcycleLo> list=new ArrayList <MotorcycleLo>();
        try{
        
        DatabaseDAO db = new DatabaseDAO();
        MotorcycleDAO c = new MotorcycleDAO();
        Connection conn= db.Get_Connection();
       
        if(type.equals("Model"))
        {
          list= c.searchByKeyword(search, conn);
        }
        else if(equals("Engine Size"))
        {
            int engine=Integer.parseInt(search);
           list= c.searchByEngineSize(engine, conn);
        }
        else
        {
            
        }
        
       }
       catch(Exception ex)
       {
    }       
      request.setAttribute("list", list);  
     return new Viewable("/search", null);
    }
   
    @GET
    @Path("{id}")
     @Produces("text/html")
    public Viewable find(@PathParam("id") String id,@Context HttpServletRequest request) {
       
        int Id=Integer.parseInt(id);
        try{
        DatabaseDAO db = new DatabaseDAO();
        MotorcycleDAO c = new MotorcycleDAO();
        
        Connection conn= db.Get_Connection();
        MotorcycleLo motorcycle =c.viewMotorcycle(Id, conn) ;
        ArrayList <MotPartLo> part= c.viewMotPart(motorcycle.getModelName(), conn);
        
        Gson gson = new Gson();
       
     
         String model="";
                
                    model=gson.toJson(motorcycle);
                    model+=gson.toJson(part);
                
        
        out.println("{\"Model\":"+model+"}");
        
        conn.close();
        out.close();
        
        request.setAttribute("model", model);
        request.setAttribute("id", Id);
        request.setAttribute("mot", motorcycle);
        request.setAttribute("part", part);
        
        
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        
        request.setAttribute("id", Id); 
        return new Viewable("/model", null);
  
    }
    
    
    
    
    
    
    /*@POST
    @Path("Motorcycle")
    public void addMotorcycle(@FormParam ("id_model")String id,@FormParam("serial")String serial,@FormParam("id_part")String part)    {
    try{
        DatabaseDAO db = new DatabaseDAO();
        MotorcycleModel c = new MotorcycleModel();
        Connection conn = db.Get_Connection();
         int idm=Integer.parseInt(id);
         int s=Integer.parseInt(serial);
        int idp=Integer.parseInt(part);
        c.addMotorcycle(idm,s,idp,conn);
    }catch(Exception e)
    {
    }
    
    }
    */
    
    @POST
    @Path("Add")
    @Produces("text/html")
    public Viewable createMotorcycleSpec(@FormParam ("model_name")String name,@FormParam("top_speed")String top_speed,@FormParam("weight")String weight,@FormParam("seat_height")String seat_height,@FormParam("frame")String frame,
    @FormParam("tank")String tank,@FormParam("engine_size")String engineSize,@FormParam("front_brakes")String frontB,@FormParam("rear_brakes")String rearB,@FormParam("front_tyre")String frontT,
    @FormParam("rear_tyre")String rearT,@FormParam("power")String power,@FormParam ("serial")String serial,@FormParam("colour")String colour,@FormParam("price")String price,@FormParam("Id")String Id,@FormParam("prod_weight")String prod_w,@FormParam("id_part")String idPart,@Context HttpServletRequest request) {
        
     int speed=Integer.parseInt(top_speed);
     int w=Integer.parseInt(weight);
     int sh=Integer.parseInt(seat_height);
     int t=Integer.parseInt(tank);
     int es=Integer.parseInt(engineSize);
     int fb=Integer.parseInt(frontB);
     int rb=Integer.parseInt(rearB);
     int ft=Integer.parseInt(frontT);
     int rt=Integer.parseInt(rearT);
     int pw=Integer.parseInt(power);
     int s=Integer.parseInt(serial);
     float pr=Float.parseFloat(price);
     int id=Integer.parseInt(Id);
      int prw=Integer.parseInt(prod_w);
       int idp=Integer.parseInt(idPart);
        try{
        DatabaseDAO db = new DatabaseDAO();
         Connection conn = db.Get_Connection();
        MotorcycleDAO c = new MotorcycleDAO();
         
        c.addSpec(name,speed,w,sh,frame,t,es,fb,rb,ft,rt,pw,s,colour, pr,prw,id,idp,conn) ; 
        }catch(Exception e)
        {
          
        }
        ArrayList <MotorcycleLo> list=new ArrayList <MotorcycleLo>();
        request.setAttribute("list", list);
        return new Viewable ("/search" ,null);
    }
    
    @GET
    @Path("Update/{id}")
    public Viewable update(@PathParam("id")String id,@Context HttpServletRequest request)
    {
        int Id=Integer.parseInt(id);
        MotorcycleLo mot=null;
         try{
        DatabaseDAO db = new DatabaseDAO();
        Connection conn = db.Get_Connection();
        MotorcycleDAO c = new MotorcycleDAO();
         
        mot=c.viewMotorcycle(Id, conn) ; 
        }catch(Exception e)
        {
          
        }
        
        request.setAttribute("mot", mot);
        return new Viewable("/edit_motorcycle", null);
    }
    
    @POST
    @Path("Update")
    @Produces("text/html")
    public void updateMotorcycleSpec(@FormParam ("idModel")String idModel,@FormParam ("model_name")String name,@FormParam("top_speed")String top_speed,@FormParam("weight")String weight,@FormParam("seat_height")String seat_height,@FormParam("frame")String frame,
    @FormParam("tank")String tank,@FormParam("engine_size")String engineSize,@FormParam("front_brakes")String frontB,@FormParam("rear_brakes")String rearB,@FormParam("front_tyre")String frontT,
    @FormParam("rear_tyre")String rearT,@FormParam("power")String power,@FormParam ("serial")String serial,@FormParam("colour")String colour,@FormParam("price")String price,@FormParam("Id")String Id,@FormParam("prod_weight")String productW,@Context HttpServletRequest request) {
   
     int idM=Integer.parseInt(idModel);
     int speed=Integer.parseInt(top_speed);
     float w=Float.parseFloat(weight);
     int sh=Integer.parseInt(seat_height);
     int t=Integer.parseInt(tank);
     int es=Integer.parseInt(engineSize);
     int fb=Integer.parseInt(frontB);
     int rb=Integer.parseInt(rearB);
     int ft=Integer.parseInt(frontT);
     int rt=Integer.parseInt(rearT);
     int pw=Integer.parseInt(power);
     int s=Integer.parseInt(serial);
     float pr=Float.parseFloat(price);
     int id=Integer.parseInt(Id);
     float prw=Float.parseFloat(productW);
        try{
        DatabaseDAO db = new DatabaseDAO();
         Connection conn = db.Get_Connection();
        MotorcycleDAO c = new MotorcycleDAO();
        c.updateSpec(idM,name,speed,w,sh,frame,t,es,fb,rb,ft,rt,pw,s,colour,pr,prw,conn) ; 
        }catch(Exception e)
        {
             System.out.println("TEST4");
        }
        
    }
    @GET
    @Path("Delete/{id}")
    
    public Viewable remove(@PathParam("id") String id,@Context HttpServletRequest request) {
         int Id=Integer.parseInt(id);
           
        try{
        DatabaseDAO db = new DatabaseDAO();
         Connection conn = db.Get_Connection();
        MotorcycleDAO c = new MotorcycleDAO();
         
        c.deleteMotorcycle(Id, conn);
        
        }
        catch(Exception e)
        {
            
        }
         ArrayList <MotorcycleLo> list=new ArrayList <MotorcycleLo>();
        request.setAttribute("list", list);
         return new Viewable("/search", null);
  
    }
    
    @GET
    @Path("Add")
    
    public Viewable add() {
        
         return new Viewable("/addMotorcycle", null);
  
    }
   
    /* 
    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, UserV entity) {
        super.edit(entity);
    }

    

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public MotorcycleV find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<UserV> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<UserV> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    
    
    
    
    
    @POST
    public Viewable register(@FormParam("username") String username, @FormParam("password")String password,@FormParam("email")String email)
    {
        boolean success=false;
        try{  
        DatabaseDAO db = new DatabaseDAO();
        UserModel c = new UserModel();
         Connection conn = db.Get_Connection();
           success= c.register(conn, username, password,email);
            }
        catch(Exception e)
        {
        }        
        if(success){ return new Viewable("/works",null);}
        else return new Viewable("/works",null);
      
    }*/
}
