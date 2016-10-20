/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.control;

import byui.cit260.starWars.model.Target;

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
    
    public String applyRepair(Target target, double amplifier, double amount)  {
     return "";
    }
    
}
