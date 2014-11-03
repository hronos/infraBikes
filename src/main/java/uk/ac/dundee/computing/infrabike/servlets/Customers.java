/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.servlets;

import com.google.gson.Gson;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import uk.ac.dundee.computing.infrabike.dao.DatabaseDAO;
import uk.ac.dundee.computing.infrabike.models.CustomerModel;

/**
 *
 * @author dlennart
 */
@WebServlet(urlPatterns = {
    "/webapi/Customer/*",
    "/webapi/Customers",
    })
@MultipartConfig
public class Customers extends HttpServlet {  
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("/customers called");
        response.setContentType("text/html;charset=UTF-8");
        
        try {
        PrintWriter out = response.getWriter();
        DatabaseDAO db = new DatabaseDAO();
        CustomerModel c = new CustomerModel();
        ArrayList customerData = null;
        
        Connection conn = db.Get_Connection();
        customerData = c.GetCustomers(conn, request, response);
        
        Gson gson = new Gson();
        String customers = gson.toJson(customerData);
        out.println("{\"Customers\":"+customers+"}");
        
        
        conn.close();
        out.close();
        request.setAttribute("customers", customers);
        RequestDispatcher rd = request.getRequestDispatcher("show_customers.jsp");
        rd.forward(request, response);
        
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
    }

}
