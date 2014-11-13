/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.dundee.computing.infrabike.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anna
 */
@Entity
@Table(name = "order_lo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderLo.findAll", query = "SELECT o FROM OrderLo o"),
    @NamedQuery(name = "OrderLo.findByIdOrder", query = "SELECT o FROM OrderLo o WHERE o.idOrder = :idOrder"),
    @NamedQuery(name = "OrderLo.findByIdDealer", query = "SELECT o FROM OrderLo o WHERE o.idDealer = :idDealer"),
    @NamedQuery(name = "OrderLo.findByDate", query = "SELECT o FROM OrderLo o WHERE o.date = :date"),
    @NamedQuery(name = "OrderLo.findByDeliveryPrice", query = "SELECT o FROM OrderLo o WHERE o.deliveryPrice = :deliveryPrice"),
    @NamedQuery(name = "OrderLo.findByRegion", query = "SELECT o FROM OrderLo o WHERE o.region = :region"),
    @NamedQuery(name = "OrderLo.findByIdCustomer", query = "SELECT o FROM OrderLo o WHERE o.idCustomer = :idCustomer"),
    @NamedQuery(name = "OrderLo.findBySerial", query = "SELECT o FROM OrderLo o WHERE o.serial = :serial"),
    @NamedQuery(name = "OrderLo.findByColor", query = "SELECT o FROM OrderLo o WHERE o.color = :color"),
    @NamedQuery(name = "OrderLo.findByPrice", query = "SELECT o FROM OrderLo o WHERE o.price = :price"),
    @NamedQuery(name = "OrderLo.findByWeigh", query = "SELECT o FROM OrderLo o WHERE o.weigh = :weigh"),
    @NamedQuery(name = "OrderLo.findByIdModel", query = "SELECT o FROM OrderLo o WHERE o.idModel = :idModel")})
public class OrderLo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_order")
    private int idOrder;
    @Column(name = "id_dealer")
    private Integer idDealer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "delivery_price")
    private float deliveryPrice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "region")
    private String region;
    @Column(name = "id_customer")
    private Integer idCustomer;
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
    @Column(name = "weigh")
    private float weigh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_model")
    private int idModel;

    public OrderLo() {
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getIdDealer() {
        return idDealer;
    }

    public void setIdDealer(Integer idDealer) {
        this.idDealer = idDealer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(float deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
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

    public float getWeigh() {
        return weigh;
    }

    public void setWeigh(float weigh) {
        this.weigh = weigh;
    }

    public int getIdModel() {
        return idModel;
    }

    public void setIdModel(int idModel) {
        this.idModel = idModel;
    }

}
