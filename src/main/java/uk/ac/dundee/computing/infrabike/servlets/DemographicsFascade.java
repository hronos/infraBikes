/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.servlets;

import java.sql.Connection;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.glassfish.jersey.server.mvc.Viewable;
import uk.ac.dundee.computing.infrabike.dao.DatabaseDAO;
import uk.ac.dundee.computing.infrabike.dto.DemographicsLo;
import uk.ac.dundee.computing.infrabike.models.DemographicsModel;

/**
 *
 * @author Anna
 */
@Stateless
@Path("Demographics")
public class DemographicsFascade {
 
    @GET
    public Viewable viewDemographics()
    {
        try{
        DemographicsLo demographics=new DemographicsLo();
        DatabaseDAO db = new DatabaseDAO();
        DemographicsModel c = new DemographicsModel();
        Connection conn = db.Get_Connection();
        demographics =c.viewDemographics(conn) ;
        }
        catch(Exception e)
        {
            
        }
         return new Viewable("/works",null);
         
    }
    
}
