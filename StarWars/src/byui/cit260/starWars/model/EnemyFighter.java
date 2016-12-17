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
public class EnemyFighter extends Target implements Serializable{
    
    private int noOfFighter;
    private String enemyFigthersLocation;
    
    public EnemyFighter() {

    }

    public int getNoOfFighter() {
        return noOfFighter;
    }

    public String getEnemyFigthersLocation() {
        return enemyFigthersLocation;
    }

    public void setNoOfFighter(int noOfFighter) {
        this.noOfFighter = noOfFighter;
    }

    public void setEnemyFigthersLocation(String enemyFigthersLocation) {
        this.enemyFigthersLocation = enemyFigthersLocation;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.noOfFighter;
        hash = 19 * hash + Objects.hashCode(this.enemyFigthersLocation);
        return hash;
    }
    
    @Override
    public String toString() {
        return "EnemyFighter{" + "noOfFighter=" + noOfFighter + ", enemyFigthersLocation=" + enemyFigthersLocation + '}';
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
        final EnemyFighter other = (EnemyFighter) obj;
        if (this.noOfFighter != other.noOfFighter) {
            return false;
        }
        if (!Objects.equals(this.enemyFigthersLocation, other.enemyFigthersLocation)) {
            return false;
        }
        return true;
    }
}
