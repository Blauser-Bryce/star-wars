/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

import byui.cit260.starWars.model.Map;
import exceptions.MapControlException;
import java.io.PrintWriter;

/**
 *
 * @author Bryce Blauser
 */
public class MapView extends View {

    private String menu;
    private String wayPointPrompt;

    GameMenuView gameMenu = new GameMenuView();
    private Iterable<Map> places;
    
    public MapView() {
        super("\n"
                + "\n-------------------------------------------"
                + "\n| Map Menu                               |"
                + "\n-------------------------------------------"
                + "\nW - Move to Waypoint"
                + "\nR - Print Report to File"
                + "\nX - Exit"
                + "\n  Supply Ship 5,6"
                + "\n-------------------------------------------");

        StringBuilder line;

        console.println("\n--------------------List of Maps--------------------");
        line = new StringBuilder("                                             ");
        line.insert(10, "Rows");
        line.insert(10, "Colums");
        console.println(line.toString());

        // for each inventory item
        for (Map map : places) {
            line = new StringBuilder("                                   ");
            line.insert(0, map.getNoOfRows());
            line.insert(20, map.getNoOfColumns());

            console.println(line.toString());
        }

    }

    @Override
    public boolean doAction(String value) {

        value = value.toUpperCase(); // converto to upper

        switch (value) {
            case "R": // Prompt for Waypoint
                this.moveToWaypoint();
                break;
            default:
                console.println("\n*** Invalid selection *** Try again");
        }

        return false;
    }

    private void printReport() {

        // prompt for and get the name of the file to save the game in
        console.println("\n\nEnter the file path for the file where the game is to be saved.");
        String filePath = this.getInput();

        try {
            saveReport(filePath);
            console.println("\nFile successfully saved to: " + filePath);
        } catch (MapControlException ex) {
            ErrorView.display("MapView", ex.getMessage());
        }
    }

    public void saveReport(String filePath) throws MapControlException {

        try (PrintWriter out = new PrintWriter(filePath)) {
            out.println("\n\n      Map Position Report");
            out.printf("%n%-20s%8s", "Rows", "Columns");
            out.printf("%n%-20s%8s", "-----", "-----");

            // for each inventory item
            for (Map map : places) {
                out.printf("%n%-20s%5d", map.getNoOfRows(), map.getNoOfColumns());
            }
        } catch (Exception e) {
            throw new MapControlException(e.getMessage());
        }
    }

    private void moveToWaypoint() {
        // display the help menu
        EnterWaypointView waypointMenu = new EnterWaypointView();
        waypointMenu.display();
    }

}
