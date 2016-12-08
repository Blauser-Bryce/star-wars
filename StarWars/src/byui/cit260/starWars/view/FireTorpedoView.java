/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

import byui.cit260.starWars.control.TargetControl;
import byui.cit260.starWars.model.Target;

/**
 *
 * @author gmoser
 */
public class FireTorpedoView extends View {

    MainMenuView mainMenu = new MainMenuView();
    private String menu;
    
    public FireTorpedoView () {

        super("\n"
                + "\n-------------------------------------------"
                + "\n|         Torpedo Fired !!!!!             |"
                + "\n-------------------------------------------"
                + "\n|                                         |"
                + "\n|                             ,:          |"
                + "\n|                           ,' |          |"
                + "\n|                          /   :          |"
                + "\n|                         '   /           |"
                + "\n|                        /   /            |"
                + "\n|                       /   /             |"
                + "\n|                      /   /              |"
                + "\n|                     /   /)'-.           |"
                + "\n|                  ./_|__/_|              |"
                + "\n|                   ( |**|                |"      
                + "\n|                 ( (.   )8:              |"
                + "\n|               .'    / (_  )             |"
                + "\n|             _. :(.   )8P  `             |"
                + "\n|_________________________________________|"
                + "\n|  F-  Fire another Torpedo               |"
                + "\n|  E-  Evade                              |"
                + "\n|  X-  Exit                               |"
                + "\n|_________________________________________|");
    }

    @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase(); // converto to upper
        
        switch (value) {
            case "F": // fire
               this.FireTorpedo();
               break;
            case "E": // evasive
               this.Evasive();
               break;
        default:
               console.println("\n*** Invalid selection *** Try again");
        break;
        }
        
        return false;
    }
    private void FireTorpedo () {
        Target target = new Target();
        double amplifier = 1.5;
        double amount = 30;
  
        TargetControl instance = new TargetControl();
        
        String result = instance.applyDamage(target, amplifier, amount);
        console.println(result);
    }
    
    private void Evasive () {
    console.println("\n stub for evasive");
        
    }

   
}

