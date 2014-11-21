/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.models;

import java.sql.Connection;
import java.util.ArrayList;
import static java.util.Collections.list;
import uk.ac.dundee.computing.infrabike.dao.WarehouseDAO;
import uk.ac.dundee.computing.infrabike.dto.PartLo;
import uk.ac.dundee.computing.infrabike.dto.WarehouseLo;

/**
 *
 * @author Anna
 */
public class WarehouseModel {
    
    
     public boolean addPart(Connection connection, String name,String part,int price,int quantity,int wID,int sID) throws Exception {
        boolean success = true;
        try {
            WarehouseDAO c = new WarehouseDAO();
            success= c.addPart(name,part,price,quantity,wID,sID,connection);
        } 
        catch (Exception e) {
            throw e;
             
        }
        return success;
    }
     public boolean addWarehouse(Connection connection, String location,int storageSize,String phone) throws Exception {
        boolean success = true;
        try {
            WarehouseDAO c = new WarehouseDAO();
             success=c.addWarehouse(phone,storageSize,location,connection);
        } 
        catch (Exception e) {
            throw e;
             
        }
        return success;
    }
     public boolean deletePart(Connection connection, int ID) throws Exception {
        boolean success = true;
        try {
            WarehouseDAO c = new WarehouseDAO();
            success= c.deletePart(ID,connection);
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
             success=c.deleteWarehouse(ID,connection);
        } 
        catch (Exception e) {
            throw e;
             
        }
        return success;
    }
     
     public boolean updatePart(Connection connection,int Id,String name,String part,int price,int quantity ) throws Exception {
        boolean success = true;
        try {
            WarehouseDAO c = new WarehouseDAO();
             success=c.updatePart(Id,name,part,price,quantity,connection);
        } 
        catch (Exception e) {
            throw e;
             
        }
        return success;
    }
     public boolean updateWarehouse(Connection connection,int Id,int storage,String phone) throws Exception {
        boolean success = true;
        try {
            WarehouseDAO c = new WarehouseDAO();
//             success=c.updateWarehouse(Id,phone,storage,connection);
        } 
        catch (Exception e) {
            throw e;
             
        }
        return success;
    }
     
     public WarehouseLo showWarehouse(String location,Connection connection)
     {
         WarehouseLo wh=new WarehouseLo();
         try {
            WarehouseDAO c = new WarehouseDAO();
  //          wh=c.showWarehouse(location,connection);
         }
         catch(Exception e)
         {
             
         }
         return wh;
     }
     
     public PartLo showPart(Connection connection,String name)
     {
         PartLo part=new PartLo();
         try {
            WarehouseDAO c = new WarehouseDAO();
            part=c.showPart(name,connection);
         }
         catch(Exception e)
         {
         }
         return part;
     }
     
     public ArrayList showParts(Connection connection)
     {
         ArrayList list=new ArrayList();
         try {
            WarehouseDAO c = new WarehouseDAO();
            
            list=c.showParts(connection);
         }
         catch(Exception e)
         {
             
         }
     return list;
     }
     
    
              
     
}
