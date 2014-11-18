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
import uk.ac.dundee.computing.infrabike.dto.DemographicsLo;

/**
 *
 * @author Anna
 */
public class DemographicsDAO {
    
    public DemographicsLo viewDemographics(Connection connection)
    {
        DemographicsLo demographics=new DemographicsLo();
        try{
         PreparedStatement ps=connection.prepareStatement("SELECT * FROM  demographics_lo");
         ResultSet rs=ps.executeQuery();
         while(rs.next())
         {
             demographics.setAverageAge(rs.getInt("average_age"));
             demographics.setAverageTemperature(rs.getInt("average_temprature"));
             demographics.setCommuting(rs.getString("commuting"));
             demographics.setCountry(rs.getString("country"));
             demographics.setCrimeStats(rs.getInt("crime_stats"));
             demographics.setMarried(rs.getBoolean("married"));
             demographics.setParking(rs.getInt("parking"));
             demographics.setPopulation(rs.getInt("population"));
             demographics.setRainyDays(rs.getInt("rainy_days"));
             demographics.setRegion(rs.getString("region"));
             demographics.setSnowyDays(rs.getInt("snowy_days"));
             demographics.setTrafficInfo(rs.getInt("traffic_info"));
         }
         
        }
        catch(SQLException e)
        {
        }
     return demographics;   
    }
}
