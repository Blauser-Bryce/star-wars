/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

import java.util.Scanner;

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
            case "L": // view map
                this.attackTurboLaser();
                break;
            case "F": // view map
                this.attackTieFighter();
                break;
            case "S": // view map
                this.attackDeflectorShield();
                break;
            case "E": // view map
                this.evasiveManeuver();
                break;
            case "T": // view map
                this.fireTorpedo();
                break;
            case "A": // view map
                this.viewAmmuntion();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
        }
        
        return false;
    }
  
    private void viewMap() {
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
    }
    
    private void fireTorpedo() {
        //TargetControl.fireTorpedo;
    }

    private void viewAmmuntion() {
        // Display the ammuntion
        AmmunitionView ammoView = new AmmunitionView();
        ammoView.display();
    }
}
