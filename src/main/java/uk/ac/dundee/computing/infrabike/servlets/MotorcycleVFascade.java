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
        MotPartLo part= c.viewMotPart(motorcycle.getModelName(), conn);
        
        Gson gson = new Gson();
       
     
         String model="";
                
                    model=gson.toJson(motorcycle);
                    model+=gson.toJson(part);
                
        
        out.println("{\"Model\":"+model+"}");
        
        conn.close();
        out.close();
        
        request.setAttribute("model", model);
        
        
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        
        request.setAttribute("id", Id); 
        return new Viewable("/model", null);
  
    }
    
    
    
    
    
    
    @POST
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
    
    
    @POST
    @Path("Specification")
    public void createMotorcycleSpec(@FormParam ("model_name")String name,@FormParam("top_speed")String top_speed,@FormParam("weight")String weight,@FormParam("seat_height")String seat_height,@FormParam("frame")String frame,
    @FormParam("tank")String tank,@FormParam("engine_size")String engineSize,@FormParam("front_brakes")String frontB,@FormParam("rear_brakes")String rearB,@FormParam("front_tyre")String frontT,
    @FormParam("rear_tyre")String rearT,@FormParam("power")String power,@FormParam ("serial")String serial,@FormParam("colour")String colour,@FormParam("price")String price,@FormParam("Id")String Id) {
        
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
     int pr=Integer.parseInt(price);
     int id=Integer.parseInt(Id);
        try{
        DatabaseDAO db = new DatabaseDAO();
         Connection conn = db.Get_Connection();
        MotorcycleModel c = new MotorcycleModel();
         System.out.println("TEST3"+name);
        c.addSpec(name,speed,w,sh,frame,t,es,fb,rb,ft,rt,pw,s,colour, pr,id,conn) ; 
        }catch(Exception e)
        {
          
        }
        
    }
    
    @POST
    @Path("Update")
     public void updateMotorcycleSpec(@FormParam ("idModel")String idModel,@FormParam ("model_name")String name,@FormParam("top_speed")String top_speed,@FormParam("weight")String weight,@FormParam("seat_height")String seat_height,@FormParam("frame")String frame,
    @FormParam("tank")String tank,@FormParam("engine_size")String engineSize,@FormParam("front_brakes")String frontB,@FormParam("rear_brakes")String rearB,@FormParam("front_tyre")String frontT,
    @FormParam("rear_tyre")String rearT,@FormParam("power")String power,@FormParam ("serial")String serial,@FormParam("colour")String colour,@FormParam("price")String price,@FormParam("Id")String Id) {
   
     int idM=Integer.parseInt(idModel);
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
     int pr=Integer.parseInt(price);
     int id=Integer.parseInt(Id);
           
        try{
        DatabaseDAO db = new DatabaseDAO();
         Connection conn = db.Get_Connection();
        MotorcycleModel c = new MotorcycleModel();
         System.out.println("TEST3"+name);
        c.updateSpec(idM,name,speed,w,sh,frame,t,es,fb,rb,ft,rt,pw,s,colour, pr,id,conn) ; 
        }catch(Exception e)
        {
             System.out.println("TEST4");
        }
        
    }
    
    
    
    /* 
    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, UserV entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        em = getEntityManager();
        UserV em2= em.merge(super.find(id));
        em.remove(em2);
        //super.remove(super.find(id));
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
