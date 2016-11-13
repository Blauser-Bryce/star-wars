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
public class Map implements Serializable{

    private String rowCount;
    private String columCount;

    private String mapLayout;
    
    public Map() {
        mapLayout = "  ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                   +"\n ----------------------------"
                   +"\n0|                          |0"
                   +"\n1|                          |1"
                   +"\n2|                          |2"
                   +"\n3|               S          |3"
                   +"\n4|                          |4"
                   +"\n5|                          |5"
                   +"\n6|                          |6"
                   +"\n7|                          |7"
                   +"\n8|                          |8"
                   +"\n9|                          |9"
                   +"\n ----------------------------"
                   +"\n  ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // Supply Ship P3
    }

    public String getMapLayout() {
        return mapLayout;
    }    

    public String getRowCount() {
        return rowCount;
    }

    public void setRowCount(String rowCount) {
        this.rowCount = rowCount;
    }

    public String getColumCount() {
        return columCount;
    }

    public void setColumCount(String columCount) {
        this.columCount = columCount;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.rowCount);
        hash = 29 * hash + Objects.hashCode(this.columCount);
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
        final Map other = (Map) obj;
        if (!Objects.equals(this.rowCount, other.rowCount)) {
            return false;
        }
        if (!Objects.equals(this.columCount, other.columCount)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Map{" + "rowCount=" + rowCount + ", columCount=" + columCount + '}';
    }
    
    
    
}
