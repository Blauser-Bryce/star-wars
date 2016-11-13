/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.model;

import java.util.Objects;
import starwars.StarWars;

/**
 *
 * @author Bryce Blauser
 */
public class Aim {
    
    public String aimLayout;
    
    Player player = StarWars.getPlayer();
    Target currentTarget = new Target();

    public Aim() {
        currentTarget = player.getCurrentTarget();
        
        aimLayout =  "Attacking " + currentTarget.getTargetName()
                   +"\n----------------------------"
                   +"\n|            |             |"
                   +"\n|            |             |"
                   +"\n|            |             |"
                   +"\n|            |             |"
                   +"\n|------------+-------------|"
                   +"\n|            |             |"
                   +"\n|            |             |"
                   +"\n|            |             |"
                   +"\n|            |             |"
                   +"\n ---------------------------";
    }

    public String getAimLayout() {
        return aimLayout;
    }

    public void setAimLayout(String aimLayout) {
        this.aimLayout = aimLayout;
    }

    public void aimUp() {
        
    }
    
    public void aimDown() {
        
    }
    
    public void aimLeft() {
        
    }
    
    public void aimRight() {
        
    }
    
    @Override
    public String toString() {
        return "Aim{" + "aimLayout=" + aimLayout + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.aimLayout);
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
        final Aim other = (Aim) obj;
        if (!Objects.equals(this.aimLayout, other.aimLayout)) {
            return false;
        }
        return true;
    }
    
}
