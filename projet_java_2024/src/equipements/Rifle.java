
package equipements;

import actors.Survivor;
import game.City;
import java.util.*;

/**
 * The Rifle class represents a rifle weapon in the game.
 * It extends the Weapon class,inheriting weapon properties.
 */
public class Rifle extends Weapon {
    /**
     *  Rifle instance.
     * Sets the values for dieRoll,threshold,damage and range.
     */
    public Rifle() {
    	super();
    	
        this.dieRoll = 2; 
        this.threshold = 4; 
        this.damage = 1; 
        this.range = new int[]{1, 3}; 
    }
    /**
     * Get the name of the rifle weapon.
     * @return The name of the rifle weapon.
     */
    @Override
    public String getName() {
        return "rifle";
    }
    
    public void use(Survivor s, City c, Scanner scanner) {
    	
    }
    
    public boolean canOpenDoor() {
		return false;
	}
}
