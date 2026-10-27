package action;

import game.*;
import actors.*;


public class MakeNoise extends SurvivorAction {
    
    public MakeNoise(City city, Survivor survivor) {
        super(city, survivor);

    }


    public void execute() {
    	this.actor.decreaseActionPoints(this.cost);
    	this.actor.getZone().increaseNoise(1);
    }


}