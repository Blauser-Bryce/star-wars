/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

import byui.cit260.starWars.control.GameControl;
import java.util.Scanner;
import starwars.StarWars;

/**
 *
 * @author Bryce Blauser
 */
public class MainMenuView extends View {

    private String menu;
    
    public MainMenuView() {
        super("\n"
                + "\n--------------------------------"
                + "\n| Main Menu                    |"
                + "\n--------------------------------"
                + "\nG - Start New Game"
                + "\nL - Load Saved Game"
                + "\nH - Help Menu"
                + "\nS - Save Game"
                + "\nX - Exit Game"
                + "\n--------------------------------");
        
    }

    @Override
    public boolean doAction(String choice) {
        
        choice = choice.toUpperCase(); // converto to upper
        
        switch (choice) {
            case "G": // Create and start game
                this.startNewGame();
                break;
            case "L": 
                this.startExistingGame();
                break;
            case "H":
                this.displayHelpMenu();
                break;
            case "S":
                this.saveGame();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
        }
        
        return false;
    }

    private void startNewGame() {
        GameControl.createNewGame(StarWars.getPlayer());
        
        // display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void startExistingGame() {
        System.out.println("*** startExistingGame function called ***");
    }

    private void displayHelpMenu() {
        // display the help menu
        GameHelpView helpMenu = new GameHelpView();
        helpMenu.display();
    }

    private void saveGame() {
        System.out.println("*** saveGame function called ***");
    }
    
}
