package action;

import game.*;
import actors.*;
import cell.*;

import java.util.*;

public class AttackSurvivor extends ZombieAction{

    private List<Survivor> targetSurvivors;

    public AttackSurvivor(City city,Zombie zombie) {
        super(city, zombie);
        this.targetSurvivors = new ArrayList<>();  
    }
    
    public void execute() {
    	
    	Cell currentCell = this.actor.getZone();
    	this.targetSurvivors = currentCell.getSurvivors();
    	
    	int survivorNb = currentCell.getSurvivorSize();
    	
    	if (survivorNb > 0) {
    		Survivor target = this.chooseRandomSurvivor();
    		target.decreaseLifePoints(((Zombie) this.actor).getPointsOfDamage());
    		
    	}
    	
    }
    
    public Survivor chooseRandomSurvivor() {
    	int size = this.targetSurvivors.size();
    	
    	Random random = new Random();
        int index = random.nextInt(size);
        
        return this.targetSurvivors.get(index);
    }
    
}