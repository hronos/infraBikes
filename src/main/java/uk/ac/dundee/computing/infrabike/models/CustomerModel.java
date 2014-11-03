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

import uk.ac.dundee.computing.infrabike.dao.CustomerDAO;
import uk.ac.dundee.computing.infrabike.dto.CustomerDTO;
/**
 *
 * @author dlennart
 */
public class CustomerModel {
    public ArrayList GetCustomers(Connection connection, HttpServletRequest request,
HttpServletResponse response) throws Exception {
        ArrayList customers = null;
        try {
            CustomerDAO c = new CustomerDAO();
            customers=c.GetCustomers(connection, request, response);
        } catch (Exception e) {
            throw e;
        }
        return customers;
    }
}
