/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

import java.util.Scanner;

/**
 *
 * @author Edvaldo Melo
 */
public class GameMenuView {

    private String menu;
    MainMenuView mainMenu = new MainMenuView();
    
    public GameMenuView() {
        this.menu = "\n"
                + "\n--------------------------------"
                + "\n| Game Menu                    |"
                + "\n--------------------------------"
                + "\nM - View Map"
                + "\nL - Attack Turbo Laser"
                + "\nF - Attack Tie Fighter"
                + "\nS - Attack Defletor Shield"
                + "\nE - Evasive Maneuver"
                + "\nT - Fire Torpedo"
                + "\nA - View Ammunition"
                + "\nX - Exit"
                + "\n--------------------------------" ; 
    }
    
    public void displayGameMenu() {
        boolean done = false; // set flag for not done
        
        System.out.println(this.menu);
        
        do {
            // prompt for and get menu input
            String menuOption = this.getMenuOption();
            // user wants to exit
            if (menuOption.toUpperCase().equals("X")) {
                mainMenu.displayMainMenuView();
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
        
        choice = choice.toUpperCase(); //convert to upper
        
        switch (choice) {
            case "M": // view map
                this.viewMap();
                break;
            case "L": // view map
                this.attackTurboLaser();
                break;
            case "F": // view map
                this.attackTieFighter();
                break;
            case "S": // view map
                this.attackDeflectorShield();
                break;
            case "E": // view map
                this.evasiveManeuver();
                break;
            case "T": // view map
                this.fireTorpedo();
                break;
            case "A": // view map
                this.viewAmmuntion();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
        }
        
        return false;
    }
  
    private void viewMap() {
       // display the map view
       MapView mapView = new MapView();
       mapView.displayMapView();
    }
    
    private void attackTurboLaser() {
       // TargetControl.attackTurboLaser;
    }
    
    private void attackTieFighter() {
        //TargetControl.attackTieFighter;
    }
    
    private void attackDeflectorShield() {
        //TargetControl.attackDefletorShield;
    }
    
    private void evasiveManeuver() {
        //TargetControl.evasiveManeuver;
    }
    
    private void fireTorpedo() {
        //TargetControl.fireTorpedo;
    }

    private void viewAmmuntion() {
        // Display the ammuntion
        AmmunitionView ammoView = new AmmunitionView();
        ammoView.displayAmmunitionView();
    }
}
