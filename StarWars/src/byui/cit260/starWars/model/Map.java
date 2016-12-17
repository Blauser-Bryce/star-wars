/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.model;

import byui.cit260.starWars.control.GameControl;
import byui.cit260.starWars.model.Location.locationStatus;
import byui.cit260.starWars.model.Scene.SceneType;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Objects;
import starwars.StarWars;

/**
 *
 * @author gmoser
 */
public class Map implements Serializable{

    private static final PrintWriter console = StarWars.getOutFile();
    
    private int noOfRows;
    private int noOfColumns;
    private Location[][] locations;
    
    public int getNoOfRows() {
        return noOfRows;
    }

    public void setNoOfRows(int noOfRows) {
        this.noOfRows = noOfRows;
    }

    public int getNoOfColumns() {
        return noOfColumns;
    }

    //private String mapLayout;
    public void setNoOfColumns(int noOfColumns) {    
        this.noOfColumns = noOfColumns;
    }

    public Map() {
    }

    public Map createMap() {        
        // Create the map
        Map map = new Map(20, 20);
        
        // Create the scenes
        Scene[] scenes = createScenes();
        
        // assign scenes to location
        GameControl.assignScenesToLocation(map, scenes);
        
        return map;
        
    }

    public Map(int noOfRows, int noOfColumns) {
        if (noOfRows < 1 || noOfColumns < 1) {
            console.println("The number of rows and columns must be > zero");
            return;
        }
        
        this.noOfRows = noOfRows;
        this.noOfColumns = noOfColumns;
        
        // Create 2-D array for location objects
        this.locations = new Location[noOfRows][noOfColumns];
        
        for (int row = 0; row < noOfRows; row++) {
            for (int column = 0; column < noOfColumns; column++) {
                // create and initialize new location object instance
                Scene scene = new Scene();
                Location location = new Location();
                location.setColumn(column);
                location.setRow(row);
                location.setScene(scene);
                location.setStatus(locationStatus.unlocked);
                
                // assign the location object to the current position in the array
                locations[row][column] = location;
            }
        }
        
    }
    
    public Location[][] getLocations() {
        return locations;
    }
    
    private static Scene[] createScenes() {
        
        console.println("\n *** Creating Scenes ***");
        
        Scene[] scenes = new Scene[SceneType.values().length];
        
        Scene rebelTransportShip = new Scene();
        rebelTransportShip.setDescription("You have entered the rebel transport ship location...");
        rebelTransportShip.setDisplaySymbol("RT");
        rebelTransportShip.setTravelTime(100);
        rebelTransportShip.setSceneType(SceneType.rebelTransportShip);
        scenes[SceneType.rebelTransportShip.ordinal()] = rebelTransportShip;
        
        Scene yavin4 = new Scene();
        yavin4.setDescription("You have landed on Yavin 4.  Stay awhile and enjoy the scenary.");
        yavin4.setDisplaySymbol("Y4");
        yavin4.setTravelTime(100);
        yavin4.setSceneType(SceneType.yavin4);
        scenes[SceneType.yavin4.ordinal()] = yavin4;
        
        Scene rebelBaseCommandCenter = new Scene();
        rebelBaseCommandCenter.setDescription("You have entered the Rebel Base Command Center.\nThis will be a good place to plan your attack.");
        rebelBaseCommandCenter.setDisplaySymbol("RB");
        rebelBaseCommandCenter.setTravelTime(100);
        rebelBaseCommandCenter.setSceneType(SceneType.rebelBaseCommandCenter);
        scenes[SceneType.rebelBaseCommandCenter.ordinal()] = rebelBaseCommandCenter;
        
        Scene rebelBaseHanger = new Scene();
        rebelBaseHanger.setDescription("You have entered the Rebel Base Hanger.  Make sure you're ready to leave.");
        rebelBaseHanger.setDisplaySymbol("BH");
        rebelBaseHanger.setTravelTime(100);
        rebelBaseHanger.setSceneType(SceneType.rebelBaseHanger);
        scenes[SceneType.rebelBaseHanger.ordinal()] = rebelBaseHanger;
        
        Scene openSpace = new Scene();
        openSpace.setDescription("Not much here except a lot of nothing...");
        openSpace.setDisplaySymbol("OS");
        openSpace.setTravelTime(100);
        openSpace.setSceneType(SceneType.openSpace);
        scenes[SceneType.openSpace.ordinal()] = openSpace;
        
        Scene deepSpaceBattleLocation = new Scene();
        deepSpaceBattleLocation.setDescription("You have entered what looks like a battle location.\nBe careful and watch your back.");
        deepSpaceBattleLocation.setDisplaySymbol("BL");
        deepSpaceBattleLocation.setTravelTime(100);
        deepSpaceBattleLocation.setSceneType(SceneType.deepSpaceBattleLocation);
        scenes[SceneType.deepSpaceBattleLocation.ordinal()] = deepSpaceBattleLocation;
        
        Scene deepSpaceRetreatLocation = new Scene();
        deepSpaceRetreatLocation.setDescription("This is a good place to get away from your enemies and re-evaluate your plan.");
        deepSpaceRetreatLocation.setDisplaySymbol("RL");
        deepSpaceRetreatLocation.setTravelTime(100);
        deepSpaceRetreatLocation.setSceneType(SceneType.deepSpaceRetreatLocation);
        scenes[SceneType.deepSpaceRetreatLocation.ordinal()] = deepSpaceRetreatLocation;
        
        Scene DeathStar = new Scene();
        DeathStar.setDescription("You are in range of the Death Star... definitely not a moon.");
        DeathStar.setDisplaySymbol("DS");
        DeathStar.setTravelTime(100);
        DeathStar.setSceneType(SceneType.DeathStar);
        scenes[SceneType.DeathStar.ordinal()] = DeathStar;
        
        Scene deathStarFighterEngagement = new Scene();
        deathStarFighterEngagement.setDescription("Watch your back, enemies are all around.");
        deathStarFighterEngagement.setDisplaySymbol("FE");
        deathStarFighterEngagement.setTravelTime(100);
        deathStarFighterEngagement.setSceneType(SceneType.deathStarFighterEngagement);
        scenes[SceneType.deathStarFighterEngagement.ordinal()] = deathStarFighterEngagement;
        
        Scene quadrant1 = new Scene();
        quadrant1.setDescription("You have entered Quandrant 1.\nTake out the deflector shields in this area to enter the trench.");
        quadrant1.setDisplaySymbol("Q1");
        quadrant1.setTravelTime(100);
        quadrant1.setSceneType(SceneType.quadrant1);
        scenes[SceneType.quadrant1.ordinal()] = quadrant1;
        
        Scene quadrant2 = new Scene();
        quadrant2.setDescription("You have entered Quandrant 2.\nTake out the deflector shields in this area to enter the trench.");
        quadrant2.setDisplaySymbol("Q2");
        quadrant2.setTravelTime(100);
        quadrant2.setSceneType(SceneType.quadrant2);
        scenes[SceneType.quadrant2.ordinal()] = quadrant2;
        
        Scene quadrant3 = new Scene();
        quadrant3.setDescription("You have entered Quandrant 3.\nTake out the deflector shields in this area to enter the trench.");
        quadrant3.setDisplaySymbol("Q3");
        quadrant3.setTravelTime(100);
        quadrant3.setSceneType(SceneType.quadrant3);
        scenes[SceneType.quadrant3.ordinal()] = quadrant3;
        
        Scene quadrant4 = new Scene();
        quadrant4.setDescription("You have entered Quandrant 4.\nTake out the deflector shields in this area to enter the trench.");
        quadrant4.setDisplaySymbol("Q4");
        quadrant4.setTravelTime(100);
        quadrant4.setSceneType(SceneType.quadrant4);
        scenes[SceneType.quadrant4.ordinal()] = quadrant4;
        
        Scene deathStarTrench = new Scene();
        deathStarTrench.setDescription("You have entered the trench area.\nFind the exhaust port.");
        deathStarTrench.setDisplaySymbol("TR");
        deathStarTrench.setTravelTime(100);
        deathStarTrench.setSceneType(SceneType.deathStarTrench);
        scenes[SceneType.deathStarTrench.ordinal()] = deathStarTrench;
        
        Scene trenchEntrance = new Scene();
        trenchEntrance.setDescription("Avoid turbo laser fire and stay focused.  The exhaust port is just up ahead.");
        trenchEntrance.setDisplaySymbol("TE");
        trenchEntrance.setTravelTime(100);
        trenchEntrance.setSceneType(SceneType.trenchEntrance);
        scenes[SceneType.trenchEntrance.ordinal()] = trenchEntrance;
        
        Scene trenchBattleLocation = new Scene();
        trenchBattleLocation.setDescription("Watch your back, enemies are closing in.");
        trenchBattleLocation.setDisplaySymbol("TB");
        trenchBattleLocation.setTravelTime(100);
        trenchBattleLocation.setSceneType(SceneType.trenchBattleLocation);
        scenes[SceneType.trenchBattleLocation.ordinal()] = trenchBattleLocation;
        
        Scene trenchExit = new Scene();
        trenchExit.setDescription("This is a good place to make your escape.");
        trenchExit.setDisplaySymbol("TX");
        trenchExit.setTravelTime(100);
        trenchExit.setSceneType(SceneType.trenchExit);
        scenes[SceneType.trenchExit.ordinal()] = trenchExit;
        
        Scene deathStarExhaustPort = new Scene();
        deathStarExhaustPort.setDescription("Hit the exhaust port and get out.");
        deathStarExhaustPort.setDisplaySymbol("EP");
        deathStarExhaustPort.setTravelTime(100);
        deathStarExhaustPort.setSceneType(SceneType.deathStarExhaustPort);
        scenes[SceneType.deathStarExhaustPort.ordinal()] = deathStarExhaustPort;
        
        Scene deathStarRetreatLocation = new Scene();
        deathStarRetreatLocation.setDescription("You have found a safe place to plan your attack.");
        deathStarRetreatLocation.setDisplaySymbol("DR");
        deathStarRetreatLocation.setTravelTime(100);
        deathStarRetreatLocation.setSceneType(SceneType.deepSpaceRetreatLocation);
        scenes[SceneType.deathStarRetreatLocation.ordinal()] = deathStarRetreatLocation;
        
        Scene turboLaserBatteries = new Scene();
        turboLaserBatteries.setDescription("Better try to avoid those Turbo Laser Battries or destroy them if you can.");
        turboLaserBatteries.setDisplaySymbol("TL");
        turboLaserBatteries.setTravelTime(100);
        turboLaserBatteries.setSceneType(SceneType.turboLaserBatteries);
        scenes[SceneType.turboLaserBatteries.ordinal()] = turboLaserBatteries;
        
        Scene deflectorShieldGenerators = new Scene();
        deflectorShieldGenerators.setDescription("Destroy the remaining Deflector Shields.");
        deflectorShieldGenerators.setDisplaySymbol("SG");
        deflectorShieldGenerators.setTravelTime(100);
        deflectorShieldGenerators.setSceneType(SceneType.deflectorShieldGenerators);
        scenes[SceneType.deflectorShieldGenerators.ordinal()] = deflectorShieldGenerators;
        
        Scene enemyFighters = new Scene();
        enemyFighters.setDescription("You found a hornets nest of enemy fighters.\nEither engage or flee.");
        enemyFighters.setDisplaySymbol("EF");
        enemyFighters.setTravelTime(100);
        enemyFighters.setSceneType(SceneType.enemyFighters);
        scenes[SceneType.enemyFighters.ordinal()] = enemyFighters;
        
        Scene friendlyFighters = new Scene();
        friendlyFighters.setDescription("You've regrouped with your squad, they've got your back.");
        friendlyFighters.setDisplaySymbol("FF");
        friendlyFighters.setTravelTime(100);
        friendlyFighters.setSceneType(SceneType.friendlyFighters);
        scenes[SceneType.friendlyFighters.ordinal()] = friendlyFighters;
        
        Scene supplyShip = new Scene();
        supplyShip.setDescription("Welcome to the supply ship.\nYou're going to need more ammo.");
        supplyShip.setDisplaySymbol("SS");
        supplyShip.setTravelTime(100);
        supplyShip.setSceneType(SceneType.supplyShip);
        scenes[SceneType.supplyShip.ordinal()] = supplyShip;
        
        Scene repairShip = new Scene();
        repairShip.setDescription("You've taken on some heavy damage.\nLet's get you fixed up so you can get back out there.");
        repairShip.setDisplaySymbol("RS");
        repairShip.setTravelTime(100);
        repairShip.setSceneType(SceneType.repairShip);
        scenes[SceneType.repairShip.ordinal()] = repairShip;
        
        return scenes;
    }
    
    public void displayMap(Map map) {
                        
        Location location = new Location();
        
        String line;
        
        console.println("                       Star Wars Map ");
        console.println("    0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19");
        console.println("  -------------------------------------------------------------");
        
        for (int row = 0; row < map.getNoOfRows(); row++) {
            line = String.valueOf(row); 
            if (row < 10) line += " ";
            for (int column = 0; column < map.getNoOfColumns(); column++) {
                location = map.locations[row][column];
                line += "|" + location.getScene().getDisplaySymbol();
            }
            console.println(line + "|");
        }
        console.println("  -------------------------------------------------------------");
    }    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.noOfRows);
        hash = 29 * hash + Objects.hashCode(this.noOfColumns);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Map other = (Map) obj;
        if (!Objects.equals(this.noOfRows, other.noOfRows)) {
            return false;
        }
        if (!Objects.equals(this.noOfColumns, other.noOfColumns)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Map{" + "rowCount=" + noOfRows + ", columCount=" + noOfColumns + '}';
    }    

    public Object getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getQuantity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
