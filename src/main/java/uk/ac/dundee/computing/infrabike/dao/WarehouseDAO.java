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

/**
 *
 * @author Anna
 */
public class WarehouseDAO {
    
    
    public void updateWarehouse(int Id,String phone,int storageS,Connection connection){
    try{
         
         PreparedStatement ps = connection.prepareStatement("UPDATE warehouse_v SET storage_size=?, phone=? WHERE id_warehouse=?"  );
         ps.setInt(1, storageS);
         ps.setString(2, phone);
         ps.setInt(3, Id);
         ps.executeUpdate();
    }catch(Exception e)
    {
    }
      
    }
    
    
    public void addWarehouse(String phone,int storageS,String location,Connection connection){
    try{
         
         PreparedStatement ps = connection.prepareStatement("INSERT INTO warehouse_v (location,storage_size,phone) VALUES (?,?,?)"  );
         ps.setString(1, location);
         ps.setInt(2, storageS);
         ps.setString(3, phone);
         ps.executeUpdate();
    }catch(Exception e)
    {
    }
      
    }
    
    
    
    
    public void addDetail(String name,String part,int price,int quantity,int warehouse_id,int supplier_id,Connection connection){
        try{
         PreparedStatement ps = connection.prepareStatement("INSERT into part_v (name, part_type,price,quantity,id_warehouse,id_supplier) VALUES(?,?,?,?,?,?)"  );
         ps.setString(1, name);
          ps.setString(2,part);
         ps.setInt(3, price);
          ps.setInt(4, quantity);
         ps.setInt(5, warehouse_id);
          ps.setInt(6, supplier_id);
         ps.executeUpdate();
        }catch(SQLException e)
      {
          System.out.println("FAIL");
          e.printStackTrace();  
      }
    
    }
    public void updateDetail(int Id,String name,String part,int price,int quantity,Connection connection){
     try{PreparedStatement ps = connection.prepareStatement("UPDATE part_v SET name=?, part_type=?,price=?,quantity-? WHERE id_part=?"  );
         ps.setString(1, name);
          ps.setString(2,part);
         ps.setInt(3, price);
          ps.setInt(4, quantity);
         ps.setInt(5, Id);
         ps.executeUpdate();
        }catch(Exception e)
        {
        }
    }
    public void deleteDetail(int Id,Connection connection){
        try{
        PreparedStatement ps = connection.prepareStatement("DELETE FROM part_v WHERE id_part=?  ");
         ps.setInt(1, Id);
         ps.executeUpdate();
        }catch(Exception e)
        {
        }
    }
    
    public void deleteWarehouse(int Id,Connection connection){
        try{
        PreparedStatement ps = connection.prepareStatement("DELETE FROM warehouse_v WHERE id_warehouse=?  ");
         ps.setInt(1, Id);
         ps.executeUpdate();
        }catch(Exception e)
        {
        }
    }
        
        
    }
    
    

