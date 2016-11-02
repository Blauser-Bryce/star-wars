/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

import byui.cit260.starWars.control.ItemControl;
import byui.cit260.starWars.model.Item;
import byui.cit260.starWars.model.Player;
import java.util.Scanner;
import java.util.regex.Pattern;
import starwars.StarWars;

/**
 *
 * @author Bryce Blauser
 */
public class SupplyShipView {

    private String menu;
    private String wayPointPrompt;
    
    private Item item = new Item();
    Player player = StarWars.getPlayer();
    
    MapView mapView = new MapView();
    
    public SupplyShipView() {
        this.menu = "\n"
                + "\n--------------------------------"
                + "\n| Supply Ship Options          |"
                + "\n--------------------------------"
                + "\nM - Replenish Missiles"
                + "\nT - Replenish Torpedoes"
                + "\nF - Replenish Flares"
                + "\nX - Exit"
                + "\n--------------------------------" ; 
    }
    
    void displaySupplyView() {
        boolean done = false; // set flag for not done
        
        System.out.println(this.menu);
        
        do {
            // prompt for and get menu input
            String menuOption = this.getMenuOption();
            // user wants to exit
            if (menuOption.toUpperCase().equals("X")) {
                mapView.displayMapView();
                return;
            }
            
            // do the requested action and display the next view
            done = this.doAction(menuOption);
        } while (!done);
    }
    
    private String getMenuOption() {
        Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while (!valid) { // loop while invalid value is entered
                       
            value = keyboard.nextLine(); // get next line typed on the keyboard
            value = value.trim(); // trim off the leading and trailing blanks
            
            if (value.length() < 1) { // value is blank
                System.out.println("\nInvalid value: value cannot be blank");
                continue;
            }
            break; // end the loop
        }
        return value;
    }

    private boolean doAction(String choice) {
        
        choice = choice.toUpperCase(); // converto to upper
        
        switch (choice) {
            case "M": // Replenish Missile
                item = player.getMissiles();
                this.getQuantity();
                break;
            case "T":  // Replenish Torpedo
                item = player.getTorpedos();
                this.getQuantity();
                break;
            case "F":  // Replenish Flare
                item = player.getFlares();
                this.getQuantity();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
        }
        this.getQuantity();
        return false;
    }
    
    private void getQuantity() {
        Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while (!valid) { // loop while invalid value is entered
            System.out.println("\nEnter Quantity to Replenish");
            
            value = keyboard.nextLine(); // get next line typed on the keyboard
            value = value.trim(); // trim off the leading and trailing blanks
            
            if (value.length() < 1) { // value is blank
                System.out.println("\nInvalid value: value cannot be blank");
                continue;
            }
            
            if (value.toUpperCase().equals("X"))
                break;
                       
            if (Pattern.matches("^[0-9]*$", value)) {
                valid = true;
                this.repItem(value);
            } else {
                System.out.println("\nInvalid value: can only contain a whole number");
                continue;
            }
            
            break; // end the loop
        }
    }

    private void repItem(String repAmount) {
        System.out.println("\nReplenishing " + repAmount);
        
        // user wants to exit
        if (repAmount.toUpperCase().equals("X")) {
            mapView.displayMapView();
        }

        int amount = Integer.parseInt(repAmount);
        ItemControl repItem = new ItemControl();
        
        String result = repItem.replenishItem(this.item, amount, 10000, true);
        System.out.println(result);
        
        this.displaySupplyView();
    }
}
