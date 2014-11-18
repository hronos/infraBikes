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
@Table(name = "part_lo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PartLo.findAll", query = "SELECT p FROM PartLo p"),
    @NamedQuery(name = "PartLo.findByName", query = "SELECT p FROM PartLo p WHERE p.name = :name"),
    @NamedQuery(name = "PartLo.findByPartType", query = "SELECT p FROM PartLo p WHERE p.partType = :partType"),
    @NamedQuery(name = "PartLo.findByPrice", query = "SELECT p FROM PartLo p WHERE p.price = :price"),
    @NamedQuery(name = "PartLo.findByQuantity", query = "SELECT p FROM PartLo p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "PartLo.findByWarehouseLocation", query = "SELECT p FROM PartLo p WHERE p.warehouseLocation = :warehouseLocation"),
    @NamedQuery(name = "PartLo.findByWarehousePhone", query = "SELECT p FROM PartLo p WHERE p.warehousePhone = :warehousePhone"),
    @NamedQuery(name = "PartLo.findBySupplierName", query = "SELECT p FROM PartLo p WHERE p.supplierName = :supplierName"),
    @NamedQuery(name = "PartLo.findBySupplierPhone", query = "SELECT p FROM PartLo p WHERE p.supplierPhone = :supplierPhone"),
    @NamedQuery(name = "PartLo.findBySupplierEmail", query = "SELECT p FROM PartLo p WHERE p.supplierEmail = :supplierEmail")})
public class PartLo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "part_type")
    private String partType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private float price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "warehouse_location")
    private String warehouseLocation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "warehouse_phone")
    private String warehousePhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "supplier_name")
    private String supplierName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "supplier_phone")
    private int supplierPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "supplier_email")
    private String supplierEmail;

    public PartLo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getWarehouseLocation() {
        return warehouseLocation;
    }

    public void setWarehouseLocation(String warehouseLocation) {
        this.warehouseLocation = warehouseLocation;
    }

    public String getWarehousePhone() {
        return warehousePhone;
    }

    public void setWarehousePhone(String warehousePhone) {
        this.warehousePhone = warehousePhone;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public int getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(int supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }
    
}
