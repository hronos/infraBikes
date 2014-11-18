/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.servlets;

import java.sql.Connection;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import org.glassfish.jersey.server.mvc.Viewable;
import stores.LoggedIn;
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
        HttpSession session=request.getSession();
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
           
            
            LoggedIn lg= new LoggedIn();
            lg.setLoggedin();
            lg.setUsername(username);
            //request.setAttribute("LoggedIn", lg);
            session.setAttribute("LoggedIn", lg);
            System.out.println("Session in servlet "+session);
            String usr = lg.getUsername();
            request.setAttribute("username", new String(usr));

            
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
