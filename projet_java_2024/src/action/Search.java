package action;

import game.*;
import cell.*;
import actors.*;
import equipements.*;

import java.util.Scanner;

/* Fouiller une pièce 
 * Seules les pièces peuvent être fouillées, pas les rues. 
 * Lorsqu’il fouille une pièce, le survivant peut ramasser un équipement qu’il découvre et le mettre dans son sac à dos. 
 * Il est pour cela nécessaire qu’il y ait encore de la place dans son sac qui peut contenir au maximum 5 équipements. 
 * Si ce n’est pas le cas, le survivant peut jeter un équipement pour en prendre un nouveau. 
 * Dans ce cas l’équipement jeté reste sur place dans la pièce, de même que tout équipement découvert lors de la fouille mais non ramassé.*/

public class Search extends SurvivorAction {
	private Scanner scanner;

    public Search(City city, Survivor survivor, Scanner scanner) {
        super(city, survivor);
        this.scanner = scanner;
    }
    
    public void execute() {
    	
    	try {
    		
    		Cell cellToSearch = this.actor.getZone();
        	
        	if (!cellToSearch.isRoom()) {
        		throw new CantExecuteActionException("This is not a room.");
        	}
        	
        	if (cellToSearch.isRoom()) {
        		
        		this.actor.decreaseActionPoints(this.cost);
        		int toolsNb = cellToSearch.getToolsNb();
        		
        		if (toolsNb == 0) {
        			System.out.print("This room doesn't have any tools.\n");
        		} else {
        			
        			String toolsDesc = cellToSearch.getToolsDescription();
        			System.out.print("Tools in this room: [" + toolsDesc + "]\n");
        			
        			String answer1 = "";
        			

        			while (!answer1.equals("yes") && !answer1.equals("no")) {
        				System.out.print("Do you want to put item in the backpack? (yes/no) ");
        				answer1 = this.scanner.nextLine(); //
        				if (!answer1.equals("yes") && !answer1.equals("no")) {
        					System.out.println("Please provide a correct answer.");
        				}
        			}
        			
        			if (answer1.equals("yes")) {
        				int answer2 = 0;
                        boolean validInput = false;
                        do {
                            System.out.print("Which item do you choose? (index of the list provided: between 0 and " + (toolsNb-1) + ") ");
                            if (this.scanner.hasNextInt()) {
                                answer2 = this.scanner.nextInt();
                                this.scanner.nextLine(); 
                                validInput = answer2 >= 0 && answer2 < toolsNb;
                                if (!validInput) {
                                    System.out.println("Please provide a correct answer.");
                                }
                            } else {
                                System.out.println("Please provide an integer.");
                                this.scanner.nextLine(); 
                            }
                        } while (!validInput);
                        
        				cellToSearch.getTool(answer2);
        				
        				if(((Survivor) this.actor).backpackIsFull()) {
        					String backpack = ((Survivor) this.actor).getBackpackDesc();
        					System.out.print("Your backpack is full: [" + backpack + "]\n");
        					int answer3 = -1;
        					while (answer3 < 0 || answer3 >= ((Survivor) this.actor).getBackpackSize()) {
        						System.out.print("Which item do you want to throw away (index of the list provided: between 0 and 4) ");
            					answer3 = this.scanner.nextInt();
            					this.scanner.nextLine();
            					if (answer3 < 0 || answer3 >= ((Survivor) this.actor).getBackpackSize()) {
            						System.out.println("Please provide a correct answer.");
            					}
        					}
        					Equipment throwAway = ((Survivor) this.actor).getBackpackItem(answer3);
        					((Survivor) this.actor).removeBackpackItem(answer3);
        					cellToSearch.addEquipment(throwAway);			
        				} 
        				
        				Equipment newTool = cellToSearch.getTool(answer2);
        				cellToSearch.removeEquipment(answer2);
        				
        				((Survivor) this.actor).addEquipmentInBackpack(newTool);
        			}
        		}
        	}
    	} catch (CantExecuteActionException e){
    		System.out.println("Search action can only be executed inside a room.");
    	}
    	
    }
    	
}