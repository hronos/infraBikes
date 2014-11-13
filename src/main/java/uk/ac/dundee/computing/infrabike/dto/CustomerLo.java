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
import javax.persistence.Id;
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
@Table(name = "customer_lo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerLo.findAll", query = "SELECT c FROM CustomerLo c"),
    @NamedQuery(name = "CustomerLo.findByUsername", query = "SELECT c FROM CustomerLo c WHERE c.username = :username"),
    @NamedQuery(name = "CustomerLo.findByFirstName", query = "SELECT c FROM CustomerLo c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "CustomerLo.findByLastName", query = "SELECT c FROM CustomerLo c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "CustomerLo.findByLocation", query = "SELECT c FROM CustomerLo c WHERE c.location = :location"),
    @NamedQuery(name = "CustomerLo.findByPhoneNumber", query = "SELECT c FROM CustomerLo c WHERE c.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "CustomerLo.findByEmail", query = "SELECT c FROM CustomerLo c WHERE c.email = :email"),
    @NamedQuery(name = "CustomerLo.findByRoleName", query = "SELECT c FROM CustomerLo c WHERE c.roleName = :roleName")})
public class CustomerLo implements Serializable {
    
    //no id here in this view-need to do;(
    
    
    private static final long serialVersionUID = 1L;
     @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
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
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "role_name")
    private String roleName;

    public CustomerLo() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
}
