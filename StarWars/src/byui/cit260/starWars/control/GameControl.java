/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.control;

import byui.cit260.starWars.model.Game;
import byui.cit260.starWars.model.Item;
import byui.cit260.starWars.model.Map;
import byui.cit260.starWars.model.Player;
import static byui.cit260.starWars.model.Item.itemType.Flare;
import static byui.cit260.starWars.model.Item.itemType.Missile;
import static byui.cit260.starWars.model.Item.itemType.Torpedo;
import byui.cit260.starWars.model.Location;
import byui.cit260.starWars.model.Scene;
import byui.cit260.starWars.model.Scene.SceneType;
import starwars.StarWars;

/**
 *
 * @author Bryce Blauser
 */
public class GameControl {

    private static Player player;

   
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
        
        Game game = new Game(); // Create new game
        StarWars.setCurrentGame(game); // Save in StarWars
        
        game.setPlayer(player); // save player in game
        
        // create the inventory list and save in the game
        Item[] inventoryList = GameControl.createInventoryList();
        game.setInventory(inventoryList);
        
        Map map = new Map(); 
        map = map.createMap();  // Create and initialize the map
        game.setMap(map);
                
        MapControl.moveActorsToStartingLocation(map);
        
    }

    public static Item[] createItemList() {
        System.out.println("*** called createItemList() in GameControl ***");
        return null;
    }

    private static Item[] createInventoryList() {
        
        // created array(list) of inventory items
        Item[] inventory = new Item[3];
        
        Item missiles = new Item();
        missiles.setType(Missile);
        missiles.setQuantity(0);
        inventory[Item.itemType.Missile.ordinal()] = missiles;
        
        Item torpedos = new Item();
        torpedos.setType(Torpedo);
        torpedos.setQuantity(0);
        inventory[Item.itemType.Torpedo.ordinal()] = torpedos;
                
        Item flares = new Item();
        flares.setType(Flare);
        flares.setQuantity(0);
        inventory[Item.itemType.Flare.ordinal()] = flares;
        
        return inventory;
        
    }

    public static void assignScenesToLocation(Map map, Scene[] scenes) {
        
        Location[][] locations = map.getLocations();
        
        //start point
        locations[0][1].setScene(scenes[SceneType.rebelTransportShip.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.yavin4.ordinal()]);
        locations[0][3].setScene(scenes[SceneType.rebelBaseCommandCenter.ordinal()]);
        locations[0][4].setScene(scenes[SceneType.rebelBaseHanger.ordinal()]);
        locations[0][5].setScene(scenes[SceneType.openSpace.ordinal()]);
        locations[1][0].setScene(scenes[SceneType.deepSpaceBattleLocation.ordinal()]);
        locations[2][0].setScene(scenes[SceneType.deepSpaceRetreatLocation.ordinal()]);
        locations[3][0].setScene(scenes[SceneType.DeathStar.ordinal()]);
        locations[4][0].setScene(scenes[SceneType.deathStarFighterEngagement.ordinal()]);
        locations[5][0].setScene(scenes[SceneType.quadrant1.ordinal()]);
        locations[1][5].setScene(scenes[SceneType.quadrant2.ordinal()]);
        locations[2][4].setScene(scenes[SceneType.quadrant3.ordinal()]);
        locations[3][3].setScene(scenes[SceneType.quadrant4.ordinal()]);
        locations[4][2].setScene(scenes[SceneType.deathStarTrench.ordinal()]);
        locations[5][1].setScene(scenes[SceneType.trenchEntrance.ordinal()]);
        locations[10][1].setScene(scenes[SceneType.trenchBattleLocation.ordinal()]);
        locations[11][2].setScene(scenes[SceneType.trenchExit.ordinal()]);
        locations[12][3].setScene(scenes[SceneType.deathStarExhaustPort.ordinal()]);
        locations[13][4].setScene(scenes[SceneType.deathStarRetreatLocation.ordinal()]);
        locations[14][5].setScene(scenes[SceneType.turboLaserBatteries.ordinal()]);
        locations[15][6].setScene(scenes[SceneType.deflectorShieldGenerators.ordinal()]);
        locations[16][7].setScene(scenes[SceneType.enemyFighters.ordinal()]);
        locations[17][8].setScene(scenes[SceneType.friendlyFighters.ordinal()]);
        locations[18][9].setScene(scenes[SceneType.supplyShip.ordinal()]);
        locations[19][10].setScene(scenes[SceneType.repairShip.ordinal()]);
    }
   
 }
