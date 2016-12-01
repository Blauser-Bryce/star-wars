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
public class StartProgramView extends View {
    
    private String promptMessage;
     
    public StartProgramView() {
        // prompt message and display banner        
        super("\nPlease enter your name: ");
            
        // Display the banner
        this.displayBanner();
    }

    public void displayBanner() {
      console.println(
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

 
    @Override
    public boolean doAction(String value) {
        if (value.length() < 2) {
            console.println("\nInvalid players name:"
                    + "The name must be greater than one character in length");
            return false;
        }
        
        // call createPlayer() control function
        Player player = GameControl.createPlayer(value);
        
        if (player == null) { // if unsuccessful
            console.println("\nError creating player.");
            return false;
        }
        
        // display next view
        this.displayNextView(player);
        
        return true; // success!
    }
    
    private void displayNextView(Player player) {
        console.println("\n========================================="
                         + "\n Welcome to the game " + player.getName()
                         + "\n We hope you have a lot of fun!"
                         + "\n=========================================");
       
        // Create MainMenu object
        MainMenuView mainMenuView = new MainMenuView();
        
        // Display the main menu view
        mainMenuView.display();
                
    }
}
