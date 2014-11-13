package uk.ac.dundee.computing.infrabike.servlets;

import com.google.gson.Gson;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import static java.lang.System.out;
import java.sql.Connection;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ejb.Stateless;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;


import org.glassfish.jersey.server.mvc.Viewable;
import uk.ac.dundee.computing.infrabike.dao.DatabaseDAO;
import uk.ac.dundee.computing.infrabike.models.UserModel;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("Users")
@Stateless
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
        UserModel u = new UserModel();
        ArrayList userData = null;
        
        Connection conn = db.Get_Connection();
      //  userData = u.GetUsers(conn, null, null);
        
        Gson gson = new Gson();
        
        String users = gson.toJson(userData);
        
        out.println("{\"Users\":"+users+"}");
        
        
        conn.close();
        out.close();
        
        request.setAttribute("users", users);
        
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
        return new Viewable("/users", null);
    }
    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Viewable findAll(@PathParam("id") Integer id){
        
        
        return new Viewable("/users", null);
    }
}
