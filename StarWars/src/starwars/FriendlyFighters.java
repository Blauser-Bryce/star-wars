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
public class FriendlyFighters extends Scene implements Serializable{
    
    private int noOfFighter;
    private String friendlyFighterLocation;

    public FriendlyFighters() {
    }
    
    public int getNoOfFighter() {
        return noOfFighter;
    }

    public void setNoOfFighter(int noOfFighter) {
        this.noOfFighter = noOfFighter;
    }

    public String getFriendlyFighterLocation() {
        return friendlyFighterLocation;
    }

    public void setFriendlyFighterLocation(String friendlyFighterLocation) {
        this.friendlyFighterLocation = friendlyFighterLocation;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.noOfFighter;
        hash = 37 * hash + Objects.hashCode(this.friendlyFighterLocation);
        return hash;
    }

    @Override
    public String toString() {
        return "FriendlyFighters{" + "noOfFighter=" + noOfFighter + ", friendlyFighterLocation=" + friendlyFighterLocation + 
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
        final FriendlyFighters other = (FriendlyFighters) obj;
        if (this.noOfFighter != other.noOfFighter) {
            return false;
        }
        if (!Objects.equals(this.friendlyFighterLocation, other.friendlyFighterLocation)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
