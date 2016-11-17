/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.control;

import byui.cit260.starWars.model.Map;

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

    static void moveActorsToStartingLocation(Map map) {
        System.out.println("\n *** moveActorsToStartingLocation called ***");
    }
}
