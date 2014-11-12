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
@Table(name = "warehouse_v", catalog = "14ac3d30", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WarehouseV.findAll", query = "SELECT w FROM WarehouseV w"),
    @NamedQuery(name = "WarehouseV.findByIdWarehouse", query = "SELECT w FROM WarehouseV w WHERE w.idWarehouse = :idWarehouse"),
    @NamedQuery(name = "WarehouseV.findByLocation", query = "SELECT w FROM WarehouseV w WHERE w.location = :location"),
    @NamedQuery(name = "WarehouseV.findByStorageSize", query = "SELECT w FROM WarehouseV w WHERE w.storageSize = :storageSize"),
    @NamedQuery(name = "WarehouseV.findByPhone", query = "SELECT w FROM WarehouseV w WHERE w.phone = :phone")})
public class WarehouseV implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_warehouse")
    private int idWarehouse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @NotNull
    @Column(name = "storage_size")
    private int storageSize;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "phone")
    private String phone;

    public WarehouseV() {
    }

    public int getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(int idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}
