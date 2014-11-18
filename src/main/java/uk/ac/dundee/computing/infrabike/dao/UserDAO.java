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
import uk.ac.dundee.computing.infrabike.dto.CustomerV;
import uk.ac.dundee.computing.infrabike.dto.DealerV;
import uk.ac.dundee.computing.infrabike.dto.Roles;
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
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM user_v ORDER BY id_user DESC");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                UserV  u = new UserV();
                u.setIdUser(rs.getInt("id_user"));
                u.setIdRole(rs.getInt("id_role"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setUsername(rs.getString("username"));
               
                userData.add(u);
            
            }
            
            return userData;
        }
        catch(Exception e){
            throw e;
        }
    }
    
    public UserV getUser(int Id,Connection connection)
    { 
    UserV  u=new UserV();
    try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM user_v WHERE id_user=?");
            ps.setInt(1, Id);
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
          
        PreparedStatement ps = connection.prepareStatement("INSERT INTO user_v (username,password,email,id_role) VALUES(?,?,?,?) "  );
        ps.setString(1, username);
        ps.setString(2, password);
        ps.setString(3, email);
        ps.setInt(4, 1);
         ps.executeUpdate();
      }catch(SQLException e)
      { 
          e.printStackTrace();  
      }
      
        return true;
    }
    
    public boolean changRole(int role,int Id,Connection connection)
    {
        try{     
        PreparedStatement ps = connection.prepareStatement("UPDATE user_v SET id_role=? where id_user=?");
        ps.setInt(1, role);
        ps.setInt(2, Id);
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
         role.setRoleName("role_name");
         }
      }catch(SQLException e)
      { 
          e.printStackTrace();  
      }
        return role;
    }
    
    //not checked
    //can dealer change the email?
   
    public boolean editDealer(int Id,String name,String  location,String phone,String emailUser,String password,String email,Connection connection)
    {   try{     
        PreparedStatement ps = connection.prepareStatement("UPDATE dealer_v SET name=?,location=?,phone=?,email=? WHERE id_dealer=?");
        
        ps.setString(1, name);
        ps.setString(2, location);
        ps.setString(3, phone);
        ps.setString(4, emailUser);
        ps.setInt(5, Id);
         ps.executeUpdate();
         editUser(Id,password,email,connection);
      }catch(SQLException e)
      { 
          e.printStackTrace();  
      }
        return true;
    }
    
    public boolean editCustomer(int Id,String first_name,String last_name,String location,String phone_number,String emailUser,String password,Connection connection)
    {
        try{     
        PreparedStatement ps = connection.prepareStatement("UPDATE customer_v SET first_name=?,last_name=?,location=?,phone_number=? where id_customer=?");
        
        ps.setString(1, first_name);
        ps.setString(2, last_name);
        ps.setString(3, location);
        ps.setString(4, phone_number);
        ps.setInt(5, Id);
         ps.executeUpdate();
         editUser(Id,password,emailUser,connection);
      }catch(SQLException e)
      { 
          e.printStackTrace();  
      }
        return true;
    }
    /* public boolean editUser(int Id,String username,String password,String email,Connection connection)
    {   try{     
        PreparedStatement ps = connection.prepareStatement("UPDATE user_v SET username=?,password=?,email=? where id_user=?");
        ps.setString(1, username);
        ps.setString(2, password);
        ps.setString(3, email);
        ps.setInt(4, Id);
         ps.executeUpdate();
      }catch(SQLException e)
      { 
          e.printStackTrace();  
      }
        return true;
    }
     */
    
     public boolean editUser(int Id,String password,String email,Connection connection)
     {
         try{
        PreparedStatement ps= connection.prepareStatement("UPDATE user_v SET password=?,email=? WHERE id_user=?");
        ps.setString(1,password);
        ps.setString(2, email);
        ps.setInt(3, Id);
        ps.executeUpdate();
         }catch(SQLException e)
         { 
          e.printStackTrace();
          return false;
         
         }
         return true;
         }
    //for dealer profile
   
    
     public DealerV viewDealer(int Id,Connection connection)
    {
        DealerV dealer;
        try{     
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM dealer_v WHERE id_user=?");
        ps.setInt(1, Id); 
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
                 dealer= new DealerV();
                dealer.setIdDealer(rs.getInt("id_dealer"));; 
                dealer.setIdUser(rs.getInt("id_user"));
                dealer.setLocation(rs.getString("location"));
                dealer.setName(rs.getString("name"));
                dealer.setPhone(rs.getString("phone"));
                dealer.setEmail(rs.getString("email"));  
            }
      }catch(SQLException e)
      { 
          e.printStackTrace();  
      }
        return null;
    }
    
   
     
     public CustomerV viewCustomer(int Id,Connection connection)
    {
        CustomerV customer=new CustomerV();
        try{     
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM customer_v WHERE id_user=?");
        ps.setInt(1, Id);
        ResultSet rs= ps.executeQuery();
        while(rs.next()){
                 customer= new CustomerV();
                customer.setIdCustomer(rs.getInt("id_dealer"));; 
                customer.setIdUser(rs.getInt("id_user"));
                customer.setLocation(rs.getString("location"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setPhoneNumber(rs.getString("phone_number"));  
            }
      }catch(SQLException e)
      { 
          e.printStackTrace();  
      }
        return customer;
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
    
}
/*  public boolean viewCustomerLo(int Id,Connection connection)
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


*/