/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeappliance_app.enums;

/**
 *
 * @author Ivan
 */
public enum EnergyLabelEnum {
    A("A",100), B("B",80), C("C",60), D("D",50), E("E",30), F("F",10);
    
    private String energyLabelCharacter;
    private Integer pricePerEnergyLabel;

    private EnergyLabelEnum(String energyLabelCharacter, Integer pricePerEnergyLabel) {
        this.energyLabelCharacter = energyLabelCharacter;
        this.pricePerEnergyLabel = pricePerEnergyLabel;
    }

    public String getEnergyLabelCharacter() {
        return energyLabelCharacter;
    }

    public Integer getPricePerEnergyLabel() {
        return pricePerEnergyLabel;
    }
    
    
}

/*
LETRA PRECIO
A $1000
B $800
C $600
D $500
E $300
F $100
*/