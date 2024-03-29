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
import uk.ac.dundee.computing.infrabike.dto.CustomerLo;
import uk.ac.dundee.computing.infrabike.dto.DealerLo;
import uk.ac.dundee.computing.infrabike.dto.Roles;
import uk.ac.dundee.computing.infrabike.dto.UserLo;
import uk.ac.dundee.computing.infrabike.dto.UserV;


/**
 *
 * @author Anna
 */
public class UserDAO {
     
    public ArrayList GetUsers(Connection connection, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList userData = new ArrayList();
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM user_lo");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                UserLo  u = new UserLo();
                u.setIdUser(rs.getInt("id_user"));
                u.setIdRole(rs.getInt("id_role"));
                u.setRole(rs.getString("role"));
                u.setEmail(rs.getString("email"));
                u.setUsername(rs.getString("username"));
                
               
                userData.add(u);
            
            }
            
            return userData;
        }
        catch(Exception e){
            throw e;
        }
    }
    
    public UserV getUser(String username,Connection connection)
    { 
    UserV  u=new UserV();
    try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM user_v WHERE username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();       
            while(rs.next()){
               u = new UserV();
                u.setIdUser(rs.getInt("id_user"));
                u.setIdRole(rs.getInt("id_role"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setUsername(rs.getString("username"));

    }            
    }
      catch(SQLException e){
          e.printStackTrace();  
    }
    return u;
    }
           
     public UserLo viewUser(String username, String role_name, String email, Connection connection){
        UserLo user = new UserLo();
        try{     
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM user_lo WHERE username=?");
        ps.setString(1, username); 
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            user.setUsername(rs.getString("username") );
            user.setRole(rs.getString("role_name"));
            user.setEmail(rs.getString("email"));
            }
      }catch(SQLException e)
      { 
          e.printStackTrace();  
      }
        return null;
    
    }
     
    public ArrayList viewDealers(Connection connection, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList dealers = new ArrayList();
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM dealer_lo ORDER BY username DESC");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                DealerLo  d = new DealerLo();
                d.setIdDealer(rs.getInt("id_dealer"));
                d.setUsername(rs.getString("username"));
                d.setName(rs.getString("name"));
                d.setLocation(rs.getString("location"));
                d.setPhone(rs.getString("phone"));
                d.setPersonalEmail(rs.getString("personal_email"));
                d.setDealerEmail(rs.getString("dealer_email"));
                dealers.add(d);         
        }
            }
        catch (Exception e){
            
        }
        return dealers;
       }
    
    public boolean userExists(String username,String password,Connection connection){
      try{
         
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM user_v WHERE username=? "  );
        
        ps.setString(1, username);
      
        ResultSet rs = ps.executeQuery();
       
        if (!rs.next() ) {
            return false;
        }
        else
        {  
                String dbpass=rs.getString("password");
                if(dbpass.equals(password)){System.out.println("TRUE");return true;}
                else {System.out.println("FALSE");return false;}
            
        }
      }catch(SQLException e)
      {
          System.out.println("FAIL");
          e.printStackTrace();  
      }
     
        return true;
    }
    
    public boolean registerUser(String username,String password,String email,Connection connection){
      try{
          
        PreparedStatement ps = connection.prepareStatement("INSERT INTO user_v (username,password,email) VALUES(?,?,?) "  );
        ps.setString(1, username);
        ps.setString(2, password);
        ps.setString(3, email);
        //ps.setInt(4, 1);
         ps.executeUpdate();
      }catch(SQLException e)
      { 
          e.printStackTrace();  
      }
      
        return true;
    }
    
    public boolean changeRole(int role,String username,Connection connection)
    {
        try{     
        PreparedStatement ps = connection.prepareStatement("UPDATE user_v SET id_role=? where username=?");
        ps.setInt(1, role);
        ps.setString(2, username);
         ps.executeUpdate();
      }catch(SQLException e)
      { 
          e.printStackTrace();  
      }
        return true;
    }
    public Roles showRole(String username,Connection connection)
    {
        Roles role=new Roles();
        try{     
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM roles WHERE username=?");
        ps.setString(1, username);
         ResultSet rs=ps.executeQuery();
         while(rs.next())
         {
         role.setRoleName(username);
         role.setRoleName(rs.getString("role_name"));
         }
      }catch(SQLException e)
      { 
          e.printStackTrace();  
      }
        return role;
    }
    
    
   
    public boolean editDealer(int Id,String username,String name,String  location,String phone,String emailUser,String email,Connection connection)
    {   try{     
        PreparedStatement ps = connection.prepareStatement("UPDATE dealer_v SET name=?,location=?,phone=?,email=? WHERE id_dealer=?");
        
        ps.setString(1, name);
        ps.setString(2, location);
        ps.setString(3, phone);
        ps.setString(4, emailUser);
        ps.setInt(5, Id);
         ps.executeUpdate();
         editUser(username,email,connection);
      }catch(SQLException e)
      { 
          e.printStackTrace();  
      }
        return true;
    }
    
    public boolean editCustomer(int Id,String username,String first_name,String last_name,String location,String phone_number,String emailUser,Connection connection)
    {
        try{     
        PreparedStatement ps = connection.prepareStatement("UPDATE customer_v SET first_name=?,last_name=?,location=?,phone_number=? where id_customer=?");
        
        ps.setString(1, first_name);
        ps.setString(2, last_name);
        ps.setString(3, location);
        ps.setString(4, phone_number);
        ps.setInt(5, Id);
         ps.executeUpdate();
         editUser(username,emailUser,connection);
      }catch(SQLException e)
      { 
          e.printStackTrace();  
      }
        return true;
    }
    public boolean editUser2(int Id,String email,Connection connection)
    {   try{     
        PreparedStatement ps = connection.prepareStatement("UPDATE user_v SET email=? where id_user=?");
       
        
        ps.setString(1, email);
        ps.setInt(2, Id);
         ps.executeUpdate();
      }catch(SQLException e)
      { 
          e.printStackTrace();  
      }
        return true;
    }
     
    
     public boolean editUser(String username,String email,Connection connection)
     {
         try{
        PreparedStatement ps= connection.prepareStatement("UPDATE user_v SET email=? WHERE username=?");
        
        ps.setString(1, email);
        ps.setString(2,username);
        ps.executeUpdate();
         }catch(SQLException e)
         { 
          e.printStackTrace();
          return false;
         
         }
         return true;
         }
    //for dealer profile
   
    
     public DealerLo viewDealer(String username,Connection connection)
    {
        DealerLo dealer= new DealerLo();
        try{     
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM dealer_lo WHERE username=?");
        ps.setString(1, username); 
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
                 
                dealer.setDealerEmail(rs.getString("dealer_email"));
                dealer.setUsername(rs.getString("username"));
                dealer.setIdDealer(rs.getInt("id_dealer"));
                dealer.setLocation(rs.getString("location"));
                dealer.setName(rs.getString("name"));
                dealer.setPhone(rs.getString("phone"));
                dealer.setPersonalEmail(rs.getString("personal_email"));  
            }
      }catch(SQLException e)
      { 
          e.printStackTrace();  
      }
        return dealer;
    }
    
   
     
     public CustomerLo viewCustomer(String username,Connection connection)
    {
        CustomerLo customer= new CustomerLo();
        try{     
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM customer_lo WHERE username=?");
        ps.setString(1, username);
        ResultSet rs= ps.executeQuery();
        while(rs.next()){
                
                customer.setIdCustomer(rs.getInt("id_customer"));; 
               customer.setUsername(rs.getString("username"));
               customer.setRoleName(rs.getString("role_name"));
                customer.setLocation(rs.getString("location"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setPhoneNumber(rs.getString("phone_number"));  
                customer.setEmail(rs.getString("email"));
            }
      }catch(SQLException e)
      { 
          e.printStackTrace();  
      }
        return customer;
    }
     
     public boolean deleteUser(int Id, Connection connection)
     {
         try{     
        
         PreparedStatement ps=connection.prepareStatement("START TRANSACTION");
         PreparedStatement ps2=connection.prepareStatement("DELETE FROM customer_v WHERE id_user=?");
         PreparedStatement ps3=connection.prepareStatement("DELETE FROM dealer_v WHERE id_user=?");
         PreparedStatement ps4=connection.prepareStatement("DELETE FROM user_v WHERE id_user?");        
         PreparedStatement ps5=connection.prepareStatement ("COMMIT");
         ps2.setInt(1, Id);
         ps3.setInt(1, Id);
         ps4.setInt(1, Id);
              ps.executeUpdate();
              ps2.executeUpdate();
              ps3.executeUpdate();
              ps4.executeUpdate();
              ps5.executeUpdate();
              
      }catch(SQLException e)
      { 
          e.printStackTrace(); 
          return false;
      }
         return true;
     }
    
     
     public boolean deleteCustomer(int Id,Connection connection)
    {
        try{     
        PreparedStatement ps = connection.prepareStatement("DELETE FROM customer_v WHERE id_customer=?");
   
         ps.setInt(1, Id);
              ps.executeUpdate();
      }catch(SQLException e)
      { 
          
          e.printStackTrace();  
      }
        return true;
    }
     
     public boolean deleteDealer(int Id,Connection connection)
    {
        try{     
        PreparedStatement ps = connection.prepareStatement("DELETE FROM dealer_v WHERE id_dealer=?");
        
         ps.setInt(1, Id);
          ps.executeUpdate();
      }catch(SQLException e)
      { 
          e.printStackTrace();  
      }
        return true;
    }
     
      public boolean addDealer(int userId,String name,String location,String phone,String email, Connection connection)
    {
        try{     
        PreparedStatement ps = connection.prepareStatement("INSERT INTO dealer_v (name,location,phone,email,id_user) VALUES (?,?,?,?,?)");
          ps.setString(1, name);
          ps.setString(2, location);
          ps.setString(3, phone);
          ps.setString(4, email);
          ps.setInt(5, userId);
          ps.executeUpdate();
      }catch(SQLException e)
      { 
          e.printStackTrace();  
      }
        return true;
    }
       public boolean addCustomer(int userId,String first_name,String last_name,String location,String phone_number,Connection connection)
    {
        try{     
        PreparedStatement ps = connection.prepareStatement("INSERT INTO customer_v (first_name,last_name,location,phone_number,id_user) VALUES (?,?,?,?,?)");
          ps.setString(1, first_name);
          ps.setString(2, last_name);
          ps.setString(3, location);
          ps.setString(4, phone_number);
          ps.setInt(5, userId);
          ps.executeUpdate();
      }catch(SQLException e)
      { 
          e.printStackTrace();  
      }
        return true;
    }
    
 public ArrayList viewUsers(Connection connection)
    {
        ArrayList list=new ArrayList();
        try{     
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM user_v");
        ResultSet rs= ps.executeQuery();
        while(rs.next())
        {
        UserV user=new UserV();
        user.setEmail(rs.getString("email"));
        user.setIdRole(rs.getInt("id_role"));
        user.setIdUser(rs.getInt("id_user"));
        user.setPassword(rs.getString("password"));
        user.setUsername(rs.getString("username"));
        list.add(user);
        }
      }catch(SQLException e)
      { 
          e.printStackTrace();  
      }
        return list;
    }
       
       
       
 public boolean viewCustomerLo(int Id,Connection connection)
    {
        try{     
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM customer_v WHERE id_user=?");
        ResultSet rs= ps.executeQuery();
      }catch(SQLException e)
      { 
          e.printStackTrace();  
      }
        return true;
    }

     public boolean viewDealerLo(int Id,Connection connection)
    {
        try{     
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM dealer_lo WHERE id_dealer=?");
         ResultSet rs=ps.executeQuery();
      }catch(SQLException e)
      { 
          e.printStackTrace();  
      }
        return true;
    }


}