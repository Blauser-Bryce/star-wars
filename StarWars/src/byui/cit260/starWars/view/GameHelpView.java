/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

import java.util.Scanner;

/**
 *
 * @author Bryce Blauser
 */
class GameHelpView {
    
    private String menu;
    MainMenuView mainMenu = new MainMenuView();
    
    public GameHelpView() {
        this.menu = "\n"
                + "\n-------------------------------------------"
                + "\n| Help Menu                               |"
                + "\n-------------------------------------------"
                + "\nG - What is the goal of the game?"
                + "\nA - How to attack"
                + "\nI - Aiming"
                + "\nM - Viewing the map"
                + "\nE - Avoiding fire using evasive maneuvers"
                + "\nX - Exit"
                + "\n-------------------------------------------" ;
        
    }
    
    public void displayHelpMenuView() {
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
        
        choice = choice.toUpperCase(); // converto to upper
        
        switch (choice) {
            case "G": // Create and start game
                this.showGoalText();
                break;
            case "A": 
                this.showAttackText();
                break;
            case "I":
                this.showAimingText();
                break;
            case "M":
                this.showMapText();
                break;
            case "E":
                this.showManeuverText();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
        }
        
        return false;
    }

    private void showGoalText() {
        System.out.println("\n The goal of this game is to destroy the Death Star");
    }

    private void showAttackText() {
        System.out.println("\n You attack by doing xyz and pressing x button");
    }

    private void showAimingText() {
        System.out.println("\n You aim by pressing up and down arrows until the target"
                         + "\n is in the crosshairs");
    }

    private void showMapText() {
        System.out.println("\n The map shows the following locations:");
    }

    private void showManeuverText() {
        System.out.println("\n You maneuver you fighter by doing xyz and launching"
                         + "\nflares by pressing xyz button");
    }

    
   
}
