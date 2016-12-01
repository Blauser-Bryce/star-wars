/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

import byui.cit260.starWars.model.Aim;

/**
 *
 * @author Bryce Blauser
 */
public class AimView extends View {
    
    Aim aim = new Aim();
    private String aimLayout;
    
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
                System.err.println("\n*** Invalid selection. *** Try again.");
                break;
        }
        
        return false;
    }

    private void aimUp() {
        
        aim.aimUp();
        aimLayout = aim.getAimLayout();
        console.println(aimLayout);
        console.println("\nAim up stub");
    }

    private void aimDown() {
        
        aim.aimDown();
        aimLayout = aim.getAimLayout();
        console.println(aimLayout);
        console.println("\nAim down stub");
    }

    private void aimLeft() {
        
        aim.aimLeft();
        aimLayout = aim.getAimLayout();
        console.println(aimLayout);
        console.println("\nAim left stub");
    }

    private void aimRight() {
        
        aim.aimRight();
        aimLayout = aim.getAimLayout();
        console.println(aimLayout);
        console.println("\nAim right stub");
    }

    private void fire() {
    FireTorpedoView torpedo = new  FireTorpedoView();
    torpedo.display();
        
    }
    
}
