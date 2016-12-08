/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

import byui.cit260.starWars.control.TargetControl;
import byui.cit260.starWars.model.Aim;
import byui.cit260.starWars.model.Player;
import byui.cit260.starWars.model.Target;
import starwars.StarWars;

/**
 *
 * @author Bryce Blauser
 */
public class AimView extends View {
    
    Aim aim = new Aim();
    
    public AimView () {
        super("\n"
                + "\n---------------------------------------------------"
                + "\n Use the U, D, L, R keys to get your target in the "
                + "\n crosshairs.  Press F to fire when ready.  F = Fire"
                + "\n   U = Up, D = Down, L = Left, R = Right, X = Exit "
                + "\n---------------------------------------------------"); 
    }
    
    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); // convert to upper
        
        switch (value) {
            case "U": // Pressed Up
                this.aimUp();
                break;
            case "D": // Pressed Down
                this.aimDown();
                break;
            case "L": // Pressed Left
                this.aimLeft();
                break;
            case "R": // Pressed Right
                this.aimRight();
                break;
            case "F": // Fire
                this.fire();
                break;
            default:
                console.println("Invalid selection. Try again.");
                break;
        }
        
        return false;
    }

    private void aimTarget(String direction) {
        if (!aim.aimDir(direction)) {
            console.println("\nLost Target!!!");
            return;
        }
  
        console.println(aim.drawLayout());
    }
    
    private void aimUp() {
        aimTarget("UP");
    }

    private void aimDown() {
        aimTarget("DOWN");
    }

    private void aimLeft() {
        aimTarget("LEFT");
    }

    private void aimRight() {   
        aimTarget("RIGHT");
    }

    private void fire() {
        
        Target target = StarWars.getPlayer().getCurrentTarget();
        if (aim.isOnTarget()) {
            TargetControl targetControl = new TargetControl();
        
            String attack = targetControl.applyDamage(target, 1.5, 50);
        
            console.println(target.getTargetName() + " - HIT : " + attack);
        } else {
            console.println("MISSED!");
        }
        
        //FireTorpedoView torpedo = new  FireTorpedoView();
        //torpedo.display();
    }
    
}
