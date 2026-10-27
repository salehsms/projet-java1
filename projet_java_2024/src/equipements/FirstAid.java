package equipements;

import java.util.*;

import actors.Survivor;
import cell.*;
import game.City;

//trousse de secours
public class FirstAid extends Equipment {
	
	public FirstAid() {
		super();
		
	}
	
	public String getName() {
		return "first aid";
	}
	
	public void use(Survivor s, City c, Scanner scanner) {
		Cell survivorCell = s.getZone();
    	
    	String survivorDesc = survivorCell.getSurvivorDescription();
    	int survivorSize = survivorCell.getSurvivorSize();
    	
    	int answer = 0;
        boolean validInput = false;
        
        System.out.println(survivorDesc);
        
        //Scanner scanner = new Scanner(System.in);
        String answer1 = "";

		while (!answer1.equals("yes") && !answer1.equals("no")) {
			System.out.print("Do you want to heal someone (yes/no) ");
			answer1 = scanner.nextLine();
			if (!answer1.equals("yes") && !answer1.equals("no")) {
				System.out.println("Please provide a correct answer.");
			}
		}
		
		if (answer1.equals("yes")) {
			
			System.out.println("Which survivor do you want to heal?");
		       
	        System.out.println("Please provide the survivor index between 1 and " + survivorSize + ": ");
	        
	        do {
	            if (scanner.hasNextInt()) {
	                answer = scanner.nextInt();
	                scanner.nextLine(); 
	                validInput = answer >= 1 && answer < survivorSize + 1;
	                if (!validInput) {
	                    System.out.println("Please provide a correct answer.");
	                }
	            } else {
	                System.out.println("Please provide an integer.");
	                scanner.nextLine(); 
	            }
	        } while (!validInput);
	        
	        Survivor survivorToHeal = survivorCell.getSurvivor(answer-1);
	        survivorToHeal.increaseLifePoints(1);
	        
	        s.decreaseActionPoints(1);
		}
		//scanner.close();	
	}
	
	public boolean canOpenDoor() {
		return false;
	}
}
