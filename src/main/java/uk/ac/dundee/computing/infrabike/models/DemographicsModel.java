/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.models;

import java.sql.Connection;
import uk.ac.dundee.computing.infrabike.dao.DemographicsDAO;
import uk.ac.dundee.computing.infrabike.dto.DemographicsLo;

/**
 *
 * @author Anna
 */
public class DemographicsModel {
 
    public DemographicsLo viewDemographics(Connection connection)
    {
    DemographicsLo demo=new DemographicsLo();
        try {
            DemographicsDAO c = new DemographicsDAO();
            demo=c.viewDemographics(connection);
                    } catch (Exception e) {
            throw e;
        }
        return demo;
    }
}
