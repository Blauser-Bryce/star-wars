/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.model;

import static byui.cit260.starWars.model.Item.itemType.Flare;
import static byui.cit260.starWars.model.Item.itemType.Missile;
import static byui.cit260.starWars.model.Item.itemType.Torpedo;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Bryce Blauser
 */
public class Player implements Serializable {
    
    // class instance variables
    private String name;
    private String coordinates;
    
    private Item missiles = new Item();
    private Item torpedos = new Item();
    private Item flares = new Item();
    
    private Target currentTarget = new Target();
    
    public Player() {
        // Load up inventory
        
        // Set to 0 for starting
        missiles.setType(Missile);
        //missiles.setQuantity(missiles.maxQuantity(Missile));
        missiles.setQuantity(0);
        torpedos.setType(Torpedo);
        //torpedos.setQuantity(torpedos.maxQuantity(Torpedo));
        torpedos.setQuantity(0);
        flares.setType(Flare);
        //flares.setQuantity(flares.maxQuantity(Flare));
        flares.setQuantity(0);
        
        currentTarget.setTargetHealth(100);
        currentTarget.setTargetShield(100);
        currentTarget.setTargetName("Testing New Target");
        currentTarget.setTargetType("Testing Type");
        
    }
    
    public Target getCurrentTarget() {
        return currentTarget;
    }

    public void setCurrentTarget(Target currentTarget) {
        this.currentTarget = currentTarget;
    }
    
    public Item getMissiles() {
        return missiles;
    }

    public void setMissiles(Item missiles) {
        this.missiles = missiles;
    }

    public Item getTorpedos() {
        return torpedos;
    }

    public void setTorpedos(Item torpedos) {
        this.torpedos = torpedos;
    }

    public Item getFlares() {
        return flares;
    }

    public void setFlares(Item flares) {
        this.flares = flares;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.coordinates);
        return hash;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", coordinates=" + coordinates + '}';
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
        final Player other = (Player) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.coordinates, other.coordinates)) {
            return false;
        }
        return true;
    }
    
    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
    
    
    
}
