package equipements;

import java.util.*;

import actors.Survivor;
import game.City;
import cell.*;

/**
 * The MasterKey class represents a master key equipment in the game.
 * It extends the Equipment class,inheriting basic equipment with properties.
 */
public class MasterKey extends Equipment {
    public MasterKey() {
    	super();
    }
    /**
     * Get the name of the master key equipment.
     * @return The name of the master key equipment.
     */
    @Override
    public String getName() {
        return "master key";
    }
    
    public void use(Survivor s, City city, Scanner scanner) {
    	s.decreaseActionPoints(1);
    	
    	int sx = s.getX();
    	int sy = s.getY();
    	
    	HashMap<String, Door> doorsMap = city.getDoorsForCell(sx, sy);
    	List<Door> doors = new ArrayList<>(doorsMap.values());
    	int doorSize = doors.size();
    	
    	for (String direction : doorsMap.keySet()) {
            System.out.print("*" + direction + " door: " + doorsMap.get(direction).toString() + "\n");
        }
    	
    	int answer = 0;
    	boolean validInput = false;
        
        //Scanner scanner = new Scanner(System.in);
        String answer1 = "";
    	
    	while (!answer1.equals("yes") && !answer1.equals("no")) {
			System.out.print("Do you want to open a door (yes/no) ");
			answer1 = scanner.nextLine();
			if (!answer1.equals("yes") && !answer1.equals("no")) {
				System.out.println("Please provide a correct answer.");
			}
		}
		
		if (answer1.equals("yes")) {
			
			System.out.println("Which door do you want to open?");
		       
	        System.out.println("Please provide index (of the previous list) between 0 and " + (doorSize - 1) + ": ");
	        
	        do {
	            if (scanner.hasNextInt()) {
	                answer = scanner.nextInt();
	                scanner.nextLine(); 
	                validInput = answer >= 0 && answer < doorSize ;
	                if (!validInput) {
	                    System.out.println("Please provide a correct answer.");
	                }
	            } else {
	                System.out.println("Please provide an integer.");
	                scanner.nextLine(); 
	            }
	        } while (!validInput);
	        
	        
	        doors.get(answer).open();
	        s.decreaseActionPoints(1);
	        
		}
		
		//scanner.close();
    }
    
    public boolean canOpenDoor() {
		return false;
	}
}
