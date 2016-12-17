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
    
    // Move to Game Modifier
    private Double gameModAmplifier;
    private boolean gameModReplenishBoost;

    private Player player;
    private Item[] inventory;
    private EnemyFighter[] enemyFighter;
    private Map map;

    public EnemyFighter[] getEnemyFighter() {
        return enemyFighter;
    }

    public void setEnemyFighter(EnemyFighter[] enemyFighter) {
        this.enemyFighter = enemyFighter;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
    
    public Item[] getInventory() {
        return inventory;
    }

    public Item getInventoryAtLocation(int location){
        return inventory[location];
    }
    
    public void setInventory(Item[] inventory) {
        this.inventory = inventory;
    }
    
    public boolean getGameModReplenishBoost() {
        return gameModReplenishBoost;
    }

    public void setGameModReplenishBoost(boolean gameModReplenishBoost) {
        this.gameModReplenishBoost = gameModReplenishBoost;
    }
    
    public Double getGameModAmplifier() {
        return gameModAmplifier;
    }

    public void setGameModAmplifier(Double gameModAmplifier) {
        this.gameModAmplifier = gameModAmplifier;
    }

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

    public EnemyFighter[] getEnemyFighters() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
