/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.model;

import java.io.Serializable;

/**
 *
 * @author Bryce Blauser
 */
public class DeathStar extends Scene implements Serializable{
    
    private int noTurboLasers;
    private int noDeflectorShields;

    public DeathStar() {
    }

    public int getNoTurboLasers() {
        return noTurboLasers;
    }

    public void setNoTurboLasers(int noTurboLasers) {
        this.noTurboLasers = noTurboLasers;
    }

    public int getNoDeflectorShields() {
        return noDeflectorShields;
    }

    public void setNoDeflectorShields(int noDeflectorShields) {
        this.noDeflectorShields = noDeflectorShields;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.noTurboLasers;
        hash = 23 * hash + this.noDeflectorShields;
        return hash;
    }

    @Override
    public String toString() {
        return "DeathStar{" + "noTurboLasers=" + noTurboLasers + ", noDeflectorShields=" + noDeflectorShields + 
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
        final DeathStar other = (DeathStar) obj;
        if (this.noTurboLasers != other.noTurboLasers) {
            return false;
        }
        if (this.noDeflectorShields != other.noDeflectorShields) {
            return false;
        }
        return true;
    }
    
    
    
}
