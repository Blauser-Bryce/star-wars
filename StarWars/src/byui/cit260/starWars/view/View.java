/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starWars.view;

import java.util.Scanner;

/**
 *
 * @author Bryce Blauser
 */
public abstract class View implements ViewInterface {
    
    protected String displayMessage;
    
    public View() {
        
    }
    
    public View(String message) {
        this.displayMessage = message;
    }
    
    @Override
    public void display() {
        boolean done = false; // set flag for not done
        
        //System.out.println(this.menu);
        
        do {
            // prompt for and get menu input
            String value = this.getInput();
            if (value.toUpperCase().equals("X")) // user wants to exit
                return;
            
            // do the requested action and display the next view
            done = this.doAction(value);
            
        } while (!done);
    }
    
    @Override
    public String getInput() {
        Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        String value = null; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while (!valid) { // loop while invalid value is entered
            
            // Prompt with message
            System.out.println("\n" + this.displayMessage);
            
            value = keyboard.nextLine(); // get next line typed on the keyboard
            value = value.trim(); // trim off the leading and trailing blanks
            
            if (value.length() < 1) { // value is blank
                System.out.println("\n*** You must enter a value ***");
                continue;
            }
            break; // end the loop
        }
        return value;
    }
}
