package equipements;

import actors.Survivor;
import game.City;
import java.util.*;

/**
 * The Map class represents a map equipment in the game
 * It extends the equipment class,inheriting basic equipment
 * properties
 */
public class Map extends Equipment {
    public Map() {
    	super();
    }
    /**
     * Get the name of the map equipments.
     * @return The name of the map equipments.
     */
    @Override
    public String getName() {
        return "map";
    }
    
    public void use(Survivor s, City city, Scanner scanner) {
    	city.displayCity();
    	city.detailsCity();
    	s.decreaseActionPoints(1);
    }
    
    public boolean canOpenDoor() {
		return false;
	}
}
