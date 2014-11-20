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
@Table(name = "demographics_lo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DemographicsLo.findAll", query = "SELECT d FROM DemographicsLo d"),
    @NamedQuery(name = "DemographicsLo.findByCountry", query = "SELECT d FROM DemographicsLo d WHERE d.country = :country"),
    @NamedQuery(name = "DemographicsLo.findByRegion", query = "SELECT d FROM DemographicsLo d WHERE d.region = :region"),
    @NamedQuery(name = "DemographicsLo.findByPopulation", query = "SELECT d FROM DemographicsLo d WHERE d.population = :population"),
    @NamedQuery(name = "DemographicsLo.findByAverageAge", query = "SELECT d FROM DemographicsLo d WHERE d.averageAge = :averageAge"),
    @NamedQuery(name = "DemographicsLo.findByMarried", query = "SELECT d FROM DemographicsLo d WHERE d.married = :married"),
    @NamedQuery(name = "DemographicsLo.findByCommuting", query = "SELECT d FROM DemographicsLo d WHERE d.commuting = :commuting"),
    @NamedQuery(name = "DemographicsLo.findByCrimeStats", query = "SELECT d FROM DemographicsLo d WHERE d.crimeStats = :crimeStats"),
    @NamedQuery(name = "DemographicsLo.findByTrafficInfo", query = "SELECT d FROM DemographicsLo d WHERE d.trafficInfo = :trafficInfo"),
    @NamedQuery(name = "DemographicsLo.findByParking", query = "SELECT d FROM DemographicsLo d WHERE d.parking = :parking"),
    @NamedQuery(name = "DemographicsLo.findBySnowyDays", query = "SELECT d FROM DemographicsLo d WHERE d.snowyDays = :snowyDays"),
    @NamedQuery(name = "DemographicsLo.findByRainyDays", query = "SELECT d FROM DemographicsLo d WHERE d.rainyDays = :rainyDays"),
    @NamedQuery(name = "DemographicsLo.findByAverageTemperature", query = "SELECT d FROM DemographicsLo d WHERE d.averageTemperature = :averageTemperature")})
public class DemographicsLo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "country")
    private String country;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "region")
    private String region;
    @Basic(optional = false)
    @NotNull
    @Column(name = "population")
    private long population;
    @Basic(optional = false)
    @NotNull
    @Column(name = "average_age")
    private int averageAge;
    @Basic(optional = false)
    @NotNull
    @Column(name = "married")
    private int married;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "commuting")
    private String commuting;
    @Basic(optional = false)
    @NotNull
    @Column(name = "crime_stats")
    private int crimeStats;
    @Basic(optional = false)
    @NotNull
    @Column(name = "traffic_info")
    private int trafficInfo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "parking")
    private int parking;
    @Basic(optional = false)
    @NotNull
    @Column(name = "snowy_days")
    private int snowyDays;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rainy_days")
    private int rainyDays;
    @Basic(optional = false)
    @NotNull
    @Column(name = "average_temperature")
    private int averageTemperature;

    public DemographicsLo() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public int getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(int averageAge) {
        this.averageAge = averageAge;
    }

    public int getMarried() {
        return married;
    }

    public void setMarried(int married) {
        this.married = married;
    }

    public String getCommuting() {
        return commuting;
    }

    public void setCommuting(String commuting) {
        this.commuting = commuting;
    }

    public int getCrimeStats() {
        return crimeStats;
    }

    public void setCrimeStats(int crimeStats) {
        this.crimeStats = crimeStats;
    }

    public int getTrafficInfo() {
        return trafficInfo;
    }

    public void setTrafficInfo(int trafficInfo) {
        this.trafficInfo = trafficInfo;
    }

    public int getParking() {
        return parking;
    }

    public void setParking(int parking) {
        this.parking = parking;
    }

    public int getSnowyDays() {
        return snowyDays;
    }

    public void setSnowyDays(int snowyDays) {
        this.snowyDays = snowyDays;
    }

    public int getRainyDays() {
        return rainyDays;
    }

    public void setRainyDays(int rainyDays) {
        this.rainyDays = rainyDays;
    }

    public int getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(int averageTemperature) {
        this.averageTemperature = averageTemperature;
    }
    
}
