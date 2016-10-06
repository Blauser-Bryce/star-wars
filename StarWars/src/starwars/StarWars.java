/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starwars;


import byui.cit260.starWars.model.Item;
import byui.cit260.starWars.model.Location;
import byui.cit260.starWars.model.Map;
import byui.cit260.starWars.model.Menu;
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
        
        Menu menulist = new Menu();
        
            menulist.setHelp("help menu");
            menulist.setSave("would you like to save game");
            menulist.setQuit("Give UP?");
        
            String menuInfo = menulist.toString();
        
            System.out.println(menuInfo);
        
         Map newMap = new Map();
         
            newMap.setRowCount("A");
            newMap.setColumCount("1");
            
            String gameMap = newMap.toString();
            
            System.out.println(gameMap);
            
         Item shipItems = new Item();
         
         
            shipItems.setType("laser");
            shipItems.setQuantity("l0");
            
            String weapons = shipItems.toString();
            
            System.out.println(weapons);
            
         Location shipLocation = new Location();
         
            shipLocation.setRow("y");
            shipLocation.setColumn("3");
            shipLocation.setStatus("DogFight");
            
            String ship = shipLocation.toString();
            
            System.out.println(ship);
         
            
            
       
        
        
        
    }
    
}
