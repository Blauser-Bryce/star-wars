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
public class Game implements Serializable{
    
    private Double totalTime;
    private Boolean isPlaying;
    private Boolean gameOver;

    public Game() {
    }

    public Double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Double totalTime) {
        this.totalTime = totalTime;
    }

    public Boolean getIsPlaying() {
        return isPlaying;
    }

    public void setIsPlaying(Boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public Boolean getGameOver() {
        return gameOver;
    }

    public void setGameOver(Boolean gameOver) {
        this.gameOver = gameOver;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.totalTime);
        hash = 41 * hash + Objects.hashCode(this.isPlaying);
        hash = 41 * hash + Objects.hashCode(this.gameOver);
        return hash;
    }

    @Override
    public String toString() {
        return "Game{" + "totalTime=" + totalTime + ", isPlaying=" + isPlaying + ", gameOver=" + gameOver + '}';
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
        final Game other = (Game) obj;
        if (!Objects.equals(this.totalTime, other.totalTime)) {
            return false;
        }
        if (!Objects.equals(this.isPlaying, other.isPlaying)) {
            return false;
        }
        if (!Objects.equals(this.gameOver, other.gameOver)) {
            return false;
        }
        return true;
    }
    
    
    
}
