/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.Objects;
import starwars.StarWars;

/**
 *
 * @author Bryce Blauser
 */
public class EnemyFighter extends Target implements Serializable {

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
        return Objects.equals(this.enemyFigthersLocation, other.enemyFigthersLocation);
    }

    EnemyFighter[] enemyFighterList = StarWars.getCurrentGame().getEnemyFighters();

    public enum EnemyFighters implements Serializable {
        BlackLeader1("Black Leader #1"),
        BlackLeader2("Black Leader #2"),
        BlackLeader3("Black Leader #3"),
        BlackLeader4("Black Leader #4"),
        BlackLeader5("Black Leader #5"),
        BlackLeader6("Black Leader #6"),
        GrayLeader1("Gray Leader #1"),
        GrayLeader2("Gray Leader #2"),
        GrayLeader3("Gray Leader #3"),
        GrayLeader4("Gray Leader #4"),
        GrayLeader5("Gray Leader #5"),
        GrayLeader6("Gray Leader #6");

        private final String description;
        private final Point coordinates;

        /*
    public EnemyFighters() {

    }
         */
        EnemyFighters(String description) {
            this.description = description;
            coordinates = new Point(12, 8); // Change to new Point(12,8);
        }

        public String getDescription() {
            return description;
        }

        // Change to Point
        public Point getCoordinates() {
            return coordinates;
        }
    }
}
