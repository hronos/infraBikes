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
 * @author Fury
 */
@Entity
@Table(name = "product_lo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductLo.findAll", query = "SELECT p FROM ProductLo p"),
    @NamedQuery(name = "ProductLo.findBySerial", query = "SELECT p FROM ProductLo p WHERE p.serial = :serial"),
    @NamedQuery(name = "ProductLo.findByColor", query = "SELECT p FROM ProductLo p WHERE p.color = :color"),
    @NamedQuery(name = "ProductLo.findByPrice", query = "SELECT p FROM ProductLo p WHERE p.price = :price"),
    @NamedQuery(name = "ProductLo.findByWeight", query = "SELECT p FROM ProductLo p WHERE p.weight = :weight"),
    @NamedQuery(name = "ProductLo.findByModelName", query = "SELECT p FROM ProductLo p WHERE p.modelName = :modelName")})
public class ProductLo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "serial")
    private int serial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private float price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight")
    private float weight;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "model_name")
    private String modelName;

    public ProductLo() {
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    
}
