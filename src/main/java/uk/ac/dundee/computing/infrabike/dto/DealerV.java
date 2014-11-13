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
@Table(name = "dealer_v")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DealerV.findAll", query = "SELECT d FROM DealerV d"),
    @NamedQuery(name = "DealerV.findByIdDealer", query = "SELECT d FROM DealerV d WHERE d.idDealer = :idDealer"),
    @NamedQuery(name = "DealerV.findByName", query = "SELECT d FROM DealerV d WHERE d.name = :name"),
    @NamedQuery(name = "DealerV.findByLocation", query = "SELECT d FROM DealerV d WHERE d.location = :location"),
    @NamedQuery(name = "DealerV.findByPhone", query = "SELECT d FROM DealerV d WHERE d.phone = :phone"),
    @NamedQuery(name = "DealerV.findByEmail", query = "SELECT d FROM DealerV d WHERE d.email = :email"),
    @NamedQuery(name = "DealerV.findByIdUser", query = "SELECT d FROM DealerV d WHERE d.idUser = :idUser")})
public class DealerV implements Serializable {
    private static final long serialVersionUID = 1L;
     @Id  
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dealer")
    private int idDealer;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_user")
    private int idUser;

    public DealerV() {
    }

    public int getIdDealer() {
        return idDealer;
    }

    public void setIdDealer(int idDealer) {
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
}
