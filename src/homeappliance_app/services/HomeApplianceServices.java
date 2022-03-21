 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeappliance_app.services;

import homeappliance_app.entities.HomeAppliance;
import homeappliance_app.entities.WashingMachine;
import homeappliance_app.enums.ColourEnum;
import homeappliance_app.enums.EnergyLabelEnum;
import java.util.Scanner;

/**
 *
 * @author Ivan
 */
public class HomeApplianceServices {
    
    private final Scanner sc = new Scanner(System.in).useDelimiter("\n");
    
    public HomeAppliance createHomeApplianceAskingQuestions(){
    
        EnergyLabelEnum energyEnum = ask4energyLabel();
        
        ColourEnum colour = ask4ColourEnum();
        
        double weight = ask4weight();
        
        double price = setBasePrice();
        
        HomeAppliance appliance = new HomeAppliance(price, colour, energyEnum, weight);
        
        double newPrice = appliance.calculateApplianceFinalPrice();
        System.out.println("Final Price for product: USD " + newPrice);
        appliance.setHomeApplPrice(newPrice);
        return appliance;
    }
    
    public WashingMachine createWashingMachineAskingQuestions(){
        HomeAppliance temporaryData = createHomeApplianceAskingQuestions();
        System.out.println("Please introduce maximum Weight for Laundry Machine");
        System.out.println("Please remember that Weight heavier than 30 kg creates a price increment");
        double weight4clothes = sc.nextDouble();
        return new WashingMachine(weight4clothes, 
                temporaryData.getHomeApplPrice(), 
                temporaryData.getHomeApplColour(), 
                temporaryData.getHomeApplEnergyLabel(), 
                temporaryData.getHomeApplWeight());
    }
    
   
    // PRICE
    
    public double calculatePriceAccording2Weight(double weight){
        /*
        PESO                PRECIO (let's divide by 10 and get a price in USD)
        Entre 1 y 19 kg     $100
        Entre 20 y 49 kg    $500
        Entre 50 y 79 kg    $800
        Mayor que 80 kg     $1000
        */
        
        double priceRelated2weight;
        if (weight < 20){
            priceRelated2weight = 10;
        } else if (weight < 50){
            priceRelated2weight = 50;
        } else if (weight < 80){
            priceRelated2weight = 80;
        } else priceRelated2weight = 100;
        return priceRelated2weight;
    }
    
    public double calculatePriceAccording2EnergyLabel(EnergyLabelEnum energyEnum){
        return (double) energyEnum.getPricePerEnergyLabel();
    }
    
    public double calculateFinalPrice(double weight, EnergyLabelEnum energyEnum){
        double pricePerWeight = calculatePriceAccording2Weight(weight);
        double pricePerEnergyConsumption = calculatePriceAccording2EnergyLabel(energyEnum);
        double finalPrice = pricePerEnergyConsumption + pricePerWeight;
        return finalPrice;
    }
    
//    public double calculateFinalPrice(HomeAppliance homeAppliance){
//        //double finalPrice = 0;
//        double priceBecauseOfWeight = calculatePriceAccording2Weight(homeAppliance);
//        double priceBecauseOfEnergyLabel = homeAppliance.getHomeApplEnergyLabel().getPricePerEnergyLabel();
//        double finalPrice = priceBecauseOfEnergyLabel + priceBecauseOfWeight;
//        return finalPrice;
//    }
    
    // ENERGY LABEL ENUM
    
    public EnergyLabelEnum ask4energyLabel(){
        System.out.println("Please specify Energy Label (from A to F)");
        String userEnergyLabelString = sc.next();
        if (userEnergyLabelString.length()>1){
            System.out.println("You've written bullshit");
            System.out.println("Label by default is 'F'");
            userEnergyLabelString = "F";
        }
                
        /*
        toCharArray() method of the String class converts the current String to a character array.
        char ch[] = str.toCharArray()
        From the array you can get the character stored at the 0th position.
        char myChar = ch[0];
        */
        
        char[] userLabelAbove = userEnergyLabelString.toCharArray();
        char userEnergyLabelChar = userLabelAbove[0];
        
        EnergyLabelEnum en01 = generateEnergyLabelEnumShortVersion(userEnergyLabelChar);
        
        return en01;
    }
    
    public EnergyLabelEnum generateEnergyLabelEnum(char aCharacter){
       //String acharact = (String) aCharacter;
       // here, the idea is that ONLY IN THE METHOD 4 MANUALLY CREATE AN APPLIANCE the person inserts a character and 
       // this methods returns either the correct Enum or the default Enum "F".
    // how can I code this??? I just don't know
    String option = "";
    EnergyLabelEnum returnThisEnum = EnergyLabelEnum.F;
    switch (aCharacter){
        case 'a': 
        case 'A':
            option = "A";
            returnThisEnum = EnergyLabelEnum.A;
            break;
        case 'b': 
        case 'B':
            option = "B";
            returnThisEnum = EnergyLabelEnum.B;
            break;    
        case 'c': 
        case 'C':
            option = "C";
            returnThisEnum = EnergyLabelEnum.C;
            break; 
        case 'd':
        case 'D':
            option = "D";
            returnThisEnum = EnergyLabelEnum.D;
            break;
        case 'e':
        case 'E':
            option = "E";
            returnThisEnum = EnergyLabelEnum.E;
            break;
        case 'f':
        case 'F':
            option = "F";
            returnThisEnum = EnergyLabelEnum.F;
            break;
        default:
            option = "F";
            returnThisEnum = EnergyLabelEnum.F;
            
    }
        System.out.println("The option in enum selector method is " + option);
        EnergyLabelEnum chosenEnum = EnergyLabelEnum.valueOf(option);
       return returnThisEnum;
   }
 
    public EnergyLabelEnum generateEnergyLabelEnumShortVersion(char aCharacter){
       //String acharact = (String) aCharacter;
       // here, the idea is that ONLY IN THE METHOD 4 MANUALLY CREATE AN APPLIANCE the person inserts a character and 
       // this methods returns either the correct Enum or the default Enum "F".
    // how can I code this??? I just don't know
    String option = "";
    EnergyLabelEnum returnThisEnum = EnergyLabelEnum.F;
    switch (aCharacter){
        case 'a': 
        case 'A':
            option = "A";
            //returnThisEnum = EnergyLabelEnum.A;
            break;
        case 'b': 
        case 'B':
            option = "B";
            //returnThisEnum = EnergyLabelEnum.B;
            break;    
        case 'c': 
        case 'C':
            option = "C";
            //returnThisEnum = EnergyLabelEnum.C;
            break; 
        case 'd':
        case 'D':
            option = "D";
            //returnThisEnum = EnergyLabelEnum.D;
            break;
        case 'e':
        case 'E':
            option = "E";
            //returnThisEnum = EnergyLabelEnum.E;
            break;
        case 'f':
        case 'F':
            option = "F";
            //returnThisEnum = EnergyLabelEnum.F;
            break;
        default:
            option = "F";
            //returnThisEnum = EnergyLabelEnum.F;
            
    }
        System.out.println("The option in enum selector method is " + option);
        EnergyLabelEnum chosenEnum = EnergyLabelEnum.valueOf(option);
       return chosenEnum;
   }
    
    // COLOUR ENUM
    
    public ColourEnum ask4ColourEnum(){
        System.out.println("Please write the Home Appliance Colour");
        String chosenCol = sc.next().toLowerCase();
        ColourEnum chosenColourEnum = generateColourEnum(chosenCol);
        return chosenColourEnum;
    }
    
    public ColourEnum generateColourEnum(String colourInput){
        //ColourEnum defaultColour = ColourEnum.WHITE;
        ColourEnum colour2return = ColourEnum.WHITE;
        switch (colourInput) {
            case "red":
            case "Red":
                System.out.println("Your have selected red");
                colour2return = ColourEnum.RED;
                break;
            case "blu":
            case "blue":
            case "Blue":
            case "vlu":
            case "bolu":
                System.out.println("You have selected colour 'Blue'");
                colour2return = ColourEnum.BLUE;
            break;
            case "black":
            case "Black":
            case "Michael Jackson":
            case "Barack Obama":
            
                System.out.println("You have selected 'Black'");
                colour2return = ColourEnum.BLACK;
                break;
            case "gray":
            case "Gray":
            case "grey":
            case "gay":
                System.out.println("You have selected 'Gray'");
                colour2return = ColourEnum.GRAY;
                break;
            case "ivan":
                System.out.println("Ivan es un genio");
                break;
            case "merca":
                System.out.println("Le encantaba al Diego");
                break;
            case "white":
            case "White":
            case "guait":
            
            default: 
                colour2return = ColourEnum.WHITE;
                
        }
        return colour2return;
    }
    
    // WEIGHT
    
    public double ask4weight(){
        System.out.println("Please introduce product weight: ");
        double weight = sc.nextDouble();
        return weight;
    }

    public double setBasePrice() {
        System.out.println("A base price is USD 10 by default");
        return 10d;
    }
    
    // SPECIFIC FOR LAUNDRY MACHINE
    
    public double ask4maximumWeight4Laundry(){
        System.out.println("Please introduce maximum weight allowed in laundry machine");
        double maxWeight = sc.nextDouble();
        return maxWeight;
    }
 
    // SPECIFIC FOR TV
    
    public boolean ask4TDT_tuner(){
        System.out.println("Does the TV include a TDT Tuner 'y' (yes)/'n' (no) ?");
        boolean hasTDT_tuner = false;
        String userInput = sc.next().toLowerCase();
        if(userInput.equals("y")){
            hasTDT_tuner = true;
        }
        return hasTDT_tuner;
    }
    
    public Integer ask4resolutionInches(){
        System.out.println("Please indicate TV resolution in inches");
        Integer tvResolution = sc.nextInt();
        return tvResolution;
    }
    
    public double extraPrice4tuner(boolean TDT_tuner, double basicPrice){
        double extraPrice4tuner = 0d;
        if (TDT_tuner){
            extraPrice4tuner = 0.3*basicPrice;
        }
        return extraPrice4tuner;
    }
    
    public double extraPrice4bigResolution(Integer resolutionInches){
        double extraPriceResol = 0d;
        if (resolutionInches > 40){
            extraPriceResol = 50;
        }
        return extraPriceResol;
    }
    
    
    /*
    • Método precioFinal():     
                            este método será heredado y se le sumará la siguiente funcionalidad. 
                            Si el televisor tiene una resolución mayor de 40 pulgadas, se incrementará el precio un 30% y 
                            si tiene un sintonizador TDT incorporado, aumentará $500. 
    */
    
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
PESO PRECIO
Entre 1 y 19 kg
$100
Entre 20 y 49 kg $500
Entre 50 y 79 kg $800
Mayor que 80 kg $1000
LETRA PRECIO
A $1000
B $800
C $600
D $500
E $300
F $100
*/

/*
From Java 1.5 Scanner class was introduced. This class accepts a File, InputStream, Path and, String objects, 
reads all the primitive data types and Strings (from the given source) token by token using regular expressions. 
By default, whitespace is considered as the delimiter (to break the data into tokens).

Reading a character using the Scanner class
Scanner class provides nextXXX() (where xxx is int, float, boolean etc) methods which are used to read various primitive datatypes. 
But it never provides a method to read a single character.
But, you still can read a single character using this class.

The next() method of the Scanner class returns the next token of the source in String format. 
This reads single characters (separated by delimiter) as a String.
String str = sc.next();
The toCharArray() method of the String class converts the current String to a character array.
char ch[] = str.toCharArray()
From the array you can get the character stored at the 0th position.
char myChar = ch[0];
Example
Following example reads a single character from the user using the Scanner class.

import java.util.Scanner;
public class ContentsOfFile {
   public static void main(String args[]) throws Exception {
      //Creating a Scanner object
      Scanner sc = new Scanner(System.in);
      //Creating a StringBuffer object
      System.out.println("Enter your grade: (A, B, C, D)");
      char grade = sc.next().toCharArray()[0];
      if(grade == 'A'){
         System.out.println("You are very good, you have been promoted");
      }else if(grade=='B'){
         System.out.println("You are good, you have been promoted");
      }else if(grade=='C'){
         System.out.println("You are average, you have been " + "promoted, you need to work hard");
      }else if(grade=='D'){
         System.out.println("You are not promoted, try again");
      }else {
         System.out.println("Improper input");
      }
   }
}
Output
Enter your grade: (A, B, C, D)
C
You are average, you have been promoted, you need to work hard


Source:
https://www.tutorialspoint.com/how-to-read-a-single-character-using-scanner-class-in-java
*/