/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.dto;

/**
 *
 * @author dlennart
 */
public class CustomerDTO {
    private String id_customer;
    private String first_name;
    private String last_name;
    private String location;
    private String phone_number;

    public CustomerDTO() {
    }

    
    public CustomerDTO(String id_customer, String first_name, String last_name, String location, String phone_number) {
        this.id_customer = id_customer;
        this.first_name = first_name;
        this.last_name = last_name;
        this.location = location;
        this.phone_number = phone_number;
    }
    
    
    
    public String getId_customer() {
        return id_customer;
    }

    public void setId_customer(String id_customer) {
        this.id_customer = id_customer;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    
}
