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
          
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE username=? "  );
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
          e.printStackTrace();  
      }
      
        return true;
    }
    
}