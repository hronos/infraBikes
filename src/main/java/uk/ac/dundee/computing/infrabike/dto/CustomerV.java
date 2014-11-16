/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anna
 */
@Entity
@Table(name = "customer_v")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerV.findAll", query = "SELECT c FROM CustomerV c"),
    @NamedQuery(name = "CustomerV.findByIdCustomer", query = "SELECT c FROM CustomerV c WHERE c.idCustomer = :idCustomer"),
    @NamedQuery(name = "CustomerV.findByFirstName", query = "SELECT c FROM CustomerV c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "CustomerV.findByLastName", query = "SELECT c FROM CustomerV c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "CustomerV.findByLocation", query = "SELECT c FROM CustomerV c WHERE c.location = :location"),
    @NamedQuery(name = "CustomerV.findByPhoneNumber", query = "SELECT c FROM CustomerV c WHERE c.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "CustomerV.findByIdUser", query = "SELECT c FROM CustomerV c WHERE c.idUser = :idUser")})
public class CustomerV implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_customer")
    private int idCustomer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_user")
    private int idUser;

    public CustomerV() {
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
}
