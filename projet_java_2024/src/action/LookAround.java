package action;

import game.*;
import actors.*;
import cell.*;
import java.util.*;

/* Regarder autour de soi 
 * Permet d’obtenir un affichage descriptif de la zone sur laquelle se trouve le survivant 
 * (acteurs présents, portes ouvertes). */

public class LookAround extends SurvivorAction {
	
	protected int cost = 0;

    public LookAround(City city, Survivor survivor) {
        super(city, survivor);
    }
    
    public void execute() {
    	int sx = this.actor.getX();
    	int sy = this.actor.getY();
    	
    	Cell cell = this.city.getCell(sx, sy);
   
    	String cellDesc = cell.getDescription();
    	
    	System.out.print("Cell information: \n");
    	System.out.print(cellDesc);
    	System.out.print("Doors: \n");
    	
    	HashMap<String, Door> doors = this.city.getDoorsForCell(sx, sy);
    	
    	for (String direction : doors.keySet()) {
            System.out.print("*" + direction + " door: " + doors.get(direction).toString() + "\n");
        }
    	
    }
    
}