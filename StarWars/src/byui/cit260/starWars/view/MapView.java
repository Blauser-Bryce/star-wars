/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

import byui.cit260.starWars.model.Map;
import java.util.Scanner;

/**
 *
 * @author Bryce Blauser
 */
public class MapView {
    
    private String menu;
    private String wayPointPrompt;
    
    GameMenuView gameMenu = new GameMenuView();
    
    public MapView() {
        Map map = new Map();
        
        this.menu = map.getMapLayout()
                +"\n"
                + "\n-------------------------------------------"
                + "\n| Map Menu                               |"
                + "\n-------------------------------------------"
                + "\nW - Move to Waypoint"
                + "\nX - Exit"
                + "\n  Supply Ship (3P)"
                + "\n-------------------------------------------" ;
        
        this.wayPointPrompt = 
                    "-------------------------------------------"
                + "\n| Enter Waypoint                            |"
                + "\n-------------------------------------------"
                + "\n  Supply Ship (3P)"
                + "\n-------------------------------------------\n" ;
        
    }
    
    public void displayMapView() {
        boolean done = false; // set flag for not done
        
        System.out.println(this.menu);
        
        do {
            // prompt for and get menu input
            String menuOption = this.getMenuOption();
            // user wants to exit
            if (menuOption.toUpperCase().equals("X")) {
                gameMenu.displayGameMenu();
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
            case "W": // Prompt for Waypoint
                this.moveToWaypoint();
                break;
            case "3P":  // Move to Supply Ship
                this.moveToSupplyShip();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
        }
        
        return false;
    }

    private void moveToWaypoint() {
        boolean done = false; // set flag for not done
        
        System.out.println(this.wayPointPrompt);
        
        do {
            // prompt for and get menu input
            String menuOption = this.getMenuOption();
            // user wants to exit
            if (menuOption.toUpperCase().equals("X")) {
                this.displayMapView();
                return;
            }
            
            // do the requested action and display the next view
            done = this.doAction(menuOption);
        } while (!done);
    }

    private void moveToSupplyShip() {
        SupplyShipView supplyView = new SupplyShipView();
        supplyView.displaySupplyView();
    }
}
