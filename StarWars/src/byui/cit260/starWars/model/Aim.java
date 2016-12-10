/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.model;

import java.util.Arrays;
import java.util.Random;
import starwars.StarWars;

/**
 *
 * @author Bryce Blauser
 */
public class Aim {
        
    Player player = StarWars.getPlayer();
    private int targetRow;
    private int targetCol;
    private final char[][] targetGrid = new char[12][20];
    private boolean onTarget;

    public boolean isOnTarget() {
        return onTarget;
    }
    
    public Aim() {
        // Place the target randomly in the view
        Random random = new Random();
        targetRow = random.nextInt(10 - 1) + 1;
        targetCol = random.nextInt(18 - 1) + 1;
    }
   
    public String drawLayout() {
        
        for (int row = 0; row < 11; row++) {
            for (int col = 0; col < 19; col++) {
                if (row == 0 || row == 5 || row == 10) {
                    targetGrid[row][col] = '-';
                } else if (col == 0 || col == 9 ||col == 18) {
                    targetGrid[row][col] = '|';
                } else {
                    targetGrid[row][col] = ' ';
                }
            }
        }
        targetGrid[5][9] = '+';
        targetGrid[targetRow][targetCol] = 'X';
        
        onTarget = targetRow == 5 && targetCol == 9;
        
        String targetLayout = "\nAttacking " + player.getCurrentTarget().getTargetName();
        
        for (int row = 0; row < 11; row++) {
            targetLayout += "\n";
            for (int col = 0; col < 19; col++) {
                targetLayout +=  targetGrid[row][col];
            }
        }
        
        return targetLayout;
    }
    
    public boolean aimDir(String direction) {
        switch (direction) {
            case "UP":
                targetRow++;
                break;
            case "DOWN":
                targetRow--;
                break;
            case "LEFT":
                targetCol++;
                break;
            case "RIGHT":
                targetCol--;
                break;
        }
        
        return targetRow > 0 && targetRow < 11 && targetCol > 0 && targetCol < 19;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.targetRow;
        hash = 29 * hash + this.targetCol;
        hash = 29 * hash + Arrays.deepHashCode(this.targetGrid);
        return hash;
    }

    @Override
    public String toString() {
        return "Aim{" + "targetRow=" + targetRow + ", targetCol=" + targetCol + ", targetGrid=" + targetGrid + '}';
    }
    
}
