/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

import byui.cit260.starWars.model.Aim;
import byui.cit260.starWars.model.Player;
import starwars.StarWars;

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
                console.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }


    private void damageTurboLaser() {
                        
        Aim aim = new Aim();
        console.println(aim.drawLayout());
        
        AimView aimView = new AimView();
        aimView.display();
    }
    
    private void evasiveManeuver() {
        console.println("*** Evasive Maneuver called ***");
    }       




}
      
            
        
       
 
     


    



   

        
