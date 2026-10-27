package action;

import game.*;
import actors.*;

public abstract class ZombieAction extends Action {
	
	public ZombieAction (City city, Zombie zombie){
        super(city, zombie);
    }

}
