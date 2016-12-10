/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

import byui.cit260.starWars.model.Aim;
import byui.cit260.starWars.model.EnemyFighter;
import byui.cit260.starWars.model.Game;
import byui.cit260.starWars.model.Item;
import byui.cit260.starWars.model.Target;
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
            + "\nA - Attack Selected Target     "
            + "\nOr enter a number to set target"
            + "\n-------------------------------");
    
}

@Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase(); // convert to upper
       
        int selection = 0;
        
        // get the selection
        try {
            selection = Integer.parseInt(value);
            value = "S";
        } catch (NumberFormatException nf) {
            // do nothing, not a number
        }
        
        switch (value) {
            case "D": // 
                this.displayRemainingTargets();
                break;
            case "A":
                this.attackTarget();
                break;
            case "S":
                this.setSelectedTarget(selection);
                break;
            default:
                console.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }

    private void displayRemainingTargets() {        
        EnemyFighter[] enemyFighterList = StarWars.getCurrentGame().getEnemyFighters();
        
        enemyAtLocation.clear(); // Clear all items to refresh display
        
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
            String health = "";
            if (enemyAtLocation.get(i).getTargetHealth() <= 0) {
                health = "Destroyed";
            } else {
                health = Double.toString(enemyAtLocation.get(i).getTargetHealth());
            }
            console.println("\nEnemy Number: " + i
                            +"\n" + enemyAtLocation.get(i).getTargetName()
                            +"\n Location: \t(" + enemyAtLocation.get(i).getTargetLocation().getRow() + "," 
                            + enemyAtLocation.get(i).getTargetLocation().getColumn() + ")"
                            + "\n Health: \t" + health);
        }
    }

    private void setSelectedTarget(int selection) {
        
        // Make sure it's a valid selection within the location array
        if (selection < 0 || selection >= enemyAtLocation.size() || enemyAtLocation.isEmpty()) {
            console.println("\nInvalid enemy selection");
        } else {
            StarWars.getPlayer().setCurrentTarget(enemyAtLocation.get(selection));
            Target target = new Target();
            console.println(target.getTargetDisplay(StarWars.getPlayer().getCurrentTarget().getTargetType()));
            console.println("You have " + StarWars.getPlayer().getCurrentTarget().getTargetName() + " on target.");
        }
    }
    
    private void attackTarget() {
        
        if (StarWars.getPlayer().getCurrentTarget() == null) {
            console.println("\nNo target selected");
            return;
        }
        
        Game game = StarWars.getCurrentGame();
        Item[] item = game.getInventory();
        int remaining = item[Item.itemType.Missile.ordinal()].getQuantity();
        
        if (remaining <= 0) {
            console.println("\nYou have no missiles!  Go to supply ship to replenish");
            return;
        }
                
        AimView aimView = new AimView();
        aimView.console.println(aimView.aim.drawLayout());
        aimView.display();
    }
    
}
