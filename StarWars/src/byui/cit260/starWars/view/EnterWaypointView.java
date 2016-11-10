/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

/**
 *
 * @author Bryce Blauser
 */
public class EnterWaypointView extends View {
    
    public EnterWaypointView() {
        super ("-------------------------------------------"
                + "\n| Enter Waypoint                            |"
                + "\n-------------------------------------------"
                + "\n  Supply Ship (3P)"
                + "\n-------------------------------------------\n");
    }
    
    @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase(); // converto to upper
        
        switch (value) {
            case "3P":  // Move to Supply Ship
                this.moveToSupplyShip();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
        }

        return false;
    }
    
    
    private void moveToSupplyShip() {
        SupplyShipView supplyView = new SupplyShipView();
        supplyView.display();
    }
}
