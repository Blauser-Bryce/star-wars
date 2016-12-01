/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.control;

import byui.cit260.starWars.model.Item;
import java.io.PrintWriter;
import org.junit.Test;
import static org.junit.Assert.*;
import starwars.StarWars;

/**
 *
 * @author Bryce Blauser
 */
public class ItemControlTest {
    
    private static final PrintWriter console = StarWars.getOutFile();
    
    public ItemControlTest() {
    }

    /**
     * Test of replenishItem method, of class ItemControl.
     */
    @Test
    public void testReplenishItem() {
        
        console.println("replenishItem");
        /********************************************
         * Test case #Error 1
         ********************************************/
        console.println("\tTest case #Error 1");
        
        //input values for test case 1
        Item item = null;
        int quantity = 0;
        long duration = 0L;
        boolean replenishBoost = false;
        
        ItemControl instance = new ItemControl();
        String expResult = "Error: Invalid Item Type";
        String result = instance.replenishItem(item, quantity, duration, replenishBoost);
        assertEquals(expResult, result);

        /********************************************
         * Test case #1
         ********************************************/
        console.println("\tTest case #1");
        
        //input values for test case 1
        
        item = new Item();
        
        quantity = 10;
        duration = 60000L;
        replenishBoost = false;
        
        // Must set type first
        item.setType(Item.itemType.Missile);
        item.setQuantity(10);
        
        expResult = "Replenishing 10 Missile(s) over 60000ms, ReplenishBoost?: false";
        result = instance.replenishItem(item, quantity, duration, replenishBoost);
        assertEquals(expResult, result);
        
        /********************************************
         * Test case #2
         ********************************************/
        console.println("\tTest case #2");
        
        //input values for test case 2
        item = new Item();
        
        quantity = 3;
        duration = 120000L;
        replenishBoost = false;
        
        // Must set type first
        item.setType(Item.itemType.Torpedo);
        item.setQuantity(5);

        expResult = "Replenishing 3 Torpedo(s) over 120000ms, ReplenishBoost?: false";
        result = instance.replenishItem(item, quantity, duration, replenishBoost);
        assertEquals(expResult, result);
        
        /********************************************
         * Test case #3
         ********************************************/
        console.println("\tTest case #3");
        
        //input values for test case 3
        item = new Item();
        
        quantity = 20;
        duration = 80000L;
        replenishBoost = true;
        
        //Must set type first
        item.setType(Item.itemType.Flare);
        item.setQuantity(10);
        
        expResult = "Replenishing 20 Flare(s) over 40000ms, ReplenishBoost?: true";
        result = instance.replenishItem(item, quantity, duration, replenishBoost);
        assertEquals(expResult, result);
        
        /********************************************
         * Test case #4
         ********************************************/
        console.println("\tTest case #4");
        
        //input values for test case 4
        item = new Item();
        
        quantity = 20;
        duration = 60000L;
        replenishBoost = false;
        
        // Must set type first
        //item.setType(Item.itemType.Flare);
        item.setQuantity(10);
        
        expResult = "Error: Invalid Item Type";
        result = instance.replenishItem(item, quantity, duration, replenishBoost);
        assertEquals(expResult, result);
        
        /********************************************
         * Test case #5
         ********************************************/
        console.println("\tTest case #5");
        
        //input values for test case 5
        item = new Item();
        
        quantity = -1;
        duration = 60000L;
        replenishBoost = false;
        
        // Must set type first
        item.setType(Item.itemType.Flare);
        item.setQuantity(10);
        
        expResult = "Error: Invalid Item Quantity";
        result = instance.replenishItem(item, quantity, duration, replenishBoost);
        assertEquals(expResult, result);
        
        /********************************************
         * Test case #6
         ********************************************/
        console.println("\tTest case #6");
        
        //input values for test case 6
        item = new Item();
        
        quantity = 20;
        duration = 60000L;
        replenishBoost = false;
        
        // Must set type first
        item.setType(Item.itemType.Flare);
        item.setQuantity(100);
        
        expResult = "Error: Flares already full";
        result = instance.replenishItem(item, quantity, duration, replenishBoost);
        assertEquals(expResult, result);
        
        /********************************************
         * Test case #7
         ********************************************/
        console.println("\tTest case #7");
        
        //input values for test case 7
        item = new Item();
        
        quantity = 20;
        duration = -1L;
        replenishBoost = false;
        
        // Must set type first
        item.setType(Item.itemType.Flare);
        item.setQuantity(100);

        expResult = "Error: Invalid Item Duration";
        result = instance.replenishItem(item, quantity, duration, replenishBoost);
        assertEquals(expResult, result);
        
        /********************************************
         * Test case #8
         ********************************************/
        console.println("\tTest case #8");
        
        //input values for test case 8
        item = new Item();
        
        quantity = 1;
        duration = 60000L;
        replenishBoost = false;
        
        // Must set type first
        item.setType(Item.itemType.Flare);
        item.setQuantity(0);

        expResult = "Replenishing 1 Flare(s) over 60000ms, ReplenishBoost?: false";
        result = instance.replenishItem(item, quantity, duration, replenishBoost);
        assertEquals(expResult, result);
        
        /********************************************
         * Test case #9
         ********************************************/
        console.println("\tTest case #9");
        
        //input values for test case 9
        item = new Item();
        
        quantity = 100;
        duration = 200L;
        replenishBoost = true;
        
        // Must set type first
        item.setType(Item.itemType.Flare);
        item.setQuantity(0);

        expResult = "Replenishing 100 Flare(s) over 100ms, ReplenishBoost?: true";
        result = instance.replenishItem(item, quantity, duration, replenishBoost);
        assertEquals(expResult, result);
    }
    
}
