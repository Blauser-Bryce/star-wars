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
public class RepairShop extends Scene implements Serializable{
    
    private int shipCondition;

    public RepairShop() {
    }
    
    public int getShipCondition() {
        return shipCondition;
    }

    public void setShipCondition(int shipCondition) {
        this.shipCondition = shipCondition;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.shipCondition;
        return hash;
    }

    @Override
    public String toString() {
        return "RepairShop{" + "shipCondition=" + shipCondition + 
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
        final RepairShop other = (RepairShop) obj;
        if (this.shipCondition != other.shipCondition) {
            return false;
        }
        return true;
    }
    
    
    
}
