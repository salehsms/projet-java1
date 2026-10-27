package equipements;

import actors.Survivor;
import game.City;
import java.util.*;

//hache
/**
 * The Axe class represents an axe equipment in the game.
 * It extends the Weapon class,inheriting weapon properties.
 */
public class Axe extends Weapon {
	public Axe() {    
		super();
		
        this.dieRoll = 1;
        this.threshold = 4;
        this.damage = 2;
        this.range = new int[]{0};
    }
    /**
     * Get the name of axe weapon.
     * @return The name of the axe weapon.
     */
	public String getName() {
		return "axe";
	}
	
	public void use(Survivor s, City c, Scanner scanner) {
    	
    }
	
	public boolean canOpenDoor() {
		return true;
	}
}


