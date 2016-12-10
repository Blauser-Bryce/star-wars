/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

/**
 *
 * @author Bryce Blauser
 */
public class MapView extends View {
    
    private String menu;
    private String wayPointPrompt;
    
    GameMenuView gameMenu = new GameMenuView();
    
    public MapView() {
        super( "\n"
                + "\n-------------------------------------------"
                + "\n| Map Menu                               |"
                + "\n-------------------------------------------"
                + "\nW - Move to Waypoint"
                + "\nX - Exit"
                + "\n  Supply Ship 5,6"
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
                console.println("\n*** Invalid selection *** Try again");
        }
        
        return false;
    }

    private void moveToWaypoint() {
        // display the help menu
        EnterWaypointView waypointMenu = new EnterWaypointView();
        waypointMenu.display();
    }

}
