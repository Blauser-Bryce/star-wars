/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

/**
 *
 * @author Edvaldo Melo
 
public class EvasiveManeuver extends View {
    
    private String menu;
    MainMenuView mainMenu = new MainMenuView();
    
    public EvasiveManeuver() {
        super ("\n"
                + "\n--------------------------------"
                + "\n| Game Menu                    |"
                + "\n--------------------------------"
                + "\nU - Evade Up"
                + "\nD - Evade Down"
                + "\nR - Evade Right"
                + "\nL - Evade Left"
                + "\nX - Exit Evade Menu"
                + "\n--------------------------------");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); // convert to upper
    }
}
*/