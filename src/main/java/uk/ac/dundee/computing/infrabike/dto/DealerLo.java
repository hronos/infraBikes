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
@Table(name = "dealer_lo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DealerLo.findAll", query = "SELECT d FROM DealerLo d"),
    @NamedQuery(name = "DealerLo.findByUsername", query = "SELECT d FROM DealerLo d WHERE d.username = :username"),
    @NamedQuery(name = "DealerLo.findByName", query = "SELECT d FROM DealerLo d WHERE d.name = :name"),
    @NamedQuery(name = "DealerLo.findByLocation", query = "SELECT d FROM DealerLo d WHERE d.location = :location"),
    @NamedQuery(name = "DealerLo.findByPhone", query = "SELECT d FROM DealerLo d WHERE d.phone = :phone"),
    @NamedQuery(name = "DealerLo.findByPersonalEmail", query = "SELECT d FROM DealerLo d WHERE d.personalEmail = :personalEmail"),
    @NamedQuery(name = "DealerLo.findByDealerEmail", query = "SELECT d FROM DealerLo d WHERE d.dealerEmail = :dealerEmail")})
public class DealerLo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "location")
    private String location;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "personal_email")
    private String personalEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dealer_email")
    private String dealerEmail;

    public DealerLo() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getDealerEmail() {
        return dealerEmail;
    }

    public void setDealerEmail(String dealerEmail) {
        this.dealerEmail = dealerEmail;
    }
    
}
