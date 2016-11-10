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
class GameHelpView extends View {
    
    private String menu;
    MainMenuView mainMenu = new MainMenuView();
    
    public GameHelpView() {
        super("\n"
                + "\n-------------------------------------------"
                + "\n| Help Menu                               |"
                + "\n-------------------------------------------"
                + "\nG - What is the goal of the game?"
                + "\nA - How to attack"
                + "\nI - Aiming"
                + "\nM - Viewing the map"
                + "\nE - Avoiding fire using evasive maneuvers"
                + "\nX - Exit"
                + "\n-------------------------------------------");
        
    }
    
    @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase(); // converto to upper
        
        switch (value) {
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
