/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

import byui.cit260.starWars.control.ItemControl;
import byui.cit260.starWars.model.Game;
import byui.cit260.starWars.model.Item;
import byui.cit260.starWars.model.Player;
import java.util.regex.Pattern;
import starwars.StarWars;

/**
 *
 * @author Bryce Blauser
 */
public class SupplyShipView extends View {

    private String menu;
    private String wayPointPrompt;
    
    private Item item = new Item();
    Player player = StarWars.getPlayer();
    
    Game game = StarWars.getCurrentGame();
    
    MapView mapView = new MapView();
    
    public SupplyShipView() {
        super("\n"
                + "\n--------------------------------"
                + "\n| Supply Ship Options          |"
                + "\n--------------------------------"
                + "\nM - Replenish Missiles"
                + "\nT - Replenish Torpedoes"
                + "\nF - Replenish Flares"
                + "\nX - Exit"
                + "\n--------------------------------"); 
    }
    
    @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase(); // converto to upper
        
        switch (value) {
            case "M": // Replenish Missile
                //item = player.getMissiles();
                item = game.getInventoryAtLocation(Item.itemType.Missile.ordinal());
                this.getQuantity();
                break;
            case "T":  // Replenish Torpedo
                //item = player.getTorpedos();
                item = game.getInventoryAtLocation(Item.itemType.Torpedo.ordinal());
                this.getQuantity();
                break;
            case "F":  // Replenish Flare
                //item = player.getFlares();
                item = game.getInventoryAtLocation(Item.itemType.Flare.ordinal());
                this.getQuantity();
                break;
            default:
                ErrorView.display(this.getClass().getName(), "Invalid selection - Try again");
        }

        return false;
    }
    
    private void getQuantity() {
        
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        try {
            while (!valid) { // loop while invalid value is entered
                console.println("\nEnter Quantity to Replenish");

                value = this.keyboard.readLine(); // get next line typed on the keyboard
                value = value.trim(); // trim off the leading and trailing blanks

                if (value.length() < 1) { // value is blank
                    ErrorView.display(this.getClass().getName(), "Invalid value: value cannot be blank");
                    continue;
                }

                if (value.toUpperCase().equals("X")) {
                    return;
                }
                
                if (Pattern.matches("^[0-9]*$", value)) {
                    valid = true;
                    this.repItem(value);
                } else {
                    ErrorView.display(this.getClass().getName(), "Invalid value: can only contain a whole number");
                    continue;
                }

                break; // end the loop
            }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());
        }
    }

    private void repItem(String repAmount) {
        console.println("\nReplenishing " + repAmount);
        
        // user wants to exit
        if (repAmount.toUpperCase().equals("X")) {
            mapView.display();
        }
        
        int amount = 0;
        
        try {
            amount = Integer.parseInt(repAmount);
        } catch (NumberFormatException nf) {
            ErrorView.display(this.getClass().getName(), "You must enter a valid number.  Try again or enter X to Exit.");
        }
        
        ItemControl repItem = new ItemControl();
        
        String result = repItem.replenishItem(this.item, amount, 10000, true);
        console.println(result);
        
        //this.display();
    }
}
