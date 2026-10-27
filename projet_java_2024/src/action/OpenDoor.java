package action;
import game.*;
import actors.*;
import cell.*;

import java.util.List;
import java.util.Random;

public class OpenDoor extends SurvivorAction {
	private Door door;

    public OpenDoor(City city, Survivor survivor, Door door) {
        super(city, survivor);
        this.door = door;
    }

    public void execute() {
    	
    	if (((Survivor) this.actor).canOpenDoor()) {
    		this.actor.decreaseActionPoints(this.cost);
    		this.door.open();
    		
    		List<Manhole> manholes = this.city.getManholes();
    		Random random = new Random();
    		
    		int zombiesNb = random.nextInt(4) + 1;
    		
			Manhole manhole = manholes.get(random.nextInt(manholes.size()));
			
			ZombieType[] zombies = ZombieType.values();
			
			//produce between 1 to 3 zombies and no more than 1 broom and 1 abomination
			Zombie z1 = manhole.produceZombie(zombies[random.nextInt(4)]);
			this.city.addZombie(z1);
			
    		for (int i=0; i < zombiesNb-1; i++) {
    			Zombie z = manhole.produceZombie(zombies[random.nextInt(2)]);
    			this.city.addZombie(z);
    		}
    		
    	} else {
    		System.out.print("You don't have the tools (axe, chainsaw, crowbar, pistol) to open a door in hand.\n");
    	}
    }
    


}