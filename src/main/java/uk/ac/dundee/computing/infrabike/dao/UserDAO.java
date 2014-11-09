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
public class UserDAO {
     
    
    
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
            while(rs.next()){
                String dbpass=rs.getString("password");
                if(dbpass.equals(password))return true;
                else return false;
            }
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
         System.out.println("YEY");
         ps.executeUpdate();
      
         System.out.println("SUCCESS");
      }catch(SQLException e)
      { System.out.println("FAIL");
          e.printStackTrace();  
      }
      
        return true;
    }
    
}