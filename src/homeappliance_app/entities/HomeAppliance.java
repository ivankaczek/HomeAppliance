/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeappliance_app.entities;

import homeappliance_app.enums.ColourEnum;
import homeappliance_app.enums.EnergyLabelEnum;

import homeappliance_app.services.HomeApplianceServices;

/**
 *
 * @author Ivan
 */
public class HomeAppliance {
    
   protected double homeApplPrice;
   protected ColourEnum homeApplColour;
   protected EnergyLabelEnum homeApplEnergyLabel;
   protected double homeApplWeight;
   protected HomeApplianceServices serv = new HomeApplianceServices();

    public HomeAppliance() {
    }

    public HomeAppliance(double homeApplPrice, ColourEnum homeApplColour, EnergyLabelEnum homeApplEnergyLabel, double homeApplWeight) {
        this.homeApplPrice = homeApplPrice;
        this.homeApplColour = homeApplColour;
        this.homeApplEnergyLabel = homeApplEnergyLabel;
        this.homeApplWeight = homeApplWeight;
    }

    public double getHomeApplPrice() {
        return homeApplPrice;
    }

    public void setHomeApplPrice(double homeApplPrice) {
        this.homeApplPrice = homeApplPrice;
    }

    public ColourEnum getHomeApplColour() {
        return homeApplColour;
    }

    public void setHomeApplColour(ColourEnum homeApplColour) {
        this.homeApplColour = homeApplColour;
    }

    public EnergyLabelEnum getHomeApplEnergyLabel() {
        return homeApplEnergyLabel;
    }

    public void setHomeApplEnergyLabel(EnergyLabelEnum homeApplEnergyLabel) {
        this.homeApplEnergyLabel = homeApplEnergyLabel;
    }

    public double getHomeApplWeight() {
        return homeApplWeight;
    }

    public void setHomeApplWeight(double homeApplWeight) {
        this.homeApplWeight = homeApplWeight;
    }

    @Override
    public String toString() {
        return "HomeAppliance{" + "homeApplPrice=" + homeApplPrice + ", homeApplColour=" + homeApplColour + ", homeApplEnergyLabel=" + homeApplEnergyLabel + ", homeApplWeight=" + homeApplWeight + '}';
    }
   
    public HomeAppliance inputApplianceInfoInDatabase(){
        return serv.createHomeApplianceAskingQuestions();
    }
    
    public void displayProductSpecifics(){
        System.out.println("Product Specifications");
        System.out.println("----------------------");
        System.out.println("Colour: " + homeApplColour);
        System.out.println("EnergyLabel: " + homeApplEnergyLabel.getEnergyLabelCharacter());
        System.out.println("Product Weight: " + homeApplWeight + " kg");
        System.out.println("Product Price: USD " + homeApplPrice);
        System.out.println("----------------------");
        
    }
    
    public double calculateApplianceFinalPrice(){
        return serv.calculateFinalPrice(homeApplWeight, homeApplEnergyLabel);
    }
  
    
}

/*
Crear una superclase llamada Electrodoméstico con los siguientes atributos:
precio, color, consumo energético (letras entre A y F) y peso.
Los constructores que se deben implementar son los siguientes:
• Un constructor vacío.
• Un constructor con todos los atributos pasados por parámetro.
Los métodos a implementar son:
• Métodos getters y setters de todos los atributos.
• Método comprobarConsumoEnergetico(char letra): comprueba que la letra
es correcta, sino es correcta usara la letra F por defecto. Este método se debe
invocar al crear el objeto y no será visible.
10
• Método comprobarColor(String color): comprueba que el color es correcto, y
si no lo es, usa el color blanco por defecto. Los colores disponibles para los
electrodomésticos son blanco, negro, rojo, azul y gris. No importa si el nombre
está en mayúsculas o en minúsculas. Este método se invocará al crear el
objeto y no será visible.
• Metodo crearElectrodomestico(): le pide la información al usuario y llena el
electrodoméstico, también llama los métodos para comprobar el color y el
consumo. Al precio se le da un valor base de $1000.
• Método precioFinal(): según el consumo energético y su tamaño, aumentará
el valor del precio. Esta es la lista de precios:
*/