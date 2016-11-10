/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

import byui.cit260.starWars.model.Map;
import java.util.Scanner;

/**
 *
 * @author Bryce Blauser
 */
public class MapView extends View {
    
    private String menu;
    private String wayPointPrompt;
    
    GameMenuView gameMenu = new GameMenuView();
    Map map = new Map();
    String mapLayout = map.getMapLayout();
    ///  *** Add Map Layout *** ///
    
    public MapView() {
        super( "\n"
                + "\n-------------------------------------------"
                + "\n| Map Menu                               |"
                + "\n-------------------------------------------"
                + "\nW - Move to Waypoint"
                + "\nX - Exit"
                + "\n  Supply Ship (3P)"
                + "\n-------------------------------------------");

    }

    @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase(); // converto to upper
        
        switch (value) {
            case "W": // Prompt for Waypoint
                this.moveToWaypoint();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
        }
        
        return false;
    }

    private void moveToWaypoint() {
        // display the help menu
        EnterWaypointView waypointMenu = new EnterWaypointView();
        waypointMenu.display();
    }

}
