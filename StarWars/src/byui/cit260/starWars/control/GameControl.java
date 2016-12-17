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
import byui.cit260.starWars.model.Location.locationStatus;
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
        EnemyFighter[] enemyFighterList = GameControl.createEnemyFighter();
        game.setEnemyFighter(enemyFighterList);
        
        Map map = new Map(); 
        map = map.createMap();  // Create and initialize the map
        game.setMap(map);
       
        // Move player to location
        Location location = map.getLocations()[0][0];
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

    private static EnemyFighter[] createEnemyFighter() {
        
        EnemyFighter[] enemyFighter = new EnemyFighter[35];
        
        // Populate the tie fighter
        for (int i = 0; i < 11; i++) {
            // Create default tie fighter
            EnemyFighter tieFighter = new EnemyFighter();
            Location location = new Location();
            location.setStatus(locationStatus.unlocked);
            location.setRow(4);
            location.setColumn(10);
            tieFighter.setTargetType(EnemyFighter.targetType.tieFighter);
            tieFighter.setTargetHealth(EnemyFighter.targetType.tieFighter.getDefaultHealth());
            tieFighter.setTargetShield(100);
            tieFighter.setTargetLocation(location);
            tieFighter.setTargetName("Tie Fighter " + (i + 1));
            enemyFighter[i] = tieFighter;
        }
        
        for (int i = 11; i < 17; i++) {
            // Create default tie interceptor
            EnemyFighter tieFighter = new EnemyFighter();
            Location location = new Location();
            location.setStatus(locationStatus.locked);
            location.setRow(7);
            location.setColumn(8);
            // Populate the tie interceptors
            tieFighter.setTargetType(EnemyFighter.targetType.tieInterceptor);
            tieFighter.setTargetHealth(EnemyFighter.targetType.tieInterceptor.getDefaultHealth());
            tieFighter.setTargetShield(100);
            tieFighter.setTargetLocation(location);
            tieFighter.setTargetName("Tie Interceptor " + (i - 10));
            enemyFighter[i] = tieFighter;
        }
        
        for (int i = 17; i < 19; i++) {
            // Create default tie interceptor
            EnemyFighter tieFighter = new EnemyFighter();
            Location location = new Location();
            location.setStatus(locationStatus.locked);
            location.setRow(11);
            location.setColumn(10);
            // Populate the tie interceptors
            tieFighter.setTargetType(EnemyFighter.targetType.tieInterceptor);
            tieFighter.setTargetHealth(EnemyFighter.targetType.tieInterceptor.getDefaultHealth());
            tieFighter.setTargetShield(100);
            tieFighter.setTargetLocation(location);
            tieFighter.setTargetName("Tie Interceptor " + (i - 10));
            enemyFighter[i] = tieFighter;
        }
        
        // Create Darth Vader fighter
        Location location = new Location();
        location.setStatus(locationStatus.locked);
        location.setRow(11);
        location.setColumn(10);
        EnemyFighter darthVader = new EnemyFighter();
        darthVader.setTargetType(EnemyFighter.targetType.darthVader);
        darthVader.setTargetHealth(EnemyFighter.targetType.darthVader.getDefaultHealth());
        darthVader.setTargetShield(100);
        darthVader.setTargetLocation(location);
        darthVader.setTargetName("Darth Vader");
        
        enemyFighter[19] = darthVader;
        
        // Populate the turbo laser
        for (int i = 20; i < 24; i++) {
            Location locationTL = new Location();
            locationTL.setStatus(locationStatus.unlocked);
            locationTL.setRow(10);
            locationTL.setColumn(10);
            locationTL.setStatus(locationStatus.unlocked);
            EnemyFighter turboLaser = new EnemyFighter();
            turboLaser.setTargetType(EnemyFighter.targetType.turboLaser);
            turboLaser.setTargetHealth(EnemyFighter.targetType.turboLaser.getDefaultHealth());
            turboLaser.setTargetShield(100);
            turboLaser.setTargetLocation(locationTL);
            turboLaser.setTargetName("Turbo Laser " + (i - 19));
            enemyFighter[i] = turboLaser;
        }
          
        // Populate the Deflector Shield
        for (int i = 24; i < 34; i++) {
            Location locationDS = new Location();
            switch(i){
                case 24:
                case 25:
                    locationDS.setRow(8);
                    locationDS.setColumn(5);
                    break;
                case 26:
                case 27:
                    locationDS.setRow(8);
                    locationDS.setColumn(11);
                    break;
                case 28:
                case 29:
                    locationDS.setRow(14);
                    locationDS.setColumn(5);
                    break;
                case 30:
                case 31:
                    locationDS.setRow(14);
                    locationDS.setColumn(11);
                    break;
                case 32:
                case 33:
                    locationDS.setRow(13);
                    locationDS.setColumn(10);
                    break;
            }
            
            locationDS.setStatus(locationStatus.unlocked);
            EnemyFighter deflectorShield = new EnemyFighter();
            deflectorShield.setTargetType(EnemyFighter.targetType.deflectorShield);
            deflectorShield.setTargetHealth(EnemyFighter.targetType.deflectorShield.getDefaultHealth());
            deflectorShield.setTargetShield(100);
            deflectorShield.setTargetLocation(locationDS);
            deflectorShield.setTargetName("Defelector Shield " + (i - 23));
            enemyFighter[i] = deflectorShield;
        }
        
        // Create Exhaust port
        Location locationEP = new Location();
        locationEP.setStatus(locationStatus.locked);
        locationEP.setRow(11);
        locationEP.setColumn(8);
        locationEP.setStatus(locationStatus.locked);
        EnemyFighter exhaustPort = new EnemyFighter();
        exhaustPort.setTargetType(EnemyFighter.targetType.exhaustPort);
        exhaustPort.setTargetHealth(EnemyFighter.targetType.exhaustPort.getDefaultHealth());
        exhaustPort.setTargetShield(0);
        exhaustPort.setTargetLocation(locationEP);
        exhaustPort.setTargetName("Exhaust Port");
        
        enemyFighter[34] = exhaustPort;
        
        return enemyFighter;
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
        locations[0][0].setScene(scenes[SceneType.rebelTransportShip.ordinal()]);
        locations[2][1].setScene(scenes[SceneType.yavin4.ordinal()]);
        locations[3][1].setScene(scenes[SceneType.rebelBaseCommandCenter.ordinal()]);
        locations[3][2].setScene(scenes[SceneType.rebelBaseHanger.ordinal()]);
        locations[3][14].setScene(scenes[SceneType.openSpace.ordinal()]);
        locations[4][9].setScene(scenes[SceneType.deepSpaceBattleLocation.ordinal()]);
        locations[4][8].setScene(scenes[SceneType.deepSpaceRetreatLocation.ordinal()]);
        locations[11][4].setScene(scenes[SceneType.DeathStar.ordinal()]);
        locations[7][8].setScene(scenes[SceneType.deathStarFighterEngagement.ordinal()]);
        locations[8][5].setScene(scenes[SceneType.quadrant1.ordinal()]);
        locations[8][11].setScene(scenes[SceneType.quadrant2.ordinal()]);
        locations[14][5].setScene(scenes[SceneType.quadrant3.ordinal()]);
        locations[14][11].setScene(scenes[SceneType.quadrant4.ordinal()]);
        
        // Locations are locked until deflector shields are destroyed
        locations[11][11].setScene(scenes[SceneType.deathStarTrench.ordinal()]);
            locations[11][11].setStatus(locationStatus.locked); // Lock until all deflector shields are destroyed
        locations[11][12].setScene(scenes[SceneType.trenchEntrance.ordinal()]);
            locations[11][12].setStatus(locationStatus.locked); // Lock until all deflector shields are destroyed
        locations[11][10].setScene(scenes[SceneType.trenchBattleLocation.ordinal()]);
            locations[11][10].setStatus(locationStatus.locked); // Lock until all deflector shields are destroyed
        locations[11][7].setScene(scenes[SceneType.trenchExit.ordinal()]);
            locations[11][7].setStatus(locationStatus.locked); // Lock until all deflector shields are destroyed
        locations[11][8].setScene(scenes[SceneType.deathStarExhaustPort.ordinal()]);
            locations[11][8].setStatus(locationStatus.locked); // Lock until all deflector shields are destroyed
        
        locations[15][8].setScene(scenes[SceneType.deathStarRetreatLocation.ordinal()]);
        locations[10][10].setScene(scenes[SceneType.turboLaserBatteries.ordinal()]);
        locations[13][10].setScene(scenes[SceneType.deflectorShieldGenerators.ordinal()]);
        locations[4][10].setScene(scenes[SceneType.enemyFighter.ordinal()]);
        locations[3][8].setScene(scenes[SceneType.friendlyFighters.ordinal()]);
        locations[5][6].setScene(scenes[SceneType.supplyShip.ordinal()]);
        locations[5][5].setScene(scenes[SceneType.repairShip.ordinal()]);
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
