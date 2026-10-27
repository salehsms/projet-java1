package action;

import game.*;
import actors.*;
import java.util.ArrayList;
import java.util.List;

public abstract class SurvivorAction extends Action{
    //add
    protected List<Survivor> survivor;

    public SurvivorAction (City city, Survivor survivor){
        super(city, survivor);
    }

}
