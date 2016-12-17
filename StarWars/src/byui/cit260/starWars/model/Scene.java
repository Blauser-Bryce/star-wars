/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.model;

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
