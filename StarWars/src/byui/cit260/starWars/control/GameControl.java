/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.control;

import byui.cit260.starWars.model.Player;
import starwars.StarWars;

/**
 *
 * @author Bryce Blauser
 */
public class GameControl {

   
    public static Player createPlayer(String name) {
        
        if (name == null) {
            return null;
        }
        
        Player player = new Player();
        player.setName(name);
        
        StarWars.setPlayer(player); // save the player
        
        return player;
    }

    public static void createNewGame(Player name) {
       
    }
  
}
