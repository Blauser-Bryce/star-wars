/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

import byui.cit260.starWars.control.GameControl;
import byui.cit260.starWars.control.TargetControl;
import byui.cit260.starWars.model.EnemyFighter;
import byui.cit260.starWars.model.EvasiveManeuver;
import byui.cit260.starWars.model.Game;
import byui.cit260.starWars.model.Map;
import starwars.StarWars;

/**
 *
 * @author Edvaldo Melo
 */
public class GameMenuView extends View {

    private String menu;
    MainMenuView mainMenu = new MainMenuView();
    
    public GameMenuView() {
        super("\n"
                + "\n--------------------------------"
                + "\n| Game Menu                    |"
                + "\n--------------------------------"
                + "\nM - View Map"
                + "\nL - Attack Turbo Laser"
                + "\nF - Attack Tie Fighter"
                + "\nS - Attack Defletor Shield"
                + "\nE - Evasive Maneuver"
                + "\nT - Fire Torpedo"
                + "\nA - View Ammunition"
                + "\nV - View Strongest Enemy"
                + "\nW - View Weakest Enemy"
                + "\nR - View Remaining Enemies"
                + "\nH - View Average Health"
                + "\nX - Exit"
                + "\n--------------------------------"); 
    }

    @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase(); //convert to upper
        
        switch (value) {
            case "M": // view map
                this.viewMap();
                break;
            case "L": // attack turbo laser
                this.attackTurboLaser();
                break;
            case "F": // attack tie fighter
                this.attackTieFighter();
                break;
            case "S": // attack deflector shield
                this.attackDeflectorShield();
                break;
            case "E": // evasive maneuver
                this.evasiveManeuver();
                break;
            case "T": // fire torpedo
                this.fireTorpedo();
                break;
            case "A": // view ammunition
                this.viewAmmuntion();
                break;
            case "V": // view strongest enemy
                this.viewStrongestEnemy();
                break;
            case "W": // view weakest enemy
                this.viewWeakEnemy();
                break;
            case "R": // view remaining ememy
                this.viewRemainingEnemy();
                break;
            case "H": // view avearge health enemy
                this.viewAvgEnemy();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
        }
        
        return false;
    }
  
    private void viewMap() {
       
       Map map = new Map();
       map = StarWars.getCurrentGame().getMap();
       map.displayMap(map);
       
       // display the map view
       MapView mapView = new MapView();
       mapView.display();
    }
    
    private void attackTurboLaser() {
       // TargetControl.attackTurboLaser;
       AttackTurboLaser attackTurboLaser = new AttackTurboLaser();
       attackTurboLaser.display();
    }
    
    private void attackTieFighter() {
        //TargetControl.attackTieFighter;
        AttackTieFighter attackTieFighter = new AttackTieFighter();
        attackTieFighter.display();
    }
    
    private void attackDeflectorShield() {
        //TargetControl.attackDefletorShield;
        AttackDeflectorShield attackDeflectorShield = new AttackDeflectorShield();
        attackDeflectorShield.display();
    }
    
    private void evasiveManeuver() {
        //TargetControl.evasiveManeuver;
        EvasiveManeuver evasiveManeuver = new EvasiveManeuver();
        evasiveManeuver.display();
    }
    
    private void fireTorpedo() {
        //TargetControl.fireTorpedo;
    }

    private void viewAmmuntion() {
        // Display the ammuntion
        AmmunitionView ammoView = new AmmunitionView();
        ammoView.display();
    }

    private void viewStrongestEnemy() {
        
        TargetControl targetControl = new TargetControl();
        EnemyFighter[] enemyFighterList = StarWars.getCurrentGame().getEnemyFighters();
        
        int strongestEnemy = targetControl.getMaxEnemyHealth(enemyFighterList);
        
        if (strongestEnemy >= 0) {
            System.out.println("\n The Strongest Enemy is: "
                              +"\n Name:\t" + enemyFighterList[strongestEnemy].getTargetName()
                              +"\n Location: \t(" + enemyFighterList[strongestEnemy].getTargetLocation().getRow() + "," 
                              + enemyFighterList[strongestEnemy].getTargetLocation().getColumn() + ")"
                              + "\n Health: \t" + enemyFighterList[strongestEnemy].getTargetHealth()      
            );
        } else {
            System.out.println("\n No enemies exist");
        }
    }
    /*gary moser*/
    private void viewWeakEnemy() {
        TargetControl targetControl = new TargetControl();
        EnemyFighter[] enemyFighterList = StarWars.getCurrentGame().getEnemyFighters();
        
        int weakEnemy = targetControl.getLowEnemyHealth(enemyFighterList);
                
        if (weakEnemy >= 0) {
            System.out.println("\n The weakest Enemy is: "
                              +"\n Name:\t" + enemyFighterList[weakEnemy].getTargetName()
                              +"\n Location: \t(" + enemyFighterList[weakEnemy].getTargetLocation().getRow() + "," 
                              + enemyFighterList[weakEnemy].getTargetLocation().getColumn() + ")"
                              + "\n Health: \t" + enemyFighterList[weakEnemy].getTargetHealth()      
            );
        } else {
            System.out.println("\n No enemies exist");
        }
    }
         /*gary moser*/
    private void viewRemainingEnemy() {
        TargetControl targetControl = new TargetControl();
        EnemyFighter[] enemyFighterList = StarWars.getCurrentGame().getEnemyFighters();
        int remainingEnemy = targetControl.getLengthEnemyHealth(enemyFighterList);
        
        if (remainingEnemy > 0){
        System.out.println("\n" + remainingEnemy + " Enemies Remaining");
        }
        else{
        System.out.println("No Ememies Remain");
        }
    }
        /*gary moser */
    private void viewAvgEnemy() {
        TargetControl targetControl = new TargetControl();
        EnemyFighter[] enemyFighterList = StarWars.getCurrentGame().getEnemyFighters();
        double avgEnemy = targetControl.getAvgEnemyHealth(enemyFighterList);
        
        System.out.println("\n Average Enemy Health " + avgEnemy);
            }
    
        
    
}
