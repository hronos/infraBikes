/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.models;

import java.sql.Connection;
import uk.ac.dundee.computing.infrabike.dao.UserDAO;
import uk.ac.dundee.computing.infrabike.dto.CustomerV;
import uk.ac.dundee.computing.infrabike.dto.DealerV;
import uk.ac.dundee.computing.infrabike.dto.Profile;
import uk.ac.dundee.computing.infrabike.dto.Roles;
import uk.ac.dundee.computing.infrabike.dto.UserV;

/**
 *
 * @author Anna
 */
public class UserModel {
    public boolean valid(Connection connection, String username,String password) throws Exception {
        boolean valid = true;

        try {
            UserDAO c = new UserDAO();
            valid=c.userExists(username,password,connection);
        } 
        catch (Exception e) {
            throw e;
        }
        return valid;
    }
    public boolean register(Connection connection, String username,String password,String email) throws Exception {
        boolean success = true;
        try {
            UserDAO c = new UserDAO();
            success=c.registerUser(username,password,email,connection);
        } 
        catch (Exception e) {
            throw e;
        }
        return success;
    }
    
    public Roles showRole(String username,Connection connection){
            boolean success = true;
            Roles role=new Roles();
        try {
            UserDAO c = new UserDAO();
            role=c.showRole(username,connection);
        } 
        catch (Exception e) {
            throw e;
        }
        return role;
    }
   
    
      public Profile findUser(int Id,Connection connection)
    {
        Profile profile=new Profile();
        UserV user;
        CustomerV customer=null;
        DealerV dealer=null;
         try {
            UserDAO c = new UserDAO();
            user=c.getUser(Id,connection);
            if(user.getIdRole()==6)
            {
                customer=c.viewCustomer(Id, connection);
            }
            else if(user.getIdRole()==7)
            {
                dealer=c.viewDealer(Id, connection);
            }
             
         profile.setCustomer(customer);
         profile.setDealer(dealer);
         profile.setUser(user);
         }catch (Exception e) {
            throw e;
        }
        return profile;
    }
      
      public boolean editCustomer(int Id,String first_name,String last_name,String location,String phone_number,String emailUser,String password,Connection connection)
      {
           boolean success = true;
        try {
            UserDAO c = new UserDAO();
            success=c.editCustomer(Id,first_name,last_name,location,phone_number,emailUser,password,connection);
        } 
        catch (Exception e) {
            throw e;
        }
        return success;
      }
      
      public boolean editDealer(int Id,String name,String location,String phone,String emailUser,String password,String email,Connection connection)
      {
           boolean success = true;
        try {
            UserDAO c = new UserDAO();
            success=c.editDealer(Id,name,location,phone,emailUser,password,email,connection);
        } 
        catch (Exception e) {
            throw e;
        }
        return success;
      }
      
      public boolean editUser(int Id,String emailUser,String password,Connection connection)
      {
           boolean success = true;
        try {
            UserDAO c = new UserDAO();
            success=c.editUser(Id,emailUser,password,connection);
        } 
        catch (Exception e) {
            throw e;
        }
        return success;
      }
      
      }
      
      

