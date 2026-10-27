package action;

import game.*;
import equipements.*;

import java.util.Scanner;

import actors.*;

/* Prendre en main Cette action permet à un survivant de prendre un objet de son sac pour le placer dans sa main. 
 * S’il a déjà en main un autre objet, alors celui-ci est replacé dans le sac.
*/

public class Collect extends SurvivorAction {
	private Scanner scanner;
    
    public Collect(City city, Survivor survivor, Scanner scanner) {
        super(city, survivor);
        this.scanner = scanner;
    }
    
    public void execute() {
    	
    	int backpackSize = ((Survivor) this.actor).getBackpackSize();
    	
    	if (backpackSize >0) {
    		
    		this.actor.decreaseActionPoints(this.cost);
    		
    		//Scanner scanner = new Scanner(System.in);
        	
        	String backpackDesc = ((Survivor) this.actor).getBackpackDesc();
        	//System.out.print("Your backpack items: [" + backpackDesc + "]\n");
        	
        	int answer = 0;
            boolean validInput = false;
            
            System.out.println("Which item do you want to take in hand?");
            System.out.println("Your backpack items: [" + backpackDesc + "]");
            System.out.println("Please provide an index between 0 and " + (backpackSize-1) + ": ");
            
            do {
                if (this.scanner.hasNextInt()) {
                    answer = this.scanner.nextInt();
                    this.scanner.nextLine(); 
                    validInput = answer >= 0 && answer < backpackSize;
                    if (!validInput) {
                        System.out.println("Please provide a correct answer.");
                    }
                } else {
                    System.out.println("Please provide an integer.");
                    this.scanner.nextLine(); 
                }
            } while (!validInput);
            
            Equipment toolToTake = ((Survivor) this.actor).getBackpackItem(answer);
            ((Survivor) this.actor).removeBackpackItem(answer);
        	
        	if (((Survivor) this.actor).hasEquipmentInHand()) {
        		Equipment oldTool = ((Survivor) this.actor).changeEquipmentInHand(toolToTake);
        		((Survivor) this.actor).addEquipmentInBackpack(oldTool);
        	} else {
        		((Survivor) this.actor).changeEquipmentInHand(toolToTake);
        	}
        	
        	//scanner.close();
    	} else { 
    		System.out.println("There's no equipment in bakcpack.");
    	}
    	
    }
}