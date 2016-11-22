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
public class SupplyShip extends Scene implements Serializable{
    
    private int noSupplies;
    private String typeSupplies;

    public SupplyShip() {
    }
    
    public int getNoSupplies() {
        return noSupplies;
    }

    public void setNoSupplies(int noSupplies) {
        this.noSupplies = noSupplies;
    }

    public String getTypeSupplies() {
        return typeSupplies;
    }

    public void setTypeSupplies(String typeSupplies) {
        this.typeSupplies = typeSupplies;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.noSupplies;
        hash = 13 * hash + Objects.hashCode(this.typeSupplies);
        return hash;
    }

    @Override
    public String toString() {
        return "SupplyShip{" + "noSupplies=" + noSupplies + ", typeSupplies=" + typeSupplies + 
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
        final SupplyShip other = (SupplyShip) obj;
        if (this.noSupplies != other.noSupplies) {
            return false;
        }
        if (!Objects.equals(this.typeSupplies, other.typeSupplies)) {
            return false;
        }
        return true;
    }
    
    
    
}
