package action;

import game.*;
import actors.*;
import cell.*;

import java.util.*;


public class MoveZombie extends ZombieAction {

    public MoveZombie(City city, Zombie zombie) {
        super(city, zombie);
    }
    
    public void execute() {
    	
    	Cell currentCell = this.actor.getZone();
    	int cx = currentCell.getx();
    	int cy = currentCell.gety();
    	
    	List<Cell> neighbors = this.city.getNeighboringCells(cx, cy);
    	
    	List<Integer> noiseLevels = new ArrayList<>();
    	
    	for(Cell c: neighbors) {
    		noiseLevels.add(c.getNoise());
    	}
    	
    	int maxNoise = 0;
        int maxIndex = 0;
        
    	for (int i = 0; i < noiseLevels.size(); i++) {
            int num = noiseLevels.get(i);
            if (num > maxNoise) {
            	maxNoise = num;
            	maxIndex = i;
            }
        }
    	
    	if (maxNoise > currentCell.getNoise()) {
    		this.city.moveActor(this.actor, neighbors.get(maxIndex).getx(), neighbors.get(maxIndex).gety());
    	}
    	
    	
    }
    
}