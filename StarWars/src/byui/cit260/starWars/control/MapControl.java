/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.control;

import byui.cit260.starWars.model.Location;
import byui.cit260.starWars.model.Location.locationStatus;
import byui.cit260.starWars.model.Map;
import byui.cit260.starWars.view.SupplyShipView;
import java.io.PrintWriter;
import starwars.StarWars;

/**
 *
 * @author Bryce Blauser
 */
public class MapControl {
    
    private static final PrintWriter console = StarWars.getOutFile();
    
    public static Map createMap() {
        // Create the map
        Map map = new Map();
        map = map.createMap();
                
        return map;
    }
        
    public boolean goToLocation(Location location) {
        
        if (location.getStatus() == locationStatus.locked) {
            return false;
        }
        
        // Check if the player moved to a new scene and perform action if necessary
        String displaySymbol = location.getScene().getDisplaySymbol();

        if (displaySymbol == null || displaySymbol.isEmpty() || "  ".equals(displaySymbol)) {
            console.println("\n*** Nothing of interest to see here ***");
            return true;
        }

        // Show the description for the scene
        console.println(location.getScene().getDescription());

        switch (location.getScene().getSceneType()) {
            case supplyShip:
                moveToSupplyShip(); // Move to Supply Ship
                break;

            default:
                //console.println("\n*** You are at an unknown location ***");
        }
        
        return true;
    }
    
    public void unlockTrench() {
        
        Map map = StarWars.getCurrentGame().getMap();
        Location[][] locations = map.getLocations();
        
        int noOfRows = map.getNoOfRows();
        int noOfCols = map.getNoOfColumns();
        
        for (int row = 0; row < noOfRows; row++) {
            for (int col = 0; col < noOfCols; col++) {
                locations[row][col].setStatus(Location.locationStatus.unlocked);
            }
        }
    }
    
    private void moveToSupplyShip() {
        SupplyShipView supplyView = new SupplyShipView();
        supplyView.display();
    }
    
    static void moveActorsToStartingLocation(Map map) {
        console.println("\n *** moveActorsToStartingLocation called ***");
    }
}
