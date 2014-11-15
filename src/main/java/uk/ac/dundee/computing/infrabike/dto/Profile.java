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
  private DealerV dealer=null;
  private CustomerV customer=null;
  
    public UserV getUser() {
        return user;
    }

    public void setUser(UserV user) {
        this.user = user;
    }

    public DealerV getDealer() {
        return dealer;
    }

    public void setDealer(DealerV dealer) {
        this.dealer = dealer;
    }

    public CustomerV getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerV customer) {
        this.customer = customer;
    }

}
