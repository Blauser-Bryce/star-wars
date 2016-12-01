/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;
import byui.cit260.starWars.model.Game;
import byui.cit260.starWars.model.Item;
import byui.cit260.starWars.model.Player;
import java.io.BufferedReader;
import java.io.PrintWriter;
import starwars.StarWars;

/**
 *
 * @author Bryce Blauser
 */
public class AmmunitionView {
    
    //private String ammunition;
    GameMenuView gameMenu = new GameMenuView();
    
    Player player = StarWars.getPlayer();

    Game game = StarWars.getCurrentGame();
    
    protected final BufferedReader keyboard = StarWars.getInFile();
    protected final PrintWriter console = StarWars.getOutFile();
    
    public AmmunitionView() {
       
        StringBuilder line; 
        
        Item[] ammunition = game.getInventory();
        
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
        
         /*
        this.ammunition = 
                    "-------------------------------------------"
                + "\n| Current Player Ammuntion (" + player.getName() + ")"
                + "\n-------------------------------------------"
               + "\n  Missiles: " + player.getMissiles().getQuantity()
               + "\n  Torpedos: " + player.getTorpedos().getQuantity()
             + "\n  Flares  : " + player.getFlares().getQuantity()
                + "\n-------------------------------------------\n"
                + "\nPress any key to exit" ; */
    }
    
    public void display() {
        boolean done = false; // set flag for not done
        
        //console.println(this.ammunition);
        
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        try {
            while (!valid) { // loop while invalid value is entered

                value = this.keyboard.readLine(); // get next line typed on the keyboard
                value = value.trim(); // trim off the leading and trailing blanks

                if (value.length() < 1) { // value is blank
                    ErrorView.display(this.getClass().getName(),"Invalid value: value cannot be blank");
                    continue;
                }

                gameMenu.display();
                break; // end the loop
            }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());
        }
    }
    
}
