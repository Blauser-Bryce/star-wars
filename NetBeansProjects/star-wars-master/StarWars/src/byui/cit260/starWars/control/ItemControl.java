/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.control;

import byui.cit260.starWars.model.Item;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Bryce Blauser
 */
public class ItemControl {
        
    public String replenishItem(Item item, int quantity, long duration, boolean replenishBoost) {
        
        if (item == null || item.getType() == null) {
            return "Error: Invalid Item Type";
        }
        
        if (quantity < 0) {
            return "Error: Invalid Item Quantity";
        }
        
        if (duration < 0) {
            return "Error: Invalid Item Duration";
        }
        
        int current = item.getQuantity();
        int max = item.maxQuantity(item.getType());
        
        if (current >= max ) {
            return "Error: " + item.getType() + "s already full";
        }
        
        if (replenishBoost) {
            duration /= 2;
        }
        
        long ticksPerReplenish = (duration / quantity);
        
        if (ticksPerReplenish < 1) {
            return "Error: Replenish duration is not sufficient to replenish quantity";
        }
        
        // Schedule item to replenish
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        
        final Runnable task = new Runnable() {
            int qtyReplenished;
            @Override
            public void run() {
                item.replenishQuantity();
                // Display each tick...
                //System.out.println("Replenished " + item.getType() + ", now at " + item.getQuantity() + " of " + item.maxQuantity(item.getType()));
                qtyReplenished++;
                if (item.getQuantity() >= item.maxQuantity(item.getType()) || qtyReplenished >= quantity) {
                    System.out.println(item.getType() + " Replenished (" + quantity + ")");
                    scheduler.shutdownNow();
                }
            }
        };
        
        final ScheduledFuture<?> handle = scheduler.scheduleAtFixedRate(task, ticksPerReplenish, ticksPerReplenish, TimeUnit.MILLISECONDS);
        scheduler.schedule(new Runnable() {public void run() { handle.cancel(true);}}, duration, TimeUnit.MILLISECONDS);
        
        return "Replenishing " + quantity + " " + item.getType() + "(s) over " + duration + "ms, ReplenishBoost?: " + replenishBoost;
    }
    
}
