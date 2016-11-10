/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

import byui.cit260.starWars.control.TargetControl;
import byui.cit260.starWars.model.Target;
import java.util.Scanner;

/**
 *
 * @author gmoser
 */
public class AttackTurboLaser extends View {
    MainMenuView mainMenu = new MainMenuView();
    private String menu;
    
    public AttackTurboLaser() {
        super("\n"
                + "\n----------------------------------"                  
                + "\n     +'     :'`                   " 
                + "\n      ;+.    '':.                 " 
                + "\n       ;';:.:,+';`::.,:           " 
                + "\n         +#;;;:'+';::;;;;;        "  
                + "\n        '+'+'''+'':;;;;;+;;`      " 
                + "\n       ''++++''+++'';;;+;;;,      " 
                + "\n        ;'++++''++++;;;;+;'':     " 
                + "\n        ;''#+'''+'+';;;;'+'+;     " 
                + "\n       `'''''''''''';;;;;''+;     " 
                + "\n      ,';'''';''''';;;;;';';      " 
                + "\n       ;'';''''''';;';;;;''';     " 
                + "\n       ;;;;;''';'';;;;;;;;++'     " 
                + "\n       ;';;;'''';';;'';;;;'';     "
                + "\n----------------------------------"
                + "\nYou Have Encountered A Turbo Laser"
                + "\nT - Fire Missile                  "
                + "\nE - Evasive Maneuver              "
                + "\nX - Exit                          "
                + "\n----------------------------------");
        
    }
    
   
    @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase(); // converto to upper
        
        switch (value) {
            case "T": // Fire Torpedo
                this.damageTurboLaser();
                break;
            case "E": // Evasive maneuver
                this.evasiveManeuver();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }


    private int damageTurboLaser() {
        
        int location = 2;//test turbo Laser location
        int target = 2;// test target location
        int health = 100;// test health
        int missile = 100;// test 
        int damage = 30;// test damage done
        double amplifier = 1.5; //test amplifier
        double amount = 30;// test amount
        
     while (missile > 0) 
        missile --; 
         if (location==target && health >= 1) {       
        health =- damage; 
        System.out.println("*** damage Turbo laser***" + health + "health remaining");    
        return health;
        }
        
        
       else if  (location == target && health <= 0)  {
            System.out.println("turbo laser destroyed");
       
       }        
       else 
          System.out.println("miss");
        
     
    return health; 
    }
       private void evasiveManeuver() {
        System.out.println("*** Evasive Maneuver called ***");
    }       




}
      
            
        
       
 
     


    



   

        
