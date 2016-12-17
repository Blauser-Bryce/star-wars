/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

/**
 *
 * @author Edvaldo Melo
 */
public class AttackTieFighter extends View {
    MainMenuView mainMenu = new MainMenuView();
    private String menu;
    
    public AttackTieFighter() {
        super("\n"
                + "\n--------------------------------------------------"
                + "\n        You Have Encountered a Tie Fighter        "
                + "\nT       Fire Torpedo                              "
                + "\nE       Evasive Maneuver                          "
                + "\nX       Exit                                      "
                + "\n--------------------------------------------------");          
    }
    
    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); // converto to upper
        
        switch (value) {
            case "T": // Fire Torpedo
                this.damageTieFighter();
                break;
            case "E": // Evasive Maneuver
                this.evasiveManeuver();
                break;
            default:
                console.println("\n*** Invalid selection. *** Try again.");
                break;
        }
        
        return false;
    }

    private int damageTieFighter() {
        
        int location = 2;//test turbo Laser location
        int target = 2;// test target location
        int health = 100;// test health
        int missile = 100;// test 
        int damage = 30;// test damage done
        double amplifier = 1.5; //test amplifier
        double amount = 30;// test amount
        
        while (missile > 0)
            missile --;
        if (location == target && health >= 1) {
            health =- damage;
            console.println("*** Damage Tie Fighter. ***" + health + "health remaining");
            return health;
        }
        
        else if (location == target && health <= 0) {
            console.println("Tie Fighter Destroyed.");
        }
        
        else
            console.println("Miss");
            return health;
    }

    private void evasiveManeuver() {
        console.println("*** Evasive Maneuver Called. ***");
    }
}
