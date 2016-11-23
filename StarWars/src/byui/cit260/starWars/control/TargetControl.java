/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.control;

import byui.cit260.starWars.model.EnemyFighter;
import byui.cit260.starWars.model.Target;
import exceptions.TargetControlException;

/**
 *
 * @author Bryce Blauser
 */
public class TargetControl {
    
    public String applyDamage(Target target, double amplifier, double amount)  {
        
        double damageShield;
        double damageHealth;
        double applyShield;
        double applyHealth;
        
        if (target == null) {
            return "Error: Invalid Target";
        }
        
        if (amount <= 0 ) {
            return "Error: Invalid Damage value";
        }
        
        if (amplifier < 1 || amplifier > 2) {
            return "Error: Invalid Amplifier value";
        }
        
        if (target.getTargetShield() > 50) {
            damageShield = amount * 0.75 * amplifier;
            damageHealth = amount * 0.5 * amplifier;
        } else if (target.getTargetShield() > 1) {
            damageShield = amount * amplifier;
            damageHealth = amount * 0.75 * amplifier;
        } else {
            damageShield = 0;
            damageHealth = amount * amplifier;
        }
        
        applyShield = target.getTargetShield() - damageShield;
        applyHealth = target.getTargetHealth() - damageHealth;
        
        target.setTargetShield(applyShield);
        target.setTargetHealth(applyHealth);
        
        if (target.getTargetHealth() <= 0) {
            return "Target Destroyed";
        }
        
        return "Target damage done: Shield " + damageShield + " Health " + damageHealth + ", Remaining: Shield " + applyShield + " Health " + applyHealth;
    }
    
    public String applyRepair(Target target, double amplifier, double amount) {
     
        double repairHealth;
        double repairShield;
        double applyRepairShield;
        double applyRepairHealth;
        
        if (target == null) {
            return "Error: Invalid Target";
        }
        if (amount <= 0 ) {
            return "Error: Invalid Amount value";
        }
        if (amplifier < 1 || amplifier > 2) {
            return "Error: Invalid Amplifier value";
        }

        
        else if (target.getTargetHealth() > 100 && target.getTargetShield() < 100){
            repairHealth = 100; 
            repairShield = amount * 0.75 * amplifier;
        }
        else if (target.getTargetHealth() > 50) {
            repairShield = amount * 0.75 * amplifier;
            repairHealth = amount * amplifier;
        }
        else if (target.getTargetHealth() >= 1) {
            repairShield = amount * 0.5 * amplifier;
            repairHealth = amount * 0.75 * amplifier;
        }
        else {
            
            return "Target Destoryed";
        }
        applyRepairShield = repairShield + target.getTargetShield();
        applyRepairHealth = repairHealth + target.getTargetHealth();
        
        target.setTargetShield(applyRepairShield);
        target.setTargetHealth(applyRepairHealth);
        
        if (target.getTargetHealth() > 100) {
            applyRepairHealth = 100;
        }
         if (target.getTargetShield() > 100) {
            applyRepairShield = 100;
         }
        if (target.getTargetHealth() >= 100 && target.getTargetShield() >= 100) {
            
           return "Target at Full Health";
        }
            
        return "Target Repair done: Shield " + repairShield + " Health " + repairHealth + ", Remaining: Shield " + applyRepairShield + " Health " + applyRepairHealth;
    }    
    
    public int getMaxEnemyHealth(EnemyFighter[] enemyFighterList) throws TargetControlException {
        
        double maxValue = enemyFighterList[0].getTargetHealth();
        int index = 0;
        int enemyIndex = 0;
        
        if (enemyFighterList == null || enemyFighterList.length == 0) {
             throw new TargetControlException("No enemies found in current list");
        }
        
        for (EnemyFighter enemyFighter : enemyFighterList) {
            if (enemyFighter.getTargetHealth() > maxValue) {
                maxValue = enemyFighter.getTargetHealth();
                enemyIndex = index;
            }
            index++;
        }
        
        return enemyIndex;   
    }
    
        public int getLowEnemyHealth(EnemyFighter[] enemyFighterList) {
        double lowValue = enemyFighterList[0].getTargetHealth();
        int index = 0;
        int enemyIndex = -1;
        
        for (EnemyFighter enemyFighter : enemyFighterList) {
            if (enemyFighter.getTargetHealth() <= lowValue) {
               lowValue = enemyFighter.getTargetHealth();
                enemyIndex = index;
            } 
            
            index++;
        }
        
        return enemyIndex;   
    }
        public int getLengthEnemyHealth(EnemyFighter[] enemyFighterList) {
        int size = enemyFighterList.length;
        return size;
    }
        public double getAvgEnemyHealth(EnemyFighter[] enemyFighterList) {
       
        double total = 0;
        for (int i = 0; i < enemyFighterList.length -1 ; i++) {
            total = total + enemyFighterList[i].getTargetHealth();
        }
        
        double average = total / (enemyFighterList.length-1);         
        
        return average;            
       
         }  
    }
