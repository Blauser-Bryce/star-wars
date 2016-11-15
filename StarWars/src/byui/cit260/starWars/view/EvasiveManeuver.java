/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

/**
 *
 *@author Edvaldo Melo
 **/
 
public class EvasiveManeuver extends View {
    
    private String menu;
    MainMenuView mainMenu = new MainMenuView();
    
    public EvasiveManeuver() {
        super ("\n"
                + "\n--------------------------------"
                + "\nYou Are Under Attack!           "
                + "\nYou Are An Easy Target, Now!    "
                + "\nYou Are On Target!!!            "
                + "\nPrepare to Evasive Maneuver     "
                + "\n| Game Menu                    |"
                + "\n--------------------------------"
                + "\nU - Evade Up                    "
                + "\nD - Evade Down                  "
                + "\nR - Evade Right                 "
                + "\nL - Evade Left                  "
                + "\nX - Exit Evade Menu             "
                + "\n--------------------------------");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); // convert to upper
        
        switch (value) {
            case "U": // Prompt for Evade Up
                this.evadeUp();
                break;
            case "D": // Prompt for Evade Down
                this.evadeDown();
                break;
            case "R": // Prompt for Evade Right
                this.evadeRight();
                break;
            case "L": // Prompt for Evade Left
                this.evadeLeft();
                break;
            default:
                System.err.println("\n*** Invalid selection. *** Try again.");
        }
        return false;
    }

    private void evadeUp() {
        
    }

    private void evadeDown() {
    
    }

    private void evadeRight() {
    
    }

    private void evadeLeft() {
    
    }
}