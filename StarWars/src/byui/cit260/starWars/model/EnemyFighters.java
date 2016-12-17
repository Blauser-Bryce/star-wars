/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.model;

import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author Edvaldo Melo
 */
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
        coordinates = new Point(12,8); // Change to new Point(12,8);
    }

    public String getDescription() {
        return description;
    }

    // Change to Point
    public Point getCoordinates() {
        return coordinates;
    }
}
