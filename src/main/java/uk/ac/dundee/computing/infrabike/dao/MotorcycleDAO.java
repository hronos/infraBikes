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
import uk.ac.dundee.computing.infrabike.dto.MotPartLo;
import uk.ac.dundee.computing.infrabike.dto.MotorcycleLo;
import uk.ac.dundee.computing.infrabike.dto.PartLo;

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
    public PartLo viewParts(int Id,Connection connection){
      PartLo part=new PartLo();
        try{
      
         PreparedStatement ps = connection.prepareStatement("SELECT * FROM part_lo WHERE id_part=?"  );
         ps.setInt(1, Id);
         ResultSet rs=ps.executeQuery();
         while(rs.next())
         {
         part.setIdPart(rs.getInt("id_part"));
         part.setName(rs.getString("name"));
         part.setPartType(rs.getString("part_type"));
         part.setPrice(rs.getFloat("price"));
         part.setQuantity(rs.getInt("quantity"));
         part.setSupplierEmail(rs.getString("supplier_email"));
         part.setSupplierName(rs.getString("supplier_name"));
         part.setSupplierPhone(rs.getInt("supplier_phone"));
         part.setWarehouseLocation(rs.getString("warehouse_location"));
         part.setWarehousePhone(rs.getString("warehouse_phone"));
         }
         
    }catch(Exception e)
    {
    }
     return part; 
    }
    
    // view parts that exist in certain bike
    public MotPartLo viewMotPart(String name, Connection connection){
        MotPartLo motPart=new MotPartLo();
        try{
      
         PreparedStatement ps = connection.prepareStatement("SELECT * FROM mot_part_lo WHERE model_name=?"  );
         ps.setString(1, name);
         ResultSet rs=ps.executeQuery();
         while(rs.next())
         {
         motPart.setModelName(rs.getString("model_name"));
         motPart.setPartName(rs.getString("part_name"));
         motPart.setPartType(rs.getString("part_type"));        
         }
         
        }catch(Exception e){
        
        }
     return motPart; 
    }
    
      public MotorcycleLo viewMotorcycle(int Id,Connection connection){
          MotorcycleLo motLo = new MotorcycleLo();
    try{
         
         PreparedStatement ps = connection.prepareStatement("SELECT * FROM motorcycle_lo WHERE id_model=?"  );
         ps.setInt(1, Id);
         ResultSet rs=ps.executeQuery();
         while(rs.next()){
             motLo.setColor(rs.getString("color"));
             motLo.setEngineSizeCc(rs.getInt("engline_size_cc"));
             motLo.setFrame(rs.getString("frame"));
             motLo.setFrontBrakes(rs.getInt("front_brakes"));
             motLo.setFrontTyreSize(rs.getInt("front_tyre_size"));
             motLo.setIdModel(rs.getInt("id_model"));
             motLo.setModelName(rs.getString("model_name"));
             motLo.setPowerKw(rs.getInt("power_kw"));
             motLo.setPrice(rs.getFloat("price"));
             motLo.setProdWeight(rs.getFloat("prod_weight"));
             motLo.setRearBrakes(rs.getInt("rear_brakes"));
             motLo.setRearTyreSize(rs.getInt("rear_tyre_size"));
             motLo.setSeatHeight(rs.getInt("seat_height"));
             motLo.setSerial(rs.getInt("serial"));
             motLo.setTank(rs.getInt("tank"));
             motLo.setTopSpeed(rs.getInt("top_speed"));
             motLo.setWeight(rs.getInt("weight"));
             
         }
    }catch(Exception e)
    {
        e.printStackTrace(); 
    }
      return motLo;
    }
    
     
    
    
    
    public void updateMotorcycle(int Id,int serial, int id_part, Connection connection){
    try{
         
         PreparedStatement ps = connection.prepareStatement("UPDATE motorcycle_v SET serial=?,id_part=? WHERE id_model=? ");
         ps.setInt(1, serial);
         ps.setInt(2, id_part);
         ps.setInt(3, Id);
         
    }catch(Exception e)
    {
    }
      
    }

    /* public void updateSpec(int Id,String model_name,int top_speed,int weight,int seat_height,String frame,int tank,
            int engine_size_cc,int front_brakes,int rear_brakes,int front_tyre_size,int rear_tyre_size,int power_kw,Connection connection)
    {
         try{
        PreparedStatement ps = connection.prepareStatement("UPDATE motorcycle_v SET model_name=?, top_speed=?, weight=?,seat_height=?,frame=?,tank=?,"
                 + "engine_size_cc=?,front_brakes=?,rear_brakes=?,front_tyre_size=?,rear_tyre_size=?,power_kw=?"
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
         ps.setInt(13, Id);
         ps.executeUpdate();
    }catch(Exception e)
    {
    }
         
    
    }
    
   
    public void updateProduct(int Id,String colour,int price, int prod_weight,Connection connection){
     try{
        PreparedStatement ps=connection.prepareStatement("UPDATE product_v SET serial=?,colour=?, price=?,prod_weight=? WHERE id_model=?");
        ps.setString(1, colour);
         ps.setInt(2,  price);
         ps.setInt(3, prod_weight);
          ps.setInt(4, Id);
          ps.executeUpdate();
    }
    catch(Exception e)
    {
    }
     
    }
    */
    
    
    
    public void addMotorcycle(int Id,int serial,int id_part,Connection connection){
            try{
         
        PreparedStatement ps = connection.prepareStatement("INSERT INTO motorcycle_v (id_model,serial,id_part) VALUES (?,?,?)"  );
        ps.setInt(1, Id);
        ps.setInt(2, serial);
        ps.setInt(3, id_part);
        ps.executeUpdate();
    }catch(Exception e)
    {
    }
      
    }
   
    /*public void addProduct(int Id ,int serial, String colour,int price, int prod_weight,Connection connection)
    {
        try{
    PreparedStatement ps=connection.prepareStatement("INSERT INTO product_v (id_type,color,price,weight,id_model) " );
         ps.setInt(1, 1);
         ps.setString(2, colour);
         ps.setInt(3, price);
         ps.setInt(4, prod_weight);
         ps.setInt(5, Id);
         ps.executeUpdate();
    }catch(Exception e)
    {
               
    }
    
    }
    */
    
    public void addSpec(String model_name,int top_speed,int weight,int seat_height,String frame,int tank,
            int engine_size_cc,int front_brakes,int rear_brakes,int front_tyre_size,int rear_tyre_size,int power_kw,int serial, String colour,float price, int prod_weight,int Id,Connection connection){
   
         try{
         
        /* PreparedStatement ps = connection.prepareStatement("INSERT INTO motorcycle_spec_v ( model_name,top_speed,weight,seat_height,frame,tank," +
"            engine_size_cc,front_brakes,rear_brakes,front_tyre_size,rear_tyre_size,power_kw \n" +
"            ) VALUES (?,?,?,?,?,?,?,?,?,?)"  );*/
             PreparedStatement ps=connection.prepareStatement("START TRANSACTION");
            PreparedStatement ps2=connection.prepareStatement("INSERT INTO motorcycle_spec_v ( model_name,top_speed,weight,seat_height,frame,tank,"
                     + "engine_size_cc,front_brakes,rear_brakes,front_tyre_size,rear_tyre_size,power_kw"
                     + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            PreparedStatement ps3=connection.prepareStatement("SELECT @A:=id_model FROM motorcycle_spec_v WHERE model_name=?");
            PreparedStatement ps4=connection.prepareStatement("INSERT INTO product_v (serial,id_type,color,price,weight,id_model) VALUES(?,?,?,?,?,@A)");        
            PreparedStatement ps5=connection.prepareStatement ("COMMIT");
         ps2.setString(1, model_name);
         ps2.setInt(2, top_speed);
         ps2.setInt(3, weight);
         ps2.setInt(4, seat_height);
         ps2.setString(5, frame);
         ps2.setInt(6, tank);
         ps2.setInt(7, engine_size_cc);
         ps2.setInt(8, front_brakes);
         ps2.setInt(9,  rear_brakes);
         ps2.setInt(10, front_tyre_size);
         ps2.setInt(11, rear_tyre_size);
         ps2.setInt(12, power_kw);
         ps3.setString(1,model_name);
         ps4.setInt(1,serial);
         ps4.setInt(2,Id);
         ps4.setString(3,colour);
         ps4.setFloat(4, price);
         ps4.setInt(5, weight);
         ps.executeUpdate();
         ps2.executeUpdate();
         ps3.executeQuery();
         ps4.executeUpdate();
         ps5.executeUpdate();
    }  catch(SQLException e){
          e.printStackTrace();  
    }
    }
    
   public void updateSpec(int Id,String model_name,int top_speed,int weight,int seat_height,String frame,int tank,
            int engine_size_cc,int front_brakes,int rear_brakes,int front_tyre_size,int rear_tyre_size,int power_kw,int serial,String colour,float price,Connection connection)
    {
         try{
        //PreparedStatement ps=connection.prepareStatement("START TRANSACTION");
        PreparedStatement ps2 = connection.prepareStatement("UPDATE motorcycle_spec_v SET model_name=?, top_speed=?, weight=?,seat_height=?,frame=?,tank=?,"
                 + "engine_size_cc=?,front_brakes=?,rear_brakes=?,front_tyre_size=?,rear_tyre_size=?,power_kw=?"
                 + " WHERE id_model=?"  );
        PreparedStatement ps3=connection.prepareStatement("UPDATE product_v SET serial=?,color=?, price=?,weight=? WHERE id_model=?");
       // PreparedStatement ps4=connection.prepareStatement ("COMMIT");
            ps2.setString(1, model_name);
            ps2.setInt(2, top_speed);
            ps2.setInt(3, weight);
            ps2.setInt(4, seat_height);
            ps2.setString(5, frame);
            ps2.setInt(6, tank);
            ps2.setInt(7, engine_size_cc);
            ps2.setInt(8, front_brakes);
            ps2.setInt(9,  rear_brakes);
            ps2.setInt(10, front_tyre_size);
            ps2.setInt(11, rear_tyre_size);
            ps2.setInt(12, power_kw);
            ps2.setInt(13, Id);
            ps3.setInt(1,serial);
            ps3.setString(2, colour);
            ps3.setFloat(3,  price);
            ps3.setInt(4, weight);
            ps3.setInt(5, Id);
          //  ps.executeUpdate();
            ps2.executeUpdate();
            ps3.executeUpdate();
            //ps4.executeUpdate();    
         }
         catch(SQLException e)
         {
          e.printStackTrace(); 
         }
   }
   
    
    
    
    
    
    
    public void deleteMotorcycle(int Id,Connection connection){
        try{
        PreparedStatement ps = connection.prepareStatement("DELETE FROM motorcycle_v WHERE id_model=?  ");
        PreparedStatement ps2 = connection.prepareStatement("DELETE FROM motorcycle_spec_v WHERE id_model=?  ");
        PreparedStatement ps3 = connection.prepareStatement("DELETE * FROM product_v  WHERE id_model=?  ");
         ps.setInt(1, Id);
         ps2.setInt(1, Id);
         ps3.setInt(1, Id);
         ps.executeUpdate();
         ps2.executeUpdate();
         ps3.executeUpdate();
        }catch(Exception e)
        {
        }
    }
    
    
    public ArrayList searchByModel(String model,Connection connection){
    ArrayList list=new ArrayList();
    try{
    PreparedStatement ps=connection.prepareStatement("SELECT * FROM motorcycle_lo WHERE model_name=?");
    ps.setString(1,model);
    ResultSet rs=ps.executeQuery();
    while(rs.next())
    {
       MotorcycleLo motorcycle=new MotorcycleLo();
       motorcycle.setIdModel(rs.getInt("id_model"));
       motorcycle.setColor(rs.getString("color"));
       motorcycle.setModelName(rs.getString("model_name"));
       motorcycle.setPrice(rs.getFloat("price"));
       list.add(motorcycle);
    }
    }
    catch(SQLException e)
    {
    }
   return list;
    }
    
     public ArrayList searchByEngineSize(int engine,Connection connection){
    ArrayList list=new ArrayList();
    try{
    PreparedStatement ps=connection.prepareStatement("SELECT * FROM motorcycle_lo WHERE engine_size_cc=?");
    ps.setInt(1,engine);
    ResultSet rs=ps.executeQuery();
    while(rs.next())
    {
       MotorcycleLo motorcycle=new MotorcycleLo();
       motorcycle.setIdModel(rs.getInt("id_model"));
       motorcycle.setColor(rs.getString("color"));
       motorcycle.setModelName(rs.getString("model_name"));
       motorcycle.setPrice(rs.getFloat("price"));
       list.add(motorcycle);
    }
    }
    catch(SQLException e)
    {
    }
   return list;
   
    }
      public ArrayList searchByKeyword(String model,Connection connection){
    ArrayList list=new ArrayList();
    try{
    PreparedStatement ps=connection.prepareStatement("SELECT * FROM motorcycle_lo WHERE model_name=?");
    ps.setString(1,model);
    ResultSet rs=ps.executeQuery();
    while(rs.next())
    {
       MotorcycleLo motorcycle=new MotorcycleLo();
       motorcycle.setIdModel(rs.getInt("id_model"));
       motorcycle.setColor(rs.getString("color"));
       motorcycle.setModelName(rs.getString("model_name"));
       motorcycle.setPrice(rs.getFloat("price"));
       list.add(motorcycle);
    }
    }
    catch(SQLException e)
    {
    }
   return list;
    }
}
    
        
    
    

