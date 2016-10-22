/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starwars;


import byui.cit260.starWars.control.ItemControl;
import byui.cit260.starWars.model.DeathStar;
import byui.cit260.starWars.model.EnemyFighters;
import byui.cit260.starWars.model.FriendlyFighters;
import byui.cit260.starWars.model.Game;
import byui.cit260.starWars.model.Item;
import byui.cit260.starWars.model.Item.itemType;
import byui.cit260.starWars.model.Location;
import byui.cit260.starWars.model.Map;
import byui.cit260.starWars.model.Menu;
import byui.cit260.starWars.model.OpenSpace;
import byui.cit260.starWars.model.Player;
import byui.cit260.starWars.model.RebelTransportShip;
import byui.cit260.starWars.model.RepairShop;
import byui.cit260.starWars.model.Scene;
import byui.cit260.starWars.model.SupplyShip;
import byui.cit260.starWars.model.Target;

/**
 *
 * @author Bryce Blauser
 */
public class StarWars {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        Player currentPlayer = new Player();
        
        
        Game game = new Game();
         
         game.setGameOver(false);
         game.setIsPlaying(true);
         game.setTotalTime(500.2);
         
         String theGame = game.toString();
         
         System.out.println(theGame);
        
        currentPlayer.setName("Test McTesterson");
        currentPlayer.setCoordinates("A,1");
        
        String playerInfo = currentPlayer.toString();
        
        System.out.println(playerInfo);
        
        Menu menulist = new Menu();
        
            menulist.setHelp("help menu");
            menulist.setSave("would you like to save game");
            menulist.setQuit("Give UP?");
        
            String menuInfo = menulist.toString();
        
            System.out.println(menuInfo);
        
         Map newMap = new Map();
         
            newMap.setRowCount("A");
            newMap.setColumCount("1");
            
            String gameMap = newMap.toString();
            
            System.out.println(gameMap);
            
         Item shipItems = new Item();
         
            shipItems.setType(itemType.Missile);
            shipItems.setQuantity(10);
            
            String weapons = shipItems.toString();
            
            System.out.println(weapons);
            
         Location shipLocation = new Location();
         
            shipLocation.setRow("y");
            shipLocation.setColumn("3");
            shipLocation.setStatus("DogFight");
            
            String ship = shipLocation.toString();
            
            System.out.println(ship);
         
        
        // Scene
         Scene scene = new Scene();
         
         scene.setDescription("Scene by Itself...");
         scene.setDisplaySymbol("X");
         scene.setTravelTime(20.0);
         
         String theScene = scene.toString();
         
         System.out.println(theScene);
        
        // Friendly Fighters
        FriendlyFighters friendlyFighters = new FriendlyFighters();
        
        // Scene
        friendlyFighters.setDescription("Friendly Fighters");
        friendlyFighters.setDisplaySymbol("^");
        friendlyFighters.setTravelTime(50.0);
        // Fighters
        friendlyFighters.setNoOfFighter(2);
        friendlyFighters.setFriendlyFighterLocation("B,5");
        
        String theFriendlyFighters = friendlyFighters.toString();

        System.out.println(theFriendlyFighters);
        
        // Supply Ship
        SupplyShip supplyShip = new SupplyShip();
        
        // Scene
        supplyShip.setDescription("Supply Ship");
        supplyShip.setDisplaySymbol("#");
        supplyShip.setTravelTime(10.0);
        // Supplies
        supplyShip.setNoSupplies(24);
        supplyShip.setTypeSupplies("Apples and bananas");
        
        String theSupplyShip = supplyShip.toString();

        System.out.println(theSupplyShip);
        
        // Repair Shop
        RepairShop repairShop = new RepairShop();
        
        // Scene
        repairShop.setDescription("Repair Shop");
        repairShop.setDisplaySymbol("Y");
        repairShop.setTravelTime(15.0);
        // Repair Shop
        repairShop.setShipCondition(100);
        
        String theRepairShop = repairShop.toString();

        System.out.println(theRepairShop);
        
        // Enemy Fighters
        EnemyFighters enemyFighters = new EnemyFighters();
        
        // Scene
        enemyFighters.setDescription("Enemy Fighters");
        enemyFighters.setDisplaySymbol("%");
        enemyFighters.setTravelTime(5.0);
        // Fighters
        enemyFighters.setNoOfFighter(15);
        enemyFighters.setEnemyFighterLocation("C,22");
        
        String theEnemyFighters = enemyFighters.toString();

        System.out.println(theEnemyFighters);
        
        // Death Star
        DeathStar deathStar = new DeathStar();
        
        // Scene
        deathStar.setDescription("Death Star");
        deathStar.setDisplaySymbol("@");
        deathStar.setTravelTime(5.0);
        // Death Star
        deathStar.setNoTurboLasers(25);
        deathStar.setNoDeflectorShields(10);
        
        String theDeathStar = deathStar.toString();

        System.out.println(theDeathStar);
        
        // Open Space
        OpenSpace openSpace = new OpenSpace();
        
        // Scene
        openSpace.setDescription("Open Space");
        openSpace.setDisplaySymbol("*");
        openSpace.setTravelTime(50.0);
        // Open Space
        openSpace.setOpenSpaceLocation("D,19");
        
        String theOpenSpace = openSpace.toString();

        System.out.println(theOpenSpace);
    
        // Rebel Transport Ship
        RebelTransportShip rebelTransportShip = new RebelTransportShip();
        
        // Scene
        rebelTransportShip.setDescription("Rebel Transport Ship");
        rebelTransportShip.setDisplaySymbol("P");
        rebelTransportShip.setTravelTime(500.0);
        // Rebel Transport Ship
        rebelTransportShip.setRebelTransportShipLocation("Z,100");
        
        String theRebelTransportShip = rebelTransportShip.toString();

        System.out.println(theRebelTransportShip);
        
        // Target
        Target newTarget = new Target();
        newTarget.setTargetHealth(100);
        newTarget.setTargetShield(100);
        newTarget.setTargetName("Test Target");
        newTarget.setTargetType("Rebel Fighter");
        
        String theNewTarget = newTarget.toString();
        
        System.out.println(theNewTarget);
        
        
        // Testing replenish (Multiple Items)
        Item repItems1 = new Item();
         
            repItems1.setType(itemType.Missile);
            repItems1.setQuantity(1);
            
            String repItem1 = repItems1.toString();
            
            System.out.println(repItem1);
            ItemControl instance1 = new ItemControl();
            String result1 = instance1.replenishItem(repItems1, 60, 20000, true);
            System.out.println(result1);
        
        Item repItems = new Item();
         
            repItems.setType(itemType.Flare);
            repItems.setQuantity(0);
            
            String repItem = repItems.toString();
            
            System.out.println(repItem);
            ItemControl instance = new ItemControl();
            String result = instance.replenishItem(repItems, 100, 200, true);
            System.out.println(result);
        
    }
}
