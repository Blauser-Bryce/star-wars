/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.control;

import byui.cit260.starWars.model.Location;
import byui.cit260.starWars.model.Map;
import byui.cit260.starWars.model.Player;
import exceptions.MapControlException;
import starwars.StarWars;

/**
 *
 * @author Bryce Blauser
 */
public class PlayerControl {

    public PlayerControl() {
    }
    
    public static void movePlayerToLocation(Location location) throws MapControlException {
        
        Map map = StarWars.getCurrentGame().getMap();
        int newRow = location.getRow();
        int newColumn = location.getColumn();
        
        if (newRow < 0 || newRow >= map.getNoOfRows() || newColumn < 0 || newColumn >= map.getNoOfColumns()) {
            throw new MapControlException("Can not move player to location " + newRow + ", " + newColumn + " because that location is outside the bounds of the map.");
        } else {
            MapControl mapControl = new MapControl();
            if (mapControl.goToLocation(location)) {
                Player player = StarWars.getPlayer();
                player.setLocation(location);
                player.setCurrentTarget(null); // do not select a target once moved to a new location
            } else {
                throw new MapControlException("Can not move player to location " + newRow + ", " + newColumn + " because that location is locked."
                        +"\nYou must destroy all Deflector Shields before moving into this location.");
            }
        }
    }
    
}
