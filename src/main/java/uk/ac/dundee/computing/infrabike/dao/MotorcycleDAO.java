/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Anna
 */
public class MotorcycleDAO {
    
    public void viewMotorcycleList(int Id,String phone,int storageS,Connection connection){
    try{
         
         PreparedStatement ps = connection.prepareStatement("SELECT * FROM motorcycle_lo"  );
         ResultSet rs=ps.executeQuery();
    }catch(Exception e)
    {
    }
      
    }
    public void viewParts(int Id,Connection connection){
    try{
         
         PreparedStatement ps = connection.prepareStatement("SELECT * FROM part_v WHERE id_part=?"  );
         ps.setInt(1, Id);
         ResultSet rs=ps.executeQuery();
    }catch(Exception e)
    {
    }
      
    }
    
    
      public void viewMotorcycle(int Id,Connection connection){
    try{
         
         PreparedStatement ps = connection.prepareStatement("SELECT * FROM motorcycle_lo WHERE id_model=?"  );
         ps.setInt(1, Id);
         ResultSet rs=ps.executeQuery();
    }catch(Exception e)
    {
    }
      
    }
    
     
    
    
    
    public void updateMotorcycle(int Id,String model_name,int top_speed,int weight,int seat_height,String frame,int tank,
            int engine_size_cc,int front_brakes,int rear_brakes,int front_tyre_size,int rear_tyre_size,int power_kw,int serial,
            String colour,int price, int prod_weight,Connection connection){
    try{
         
         PreparedStatement ps = connection.prepareStatement("UPDATE motorcycle_lo SET model_name=?, top_speed=?, weight=?,seat_height=?,frame=?,tank=?,"
                 + "engine_size_cc=?,front_brakes=?,rear_brakes=?,front_tyre_size=?,rear_tyre_size=?,power_kw=?,serial=?,colour=?, price=?,prod_weight=?"
                 + " WHERE id_model=?"  );
         ps.setString(1, model_name);
         ps.setInt(2, top_speed);
         ps.setInt(3, weight);
          ps.setInt(4, seat_height);
         ps.setString(5, frame);
         ps.setInt(6, tank);
          ps.setInt(7, engine_size_cc);
         ps.setInt(8, front_brakes);
         ps.setInt(9,  rear_brakes);
          ps.setInt(10, front_tyre_size);
         ps.setInt(11, rear_tyre_size);
         ps.setInt(12, power_kw);
          ps.setInt(13, serial);
         ps.setString(14, colour);
         ps.setInt(15, price);
          ps.setInt(16, prod_weight);
         ps.setInt(17, Id);
         ps.executeUpdate();
    }catch(Exception e)
    {
    }
      
    }
    
   
      
    
    public void addMotorcycle(String model_name,int top_speed,int weight,int seat_height,String frame,int tank,
            int engine_size_cc,int front_brakes,int rear_brakes,int front_tyre_size,int rear_tyre_size,int power_kw,int serial,
            String colour,int price, int prod_weight,Connection connection){
    try{
         
         PreparedStatement ps = connection.prepareStatement("INSERT INTO motorcycle_lo ( model_name,top_speed,weight,seat_height,frame,tank," +
"            engine_size_cc,front_brakes,rear_brakes,front_tyre_size,rear_tyre_size,power_kw,serial,\n" +
"            colour,price, prod_weight) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,)"  );
         ps.setString(1, model_name);
         ps.setInt(2, top_speed);
         ps.setInt(3, weight);
          ps.setInt(4, seat_height);
         ps.setString(5, frame);
         ps.setInt(6, tank);
          ps.setInt(7, engine_size_cc);
         ps.setInt(8, front_brakes);
         ps.setInt(9,  rear_brakes);
          ps.setInt(10, front_tyre_size);
         ps.setInt(11, rear_tyre_size);
         ps.setInt(12, power_kw);
          ps.setInt(13, serial);
         ps.setString(14, colour);
         ps.setInt(15, price);
         ps.setInt(16, prod_weight);
         ps.executeUpdate();
    }catch(Exception e)
    {
    }
      
    }
   
    
    
    
    
    
    public void deleteMotorcycle(int Id,Connection connection){
        try{
        PreparedStatement ps = connection.prepareStatement("DELETE FROM part_v WHERE id_model=?  ");
         ps.setInt(1, Id);
         ps.executeUpdate();
        }catch(Exception e)
        {
        }
    }
    
   
    }
    
        
    
    

