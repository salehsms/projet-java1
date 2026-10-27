package equipements;
//lunettes infrarouges

import actors.Survivor;
import game.City;
import cell.*;
import java.util.*;

/**
 * The Infrared class represents a set of infrared glasses equipment in the game.
 * It extends the equipment class,inheriting basic equipment properties.
 */
public class Infrared extends Equipment {
	public Infrared() {
		super();
	}

	/**
	 * Get the name of the infrared glasses equipment.
	 * @return The name of the infrared glasses equipment.
	 */
	public String getName() {
		return "infrared glasses";
	}
	
	public void use(Survivor s, City city, Scanner scanner) {
    	int sx = s.getX();
    	int sy = s.getY();
    	
    	Cell currentCell = city.getCell(sx, sy);
    	currentCell.getDescription();
    	
    	if (city.cellExists(sx+1, sy)) {
    		String s1 = city.getCell(sx+1, sy).getDescription();
    		System.out.print(">>Cell to the south\n");
    		System.out.print(s1);
    	}
    	if (city.cellExists(sx-1, sy)) {
    		String s2 = city.getCell(sx-1, sy).getDescription();
    		System.out.print(">>Cell to the north\n");
    		System.out.print(s2);
    	}
    	if (city.cellExists(sx, sy+1)) {
    		String s3 = city.getCell(sx, sy+1).getDescription();
    		System.out.print(">>Cell to the west\n");
    		System.out.print(s3);
    	}
    	if (city.cellExists(sx, sy-1)) {
    		String s4 = city.getCell(sx, sy-1).getDescription();
    		System.out.print(">>Cell to the east\n");
    		System.out.print(s4);
    	}
    	
    	s.decreaseActionPoints(1);
    }
	
	public boolean canOpenDoor() {
		return false;
	}
}
