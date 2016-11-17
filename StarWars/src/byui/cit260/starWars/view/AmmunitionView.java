/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

import byui.cit260.starWars.model.Game;
import byui.cit260.starWars.model.Item;
import byui.cit260.starWars.model.Player;
import java.util.Scanner;
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
    
    public AmmunitionView() {
       
        StringBuilder line; 
        
        Item[] ammunition = game.getInventory();
        
        System.out.println("\n      LIST OF AMMUNITION ITEMS");
        line = new StringBuilder("                                          ");
        line.insert(0, "TYPE");
        line.insert(20, "QUANTITY");
        System.out.println(line.toString());
        
        // for each inventory item
        for (Item item : ammunition) {
            line = new StringBuilder("                                   ");
            line.insert(0, item.getType());
            line.insert(20, item.getQuantity());
            
            System.out.println(line.toString());
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
        
        //System.out.println(this.ammunition);
        
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
            
            gameMenu.display();
            break; // end the loop
        }

    }
    
}
