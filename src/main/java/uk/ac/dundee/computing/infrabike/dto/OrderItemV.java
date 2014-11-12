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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anna
 */
@Entity
@Table(name = "order_item_v", catalog = "14ac3d30", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderItemV.findAll", query = "SELECT o FROM OrderItemV o"),
    @NamedQuery(name = "OrderItemV.findByIdOrderItem", query = "SELECT o FROM OrderItemV o WHERE o.idOrderItem = :idOrderItem"),
    @NamedQuery(name = "OrderItemV.findByIdOrder", query = "SELECT o FROM OrderItemV o WHERE o.idOrder = :idOrder"),
    @NamedQuery(name = "OrderItemV.findBySerial", query = "SELECT o FROM OrderItemV o WHERE o.serial = :serial")})
public class OrderItemV implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_order_item")
    private int idOrderItem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_order")
    private int idOrder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "serial")
    private int serial;

    public OrderItemV() {
    }

    public int getIdOrderItem() {
        return idOrderItem;
    }

    public void setIdOrderItem(int idOrderItem) {
        this.idOrderItem = idOrderItem;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }
    
}
