/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.control;

import byui.cit260.starWars.model.EnemyFighter;
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
import byui.cit260.starWars.view.ErrorView;
import exceptions.GameControlException;
import exceptions.MapControlException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import starwars.StarWars;

/**
 *
 * @author Bryce Blauser
 */
public class GameControl {

    private Player player;
    private static final PrintWriter console = StarWars.getOutFile();
    
    public static Player createPlayer(String name) {
        
        if (name == null) {
            return null;
        }
        
        Player player = new Player();
        
        player.setName(name);
        
        StarWars.setPlayer(player); // save the player
        
        return player;
    }

    public static void createNewGame(Player player) {
        
        Game game = new Game(); // Create new game
        game.setPlayer(player); // save player in game
        StarWars.setCurrentGame(game); // Save in StarWars
        
        StarWars.setPlayer(player);
        
        // create the inventory list and save in the game
        Item[] inventoryList = GameControl.createInventoryList();
        game.setInventory(inventoryList);
        
        // create the enemy fighter list
        EnemyFighter[] enemyFighterList = GameControl.createEnemyFighters();
        game.setEnemyFighters(enemyFighterList);
        
        Map map = new Map(); 
        map = map.createMap();  // Create and initialize the map
        game.setMap(map);
       
        // Move player to location
        Location location = new Location();
        location.setColumn(10);
        location.setRow(10);
        try {
            PlayerControl.movePlayerToLocation(location);
        } catch (MapControlException me) {
            ErrorView.display("GameControl", me.getMessage());
        }
        
    }

    public static Item[] createItemList() {
        console.println("*** called createItemList() in GameControl ***");
        return null;
    }

    private static EnemyFighter[] createEnemyFighters() {
        
        EnemyFighter[] enemyFighters = new EnemyFighter[20];
        
        // Create default tie fighter
        EnemyFighter tieFighter = new EnemyFighter();
        Location location = new Location();
        location.setRow(0);
        location.setColumn(0);
        location.setStatus("Enemy Fighters Initialized Here");
        
        tieFighter.setTargetType(EnemyFighter.targetType.tieFighter);
        tieFighter.setTargetHealth(EnemyFighter.targetType.tieFighter.getDefaultHealth());
        tieFighter.setTargetShield(100);
        tieFighter.setTargetLocation(location);
        
        // Populate the tie fighters
        for (int i = 0; i < 11; i++) {
            tieFighter.setTargetName("Tie Fighter " + (i + 1));
            enemyFighters[i] = tieFighter;
        }
        
        // Populate the tie interceptors
        tieFighter.setTargetType(EnemyFighter.targetType.tieInterceptor);
        tieFighter.setTargetHealth(EnemyFighter.targetType.tieInterceptor.getDefaultHealth());
        for (int i = 11; i < 19; i++) {
            tieFighter.setTargetName("Tie Interceptor " + (i - 10));
            enemyFighters[i] = tieFighter;
        }
        
        // Create Darth Vader fighter
        EnemyFighter darthVader = new EnemyFighter();
        darthVader.setTargetType(EnemyFighter.targetType.darthVader);
        darthVader.setTargetHealth(EnemyFighter.targetType.darthVader.getDefaultHealth());
        darthVader.setTargetShield(100);
        darthVader.setTargetLocation(location);
        darthVader.setTargetName("Darth Vader");
        
        enemyFighters[19] = darthVader;
        
        return enemyFighters;
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

    public static void saveGame(Game game, String filePath) throws GameControlException {
        
        try( FileOutputStream fops = new FileOutputStream(filePath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            output.writeObject(game); // write the game object out to file
        } catch (Exception e) {
            throw new GameControlException(e.getMessage());
        }
    }

    public static void getSavedGame(String filepath) throws GameControlException {
        Game game = null;
        
        try( FileInputStream fips = new FileInputStream(filepath)) {
            ObjectInputStream input = new ObjectInputStream(fips);
            
            game = (Game) input.readObject(); // read the game object from file
        } catch (Exception e) {
            throw new GameControlException(e.getMessage());
        }
        
        // close the output file
        StarWars.setCurrentGame(game);
    }
   
 }
