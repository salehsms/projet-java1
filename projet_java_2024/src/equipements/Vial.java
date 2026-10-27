package equipements;

import actors.*;
import game.City;
import java.util.*;

/**
 * The Vial class represents a vial equipment in the game
* It extends the Equipment class,inheriting basic equipment with properties.
*/
public class Vial extends Equipment {
	
    public Vial() {
    	super();
    }
    /**
     * Get the name of the vial equipment.
     * @return The name of the vial equipment.
     */
    @Override
    public String getName() {
        return "vial";
    }
    
    public void use(Survivor s, City city, Scanner scanner) {
    	s.increaseLifePoints(1);
    	s.decreaseActionPoints(1);
    }
    
    public boolean canOpenDoor() {
		return false;
	}
}
