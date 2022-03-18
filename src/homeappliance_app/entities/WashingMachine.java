/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeappliance_app.entities;

import homeappliance_app.enums.ColourEnum;
import homeappliance_app.enums.EnergyLabelEnum;
import homeappliance_app.services.HomeApplianceServices;
import java.util.Scanner;

/**
 *
 * @author Ivan
 */
public class WashingMachine extends HomeAppliance {
    protected double maxWeight4WashingMachine;
    //protected HomeApplianceServices serv = new HomeApplianceServices();

    public WashingMachine() {
    }

//    public WashingMachine(double maxWeight4WashingMachine) {
//        this.maxWeight4WashingMachine = maxWeight4WashingMachine;
//    }

    public WashingMachine(double maxWeight4WashingMachine, double homeApplPrice, ColourEnum homeApplColour, EnergyLabelEnum homeApplEnergyLabel, double homeApplWeight) {
        super(homeApplPrice, homeApplColour, homeApplEnergyLabel, homeApplWeight);
        this.maxWeight4WashingMachine = maxWeight4WashingMachine;
    }

    public double getMaxWeight4WashingMachine() {
        return maxWeight4WashingMachine;
    }

    public void setMaxWeight4WashingMachine(double maxWeight4WashingMachine) {
        this.maxWeight4WashingMachine = maxWeight4WashingMachine;
    }

    // ATTENTION : PLEASE RE READ THIS
    public WashingMachine inputInfoWashingMachineInDatabase(){
        // We notice that we don't need to import the parent class, and we have access to its methods without instantiating an object
        HomeAppliance appliance01 = inputApplianceInfoInDatabase();
//        System.out.println("Plase introduce max weight 4 laudnry machine");
//        Scanner sc = new Scanner(System.in);
//        double maxWeight = sc.nextDouble();
        double maxWeight = serv.ask4maximumWeight4Laundry();
        /*
        Attention: I don't need to import "services" since it is an attribute inherited from the parent
        */
        // Now we create the daughter object and we absorb previous attributes from the parent
        WashingMachine laundry01 = new WashingMachine(  maxWeight, 
                                                        appliance01.getHomeApplPrice(), 
                                                        appliance01.getHomeApplColour(), 
                                                        appliance01.getHomeApplEnergyLabel(), 
                                                        appliance01.getHomeApplWeight());
        //laundry01.setHomeApplPrice(calculateApplianceFinalPrice());
        double newPrice = laundry01.calculateApplianceFinalPrice();
        laundry01.setHomeApplPrice(newPrice);
        return laundry01;
    }

    @Override
    public String toString() {
        return "WashingMachine{" + "maxWeight4WashingMachine=" + maxWeight4WashingMachine + '}';
    }

    @Override
    public void displayProductSpecifics() {
        super.displayProductSpecifics(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double calculateApplianceFinalPrice() {
        double extraPricePerMaxWeight = 0;
        if (maxWeight4WashingMachine > 30){
            extraPricePerMaxWeight = 50d;
        }
        double basePrice = super.calculateApplianceFinalPrice();
        double finalPrice = basePrice + extraPricePerMaxWeight;
        
        return finalPrice; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

/*
A continuación se debe crear una subclase llamada Lavadora, con el atributo
carga, además de los atributos heredados.
Los constructores que se implementarán serán:
• Un constructor vacío.
• Un constructor con la carga y el resto de atributos heredados. Recuerda que
debes llamar al constructor de la clase padre.
Los métodos que se implementara serán:
• Método get y set del atributo carga.
• Método crearLavadora (): este método llama a crearElectrodomestico() de la
clase padre, lo utilizamos para llenar los atributos heredados del padre y
después llenamos el atributo propio de la lavadora.
• Método precioFinal(): este método será heredado y se le sumará la siguiente
funcionalidad. Si tiene una carga mayor de 30 kg, aumentará el precio en $500,
si la carga es menor o igual, no se incrementará el precio. Este método debe
llamar al método padre y añadir el código necesario. Recuerda que las
condiciones que hemos visto en la clase Electrodoméstico también deben
afectar al precio.
*/