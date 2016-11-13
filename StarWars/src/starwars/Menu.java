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
 * @author gmoser
 */
public class Menu implements Serializable{
   
    private String help;
    private String save;
    private String quit;

    public Menu() {
    }

    
    
    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
    }

    public String getQuit() {
        return quit;
    }

    public void setQuit(String quit) {
        this.quit = quit;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.help);
        hash = 41 * hash + Objects.hashCode(this.save);
        hash = 41 * hash + Objects.hashCode(this.quit);
        return hash;
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
        final Menu other = (Menu) obj;
        if (!Objects.equals(this.help, other.help)) {
            return false;
        }
        if (!Objects.equals(this.save, other.save)) {
            return false;
        }
        if (!Objects.equals(this.quit, other.quit)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Menu{" + "help=" + help + ", save=" + save + ", quit=" + quit + '}';
    }

    public void newMenu(String help_Menu_Test) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void testMenu(String displays_help_menu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
