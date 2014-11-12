/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.models;

import java.sql.Connection;
import uk.ac.dundee.computing.infrabike.dao.WarehouseDAO;

/**
 *
 * @author Anna
 */
public class WarehouseModel {
    
    
     public boolean addDetail(Connection connection, String name,String part,int price,int quantity,int wID,int sID) throws Exception {
        boolean success = true;
        try {
            WarehouseDAO c = new WarehouseDAO();
             c.addDetail(name,part,price,quantity,wID,sID,connection);
        } 
        catch (Exception e) {
            throw e;
             
        }
        return success;
    }
     public boolean addWarehouse(Connection connection, String name,String part,int price,int quantity,int wID,int sID) throws Exception {
        boolean success = true;
        try {
            WarehouseDAO c = new WarehouseDAO();
             c.addDetail(name,part,price,quantity,wID,sID,connection);
        } 
        catch (Exception e) {
            throw e;
             
        }
        return success;
    }
     public boolean deleteDetail(Connection connection, int ID) throws Exception {
        boolean success = true;
        try {
            WarehouseDAO c = new WarehouseDAO();
            // c.addDetail(name,part,price,quantity,wID,sID,connection);
        } 
        catch (Exception e) {
            throw e;
             
        }
        return success;
    }
     public boolean deleteWarehouse(Connection connection, int ID) throws Exception {
        boolean success = true;
        try {
            WarehouseDAO c = new WarehouseDAO();
             //c.addDetail(name,part,price,quantity,wID,sID,connection);
        } 
        catch (Exception e) {
            throw e;
             
        }
        return success;
    }
     
     public boolean updateDetail(Connection connection, String name,String part,int price,int quantity,int wID,int sID) throws Exception {
        boolean success = true;
        try {
            WarehouseDAO c = new WarehouseDAO();
             c.addDetail(name,part,price,quantity,wID,sID,connection);
        } 
        catch (Exception e) {
            throw e;
             
        }
        return success;
    }
     public boolean updateWarehouse(Connection connection, String name,String part,int price,int quantity,int wID,int sID) throws Exception {
        boolean success = true;
        try {
            WarehouseDAO c = new WarehouseDAO();
             c.addDetail(name,part,price,quantity,wID,sID,connection);
        } 
        catch (Exception e) {
            throw e;
             
        }
        return success;
    }
}
