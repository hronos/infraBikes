/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.dto;

/**
 *
 * @author Anna
 */
public class Profile {
  private UserV user;
  private DealerLo dealer=null;
  private CustomerLo customer=null;
  
    public UserV getUser() {
        return user;
    }

    public void setUser(UserV user) {
        this.user = user;
    }

    public DealerLo getDealer() {
        return dealer;
    }

    public void setDealer(DealerLo dealer) {
        this.dealer = dealer;
    }

    public CustomerLo getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerLo customer) {
        this.customer = customer;
    }

}
