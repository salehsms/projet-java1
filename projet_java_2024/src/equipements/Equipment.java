package equipements;

import actors.*;
import game.City;
import cell.Cell;
import java.util.*;

public abstract class Equipment {
	
	protected Cell zone;
    
    /**
     * Constructor for Equipment class.
     * Initializes the equipment.
     */
    public Equipment() {
        this.zone= null;
    }
    
    /**
     * Get the name of the equipment.
     * @return The name of the equipment.
     */
    public String getName() {
        return "equipment";
    }
    
    //public abstract void use(Survivor s, City c);
    
    public abstract void use(Survivor s, City c, Scanner scanner);
    
    public abstract boolean canOpenDoor();
    
    public void setZone(Cell c) {
    	this.zone = c;
    }
    
    public void removeZone() {
    	this.zone = null;
    }
    
    public boolean canAttackZombie() {
    	return false;
    }
    
    public String toString() {
    	return this.getName();
    }

}
