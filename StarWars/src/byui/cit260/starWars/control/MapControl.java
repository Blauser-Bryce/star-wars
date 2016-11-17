/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.control;

//import byui.cit260.starWars.model.Game;
//import byui.cit260.starWars.model.Location;
import byui.cit260.starWars.model.Map;
//import starwars.StarWars;

/**
 *
 * @author Bryce Blauser
 */
public class MapControl {
    
    public static Map createMap() {
        // Create the map
        Map map = new Map();
        map = map.createMap();
                
        return map;
    }
/*
    public Location[][] getClosestLocations() {
        
        Game game = new Game(); // Create new game
        StarWars.getCurrentGame(); // get current game

        Location[][] locations = game.getMap().getLocations();
        
        System.out.println(locations.length());
        
        return locations;
    }
    
    public static Location[][] sortLocations(Location[][] array) {
        
        private int totalLocations = array.get
        
        final String[][] data;
        
        // Populate the data to sort
        for (Location[] row : array) {
            for (Location col : row) {
                data[row][col] = 
            }
            
        }
    }
  
    private static void swapLocations(int i, int j, Location[][] array) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
*/    
    static void moveActorsToStartingLocation(Map map) {
        System.out.println("\n *** moveActorsToStartingLocation called ***");
    }
}
