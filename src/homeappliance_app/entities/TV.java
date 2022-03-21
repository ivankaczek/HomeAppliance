/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeappliance_app.entities;

import homeappliance_app.enums.ColourEnum;
import homeappliance_app.enums.EnergyLabelEnum;

/**
 *
 * @author Ivan
 */
public class TV extends HomeAppliance{
    
    protected boolean TDT_tuner;
    protected Integer resolutionInches;

    public TV() {
    }

   
    public TV(  boolean TDT_tuner, 
                Integer resolutionInches, 
                double homeApplPrice, 
                ColourEnum homeApplColour, 
                EnergyLabelEnum homeApplEnergyLabel, 
                double homeApplWeight) {
        super(homeApplPrice, homeApplColour, homeApplEnergyLabel, homeApplWeight);
        this.TDT_tuner = TDT_tuner;
        this.resolutionInches = resolutionInches;
    }

    public boolean isTDT_tuner() {
        return TDT_tuner;
    }

    public void setTDT_tuner(boolean TDT_tuner) {
        this.TDT_tuner = TDT_tuner;
    }

    public Integer getResolutionInches() {
        return resolutionInches;
    }

    public void setResolutionInches(Integer resolutionInches) {
        this.resolutionInches = resolutionInches;
    }
    
    public TV inputTVinfoInDatabase(){
        // first we create a 'parental' HomeAppliance object to re-use the code concerning info input and creation of the object
        HomeAppliance parentHomeAppliance = inputApplianceInfoInDatabase();
        //  now we use the info stored in this 'parental' home appliance to pass the info into the TV
        TV newlyCreatedTV = new TV( serv.ask4TDT_tuner(), 
                                    serv.ask4resolutionInches(),
                                    parentHomeAppliance.getHomeApplPrice(), 
                                    parentHomeAppliance.getHomeApplColour(),
                                    parentHomeAppliance.getHomeApplEnergyLabel(),
                                    parentHomeAppliance.getHomeApplWeight());
        
        return newlyCreatedTV;
    }

    @Override
    public double getHomeApplPrice() {
        double basicPrice = super.getHomeApplPrice();
        double extraPrice4tuner = serv.extraPrice4tuner(TDT_tuner,homeApplPrice);
        double extraPrice4resolution = serv.extraPrice4bigResolution(resolutionInches);
        double tvFinalPrice = basicPrice + extraPrice4tuner + extraPrice4resolution;
        return  tvFinalPrice;
    }
    
    
    
}

/*
Se debe crear también una subclase llamada Televisor con los siguientes atributos: 
        resolución (en pulgadas) y 
        sintonizador TDT (booleano), 
además de los atributos heredados.

Los constructores que se implementarán serán:
• Un constructor vacío.
• Un constructor con la resolución, sintonizador TDT y el resto de atributos heredados. 
Recuerda que debes llamar al constructor de la clase padre.

Los métodos que se implementara serán:
• Método get y set de los atributos resolución y sintonizador TDT.
• Método crearTelevisor():  
                            este método llama a crearElectrodomestico() de la clase padre, 
                            lo utilizamos para llenar los atributos heredados del padre 
                            y después llenamos los atributos del televisor.
• Método precioFinal():     
                            este método será heredado y se le sumará la siguiente funcionalidad. 
                            Si el televisor tiene una resolución mayor de 40 pulgadas, se incrementará el precio un 30% y 
                            si tiene un sintonizador TDT incorporado, aumentará $500. 

Recuerda que las condiciones que hemos visto en la clase Electrodomestico también deben afectar al precio.
*/