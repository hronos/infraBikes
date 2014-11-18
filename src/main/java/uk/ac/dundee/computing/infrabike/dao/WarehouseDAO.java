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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uk.ac.dundee.computing.infrabike.dto.PartLo;
import uk.ac.dundee.computing.infrabike.dto.WarehouseLo;
import uk.ac.dundee.computing.infrabike.dto.WarehouseV;

/**
 *
 * @author Anna
 */
public class WarehouseDAO {
    
     public ArrayList getWarehouses(Connection connection, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
          ArrayList warehouseData = new ArrayList();
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM warehouse_v ORDER BY id_warehouse DESC");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                WarehouseV w = new WarehouseV();
                
                w.setIdWarehouse(rs.getInt("id_warehouse"));
               w.setLocation(rs.getString("location"));
               w.setStorageSize(rs.getInt("storage_size"));
               w.setPhone(rs.getString("phone"));
               
               warehouseData.add(w);
            
            }
            
            return warehouseData;
        }
        catch(Exception e){
            throw e;
        }
     }
        
    
    
    
    public boolean updateWarehouse(int Id,String phone,int storageS,Connection connection){
    try{
         
         PreparedStatement ps = connection.prepareStatement("UPDATE warehouse_v SET storage_size=?, phone=? WHERE id_warehouse=?"  );
         ps.setInt(1, storageS);
         ps.setString(2, phone);
         ps.setInt(3, Id);
         ps.executeUpdate();
         return true;
         
    }catch(Exception e)
    {
        return false;
    }
      
    }
    
    
    public boolean addWarehouse(String phone,int storageS,String location,Connection connection){
    try{
         
         PreparedStatement ps = connection.prepareStatement("INSERT INTO warehouse_v (location,storage_size,phone) VALUES (?,?,?)"  );
         ps.setString(1, location);
         ps.setInt(2, storageS);
         ps.setString(3, phone);
         ps.executeUpdate();
         return true;
    }catch(Exception e)
    {
        return false;
    }
      
    }
    
    
    
    
    public boolean addPart(String name,String part,int price,int quantity,int warehouse_id,int supplier_id,Connection connection){
        try{
         PreparedStatement ps = connection.prepareStatement("INSERT into part_v (name, part_type,price,quantity,id_warehouse,id_supplier) VALUES(?,?,?,?,?,?)"  );
         ps.setString(1, name);
          ps.setString(2,part);
         ps.setInt(3, price);
          ps.setInt(4, quantity);
         ps.setInt(5, warehouse_id);
          ps.setInt(6, supplier_id);
         ps.executeUpdate();
         return true;
        }catch(SQLException e)
      {
        
          e.printStackTrace();  
          return false;
      }
    
    }
    public boolean updatePart(int Id,String name,String part,int price,int quantity,Connection connection){
     try{PreparedStatement ps = connection.prepareStatement("UPDATE part_v SET name=?, part_type=?,price=?,quantity=? WHERE id_part=?"  );
         ps.setString(1, name);
          ps.setString(2,part);
         ps.setInt(3, price);
          ps.setInt(4, quantity);
         ps.setInt(5, Id);
         ps.executeUpdate();
         return true;
        }catch(Exception e)
        {
            return false;
        }
    }
    public boolean deletePart(int Id,Connection connection){
        try{
        PreparedStatement ps = connection.prepareStatement("DELETE FROM part_v WHERE id_part=?  ");
         ps.setInt(1, Id);
         ps.executeUpdate();
         return true;
        }catch(Exception e)
        {
            return false;
        }
    }

    
    public PartLo showPart(String name,Connection connection)
    {
         PartLo part = new PartLo();
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM part_lo WHERE name=?");
            ps.setString(1, name);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
               
                part.setName(rs.getString("name"));
                part.setPartType(rs.getString("part_type"));
                part.setPartType(rs.getString("name"));
                part.setPrice(rs.getInt("price"));
                part.setQuantity(rs.getInt("quantity"));
                part.setSupplierEmail(rs.getString("supplier_email"));
                part.setSupplierName(rs.getString("supplier_name"));
                part.setSupplierPhone(rs.getInt("supplier_phone"));
                part.setWarehouseLocation(rs.getString("warehouse_location"));
                part.setWarehousePhone(rs.getString("warehouse_phone"));
            
            }
        }
        catch(SQLException e)
        {
        }
        return part;
    }
    
    public ArrayList showParts(Connection connection)
    {
         ArrayList list=new ArrayList();
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM part_lo ");
        
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                PartLo part = new PartLo();
                part.setName(rs.getString("name"));
                part.setPartType(rs.getString("part_type"));
                part.setPrice(rs.getInt("price"));
                part.setQuantity(rs.getInt("quantity"));
                part.setSupplierEmail(rs.getString("supplier_email"));
                part.setSupplierName(rs.getString("supplier_name"));
                part.setSupplierPhone(rs.getInt("supplier_phone"));
                part.setWarehouseLocation(rs.getString("warehouse_location"));
                part.setWarehousePhone(rs.getString("warehouse_phone"));
                list.add(part);
            }
        }
        catch(SQLException e)
        {
        }
        return list;
    
    }
    
    public WarehouseLo showWarehouse(String location,Connection connection)
    {
     WarehouseLo wh=new WarehouseLo();
     try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM warehouse_lo WHERE location=? ");
            ps.setString(1, location);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                wh.setLocation(rs.getString("location"));
                wh.setPhone(rs.getString("phone"));
                wh.setStorageSize(rs.getInt("storage_size"));
            }
     }
     catch(SQLException e)
     {
     }
     return wh;
    }
    
    
    
    
    
    public boolean deleteWarehouse(int Id,Connection connection){
        try{
        PreparedStatement ps = connection.prepareStatement("DELETE FROM warehouse_v WHERE id_warehouse=?  ");
         ps.setInt(1, Id);
         ps.executeUpdate();
            return true;
        }catch(Exception e)
        {
            return false;
        }
    }
        
        
    }
    
    

