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
public class AttackDeflectorShield {
    MainMenuView mainMenu = new MainMenuView();
    private String menu;
    
    public AttackDeflectorShield() {
        this.menu = "\n"
                + "\n--------------------------------------------------"
                + "\n        You Have Encountered a Deflector Shild    "
                + "\nT       Fire Torpedo                              "
                + "\nE       Evasive Maneuver                          "
                + "\nX       Exit                                      "
                + "\n--------------------------------------------------";          
    }
    
    public void displayAttackDeflectorShield() {
        boolean done = false; // set flag for not done
        
        System.out.println(this.menu);
        
        do {
            // prompt for and get menu input
            String menuOption = this.getMenuOption();
            // user wanta to exit
            if (menuOption.toLowerCase().equals("X")) {
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

    private boolean doAction(String menuOption) {
        menuOption = menuOption.toUpperCase(); // converto to upper
        
        switch (menuOption) {
            case "T": // Fire Torpedo
                this.damageDeflectorShield();
                break;
            case "E": // Evasive Maneuver
                this.evasiveManeuver();
                break;
            default:
                System.err.println("\n*** Invalid selection. *** Try again.");
                break;
        }
        
        return false;
    }

    private void damageDeflectorShield() {
        System.err.println("*** Damage Tie Fighter. ***");
    }

    private void evasiveManeuver() {
        System.err.println("*** Evasive Maneuver Called. ***");
    }
}