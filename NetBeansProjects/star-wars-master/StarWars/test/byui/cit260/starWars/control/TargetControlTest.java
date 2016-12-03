/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.control;

import byui.cit260.starWars.model.Target;
import java.io.PrintWriter;
import org.junit.Test;
import static org.junit.Assert.*;
import starwars.StarWars;

/**
 *
 * @author Bryce Blauser
 */
public class TargetControlTest {
    
    private static final PrintWriter console = StarWars.getOutFile();
    
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
        console.println("\tTest case #Error 1");
        
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
        console.println("\tTest case #1");
        
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
        console.println("\tTest case #2");
        
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
        console.println("\tTest case #3");
        
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
        console.println("\tTest case #4");
        
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
        console.println("\tTest case #4");
        
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
        console.println("\tTest case #5");
        
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
        console.println("\tTest case #6");
        
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
        console.println("\tTest case #7");
        
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

    /**
     * Test of applyRepair method, of class TargetControl.
     */
    @Test
    public void testApplyRepair() {
        console.println("\tTest case #Error 1");
        
        //input values for test case 1
        Target target = null;
        double amplifier = 0.0;
        double amount = 0.0;
        
        TargetControl instance = new TargetControl();
        
        String expResult = "Error: Invalid Target";
        String result = instance.applyDamage(target, amplifier, amount);
        assertEquals(expResult, result);
        
         /********************************************
         * Test case applyRepair #1
         ********************************************/
         
       
         
         
         console.println("\tTest case applyRepair #1");
        
        //input values for test case 1
        target = new Target();
        amplifier = 1.2;
        amount = 30.0;
        
        target.setTargetShield(1);
        target.setTargetHealth(1);
        
        expResult = "Target Repair done: Shield 18.0 Health 27.0, Remaining: Shield 19.0 Health 28.0";
        result = instance.applyRepair(target, amplifier, amount);
        assertEquals(expResult, result);
        
         /********************************************
         * Test case applyRepair #2
         ********************************************/
        
        console.println("\tTest case applyRepair #2");
        
        //input values for test case 2
        target = new Target();
        amplifier = 1.8;
        amount = 30.0;
        
        target.setTargetShield(100);
        target.setTargetHealth(100);
        
        expResult = "Target at Full Health";
        result = instance.applyRepair(target, amplifier, amount);
        assertEquals(expResult, result);
        
         /********************************************
         * Test case applyRepair #3
         ********************************************/
        
        console.println("\tTest case applyRepair #3");
        
        //input values for test case 3
        target = new Target();
        amplifier = 1.8;
        amount = 10.0;
        
        target.setTargetShield(60);
        target.setTargetHealth(100);
        
        expResult = "Target Repair done: Shield 13.5 Health 18.0, Remaining: Shield 73.5 Health 100.0";
        result = instance.applyRepair(target, amplifier, amount);
        assertEquals(expResult, result);
        
         /********************************************
         * Test case applyRepair #4
         ********************************************/
        
        console.println("\tTest case applyRepair #4");
        
        //input values for test case 4
        target = new Target();
        amplifier = -0.1;
        amount = 50.0;
        
        target.setTargetShield(40);
        target.setTargetHealth(70);
        
        expResult = "Error: Invalid Amplifier value";
        result = instance.applyRepair(target, amplifier, amount);
        assertEquals(expResult, result);
        
         /********************************************
         * Test case applyRepair #5
         ********************************************/
        
        console.println("\tTest case applyRepair #5");
        
        //input values for test case 5
        target = new Target();
        amplifier = 1;
        amount = -1;
        
        target.setTargetShield(40);
        target.setTargetHealth(70);
        
        expResult = "Error: Invalid Amount value";
        result = instance.applyRepair(target, amplifier, amount);
        assertEquals(expResult, result);
        
         /********************************************
         * Test case applyRepair #6
         ********************************************/
        
        console.println("\tTest case applyRepair #6");
        
        //input values for test case 6
        target = new Target();
        amplifier = 1;
        amount = 50;
        
        target.setTargetShield(1);
        target.setTargetHealth(1);
        
        expResult = "Target Repair done: Shield 25.0 Health 37.5, Remaining: Shield 26.0 Health 38.5";
        result = instance.applyRepair(target, amplifier, amount);
        assertEquals(expResult, result);
        
         /********************************************
         * Test case applyRepair #7
         ********************************************/
        
        console.println("\tTest case applyRepair #7");
        
        //input values for test case 7
        target = new Target();
        amplifier = 2;
        amount = 50;
        
        target.setTargetShield(100);
        target.setTargetHealth(100);
        
        expResult = "Target at Full Health";
        result = instance.applyRepair(target, amplifier, amount);
        assertEquals(expResult, result);
    }
   
}
