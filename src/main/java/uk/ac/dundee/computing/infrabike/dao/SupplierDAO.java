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
import uk.ac.dundee.computing.infrabike.dto.SupplierLo;

/**
 *
 * @author Anna
 */
public class SupplierDAO {
    
    
    public boolean addSupplier(String name,String location,int phone,String email,Connection connection){
    try{      
         PreparedStatement ps = connection.prepareStatement("INSERT INTO supplier_v (name,location,phone,email) VALUES (?,?,?,?)"  );
         ps.setString(1, name);
         ps.setString(2, location);
         ps.setInt(3, phone);
         ps.setString(4, email);
         ps.executeUpdate();
         return true;
        }catch(Exception e)
    {
        return false;
    }
    }
    
    
    public boolean updateSupplier(String name,String location,int phone,String email,Connection connection){
    try{PreparedStatement ps = connection.prepareStatement("UPDATE supplier_v SET location=?, phone=?,email=? WHERE name=?"  );
         ps.setString(1, location);
         ps.setInt(2, phone);
         ps.setString(3, email);
         ps.setString(4, name);
         ps.executeUpdate();
         return true;
        }catch(Exception e)
        {
            return false;
        }
    }
    
    
    public boolean deleteSuplier(String name,Connection connection){
    
    try{
        PreparedStatement ps = connection.prepareStatement("DELETE FROM supplier_v WHERE name=?  ");
         ps.setString(1, name);
         ps.executeUpdate();
         return true;
        }catch(Exception e)
        {
            return false;
        }
    
    }

    
    public SupplierLo showSupplier(String name,Connection connection){
    SupplierLo supplier=new SupplierLo();
    try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM supplier_lo WHERE name=? ");
            ps.setString(1, name);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
               
                supplier.setName(rs.getString("name"));
                supplier.setLocation(rs.getString("location"));
                supplier.setEmail(rs.getString("email"));
                supplier.setPhone(rs.getInt("phone"));
                
            }
            
            
    }
    catch(SQLException e)
    {
        
    }
    return supplier;
    }
   
    
    public ArrayList showSuppliers(Connection connection, HttpServletRequest request, HttpServletResponse response)
        throws Exception {
    ArrayList list=new ArrayList();
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM supplier ORDER BY name DESC");
           
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                SupplierLo supplier=new SupplierLo();
                supplier.setName(rs.getString("name"));
                supplier.setLocation(rs.getString("location"));
                supplier.setEmail(rs.getString("email"));
                supplier.setPhone(rs.getInt("phone"));
                list.add(supplier);
            }
    }
       
    catch(SQLException e)
    {
        
    }
     return list;
    }
    
    
    
    
            
}
