/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starwars;

import byui.cit260.starWars.model.Player;

/**
 *
 * @author Bryce Blauser
 */
public class StarWars {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player currentPlayer = new Player();
        
        
        currentPlayer.setName("Test McTesterson");
        currentPlayer.setCoordinates("A,1");
        
        String playerInfo = currentPlayer.toString();
        
        System.out.println(playerInfo);
        
    }
    
}
