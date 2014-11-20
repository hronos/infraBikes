/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uk.ac.dundee.computing.infrabike.dto.CustomerLo;
import uk.ac.dundee.computing.infrabike.dto.CustomerV;

//import uk.ac.dundee.computing.infrabike.dto.Customer;
/**
 *
 * @author dlennart
 */
public class CustomerDAO {
    public ArrayList GetCustomers(Connection connection, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList customerData = new ArrayList();
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM customer ORDER BY id_customer DESC");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                CustomerV c = new CustomerV();
                c.setIdCustomer(rs.getInt("id_customer"));
                c.setFirstName(rs.getString("first_name"));
                c.setLastName(rs.getString("last_name"));
                c.setLocation(rs.getString("location"));
                c.setPhoneNumber(rs.getString("phone_number"));
                customerData.add(c);
            
            }
            
            return customerData;
        }
        catch(Exception e){
            throw e;
        }
    }
    
    public ArrayList showCustomers(Connection connection, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList cusData = new ArrayList();
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM customer_lo ORDER BY id_customer DESC");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                CustomerLo c = new CustomerLo();
                c.setIdCustomer(rs.getInt("id_customer"));
                c.setUsername(rs.getString("username"));
                c.setFirstName(rs.getString("first_name"));
                c.setLastName(rs.getString("last_name"));
                c.setLocation(rs.getString("location"));
                c.setPhoneNumber(rs.getString("phone_number"));
                c.setEmail(rs.getString("email"));
                c.setRoleName(rs.getString("role_name"));
                cusData.add(c);
            
            }
            
            return cusData;
        }
        catch(Exception e){
            throw e;
        }
    }
}
