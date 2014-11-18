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
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import static javafx.scene.input.KeyCode.A;
import uk.ac.dundee.computing.infrabike.dto.OrderLo;

/**
 *
 * @author Anna
 */
public class OrderDAO {
 
    
    
    public boolean addOrder(int id_d,int del_price,String region,int id_c,int serial,Connection connection)
    {
        try{
         PreparedStatement ps=connection.prepareStatement("START TRANSACTION");
         PreparedStatement ps2=connection.prepareStatement("INSERT INTO order_v (id_dealer,date,delivery_price,region,id_customer) VALUES (?,?,?,?,?)");
         PreparedStatement ps3=connection.prepareStatement("SELECT @A:=id_order FROM order_v WHERE date=?");
         PreparedStatement ps4=connection.prepareStatement("INSERT INTO order_item_v (id_order,serial) VALUES(@A,?)");        
         PreparedStatement ps5=connection.prepareStatement ("COMMIT");
         java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
         
         ps2.setInt(1,id_d);
         ps2.setDate(2, null);
         ps2.setInt(3,del_price);
         ps2.setString(4,region);
         ps2.setInt(5,id_c);
         ps3.setTimestamp(1, date);
         ps4.setInt(1,serial);
         ps.executeUpdate();
         ps2.executeUpdate();
         ps3.executeQuery();
         ps4.executeUpdate();
         ps5.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean deleteOrder(int id,Connection connection)
    {
        try{
        PreparedStatement ps=connection.prepareStatement("START TRANSACTION");
         PreparedStatement ps2=connection.prepareStatement("DELETE FROM order_v WHERE id_order=?");
         PreparedStatement ps3=connection.prepareStatement("DELETE FROM order_v WHERE id_order=?");        
         PreparedStatement ps4=connection.prepareStatement ("COMMIT");
         ps2.setInt(1,id);
         ps3.setInt(1,id);
          ps.executeUpdate();
         ps2.executeUpdate();
         ps3.executeUpdate();
         ps4.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public ArrayList showOrder(int role, String name,Connection connection)
    {
        PreparedStatement ps;
        ArrayList orderList=new ArrayList();
        try{
            if(role==6){
                ps=connection.prepareStatement("SELECT * FROM order_lo WHERE dealer_name=?");
            }   
            else
            {
                ps=connection.prepareStatement("SELECT * FROM order_lo WHERE customer_name=?");
            }
        ps.setString(1, name);
        ResultSet rs= ps.executeQuery();
        while(rs.next()){
            OrderLo order=new OrderLo();
            order.setColor(rs.getString("color"));
            order.setDate(rs.getTimestamp("date"));
            order.setDeliveryPrice(rs.getInt("delivery_price"));
            order.setCustomerName(rs.getString("customer name"));
            order.setDealerName(rs.getString("dealer_name"));
            order.setSerial(rs.getInt("serial"));
            order.setIdOrder(rs.getInt("id_order"));
            order.setPrice(rs.getInt("price"));
            order.setRegion(rs.getString("region"));
            order.setModel(rs.getString("model"));
            order.setWeigh(rs.getInt("weight"));
            orderList.add(order);
        }
        
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        return orderList;
    }
    public ArrayList showOrders(Connection connection)
    {
        ArrayList orderList=new ArrayList();
        try{
        PreparedStatement ps=connection.prepareStatement("SELECT * FROM order_lo");
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            OrderLo order=new OrderLo();
            order.setColor(rs.getString("color"));
            order.setDate(rs.getDate("date"));
            order.setDeliveryPrice(rs.getInt("delivery_price"));
            order.setCustomerName(rs.getString("customer name"));
            order.setDealerName(rs.getString("dealer_name"));
            order.setSerial(rs.getInt("serial"));
            order.setIdOrder(rs.getInt("id_order"));
            order.setPrice(rs.getInt("price"));
            order.setRegion(rs.getString("region"));
            order.setModel(rs.getString("model"));
            order.setWeigh(rs.getInt("weight"));
            orderList.add(order);
        }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        return orderList;
    }
    
    public boolean updateOrder(int id,int idI,int id_d,int del_price,String region,int id_c,int serial, Connection connection)
    {
        try{
        PreparedStatement ps=connection.prepareStatement("START TRANSACTION");
        PreparedStatement ps2=connection.prepareStatement("UPDATE order_v SET id_dealer=?,delivery_price=?,region=?,id_customer=? WHERE id_order =?");
        PreparedStatement ps3=connection.prepareStatement("UPDATE order_item_v SET id_order=?, serial=? WHERE id_order_item=?");
        PreparedStatement ps4=connection.prepareStatement("COMMIT");
        ps2.setInt(1, id_d);
        ps2.setInt(2, del_price);
        ps2.setString(3, region);
        ps2.setInt(4,id_c);
        ps2.setInt(5,id);
        ps3.setInt(1,id);
        ps3.setInt(2,serial);
        ps3.setInt(3,idI);
        ps.executeUpdate();
        ps2.executeUpdate();
        ps3.executeUpdate();
        ps4.executeUpdate();
        }catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    
    }
    
}
