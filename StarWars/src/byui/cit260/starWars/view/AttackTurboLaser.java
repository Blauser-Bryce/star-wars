/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

import java.util.Scanner;

/**
 *
 * @author gmoser
 */
public class AttackTurboLaser {
    MainMenuView mainMenu = new MainMenuView();
    private String menu;
    
    public AttackTurboLaser() {
        this.menu = "\n"
                + "\n----------------------------------"                  
                + "\n     +'     :'`                   " 
                + "\n      ;+.    '':.                 " 
                + "\n       ;';:.:,+';`::.,:           " 
                + "\n         +#;;;:'+';::;;;;;        "  
                + "\n        '+'+'''+'':;;;;;+;;`      " 
                + "\n       ''++++''+++'';;;+;;;,      " 
                + "\n        ;'++++''++++;;;;+;'':     " 
                + "\n        ;''#+'''+'+';;;;'+'+;     " 
                + "\n       `'''''''''''';;;;;''+;     " 
                + "\n      ,';'''';''''';;;;;';';      " 
                + "\n       ;'';''''''';;';;;;''';     " 
                + "\n       ;;;;;''';'';;;;;;;;++'     " 
                + "\n       ;';;;'''';';;'';;;;'';     "
                + "\n----------------------------------"
                + "\nYou Have Encountered A Turbo Laser"
                + "\nT - Fire Torpedo                  "
                + "\nE - Evasive Maneuver              "
                + "\nX - Exit                          "
                + "\n----------------------------------";
        
    }
    
    public void displayAttackTurboLaser() {
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
            case "T": // Fire Torpedo
                this.damageTurboLaser();
                break;
            case "E": // Evasive maneuver
                this.evasiveManeuver();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }


    

    private void evasiveManeuver() {
        System.out.println("*** Evasive Maneuver called ***");
    }



    private void damageTurboLaser() {
        System.out.println("*** damage Turbo laser***");
    }


    
    }

   

        
