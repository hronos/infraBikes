/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.servlets;

import com.google.gson.Gson;
import java.sql.Connection;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import org.glassfish.jersey.server.mvc.Viewable;
import uk.ac.dundee.computing.infrabike.dao.DatabaseDAO;
import uk.ac.dundee.computing.infrabike.dao.DemographicsDAO;
import uk.ac.dundee.computing.infrabike.dto.DemographicsLo;

/**
 *
 * @author Anna
 */
@Stateless
@Path("Demo")
public class DemographicsFascade {
 
    @GET
    @Produces("text/html")
    public Viewable viewDemographics(@Context HttpServletRequest request)
    {
        ArrayList demoData = null;
        try{
        DatabaseDAO db = new DatabaseDAO();
        DemographicsDAO d = new DemographicsDAO();
        Connection conn = db.Get_Connection();
        
        demoData = d.viewDemographics(conn) ;
        Gson gson = new Gson();
        String demoD;
        demoD = gson.toJson(demoData);
        System.out.println(demoD);
        conn.close();
        request.setAttribute("demo", demoD);
        }
        catch(Exception e)
        {
            
        }
         return new Viewable("/demo",null);
         
    }
    
}
