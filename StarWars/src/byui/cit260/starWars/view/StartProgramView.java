/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

import byui.cit260.starWars.control.GameControl;
import byui.cit260.starWars.model.Player;
import java.util.Scanner;

/**
 *
 * @author Bryce Blauser
 */
public class StartProgramView {
    
    private String promptMessage;
     
    public StartProgramView() {
        // prompt message and display banner        
        this.promptMessage = "\nPlease enter your name: ";
            
        // Display the banner
        this.displayBanner();
    }

    public void displayBanner() {
      System.out.println(
        "***************************************************************************************"
      + "\n*This game will be a text based role playing game where the trench run Death Star     *"
      + "\n*destruction sequence from the movie “Star Wars: A New Hope” is recreated.             *"
      + "\n*You will lead a small group of 22 X-wing, 8 Y-wing and 2 R-22 Spearhead fighters to  *"
      + "\n*destroy the space station before it can destroy the Rebel base on Yavin 4.           *" 
      + "\n*                                                                                     *"
      + "\n*You will be piloting an X-wing in the Red Squadron and are tasked with dropping a    *"
      + "\n*torpedo into an exhaust port with perfect accuracy.  You will first have to avoid    *"
      + "\n*and destroy turbo laser batteries and then evade tie fighters as you make your way   *"
      + "\n*to the trench.  Before you can continue, 10 deflector shield towers which protect    *"
      + "\n*the trench must be destroyed.  Once in the trench, you must again avoid turbo lasers *"
      + "\n*and tie fighters, lock on to the exhaust port and fire your torpedo.  The lives of   *"
      + "\n*thousands of Rebel soldiers and leaders are counting on your success.                *"
      + "\n***************************************************************************************");
      
    }

    public void displayStartProgramView() {
        //System.out.println("\n*** displayStartProgram() function called ***");
        
        boolean done = false; // set flag to not done
        do {
            // prompt for and get players name
            String playersName = this.getPlayersName();
            if (playersName.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the game
            
            // do the requested action and display the next view
            done = this.doAction(playersName);
        } while (!done);
    }

    private String getPlayersName() {
        Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while (!valid) { // loop while invalidB value is entered
            System.out.println("\n" + this.promptMessage);
            
            value = keyboard.nextLine(); // get next line typed on the keyboard
            value = value.trim(); // trim off the leading and trailing blanks
            
            if (value.length() < 1) { // value is blank
                System.out.println("\nInvalid value: value cannot be blank");
                continue;
            }
            
            break; // end the loop
        }
        
        return value; // return the value entered
    }

    private boolean doAction(String playersName) {
        if (playersName.length() < 2) {
            System.out.println("\nInvalid players name:"
                    + "The name must be greater than one character in length");
            return false;
        }
        
        // call createPlayer() control function
        Player player = GameControl.createPlayer(playersName);
        
        if (player == null) { // if unsuccessful
            System.out.println("\nError creating player.");
            return false;
        }
        
        // display next view
        this.displayNextView(player);
        
        return true; // success!
    }
    
    private void displayNextView(Player player) {
        System.out.println("\n========================================="
                         + "\n Welcome to the game " + player.getName()
                         + "\n We hope you have a lot of fun!"
                         + "\n=========================================");
       
        // Create MainMenu object
        MainMenuView mainMenuView = new MainMenuView();
        
        // Display the main menu view
        mainMenuView.displayMainMenuView();
                
    }
}
