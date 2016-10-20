/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.control;

import byui.cit260.starWars.model.Target;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bryce Blauser
 */
public class TargetControlTest {
    
    public TargetControlTest() {
    }

    /**
     * Test of applyDamage method, of class TargetControl.
     */
    @Test
    public void testApplyDamage() {
        
        /********************************************
         * Test case #Error 1
         ********************************************/
        System.out.println("\tTest case #Error 1");
        
        //input values for test case 1
        Target target = null;
        double amplifier = 0.0;
        double amount = 0.0;
        
        TargetControl instance = new TargetControl();
        
        String expResult = "Error: Invalid Target";
        String result = instance.applyDamage(target, amplifier, amount);
        assertEquals(expResult, result);
        
        /********************************************
         * Test case #1
         ********************************************/
        System.out.println("\tTest case #1");
        
        //input values for test case 1
        target = new Target();
        amplifier = 1.2;
        amount = 50.0;
        
        target.setTargetShield(100);
        target.setTargetHealth(100);
        
        expResult = "Target damage done: Shield 45.0 Health 30.0, Remaining: Shield 55.0 Health 70.0";
        result = instance.applyDamage(target, amplifier, amount);
        assertEquals(expResult, result);
        
        /********************************************
         * Test case #2
         ********************************************/
        System.out.println("\tTest case #2");
        
        //input values for test case 2
        target = new Target();
        amplifier = 1.5;
        amount = 60.0;
        
        target.setTargetShield(10);
        target.setTargetHealth(50);
        
        expResult = "Target Destroyed";
        result = instance.applyDamage(target, amplifier, amount);
        assertEquals(expResult, result);
        
        /********************************************
         * Test case #3
         ********************************************/
        System.out.println("\tTest case #3");
        
        //input values for test case 3
        target = new Target();
        amplifier = 1.5;
        amount = 20.0;
        
        target.setTargetShield(30);
        target.setTargetHealth(70);
        
        expResult = "Target damage done: Shield 30.0 Health 22.5, Remaining: Shield 0.0 Health 47.5";
        result = instance.applyDamage(target, amplifier, amount);
        assertEquals(expResult, result);
        
        /********************************************
         * Test case #4
         ********************************************/
        System.out.println("\tTest case #4");
        
        //input values for test case 4
        target = new Target();
        amplifier = -0.1;
        amount = 50.0;
        
        target.setTargetShield(40);
        target.setTargetHealth(70);
        
        expResult = "Error: Invalid Amplifier value";
        result = instance.applyDamage(target, amplifier, amount);
        assertEquals(expResult, result);
        
        /********************************************
         * Test case #4
         ********************************************/
        System.out.println("\tTest case #4");
        
        //input values for test case 4
        target = new Target();
        amplifier = -0.1;
        amount = 50.0;
        
        target.setTargetShield(40);
        target.setTargetHealth(70);
        
        expResult = "Error: Invalid Amplifier value";
        result = instance.applyDamage(target, amplifier, amount);
        assertEquals(expResult, result);
        
        /********************************************
         * Test case #5
         ********************************************/
        System.out.println("\tTest case #5");
        
        //input values for test case 5
        target = new Target();
        amplifier = 0.5;
        amount = -1.0;
        
        target.setTargetShield(100);
        target.setTargetHealth(100);
        
        expResult = "Error: Invalid Damage value";
        result = instance.applyDamage(target, amplifier, amount);
        assertEquals(expResult, result);
        
        /********************************************
         * Test case #6
         ********************************************/
        System.out.println("\tTest case #6");
        
        //input values for test case 6
        target = new Target();
        amplifier = 1.0;
        amount = 50.0;
        
        target.setTargetShield(100);
        target.setTargetHealth(100);
        
        expResult = "Target damage done: Shield 37.5 Health 25.0, Remaining: Shield 62.5 Health 75.0";
        result = instance.applyDamage(target, amplifier, amount);
        assertEquals(expResult, result);
        
        /********************************************
         * Test case #7
         ********************************************/
        System.out.println("\tTest case #7");
        
        //input values for test case 7
        target = new Target();
        amplifier = 2.0;
        amount = 50.0;
        
        target.setTargetShield(100);
        target.setTargetHealth(100);
        
        expResult = "Target damage done: Shield 75.0 Health 50.0, Remaining: Shield 25.0 Health 50.0";
        result = instance.applyDamage(target, amplifier, amount);
        assertEquals(expResult, result);
    }
    
}
