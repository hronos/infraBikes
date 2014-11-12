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
@Table(name = "order_v", catalog = "14ac3d30", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderV.findAll", query = "SELECT o FROM OrderV o"),
    @NamedQuery(name = "OrderV.findByIdOrder", query = "SELECT o FROM OrderV o WHERE o.idOrder = :idOrder"),
    @NamedQuery(name = "OrderV.findByIdDealer", query = "SELECT o FROM OrderV o WHERE o.idDealer = :idDealer"),
    @NamedQuery(name = "OrderV.findByDate", query = "SELECT o FROM OrderV o WHERE o.date = :date"),
    @NamedQuery(name = "OrderV.findByDeliveryPrice", query = "SELECT o FROM OrderV o WHERE o.deliveryPrice = :deliveryPrice"),
    @NamedQuery(name = "OrderV.findByRegion", query = "SELECT o FROM OrderV o WHERE o.region = :region"),
    @NamedQuery(name = "OrderV.findByIdCustomer", query = "SELECT o FROM OrderV o WHERE o.idCustomer = :idCustomer")})
public class OrderV implements Serializable {
    private static final long serialVersionUID = 1L;
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

    public OrderV() {
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
    
}
