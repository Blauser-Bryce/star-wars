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
public class OpenSpace extends Scene implements Serializable{
    
    private String openSpaceLocation;

    public OpenSpace() {
    }

    public String getOpenSpaceLocation() {
        return openSpaceLocation;
    }

    public void setOpenSpaceLocation(String openSpaceLocation) {
        this.openSpaceLocation = openSpaceLocation;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.openSpaceLocation);
        return hash;
    }

    @Override
    public String toString() {
        return "OpenSpace{" + "openSpaceLocation=" + openSpaceLocation + 
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
        final OpenSpace other = (OpenSpace) obj;
        if (!Objects.equals(this.openSpaceLocation, other.openSpaceLocation)) {
            return false;
        }
        return true;
    }
    
    
    
}
