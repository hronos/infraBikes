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
@Table(name = "motorcycle_v", catalog = "14ac3d30", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MotorcycleV.findAll", query = "SELECT m FROM MotorcycleV m"),
    @NamedQuery(name = "MotorcycleV.findByIdModel", query = "SELECT m FROM MotorcycleV m WHERE m.idModel = :idModel"),
    @NamedQuery(name = "MotorcycleV.findBySerial", query = "SELECT m FROM MotorcycleV m WHERE m.serial = :serial"),
    @NamedQuery(name = "MotorcycleV.findByIdPart", query = "SELECT m FROM MotorcycleV m WHERE m.idPart = :idPart")})
public class MotorcycleV implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_model")
    private int idModel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "serial")
    private int serial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_part")
    private int idPart;

    public MotorcycleV() {
    }

    public int getIdModel() {
        return idModel;
    }

    public void setIdModel(int idModel) {
        this.idModel = idModel;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public int getIdPart() {
        return idPart;
    }

    public void setIdPart(int idPart) {
        this.idPart = idPart;
    }
    
}
