/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.models;

import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uk.ac.dundee.computing.infrabike.dao.UserDAO;

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
}
