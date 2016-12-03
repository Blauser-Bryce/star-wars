/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

import byui.cit260.starWars.control.PlayerControl;
import byui.cit260.starWars.model.Location;
import byui.cit260.starWars.model.Map;
import byui.cit260.starWars.model.Scene;
import exceptions.MapControlException;
import starwars.StarWars;

/**
 *
 * @author Bryce Blauser
 */
public class EnterWaypointView extends View {
    
    public EnterWaypointView() {
        super ("-------------------------------------------"
                + "\n| Enter Waypoint                            |"
                + "\n-------------------------------------------"
                + "\n  Row,Column"
                + "\n-------------------------------------------\n");
    }
    
    @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase(); // convert to upper
        
        int row = 0;
        int column = 0;
        if (value.contains(",")) {
            // Split the string to get the coordinates
            String[] locationArray = value.split("\\s*,\\s*");
            
            // Set the row and column
            try {
                row = Integer.parseInt(locationArray[0]);
            } catch (NumberFormatException nf) {
                ErrorView.display(this.getClass().getName(), "You must enter a valid set of numbers.  Try again or enter X to Exit.");
            }
            
            try {
                column = Integer.parseInt(locationArray[1]);
            } catch (NumberFormatException nf) {
                ErrorView.display(this.getClass().getName(), "nYou must enter a valid set of numbers.  Try again or enter X to Exit.");
            }
                        
            // Move player to location
            Location location = new Location();
            location.setRow(row);
            location.setColumn(column);
            try {
                PlayerControl.movePlayerToLocation(location);
            } catch (MapControlException me) {
                ErrorView.display(this.getClass().getName(), me.getMessage());
            }
            
            // Check if the player moved to a new scene and perform action if necessary
            Map map = StarWars.getCurrentGame().getMap();     
            Location[][] locations = map.getLocations();
            
            // Move to Supply ship view if location matches
            if ("SS".equals(locations[row][column].getScene().getDisplaySymbol())) {
                moveToSupplyShip();
            }
                        
        } else {
            console.println("\n*** Invalid selection *** Try again");
        }

        return false;
    }
    
    private void moveToSupplyShip() {
        SupplyShipView supplyView = new SupplyShipView();
        supplyView.display();
    }
}
