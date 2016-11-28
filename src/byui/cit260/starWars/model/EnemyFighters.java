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
public class EnemyFighters extends Scene implements Serializable{
    
    private int noOfFighter;
    private String enemyFighterLocation;

    public int getNoOfFighter() {
        return noOfFighter;
    }

    public EnemyFighters() {
    }
    
    public void setNoOfFighter(int noOfFighter) {
        this.noOfFighter = noOfFighter;
    }

    public String getEnemyFighterLocation() {
        return enemyFighterLocation;
    }

    public void setEnemyFighterLocation(String enemyFighterLocation) {
        this.enemyFighterLocation = enemyFighterLocation;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.noOfFighter;
        hash = 19 * hash + Objects.hashCode(this.enemyFighterLocation);
        return hash;
    }

    @Override
    public String toString() {
        return "EnemyFighters{" + "noOfFighter=" + noOfFighter + ", enemyFighterLocation=" + enemyFighterLocation + 
                "} Scene {description=" + getDescription() +  ", travelTime=" + getTravelTime() + ", displaySymbol=" + getDisplaySymbol() + "}";
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
        final EnemyFighters other = (EnemyFighters) obj;
        if (this.noOfFighter != other.noOfFighter) {
            return false;
        }
        if (!Objects.equals(this.enemyFighterLocation, other.enemyFighterLocation)) {
            return false;
        }
        return true;
    }
    
    
    
}
