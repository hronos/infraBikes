/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.models;

import java.sql.Connection;
import java.util.ArrayList;
import uk.ac.dundee.computing.infrabike.dao.SupplierDAO;
import uk.ac.dundee.computing.infrabike.dao.WarehouseDAO;
import uk.ac.dundee.computing.infrabike.dto.SupplierLo;

/**
 *
 * @author Anna
 */
public class SupplierModel {
    
    
    public boolean addSupplier(String name,String location,int phone,String email,Connection connection)
    {        
        boolean success = true;
        try {
            SupplierDAO c = new SupplierDAO();
             success=c.addSupplier(email, location, phone, email, connection);
        } 
        catch (Exception e) {
            throw e;
             
        }
        return success;
        
    }
   
    public boolean updateSupplier(String name, String location,int phone,String email,Connection connection)
    {
    boolean success = true;
        try {
            SupplierDAO c = new SupplierDAO();
             success=c.updateSupplier(name,location,phone,email,connection);
        } 
        catch (Exception e) {
            throw e;
             
        }
        return success;
    }
    
    public boolean deleteSupplier(String name,Connection connection)
    {
    boolean success = true;
        try {
            SupplierDAO c = new SupplierDAO();
             success=c.deleteSuplier(name, connection);
        } 
        catch (Exception e) {
            throw e;
             
        }
        return success;
    }
    
    public ArrayList showSuppliers(Connection connection) throws Exception
    {        
       ArrayList list = new ArrayList();
        try {
            SupplierDAO c = new SupplierDAO();
             list=c.showSuppliers(connection, null, null);
        } 
        catch (Exception e) {
            throw e;
             
        }
        return list;
    }
    
    public SupplierLo showSupplier(String name,Connection connection)
    {
        SupplierLo supplier;
        try {
            SupplierDAO c = new SupplierDAO();
            supplier=c.showSupplier(name, connection);
        } 
        catch (Exception e) {
            throw e;
             
        }
        return supplier;
    }
    }