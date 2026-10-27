package equipements;

import actors.Survivor;
import game.City;
import java.util.*;

//pied de biche
/**
 * The Crowbar class represents a crowbar weapon in the game.
 * It extends the Weapon class,inheriting weapon properties.
 */
public class Crowbar extends Weapon {
    /**
     * a new Crowbar instance.
     * Sets the values for dieRoll,threshold,damage and range.
     */
	public Crowbar() {    
		super();
        this.dieRoll = 1;
        this.threshold = 4;
        this.damage = 1;
        this.range = new int[]{0};
    }
    /**
     * Get the name of the crowbar weapon.
     * @return The name of the crowbar weapon.
     */
	public String getName() {
		return "crowbar";
	}
	
	public void use(Survivor s, City c, Scanner scanner) {
    	
    }
	
	public boolean canOpenDoor() {
		return true;
	}
}
