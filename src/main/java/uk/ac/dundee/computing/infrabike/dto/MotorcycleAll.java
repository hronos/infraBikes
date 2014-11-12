/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.infrabike.dto;

/**
 *
 * @author Anna
 */
public class MotorcycleAll {
    
    private MotorcycleSpecV spec;

    public MotorcycleSpecV getSpec() {
        return spec;
    }

    public void setSpec(MotorcycleSpecV spec) {
        this.spec = spec;
    }

    public MotorcycleLo getMotorcycle() {
        return motorcycle;
    }

    public void setMotorcycle(MotorcycleLo motorcycle) {
        this.motorcycle = motorcycle;
    }
    private MotorcycleLo motorcycle;
    
    
}
