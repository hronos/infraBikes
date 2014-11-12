/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.servlets;

import java.sql.Connection;
import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import org.glassfish.jersey.server.mvc.Viewable;
import uk.ac.dundee.computing.infrabike.dao.DatabaseDAO;
import uk.ac.dundee.computing.infrabike.models.UserModel;

/**
 *
 * @author Anna
 */
@Stateless
@Path("Login")
public class Login {
    
    
    @POST
    //@Consumes({"application/xml", "application/json"})
    public Viewable exists(@FormParam("login") String username, @FormParam("password")String password) {
        boolean exists=false;
                System.out.println("TUT");
        try{
           
        DatabaseDAO db = new DatabaseDAO();
        UserModel c = new UserModel();
         Connection conn = db.Get_Connection();
           exists= c.valid(conn, username, password);
            }
        catch(Exception e)
        {
        }        
        if(exists){ return new Viewable("/works",null);}
        else return new Viewable("/works",null);
    }
    
}
