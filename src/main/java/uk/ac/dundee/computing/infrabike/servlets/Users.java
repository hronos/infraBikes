package uk.ac.dundee.computing.infrabike.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;


import org.glassfish.jersey.server.mvc.Viewable;
import uk.ac.dundee.computing.infrabike.dao.DatabaseDAO;
import uk.ac.dundee.computing.infrabike.dao.UserDAO;
import uk.ac.dundee.computing.infrabike.dto.UserV;

/**
 * Root resource (exposed at "myresource" path)
 */

@Stateless
@Path("Users")
public class Users {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    
    @Produces("text/html")
    public Viewable getIt(@Context HttpServletRequest request) {
        System.out.println("/users called");       
        try {        
        DatabaseDAO db = new DatabaseDAO();
        UserDAO u = new UserDAO();
        ArrayList userData = null;
        
        Connection conn = db.Get_Connection();
        userData = u.GetUsers(conn, null, null);
        
        Gson gson = new Gson();
        
        String users = gson.toJson(userData);
        
        System.out.println("{\"Users\":"+users+"}");
        conn.close();
        request.setAttribute("users", users);

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
        return new Viewable("/showUser", null);
    }
    @POST
    @Path("{username}")
    public void saveUserRole(@Context HttpServletRequest request, @PathParam("username") String username,
            @FormParam("sel_Role") String role_name) {
        int role;
        switch(role_name){
        default:
             throw new IllegalArgumentException("Invalid role");
        case "admin":
            role = 1;
            break;
        case "marketing":
            role = 2;
            break;
        case "manager":
            role = 3;
            break;
        case "tech":
            role = 4;
            break;
        case "warehouse_keeper":
            role = 5;
            break;
        case "customer":
            role = 6;
            break;
        case "dealer":
            role = 7;
            break;
        }
        UserDAO u = new UserDAO();
        UserV user = new UserV();
        
        DatabaseDAO db = new DatabaseDAO();
        try {
        Connection conn = db.Get_Connection();
        u.changeRole(role, username, conn);
        
        } catch (Exception e){}
        
    }
    @GET
    @Path("{username}")
    public Viewable editUser(@Context HttpServletRequest request, @PathParam("username") String username){
        UserDAO u = new UserDAO();
        UserV user = new UserV();
        DatabaseDAO db = new DatabaseDAO();
        try {
        Connection conn = db.Get_Connection();
        user = u.getUser(username, conn);
        
        } catch (Exception e){}
        
        request.setAttribute("username", user.getUsername());
        request.setAttribute("role", user.getIdRole());
        return new Viewable("/edit_user", null);
    }
    @GET
    @Path("Dealer")
    @Produces("text/html")
    public Viewable getItDealer(@Context HttpServletRequest request) {
        System.out.println("/dealer called");       
        try {        
        DatabaseDAO db = new DatabaseDAO();
        UserDAO deal = new UserDAO();
        ArrayList dealData = null;
        
        Connection conn = db.Get_Connection();
        dealData = deal.viewDealers(conn, null, null);
        
        Gson gson = new Gson();
        
        String dealers = gson.toJson(dealData);
        
        out.println("{\"Dealer\":"+dealers+"}");
        
        
        conn.close();
        out.close();
        
        request.setAttribute("dealer", dealers);
        
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
        return new Viewable("/dealer", null);
    }
    
    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Viewable find(@PathParam("id") String id){
        int Id=Integer.parseInt(id);
        
        return new Viewable("/users", null);
    }
}
