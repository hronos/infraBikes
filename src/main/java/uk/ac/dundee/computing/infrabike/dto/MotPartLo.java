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
@Table(name = "mot_part_lo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MotPartLo.findAll", query = "SELECT m FROM MotPartLo m"),
    @NamedQuery(name = "MotPartLo.findByModelName", query = "SELECT m FROM MotPartLo m WHERE m.modelName = :modelName"),
    @NamedQuery(name = "MotPartLo.findByPartName", query = "SELECT m FROM MotPartLo m WHERE m.partName = :partName"),
    @NamedQuery(name = "MotPartLo.findByPartType", query = "SELECT m FROM MotPartLo m WHERE m.partType = :partType")})
public class MotPartLo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "model_name")
    private String modelName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "part_name")
    private String partName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "part_type")
    private String partType;

    public MotPartLo() {
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType;
    }
    
}
