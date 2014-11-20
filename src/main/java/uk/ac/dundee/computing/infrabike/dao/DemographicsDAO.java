/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import uk.ac.dundee.computing.infrabike.dto.DemographicsLo;

/**
 *
 * @author Anna
 */
public class DemographicsDAO {
    
    public ArrayList viewDemographics(Connection connection) throws SQLException
    {
        ArrayList demoData = new ArrayList();
        
        try{
         PreparedStatement ps=connection.prepareStatement("SELECT * FROM demographics_lo");
         ResultSet rs = ps.executeQuery();
         
         System.out.println("DAO before while");
         
         while(rs.next())
         {
             DemographicsLo d = new DemographicsLo();
             d.setAverageAge(rs.getInt("average_age"));
             d.setAverageTemperature(rs.getInt("average_temperature"));
             d.setCommuting(rs.getString("commuting"));
             d.setCountry(rs.getString("country"));
             d.setCrimeStats(rs.getInt("crime_stats"));
             d.setMarried(rs.getInt("married"));
             d.setParking(rs.getInt("parking"));
             d.setPopulation(rs.getInt("population"));
             d.setRainyDays(rs.getInt("rainy_days"));
             d.setRegion(rs.getString("region"));
             d.setSnowyDays(rs.getInt("snowy_days"));
             d.setTrafficInfo(rs.getInt("traffic_info"));
             demoData.add(d);
             System.out.println("DAO after add");
         } 
         return demoData;
        }
        catch(SQLException e)
        {
            throw e;
        }
       
    }
}
