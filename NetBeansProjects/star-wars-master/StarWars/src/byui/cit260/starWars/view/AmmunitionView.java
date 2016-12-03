/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;
import byui.cit260.starWars.model.Game;
import byui.cit260.starWars.model.Item;
import byui.cit260.starWars.model.Player;
import exceptions.GameControlException;
import java.io.PrintWriter;
import starwars.StarWars;

/**
 *
 * @author Bryce Blauser
 */
public class AmmunitionView extends View {
    
    //private String ammunition;
    GameMenuView gameMenu = new GameMenuView();
    
    Player player = StarWars.getPlayer();
    Game game = StarWars.getCurrentGame();
    Item[] ammunition = game.getInventory();
    
    public AmmunitionView() {
       
        super("\n"
                + "\n---------------------------------------------------"
                + "\n Ammunition Report "
                + "\n R - Print Report to file"
                + "\n X - Exit "
                + "\n---------------------------------------------------");
        
        StringBuilder line; 
        
        console.println("\n      LIST OF AMMUNITION ITEMS");
        line = new StringBuilder("                                          ");
        line.insert(0, "TYPE");
        line.insert(20, "QUANTITY");
        console.println(line.toString());
        
        // for each inventory item
        for (Item item : ammunition) {
            line = new StringBuilder("                                   ");
            line.insert(0, item.getType());
            line.insert(20, item.getQuantity());
            
            console.println(line.toString());
        }
        
    }
    
    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); // convert to upper
        
        switch (value) {
            case "R": // Print the ammunition data to file
                this.printReport();
                break;
            default:
                console.println("Invalid selection. Try again.");
                break;
        }
        return false;
    }

    private void printReport() {
        
        // prompt for and get the name of the file to save the game in
        console.println("\n\nEnter the file path for the file where the game is to be saved.");
        String filePath = this.getInput();
        
        try {
            saveReport(filePath);
            console.println("\nFile successfully saved to: " + filePath);
        } catch (Exception ex) {
            ErrorView.display("AmmunitionView", ex.getMessage());
        }
    }
    
    public void saveReport(String filePath) throws GameControlException {
        
        try (PrintWriter out = new PrintWriter(filePath)) {
            out.println("\n\n      Ammunition Report");
            out.printf("%n%-20s%8s","Ammunition Type","Quantity");
            out.printf("%n%-20s%8s","---------------","--------");
            
            // for each inventory item
            for (Item item : ammunition) {
                out.printf("%n%-20s%5d",item.getType(), item.getQuantity());
            }
        } catch (Exception e) {
            throw new GameControlException(e.getMessage());
        }
    }
}
