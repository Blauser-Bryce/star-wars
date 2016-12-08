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
public class Target implements Serializable {
 
    public enum targetType {
        tieFighter(50),
        tieInterceptor(75),
        darthVader(100),
        turboLaser(25),
        deflectorShield(35);
        
        private final int defaultHealth;
        
        targetType(int defaultHealth) {
            this.defaultHealth = defaultHealth;
        }
        
        public int getDefaultHealth() {
            return this.defaultHealth;
        }
    }
    
    private double targetHealth;
    private double targetShield;
    private String targetName;
    private Location targetLocation;
    private targetType targetType;

    public Target() {
    }

    public double getTargetHealth() {
        return targetHealth;
    }

    public targetType getTargetType() {
        return targetType;
    }

    public void setTargetType(targetType targetType) {
        this.targetType = targetType;
    }

    public void setTargetHealth(double targetHealth) {
        this.targetHealth = targetHealth;
    }

    public double getTargetShield() {
        return targetShield;
    }

    public void setTargetShield(double targetShield) {
        this.targetShield = targetShield;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public Location getTargetLocation() {
        return targetLocation;
    }

    public void setTargetLocation(Location targetLocation) {
        this.targetLocation = targetLocation;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.targetHealth) ^ (Double.doubleToLongBits(this.targetHealth) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.targetShield) ^ (Double.doubleToLongBits(this.targetShield) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.targetName);
        hash = 97 * hash + Objects.hashCode(this.targetLocation);
        hash = 97 * hash + Objects.hashCode(this.targetType);
        return hash;
    }

    @Override
    public String toString() {
        return "Target{" + "targetHealth=" + targetHealth + ", targetShield=" + targetShield + ", targetName=" + targetName + ", targetLocation=" + targetLocation + ", targetType=" + targetType + '}';
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
        final Target other = (Target) obj;
        if (Double.doubleToLongBits(this.targetHealth) != Double.doubleToLongBits(other.targetHealth)) {
            return false;
        }
        if (Double.doubleToLongBits(this.targetShield) != Double.doubleToLongBits(other.targetShield)) {
            return false;
        }
        if (!Objects.equals(this.targetName, other.targetName)) {
            return false;
        }
        if (!Objects.equals(this.targetType, other.targetType)) {
            return false;
        }
        if (!Objects.equals(this.targetLocation, other.targetLocation)) {
            return false;
        }
        return true;
    }

    
    
    
    
    
    
}

