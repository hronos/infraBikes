/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.models;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import uk.ac.dundee.computing.infrabike.dao.OrderDAO;
import static uk.ac.dundee.computing.infrabike.dto.MotorcycleLo_.price;
import static uk.ac.dundee.computing.infrabike.dto.MotorcycleLo_.serial;
import uk.ac.dundee.computing.infrabike.dto.OrderLo;
import static uk.ac.dundee.computing.infrabike.dto.OrderV_.region;

/**
 *
 * @author Anna
 */
public class OrderModel {
    
    
    public boolean addOrder(int id_d,int price,String region,int id_c,int serial,Connection connection)
    {
        boolean success=false;
         try {
            OrderDAO o = new OrderDAO();
            success= o.addOrder(id_d, price, region, id_c, serial, connection);
            
        } catch (Exception e) {
            throw e;
        }
         return success;
    }
    
    public boolean deleteOrder(int id,Connection connection)
    {
     boolean success=false;
         try {
            OrderDAO o = new OrderDAO();
            success= o.deleteOrder(id, connection);
            
        } catch (Exception e) {
            throw e;
        }
         return success;
    }
    
    public ArrayList showOrder(int role,String name,Connection connection)
    {
     ArrayList list;
         try {
            OrderDAO o = new OrderDAO();
            list= o.showOrder(role, name, connection);
            
        } catch (Exception e) {
            throw e;
        }
         return list;
    }
    public List<OrderLo> showOrders(Connection connection)
    {
        ArrayList list;
         try {
            OrderDAO o = new OrderDAO();
            list= o.showOrders( connection);
            
        } catch (Exception e) {
            throw e;
        }
         return list;
   
    }
    
    public boolean updateOrder(int id,int id_d,int delivery_price,String region,int id_c,Connection connection)
    {
    boolean success=false;    
    try {
            OrderDAO o = new OrderDAO();
            success= o.updateOrder(id, id_d, delivery_price, region, id_c, connection);
            
        } catch (Exception e) {
            throw e;
        }
         return success;
    }
    
     public boolean updateItem(int id,int idI,int serial,Connection connection)
    {
    boolean success=false;    
    try {
            OrderDAO o = new OrderDAO();
            success= o.updateItem(id, idI,serial, connection);
            
        } catch (Exception e) {
            throw e;
        }
         return success;
    }
    public boolean addOrderItem(int id,int serial,Connection connection)
    {
        boolean success=false;
        try{
            OrderDAO o= new OrderDAO();
            success=o.addItem(id,serial,connection);
        }catch(Exception e)
        {
        }
        return success;
    }
    
     public boolean deleteItem(int id,Connection connection)
    {
        boolean success=false;
        try{
            OrderDAO o= new OrderDAO();
            success=o.deleteItem(id,connection);
        }catch(Exception e)
        {
        }
        return success;
    }
    
     
}
