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
public class RebelTransportShip extends Scene implements Serializable{
    
    private String rebelTransportShipLocation;

    public RebelTransportShip() {
    }

    public String getRebelTransportShipLocation() {
        return rebelTransportShipLocation;
    }

    public void setRebelTransportShipLocation(String rebelTransportShipLocation) {
        this.rebelTransportShipLocation = rebelTransportShipLocation;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.rebelTransportShipLocation);
        return hash;
    }

    @Override
    public String toString() {
        return "RebelTransportShip{" + "rebelTransportShipLocation=" + rebelTransportShipLocation + 
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
        final RebelTransportShip other = (RebelTransportShip) obj;
        if (!Objects.equals(this.rebelTransportShipLocation, other.rebelTransportShipLocation)) {
            return false;
        }
        return true;
    }
    
    
    
}
