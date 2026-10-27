package equipements;

import actors.Survivor;
import game.City;
import java.util.*;

public class Pistol extends Weapon {
    /**
     * Chainsaw instance.
     * Sets the values for dieRoll,threshold,damage and range.
     */
    public Pistol() {
    	super();
    	
        this.dieRoll = 1; 
        this.threshold = 4; 
        this.damage = 1;
        this.range = new int[]{0, 1}; 
    }
    /**
     * Get the name of the pistol weapon.
     * @return The name of the pistol weapon.
     */
    @Override
    public String getName() {
        return "pistol";
    }
    
    public void use(Survivor s, City c, Scanner scanner) {
    	
    }
    
    public boolean canOpenDoor() {
		return true;
	}
}

