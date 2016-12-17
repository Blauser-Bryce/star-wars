/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

import byui.cit260.starWars.control.GameControl;
import exceptions.GameControlException;
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
                + "\nN - Start New Game"
                + "\nG - Start Saved Game"
                + "\nH - Help Menu"
                + "\nS - Save Game"
                + "\nX - Exit Game"
                + "\n--------------------------------");
        
    }

    @Override
    public boolean doAction(String choice) {
        
        choice = choice.toUpperCase(); // converto to upper
        
        switch (choice) {
            case "N": // Create and start game
                this.startNewGame();
                break;
            case "G": 
                this.startExistingGame();
                break;
            case "H":
                this.displayHelpMenu();
                break;
            case "S":
                this.saveGame();
                break;
            default:
                console.println("\n*** Invalid selection *** Try again");
        }
        
        return false;
    }

    private void startNewGame() {
        // create a new game
        GameControl.createNewGame(StarWars.getPlayer());
        
        // display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void startExistingGame() {
        
        // prompt for and get the name of the file to save the game in
        console.println("\n\nEnter the file path for the file where the game is saved.");
        String filePath = this.getInput();
        
        try {
            GameControl.getSavedGame(filePath);
        } catch (GameControlException ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
        
        //display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void displayHelpMenu() {
        // display the help menu
        GameHelpView helpMenu = new GameHelpView();
        helpMenu.display();
    }

    private void saveGame() {
        // prompt for and get the name of the file to save the game in
        console.println("\n\nEnter the file path for the file where the game is to be saved.");
        String filePath = this.getInput();
        
        try {
            GameControl.saveGame(StarWars.getCurrentGame(), filePath);
        } catch (GameControlException ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }

    }
    
}
