/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.model;

import byui.cit260.starWars.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Bryce Blauser
 */
public class Scene implements Serializable{
    
    private String description;
    private int travelTime;
    private String displaySymbol;
    private SceneType type;
    
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        Scene.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        Scene.inFile = inFile;
    }
    
    public static void main(String[] args) throws IOException {
        try {
            //open character stream files for end user input and output
            starwars.StarWars.inFile = new BufferedReader(new InputStreamReader(System.in));
            starwars.StarWars.outFile = new PrintWriter(System.out, true);
            
            // open log file
            String filePath = "log.txt";
            starwars.StarWars.logFile = new PrintWriter(filePath);
            
            // create StartProgramView ans start the program
            StartProgramView startProgramView = new StartProgramView();
            startProgramView.display();
            return;
            
        } catch (Throwable e) {
            System.out.println("Exception: " + e.toString() + 
                               "\nCause: " + e.getCause() +
                               "\nMessage: " + e.getMessage());
            
            e.printStackTrace();;
        }
        
        finally {
            
            try {
                if (starwars.StarWars.inFile != null) starwars.StarWars.inFile.close();
                
                if (starwars.StarWars.outFile != null) starwars.StarWars.outFile.close();
                
                if (starwars.StarWars.logFile != null) starwars.StarWars.logFile.close();
                
            } catch (IOException ex) {
                System.out.println("Error closing files");
                return;
            }
        }
    }
    
    public enum SceneType {
        rebelTransportShip,
        yavin4,
        rebelBaseCommandCenter,
        rebelBaseHanger,
        openSpace,
        deepSpaceBattleLocation,
        deepSpaceRetreatLocation,
        DeathStar,
        deathStarFighterEngagement,
        quadrant1,
        quadrant2,
        quadrant3,
        quadrant4,
        deathStarTrench,
        trenchEntrance,
        trenchBattleLocation,
        trenchExit,
        deathStarExhaustPort,
        deathStarRetreatLocation,
        turboLaserBatteries,
        deflectorShieldGenerators,
        enemyFighters,
        friendlyFighters,
        supplyShip,
        repairShip;

        public static class enemyFighter {

            public static int ordinal() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            public enemyFighter() {
            }
        }
    }
    
    public Scene() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public String getDisplaySymbol() {
        
        if (this.displaySymbol == null) {
            return "  ";
        }
        
        return displaySymbol;
    }

    public void setSceneType(SceneType type) {
        this.type = type;
    }
    
    public SceneType getSceneType() {
        return this.type;
    }
    
    public void setDisplaySymbol(String displaySymbol) {
        this.displaySymbol = displaySymbol;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.description);
        hash = 59 * hash + Objects.hashCode(this.travelTime);
        hash = 59 * hash + Objects.hashCode(this.displaySymbol);
        return hash;
    }

    @Override
    public String toString() {
        return "Scene{" + "description=" + description + ", travelTime=" + travelTime + ", displaySymbol=" + displaySymbol + '}';
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
        final Scene other = (Scene) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.displaySymbol, other.displaySymbol)) {
            return false;
        }
        if (!Objects.equals(this.travelTime, other.travelTime)) {
            return false;
        }
        return true;
    }
    
    
    
}
