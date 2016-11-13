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
 * @author gmoser
 */
public class Item implements Serializable {
    
    public enum itemType {
        Missile, 
        Torpedo, 
        Flare
    }
    
    private itemType type;
    private int quantity;

    public Item() {
    }

    public int maxQuantity(itemType type) {
        
        if (type == null) return 0;
        
        switch (type) {
            case Missile:
                return 50;
            case Torpedo:
                return 10;
            case Flare:
                return 100;
            default:
                return 0;
        }
    }
    
    public itemType getType() {
        return type;
    }

    public void setType(itemType type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = (quantity > maxQuantity(this.type)) ? maxQuantity(this.type) : quantity;
    }
    
    public void replenishQuantity(){
        if (this.quantity >= maxQuantity(this.type)) {
            this.quantity = maxQuantity(this.type);
        } else {
            this.quantity++;
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.type);
        hash = 17 * hash + Objects.hashCode(this.quantity);
        return hash;
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
        final Item other = (Item) obj;
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.quantity, other.quantity)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "type=" + type + ", quantity=" + quantity + '}';
    }
    
    
    
    
}
