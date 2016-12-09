/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

import byui.cit260.starWars.model.EnemyFighter;
import java.util.ArrayList;
import starwars.StarWars;

/**
 *
 * @author gmoser
 */
public class SelectTargetView extends View {
    ArrayList<EnemyFighter> enemyAtLocation = new ArrayList<>();
    
    MainMenuView mainMenu = new MainMenuView();
    private String menu;
    public SelectTargetView() {
        super("\n-------------------------------"
            + "\n                               "
            + "\nD - Display Remaining Targets  "
            + "\nM - Move to Target             "
            + "\n-------------------------------");
    
}

@Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase(); // converto to upper
        
        switch (value) {
            case "D": // Fire Torpedo
                this.displayRemainingTargets();
                break;
            case "M": // Evasive maneuver
                this.moveToWaypoint();
                break;
            default:
                console.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }

    private void displayRemainingTargets() {        
        EnemyFighter[] enemyFighterList = StarWars.getCurrentGame().getEnemyFighters();
        
        // Get the player position
        int playerRow = StarWars.getPlayer().getLocation().getRow();
        int playerCol = StarWars.getPlayer().getLocation().getColumn();
        
        if (enemyFighterList.length > 0){
             for (int i = 0; i < enemyFighterList.length -1 ; i++){
                // Show only enemies at the player's current location and enemy health > 0
                if (enemyFighterList[i].getTargetLocation().getRow() == playerRow &&
                    enemyFighterList[i].getTargetLocation().getColumn() == playerCol &&
                    enemyFighterList[i].getTargetHealth() > 0) {
                        enemyAtLocation.add(enemyFighterList[i]);
                }
            }
        }
        
        // Print enemy fighters at current location
        int arraySize = enemyAtLocation.size();
        
        if (arraySize == 0) {
            console.println("\nNo enemies at this location (" + playerRow + "," + playerCol + ")");
            return;
        }
        
        for (int i = 0; i < arraySize; i++) {
            console.println("\nEnemy Number: " + i
                            +"\n" + enemyAtLocation.get(i).getTargetName()
                            +"\n Location: \t(" + enemyAtLocation.get(i).getTargetLocation().getRow() + "," 
                            + enemyAtLocation.get(i).getTargetLocation().getColumn() + ")"
                            + "\n Health: \t" + enemyAtLocation.get(i).getTargetHealth());
        }
    }

    private void setSelectedTarget(int selection) {
        
        // Make sure it's a valid selection within the location array
        if (selection < 0 || selection > enemyAtLocation.size()) {
            console.println("\nInvalid enemy selction");
        } else {
            StarWars.getPlayer().setCurrentTarget(enemyAtLocation.get(selection));
        }
    }
    
    private void moveToWaypoint() {
         
        // display the help menu
        EnterWaypointView waypointMenu = new EnterWaypointView();
        waypointMenu.display();
    
    }
}
