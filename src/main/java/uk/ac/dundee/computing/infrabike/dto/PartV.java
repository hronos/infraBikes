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
@Table(name = "part_v")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PartV.findAll", query = "SELECT p FROM PartV p"),
    @NamedQuery(name = "PartV.findByIdPart", query = "SELECT p FROM PartV p WHERE p.idPart = :idPart"),
    @NamedQuery(name = "PartV.findByName", query = "SELECT p FROM PartV p WHERE p.name = :name"),
    @NamedQuery(name = "PartV.findByPartType", query = "SELECT p FROM PartV p WHERE p.partType = :partType"),
    @NamedQuery(name = "PartV.findByPrice", query = "SELECT p FROM PartV p WHERE p.price = :price"),
    @NamedQuery(name = "PartV.findByQuantity", query = "SELECT p FROM PartV p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "PartV.findByIdWarehouse", query = "SELECT p FROM PartV p WHERE p.idWarehouse = :idWarehouse"),
    @NamedQuery(name = "PartV.findByIdSupplier", query = "SELECT p FROM PartV p WHERE p.idSupplier = :idSupplier")})
public class PartV implements Serializable {
    private static final long serialVersionUID = 1L;
     @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_part")
    private int idPart;
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
    @Column(name = "id_warehouse")
    private int idWarehouse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_supplier")
    private int idSupplier;

    public PartV() {
    }

    public int getIdPart() {
        return idPart;
    }

    public void setIdPart(int idPart) {
        this.idPart = idPart;
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

    public int getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(int idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }
    
}
