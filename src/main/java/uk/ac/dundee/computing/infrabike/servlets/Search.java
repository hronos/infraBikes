/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.servlets;

import java.sql.Connection;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import org.glassfish.jersey.server.mvc.Viewable;
import uk.ac.dundee.computing.infrabike.dao.DatabaseDAO;
import uk.ac.dundee.computing.infrabike.dao.MotorcycleDAO;
import uk.ac.dundee.computing.infrabike.dto.MotorcycleLo;

/**
 *
 * @author Anna
 */
@Stateless
@Path("Motorcycle")
public class Search {
    
    @GET
    public Viewable defaultSearch(@Context HttpServletRequest request) 
    {
        ArrayList<MotorcycleLo> mot=new ArrayList<MotorcycleLo>();
        try{
        
        DatabaseDAO db = new DatabaseDAO();
        MotorcycleDAO c = new MotorcycleDAO();
        Connection conn= db.Get_Connection();
        mot= c.searchByModel("model", conn);
        }
       catch(Exception e)
       {
       }
        
    request.setAttribute("list", mot);  
     return new Viewable("/search", null);
    }

}