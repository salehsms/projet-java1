package equipements;

import actors.Survivor;
import game.City;
import java.util.*;

//tronçonneuse
/**
 * The Chainsaw class represents a chainsaw weapon in the game.
 * It extends the Weapon class,inheriting weapon properties.
 */
public class Chainsaw extends Weapon {
    /**
     * a new Chainsaw instance.
     * Sets the values for dieRoll,threshold,damage and range.
     */
	public Chainsaw() {    
        this.dieRoll = 2;
        this.threshold = 5;
        this.damage = 3;
        this.range = new int[]{0};
    }

    /**
     * Get the name of chainsaw  weapon.
     * @return The name of the chainsaw weapon.
     */
	public String getName() {
		return "chainsaw";
	}
	
	public void use(Survivor s, City c, Scanner scanner) {
    	
    }
	
	public boolean canOpenDoor() {
		return true;
	}
}
