/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.servlets;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
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
    public Viewable exists(@Context HttpServletRequest request, @FormParam("username") String username, @FormParam("password")String password) {
        boolean exists=false;
                System.out.println("Login " + username + " " + password);
        try{
           
        DatabaseDAO db = new DatabaseDAO();
        UserModel c = new UserModel();
         Connection conn = db.Get_Connection();
           exists= c.valid(conn, username, password);
            }
        catch(Exception e)
        {
        }        
        if(exists){ 
           
            request.setAttribute("username", new String(username));
            
            return new Viewable("/works",null);
        }
        else {
            System.out.println("incorrect user");
            String msg = "Incorrect login details";
            request.setAttribute("msg", new String(msg));
            return new Viewable("/message",null);
        }
    }
    
}
