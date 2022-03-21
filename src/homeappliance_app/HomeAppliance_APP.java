/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeappliance_app;

import homeappliance_app.entities.HomeAppliance;
import homeappliance_app.entities.TV;
import homeappliance_app.entities.WashingMachine;
import homeappliance_app.enums.EnergyLabelEnum;
import homeappliance_app.services.HomeApplianceServices;

/**
 *
 * @author Ivan
 */
public class HomeAppliance_APP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        /*
        Finalmente, en el main debemos realizar lo siguiente:
        Vamos a crear una Lavadora y un Televisor y llamar a los métodos necesarios
        para mostrar el precio final de los dos electrodomésticos.
        
        */
        
        
        /*
        TO DO: Build a list asking 2 choose which home appliance you're inputing in the system.
        
        */
        WashingMachine laundry = new WashingMachine().inputInfoWashingMachineInDatabase();

               
        WashingMachine laundry2 = new WashingMachine().inputInfoWashingMachineInDatabase();

        TV tv50inWithTuner = new TV().inputTVinfoInDatabase();
        TV tv30inNoTuner = new TV().inputTVinfoInDatabase();
        
        
        
        laundry.displayProductSpecifics();
        laundry2.displayProductSpecifics();
        tv50inWithTuner.displayProductSpecifics();
        tv30inNoTuner.displayProductSpecifics();
        
        
        // Maybe we DO NOT want to create a generic home appliance, in fact doing that MAKES NONSENSE!!!
        // The idea here is to code sth, a specific method to check colour and energy label or price calculation
        // that we eventually REUSE when a specific home appliance (a washing maschine, a tv) inherits the parent methods
        
        
        
        
        
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