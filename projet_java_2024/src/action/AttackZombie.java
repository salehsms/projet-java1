package action;

import game.*;
import cell.*;
import actors.*;
import equipements.*;

import java.util.*;

public class AttackZombie extends SurvivorAction{
    private Scanner scanner;
    private List<Zombie> targetZombies;

    public AttackZombie(City city, Survivor survivor, Scanner scanner) {
        super(city, survivor);
        this.scanner = scanner;
        this.targetZombies = new ArrayList<>();
    }

    //add
    public void execute() {
    	if (((Survivor) this.actor).canAttackZombie()) {
    		
    		Cell currentCell = this.actor.getZone();
    		int zombiesNb = currentCell.getZombieSize();
    		
    		if (zombiesNb == 0) {
    			System.out.print("There aren't any zombies to attack.");
    		} else {
    			
    			this.targetZombies = currentCell.getZombies();
    			
    			Equipment weapon = ((Survivor) this.actor).getEquipmentInHand();
        		
        		System.out.println("Your weapon in hand: " + weapon.toString());
        		System.out.println("Zombies you can attack: ");
        		String zd = currentCell.getZombieDescription();
        		System.out.print(zd);
        		//System.out.println("Which zombie do you want to attack? () ");
        		
        		int answer = 0;
                boolean validInput = false;
                do {
                    System.out.print("Which zombie do you want to attack? (index of the list provided: between 1 and " + zombiesNb + ") ");
                    if (this.scanner.hasNextInt()) {
                    	answer = this.scanner.nextInt();
                        this.scanner.nextLine(); 
                        validInput = answer >= 1 && answer <= zombiesNb;
                        if (!validInput) {
                            System.out.println("Please provide a correct answer.");
                        }
                    } else {
                        System.out.println("Please provide an integer.");
                        this.scanner.nextLine(); 
                    }
                } while (!validInput);
                
                
                Zombie target = this.targetZombies.get(answer-1);
                
                if (this.successfulAttack((Weapon) weapon)) {
                	
                	target.decreaseLifePoints(((Weapon) weapon).getDamage());
                	System.out.println("Attack was successful!");
                	
                	if (!target.isAlive()) {
                		((Survivor) this.actor).increaseExperience(1);
                	}
                }
                
                this.actor.decreaseActionPoints(this.cost);
                System.out.println("Attack was unsuccessful.");
    		}
    		
    		
    	} else {
    		System.out.print("You don't have the necessary tools (weapons) in hand to attack a zombie.");
    	}
    }
    
    public int throwDice() {

        Random random = new Random();
        int result = random.nextInt(6) + 1;
        
        return result;
    }
    
    public boolean successfulAttack(Weapon weapon) {
    	boolean result = false;
    	for (int i=0; i<weapon.getDieRoll(); i++) {
    		if (this.throwDice() >= weapon.getThreshold()) {
    			result = true;
    		}
    	}
    	return result;
    }
    
}