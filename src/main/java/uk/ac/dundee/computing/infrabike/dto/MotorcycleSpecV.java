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
@Table(name = "motorcycle_spec_v", catalog = "14ac3d30", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MotorcycleSpecV.findAll", query = "SELECT m FROM MotorcycleSpecV m"),
    @NamedQuery(name = "MotorcycleSpecV.findByIdModel", query = "SELECT m FROM MotorcycleSpecV m WHERE m.idModel = :idModel"),
    @NamedQuery(name = "MotorcycleSpecV.findByModelName", query = "SELECT m FROM MotorcycleSpecV m WHERE m.modelName = :modelName"),
    @NamedQuery(name = "MotorcycleSpecV.findByTopSpeed", query = "SELECT m FROM MotorcycleSpecV m WHERE m.topSpeed = :topSpeed"),
    @NamedQuery(name = "MotorcycleSpecV.findByWeight", query = "SELECT m FROM MotorcycleSpecV m WHERE m.weight = :weight"),
    @NamedQuery(name = "MotorcycleSpecV.findBySeatHeight", query = "SELECT m FROM MotorcycleSpecV m WHERE m.seatHeight = :seatHeight"),
    @NamedQuery(name = "MotorcycleSpecV.findByFrame", query = "SELECT m FROM MotorcycleSpecV m WHERE m.frame = :frame"),
    @NamedQuery(name = "MotorcycleSpecV.findByTank", query = "SELECT m FROM MotorcycleSpecV m WHERE m.tank = :tank"),
    @NamedQuery(name = "MotorcycleSpecV.findByEngineSizeCc", query = "SELECT m FROM MotorcycleSpecV m WHERE m.engineSizeCc = :engineSizeCc"),
    @NamedQuery(name = "MotorcycleSpecV.findByFrontBrakes", query = "SELECT m FROM MotorcycleSpecV m WHERE m.frontBrakes = :frontBrakes"),
    @NamedQuery(name = "MotorcycleSpecV.findByRearBrakes", query = "SELECT m FROM MotorcycleSpecV m WHERE m.rearBrakes = :rearBrakes"),
    @NamedQuery(name = "MotorcycleSpecV.findByFrontTyreSize", query = "SELECT m FROM MotorcycleSpecV m WHERE m.frontTyreSize = :frontTyreSize"),
    @NamedQuery(name = "MotorcycleSpecV.findByRearTyreSize", query = "SELECT m FROM MotorcycleSpecV m WHERE m.rearTyreSize = :rearTyreSize"),
    @NamedQuery(name = "MotorcycleSpecV.findByPowerKw", query = "SELECT m FROM MotorcycleSpecV m WHERE m.powerKw = :powerKw")})
public class MotorcycleSpecV implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id  
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_model")
    private int idModel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "model_name")
    private String modelName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "top_speed")
    private int topSpeed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight")
    private float weight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seat_height")
    private int seatHeight;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "frame")
    private String frame;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tank")
    private int tank;
    @Basic(optional = false)
    @NotNull
    @Column(name = "engine_size_cc")
    private int engineSizeCc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "front_brakes")
    private int frontBrakes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rear_brakes")
    private int rearBrakes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "front_tyre_size")
    private int frontTyreSize;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rear_tyre_size")
    private int rearTyreSize;
    @Basic(optional = false)
    @NotNull
    @Column(name = "power_kw")
    private int powerKw;

    public MotorcycleSpecV() {
    }

    public int getIdModel() {
        return idModel;
    }

    public void setIdModel(int idModel) {
        this.idModel = idModel;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getSeatHeight() {
        return seatHeight;
    }

    public void setSeatHeight(int seatHeight) {
        this.seatHeight = seatHeight;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public int getTank() {
        return tank;
    }

    public void setTank(int tank) {
        this.tank = tank;
    }

    public int getEngineSizeCc() {
        return engineSizeCc;
    }

    public void setEngineSizeCc(int engineSizeCc) {
        this.engineSizeCc = engineSizeCc;
    }

    public int getFrontBrakes() {
        return frontBrakes;
    }

    public void setFrontBrakes(int frontBrakes) {
        this.frontBrakes = frontBrakes;
    }

    public int getRearBrakes() {
        return rearBrakes;
    }

    public void setRearBrakes(int rearBrakes) {
        this.rearBrakes = rearBrakes;
    }

    public int getFrontTyreSize() {
        return frontTyreSize;
    }

    public void setFrontTyreSize(int frontTyreSize) {
        this.frontTyreSize = frontTyreSize;
    }

    public int getRearTyreSize() {
        return rearTyreSize;
    }

    public void setRearTyreSize(int rearTyreSize) {
        this.rearTyreSize = rearTyreSize;
    }

    public int getPowerKw() {
        return powerKw;
    }

    public void setPowerKw(int powerKw) {
        this.powerKw = powerKw;
    }
    
}
