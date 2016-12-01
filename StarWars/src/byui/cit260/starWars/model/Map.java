/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.model;

import byui.cit260.starWars.control.GameControl;
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
                location.setStatus("initialized");
                
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
        rebelTransportShip.setDescription("Description ... ");
        rebelTransportShip.setDisplaySymbol("RT");
        rebelTransportShip.setTravelTime(100);
        scenes[SceneType.rebelTransportShip.ordinal()] = rebelTransportShip;
        
        Scene yavin4 = new Scene();
        yavin4.setDescription("Description ... ");
        yavin4.setDisplaySymbol("Y4");
        yavin4.setTravelTime(100);
        scenes[SceneType.yavin4.ordinal()] = yavin4;
        
        Scene rebelBaseCommandCenter = new Scene();
        rebelBaseCommandCenter.setDescription("Description ... ");
        rebelBaseCommandCenter.setDisplaySymbol("RB");
        rebelBaseCommandCenter.setTravelTime(100);
        scenes[SceneType.rebelBaseCommandCenter.ordinal()] = rebelBaseCommandCenter;
        
        Scene rebelBaseHanger = new Scene();
        rebelBaseHanger.setDescription("Description ... ");
        rebelBaseHanger.setDisplaySymbol("BH");
        rebelBaseHanger.setTravelTime(100);
        scenes[SceneType.rebelBaseHanger.ordinal()] = rebelBaseHanger;
        
        Scene openSpace = new Scene();
        openSpace.setDescription("Description ... ");
        openSpace.setDisplaySymbol("OS");
        openSpace.setTravelTime(100);
        scenes[SceneType.openSpace.ordinal()] = openSpace;
        
        Scene deepSpaceBattleLocation = new Scene();
        deepSpaceBattleLocation.setDescription("Description ... ");
        deepSpaceBattleLocation.setDisplaySymbol("BL");
        deepSpaceBattleLocation.setTravelTime(100);
        scenes[SceneType.deepSpaceBattleLocation.ordinal()] = deepSpaceBattleLocation;
        
        Scene deepSpaceRetreatLocation = new Scene();
        deepSpaceRetreatLocation.setDescription("Description ... ");
        deepSpaceRetreatLocation.setDisplaySymbol("RL");
        deepSpaceRetreatLocation.setTravelTime(100);
        scenes[SceneType.deepSpaceRetreatLocation.ordinal()] = deepSpaceRetreatLocation;
        
        Scene DeathStar = new Scene();
        DeathStar.setDescription("Description ... ");
        DeathStar.setDisplaySymbol("DS");
        DeathStar.setTravelTime(100);
        scenes[SceneType.DeathStar.ordinal()] = DeathStar;
        
        Scene deathStarFighterEngagement = new Scene();
        deathStarFighterEngagement.setDescription("Description ... ");
        deathStarFighterEngagement.setDisplaySymbol("FE");
        deathStarFighterEngagement.setTravelTime(100);
        scenes[SceneType.deathStarFighterEngagement.ordinal()] = deathStarFighterEngagement;
        
        Scene quadrant1 = new Scene();
        quadrant1.setDescription("Description ... ");
        quadrant1.setDisplaySymbol("Q1");
        quadrant1.setTravelTime(100);
        scenes[SceneType.quadrant1.ordinal()] = quadrant1;
        
        Scene quadrant2 = new Scene();
        quadrant2.setDescription("Description ... ");
        quadrant2.setDisplaySymbol("Q2");
        quadrant2.setTravelTime(100);
        scenes[SceneType.quadrant2.ordinal()] = quadrant2;
        
        Scene quadrant3 = new Scene();
        quadrant3.setDescription("Description ... ");
        quadrant3.setDisplaySymbol("Q3");
        quadrant3.setTravelTime(100);
        scenes[SceneType.quadrant3.ordinal()] = quadrant3;
        
        Scene quadrant4 = new Scene();
        quadrant4.setDescription("Description ... ");
        quadrant4.setDisplaySymbol("Q4");
        quadrant4.setTravelTime(100);
        scenes[SceneType.quadrant4.ordinal()] = quadrant4;
        
        Scene deathStarTrench = new Scene();
        deathStarTrench.setDescription("Description ... ");
        deathStarTrench.setDisplaySymbol("TR");
        deathStarTrench.setTravelTime(100);
        scenes[SceneType.deathStarTrench.ordinal()] = deathStarTrench;
        
        Scene trenchEntrance = new Scene();
        trenchEntrance.setDescription("Description ... ");
        trenchEntrance.setDisplaySymbol("TE");
        trenchEntrance.setTravelTime(100);
        scenes[SceneType.trenchEntrance.ordinal()] = trenchEntrance;
        
        Scene trenchBattleLocation = new Scene();
        trenchBattleLocation.setDescription("Description ... ");
        trenchBattleLocation.setDisplaySymbol("TB");
        trenchBattleLocation.setTravelTime(100);
        scenes[SceneType.trenchBattleLocation.ordinal()] = trenchBattleLocation;
        
        Scene trenchExit = new Scene();
        trenchExit.setDescription("Description ... ");
        trenchExit.setDisplaySymbol("TX");
        trenchExit.setTravelTime(100);
        scenes[SceneType.trenchExit.ordinal()] = trenchExit;
        
        Scene deathStarExhaustPort = new Scene();
        deathStarExhaustPort.setDescription("Description ... ");
        deathStarExhaustPort.setDisplaySymbol("EP");
        deathStarExhaustPort.setTravelTime(100);
        scenes[SceneType.deathStarExhaustPort.ordinal()] = deathStarExhaustPort;
        
        Scene deathStarRetreatLocation = new Scene();
        deathStarRetreatLocation.setDescription("Description ... ");
        deathStarRetreatLocation.setDisplaySymbol("DR");
        deathStarRetreatLocation.setTravelTime(100);
        scenes[SceneType.deathStarRetreatLocation.ordinal()] = deathStarRetreatLocation;
        
        Scene turboLaserBatteries = new Scene();
        turboLaserBatteries.setDescription("Description ... ");
        turboLaserBatteries.setDisplaySymbol("TL");
        turboLaserBatteries.setTravelTime(100);
        scenes[SceneType.turboLaserBatteries.ordinal()] = turboLaserBatteries;
        
        Scene deflectorShieldGenerators = new Scene();
        deflectorShieldGenerators.setDescription("Description ... ");
        deflectorShieldGenerators.setDisplaySymbol("SG");
        deflectorShieldGenerators.setTravelTime(100);
        scenes[SceneType.deflectorShieldGenerators.ordinal()] = deflectorShieldGenerators;
        
        Scene enemyFighters = new Scene();
        enemyFighters.setDescription("Description ... ");
        enemyFighters.setDisplaySymbol("EF");
        enemyFighters.setTravelTime(100);
        scenes[SceneType.enemyFighters.ordinal()] = enemyFighters;
        
        Scene friendlyFighters = new Scene();
        friendlyFighters.setDescription("Description ... ");
        friendlyFighters.setDisplaySymbol("FF");
        friendlyFighters.setTravelTime(100);
        scenes[SceneType.friendlyFighters.ordinal()] = friendlyFighters;
        
        Scene supplyShip = new Scene();
        supplyShip.setDescription("Description ... ");
        supplyShip.setDisplaySymbol("SS");
        supplyShip.setTravelTime(100);
        scenes[SceneType.supplyShip.ordinal()] = supplyShip;
        
        Scene repairShip = new Scene();
        repairShip.setDescription("Description ... ");
        repairShip.setDisplaySymbol("RS");
        repairShip.setTravelTime(100);
        scenes[SceneType.repairShip.ordinal()] = repairShip;
        
        return scenes;
    }
    
    public void displayMap(Map map) {
                        
        Location location = new Location();
        
        String line;
        
        console.println("                       Star Wars Map ");
        console.println("    0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19");
        console.println("  -------------------------------------------------------------");
                
        location = map.locations[0][0];
        console.println(location.getScene().getDisplaySymbol());
        for (int row = 0; row < map.getNoOfRows(); row++) {
            line = String.valueOf(row); 
            if (row < 10) line += " ";
            for (int column = 0; column < map.getNoOfColumns(); column++) {
                location = map.locations[row][column];
                line += "|" + location.getScene().getDisplaySymbol();
            }
            console.println(line + "|");
        }
        console.println("-------------------------------------------------------------");
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
   
}
