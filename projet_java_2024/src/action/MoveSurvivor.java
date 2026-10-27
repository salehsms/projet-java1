package action;

import game.*;
import actors.*;
import cell.Cell;

import java.util.*;


public class MoveSurvivor extends SurvivorAction {
	private Scanner scanner;

    public MoveSurvivor(City city, Survivor survivor, Scanner scanner) {
        super(city, survivor);
        this.scanner = scanner;
    }
    
    public void execute() {
    	try {
    		
    		Cell currentCell = this.actor.getZone();
    		int cx = currentCell.getx();
    		int cy = currentCell.gety();
    		
    		int nx = 0;
    		int ny = 0;

			String answer1 = "";
			

			while (!answer1.equals("north") && !answer1.equals("south") && !answer1.equals("west") && !answer1.equals("east")) {
				System.out.print("Which direction do you want to move? (north/south/west/east) \n");
				answer1 = this.scanner.nextLine(); //
				if (!answer1.equals("north") && !answer1.equals("south") && !answer1.equals("west") && !answer1.equals("east")) {
					System.out.println("Please provide a correct answer.");
				}
			}
			
			if (answer1.equals("north")) {
				if (cx-1 >= 0) {
					this.city.moveActor(this.actor, cx-1, cy);
					this.actor.decreaseActionPoints(this.cost);
				}
				nx = cx-1;
				ny = cy;
			}
			
			if (answer1.equals("south")) {
				if (cx+1 < this.city.getX()) {
					this.city.moveActor(this.actor, cx+1, cy);
					this.actor.decreaseActionPoints(this.cost);
				}
				nx = cx+1;
				ny = cy;
			}
        	
			if (answer1.equals("west")) {
				if (cy+1 < this.city.getY()) {
					this.city.moveActor(this.actor, cx, cy+1);
					this.actor.decreaseActionPoints(this.cost);
				}
				nx = cx;
				ny = cy+1;
			}
        	
			if (answer1.equals("east")) {
				if (cy-1 >= 0) {
					this.city.moveActor(this.actor, cx, cy-1);
					this.actor.decreaseActionPoints(this.cost);
				}
				nx = cx;
				ny = cy-1;
			}
     
        			
			if (!this.city.cellExists(nx, ny)) {
        		throw new CantExecuteActionException("Can't move this direction");
        	}
        			
    	} catch (CantExecuteActionException e){
    		System.out.println("You can't move this direction.");
    	}
    	
    }
    
}