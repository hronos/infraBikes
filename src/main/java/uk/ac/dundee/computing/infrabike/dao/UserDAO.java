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
       System.out.println("TUT7");
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
    
}
