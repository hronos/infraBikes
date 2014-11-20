/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.servlets;

import com.google.gson.Gson;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import org.glassfish.jersey.server.mvc.Viewable;
import uk.ac.dundee.computing.infrabike.dao.CustomerDAO;

import uk.ac.dundee.computing.infrabike.dao.DatabaseDAO;
import uk.ac.dundee.computing.infrabike.models.CustomerModel;

/**
 *
 * @author dlennart
 */

@Stateless
@Path("Customer")

public class Customers {  
    

    
    @GET
    
    @Produces("text/html")
    public Viewable getIt(@Context HttpServletRequest request) {
        System.out.println("/customer called");       
        try {        
        DatabaseDAO db = new DatabaseDAO();
        CustomerDAO war = new CustomerDAO();
        ArrayList cusData = null;
        
        Connection conn = db.Get_Connection();
        cusData = war.showCustomers(conn, null, null);
        
        Gson gson = new Gson();
        
        String customers = gson.toJson(cusData);
        
        //out.println("{\"Customers\":"+customers+"}");
        
        
        conn.close();
        //out.close();
        
        request.setAttribute("customers", customers);
        
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
        return new Viewable("/customers", null);
    }

}
