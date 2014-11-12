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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "dealer", catalog = "14ac3d30", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dealer.findAll", query = "SELECT d FROM Dealer d"),
    @NamedQuery(name = "Dealer.findByIdDealer", query = "SELECT d FROM Dealer d WHERE d.idDealer = :idDealer"),
    @NamedQuery(name = "Dealer.findByName", query = "SELECT d FROM Dealer d WHERE d.name = :name"),
    @NamedQuery(name = "Dealer.findByLocation", query = "SELECT d FROM Dealer d WHERE d.location = :location"),
    @NamedQuery(name = "Dealer.findByPhone", query = "SELECT d FROM Dealer d WHERE d.phone = :phone"),
    @NamedQuery(name = "Dealer.findByEmail", query = "SELECT d FROM Dealer d WHERE d.email = :email")})
public class Dealer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dealer")
    private Integer idDealer;
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
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;

    public Dealer() {
    }

    public Dealer(Integer idDealer) {
        this.idDealer = idDealer;
    }

    public Dealer(Integer idDealer, String name, String location, String phone, String email) {
        this.idDealer = idDealer;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
    }

    public Integer getIdDealer() {
        return idDealer;
    }

    public void setIdDealer(Integer idDealer) {
        this.idDealer = idDealer;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDealer != null ? idDealer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dealer)) {
            return false;
        }
        Dealer other = (Dealer) object;
        if ((this.idDealer == null && other.idDealer != null) || (this.idDealer != null && !this.idDealer.equals(other.idDealer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uk.ac.dundee.computing.infrabike.dao.Dealer[ idDealer=" + idDealer + " ]";
    }
    
}
