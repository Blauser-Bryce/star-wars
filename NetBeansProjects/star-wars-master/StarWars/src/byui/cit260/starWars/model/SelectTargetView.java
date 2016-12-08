/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

import byui.cit260.starWars.control.TargetControl;
import byui.cit260.starWars.model.EnemyFighter;
import byui.cit260.starWars.view.View;
import starwars.StarWars;

/**
 *
 * @author gmoser
 */
public class SelectTargetView extends View {
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
        TargetControl targetControl = new TargetControl();
        EnemyFighter[] enemyFighterList = StarWars.getCurrentGame().getEnemyFighters();
        int remainingEnemy = targetControl.getLengthEnemyHealth(enemyFighterList);
        
        if (remainingEnemy > 0){
             for (int i = 0; i < enemyFighterList.length -1 ; i++){
             console.println("\n" + enemyFighterList[3].getTargetName()
                       +     "\n Location: \t(" + enemyFighterList[i].getTargetLocation().getRow() + "," 
                              + enemyFighterList[i].getTargetLocation().getColumn() + ")"
                           + "\n Health: \t" + enemyFighterList[i].getTargetHealth());
             
              }
        }          
    }

    private void moveToWaypoint() {
         
        // display the help menu
        EnterWaypointView waypointMenu = new EnterWaypointView();
        waypointMenu.display();
    
    }
}
