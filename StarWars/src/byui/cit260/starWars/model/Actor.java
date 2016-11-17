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
public enum Actor implements Serializable {
    
    RedLeader1("Red Leader #1"),
    RedLeader2("Red Leader #2"),
    RedLeader3("Red Leader #3"),
    RedLeader4("Red Leader #4"),
    RedLeader5("Red Leader #5"),
    RedLeader6("Red Leader #6"),
    BlueLeader1("Blue Leader #1"),
    BlueLeader2("Blue Leader #2"),
    BlueLeader3("Blue Leader #3"),
    BlueLeader4("Blue Leader #4"),
    BlueLeader5("Blue Leader #5"),
    BlueLeader6("Blue Leader #6");
    
    private final String description;
    private final String coordinates;

    /*
    public Actor() {
   
    }
   */
    Actor(String description) {
        this.description = description;
        coordinates = "1,1"; // Change to new Point(1,1);
    }

    public String getDescription() {
        return description;
    }

    // Change to Point
    public String getCoordinates() {
        return coordinates;
    }

}
